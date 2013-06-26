package main;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

  private static List<Item> _items = null;
  private static int MAX_QUALITY = 50;
  private static int MIN_QUALITY = 0;
  private static int PASSES_LIMIT = 10;
  private static int PASSES_LIMIT_2 = 5;

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
    int initialQuality = item.getQuality();
    initialQuality += delta;
    if ( isQualityInBounds(initialQuality)){
      item.setQuality(item.getQuality() + delta);
    }
  }

  private static boolean isQualityInBounds(int quality){
    return quality >= MIN_QUALITY && quality <= MAX_QUALITY;
  }


  public static void updateQuality(List<Item> items)
  {
    for (int i = 0; i < items.size(); i++)
    {
      Item item = items.get(i);
      if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
      {

        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
        {
          changeQuality(-1, item);
        }

      }
      else
      {
        changeQuality(1, item);

        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
        {
          if (item.getSellIn() <= PASSES_LIMIT)
          {
            changeQuality(1, item);
          }

          if (item.getSellIn() <= PASSES_LIMIT_2)
          {
            changeQuality(1, item);
          }
        }

      }

      if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
      {
        item.setSellIn(item.getSellIn() - 1);
      }

      if (item.getSellIn() < 0)
      {
        if (!"Aged Brie".equals(item.getName()))
        {
          if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
          {
            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
              changeQuality(-1, item);
            }
          }
          else
          {
            items.get(i).setQuality(item.getQuality() - item.getQuality());
          }
        }
        else
        {
          changeQuality(1, item);
        }
      }
    }
  }


}
