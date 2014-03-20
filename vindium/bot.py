from random import choice
import time
from game import Game

class Bot:
    pass

class RandomBot(Bot):

    def move(self, state):
        game = Game(state)
        dirs = ['Stay', 'North', 'South', 'East', 'West']
        return choice(dirs)


class FighterBot(Bot):
    def move(self, state):
        dirs = ['Stay', 'North', 'South', 'East', 'West']
        return choice(dirs)

class Path(object):
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
        self.game = None
        self.me = None
        self.my_fucking_name = "test098A8"
        
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
   	        for x in xrange(deltaX):
   	            path.addMove('East')
   	    else:
   	        for x in xrange(abs(deltaX)):
  	            path.addMove('West')
  	            
  	    if deltaY > 0:
   	        for y in xrange(deltaY):
   	            path.addMove('South')
   	    else:
   	        for y in xrange(abs(deltaY)):
  	            path.addMove('North')  	               	    
	    return path   
    
        
    def getselfhero(self):
        for hero in self.game.heroes:
            if hero.name == self.my_fucking_name:
                return hero

    def printmine(self):
        for mine in self.game.mines_locs:
	        x, y = mine
	        print "x={}, y={}".format(x, y)
	        print self.game.mines_locs[mine] # Print the fucking mine owner	    

class SlowBot(Bot):
    def move(self, state):
        dirs = ['Stay', 'North', 'South', 'East', 'West']
        time.sleep(2)
        return choice(dirs)
