package tests;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import main.GildedRose;
import main.Item;


public class T_GildedRose {
	@Test
	public void testTheTruth() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use your special stream
		System.setOut(ps);
		// Print some output: goes to your special stream
		GildedRose.main(null);

		// Put things back
		System.out.flush();
		System.setOut(old);
		// Show what happened
		assertEquals(-312259383, baos.toString().hashCode());
		System.out.println(baos.toString().hashCode());
	}

	@Test
	public void testStandardObject(){
		int initialQuality = 20;
		int initialSellin = 10;

		Item item = new Item("+5 Dexterity Vest", initialSellin, initialQuality);
		this.updateItem(item);
	    assertEquals(initialSellin-1, item.getSellIn());
	    assertEquals(initialQuality-1, item.getQuality());
	}

	private void updateItem(Item item){
		//TODO
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.updateQuality(items);

	}

	@Test
	public void testAgeBrie(){
		int initialQuality = 20;
		int initialSellin = 10;

		Item item = new Item("Aged Brie", initialSellin, initialQuality);
		this.updateItem(item);
	    assertEquals(initialSellin-1, item.getSellIn());
	    assertEquals(initialQuality+1, item.getQuality());
	}


}
