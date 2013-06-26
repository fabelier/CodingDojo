package main;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

  private static List<Item> _items = null;

  /**
   * @param args
   */
  public static void main(String[] args) {

    System.out.println("OMGHAI!");

    _items = new ArrayList<Item>();
    _items.add(new Item("+5 Dexterity Vest", 10, 20));
    _items.add(new Item("Aged Brie", 2, 0));
    _items.add(new Item("Elixir of the Mongoose", 5, 7));
    _items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
    _items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    _items.add(new Item("Conjured Mana Cake", 3, 6));

    updateQuality(_items);
    System.out.println(print(_items));
  }

  public static String print(List<Item> items){
	  String result = "";
	  for(Item item : items){
		  result += print(item) + "\n";
	  }
	  return result;
  }

  private static String print(Item item){
	  String result = "";
	  result += item.name + "-" + item.sellIn + "-" + item.quality;
	  return result;
  }

  private static void changeQuality(int delta, Item item){
	  item.setQuality(item.getQuality() + delta);
  }


  public static void updateQuality(List<Item> items)
  {
    for (int i = 0; i < items.size(); i++)
    {
      if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
      {
        if (items.get(i).getQuality() > 0)
        {
          if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
          {
        	  changeQuality(-1, items.get(i));
          }
        }
      }
      else
      {
        if (items.get(i).getQuality() < 50)
        {
        	changeQuality(1, items.get(i));

          if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
          {
            if (items.get(i).getSellIn() < 11)
            {
              if (items.get(i).getQuality() < 50)
              {
            	  changeQuality(1, items.get(i));
              }
            }

            if (items.get(i).getSellIn() < 6)
            {
              if (items.get(i).getQuality() < 50)
              {
            	  changeQuality(1, items.get(i));
              }
            }
          }
        }
      }

      if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
      {
        items.get(i).setSellIn(items.get(i).getSellIn() - 1);
      }

      if (items.get(i).getSellIn() < 0)
      {
        if (!"Aged Brie".equals(items.get(i).getName()))
        {
          if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
          {
            if (items.get(i).getQuality() > 0)
            {
              if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
              {
            	  changeQuality(-1, items.get(i));
              }
            }
          }
          else
          {
            items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
          }
        }
        else
        {
          if (items.get(i).getQuality() < 50)
          {
        	  changeQuality(1, items.get(i));
          }
        }
      }
    }
  }


}
