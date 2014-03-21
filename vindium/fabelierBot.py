#!/usr/bin/python3

from bot import Bot
from game import Game

class Path:
    def __init__(self):
        self.moves = []

    def distance(self):
        return len(self.moves)

    def getFirstMove(self):
        if len(self.moves) == 0:
            return 'Stay'
        return self.moves[0]

    def addMove(self, move):
        self.moves.append(move)


class FabelierBot(Bot):
    def __init__(self):
        super().__init__()

    def move(self, state):
        self.game = Game(state)
        dirs = ['Stay', 'North', 'South', 'East', 'West']
        self.printmine()
        self.me = self.getselfhero()
        bestPath = None
        for mine in self.game.mines_locs:
            currentPath = self.pathToMine(mine)
            if bestPath == None or currentPath.distance() < bestPath.distance():
                bestPath = currentPath

        xHero, yHero = self.me.pos
        return bestPath.getFirstMove()

    def pathToMine(self, mine):
        xHero = self.me.pos['x']
        yHero = self.me.pos['y']
        xMine, yMine = mine
        deltaX = xMine - xHero
        deltaY = yMine - yHero
        path = Path()
        # On prends le plus court chemin sans prendre en compte les obstacles.
        if deltaX > 0:
            for x in range(deltaX):
                path.addMove('East')
        else:
            for x in range(abs(deltaX)):
                path.addMove('West')

        if deltaY > 0:
            for y in range(deltaY):
                path.addMove('South')
        else:
            for y in range(abs(deltaY)):
                path.addMove('North')
        return path


    def getselfhero(self):
        for hero in self.game.heroes:
            if hero.name == self.my_name:
                return hero

    def printmine(self):
        for mine in self.game.mines_locs:
            x, y = mine
            print("x={}, y={}, Mine Owner:{}".format(x, y,
                    self.game.mines_locs[mine]))


