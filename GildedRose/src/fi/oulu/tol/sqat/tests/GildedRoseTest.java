package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void testDexQuality() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void testDexSell() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		
		List<Item> items = inn.getItems();
		int OriginalSellIn = items.get(0).getSellIn();
		
		inn.oneDay();
		
		int NewSellIn = items.get(0).getSellIn();
		
		assertEquals("Failed SellIn for Dex vest", OriginalSellIn - 1, NewSellIn);
	}
	
	
	
	
	@Test
	public void testElixirQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
		
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Elixir", OriginalQuality - 1, NewQuality);
	}
	
	@Test
	public void testElixirSell() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
		
		List<Item> items = inn.getItems();
		int OriginalSellIn = items.get(0).getSellIn();
		
		inn.oneDay();
		
		int NewSellIn = items.get(0).getSellIn();
		
		assertEquals("Failed SellIn for Elixir", OriginalSellIn - 1, NewSellIn);
	}
	
	@Test
	public void testElixirQualityAfterSellIn() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
		
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();	// -1
		inn.oneDay();	// -1
		inn.oneDay();	// -1
		inn.oneDay();	// -1
		inn.oneDay();	// -1
		inn.oneDay();	// -2
			
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed Quality for Elixir", OriginalQuality - 7, NewQuality);
	}
	
	@Test
	public void testBrieQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Aged Brie", OriginalQuality + 1 , NewQuality);
	}
	
	@Test
	public void testBrieSell() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		
		List<Item> items = inn.getItems();
		int OriginalSellIn = items.get(0).getSellIn();
		
		inn.oneDay();
		
		int NewSellIn = items.get(0).getSellIn();
		
		assertEquals("Failed SellIn for AgedBrie", OriginalSellIn - 1, NewSellIn);
	}
	
	@Test
	public void testSulfurasQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Aged Brie", OriginalQuality , NewQuality);
	}
	
	@Test
	public void testBackstagePassQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Backstage Pass", OriginalQuality + 1, NewQuality);
	}
	
	@Test
	public void testBackstagePassQualityAfter6Days() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +2
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Backstage Pass", OriginalQuality + 7, NewQuality);
	}
	
	@Test
	public void testBackstagePassQualityAfter11Days() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +3
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Backstage Pass", OriginalQuality + 18, NewQuality);
	}
	
	@Test
	public void testBackstagePassQualityAfter16Days() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		List<Item> items = inn.getItems();
		
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +1
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +2
		inn.oneDay();	// +3
		inn.oneDay();	// +3
		inn.oneDay();	// +3
		inn.oneDay();	// +3
		inn.oneDay();	// +3
		inn.oneDay();	// --> 0
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Backstage Pass", 0, NewQuality);
	}
	
	@Test
	public void testBrieQualityAfterSellIn() {
	    GildedRose inn = new GildedRose();
	    inn.setItem(new Item("Aged Brie", 0, 10));
	    List<Item> items = inn.getItems();
	    int OriginalQuality = items.get(0).getQuality();

	    inn.oneDay();
	    inn.oneDay();


	    int NewQuality = items.get(0).getQuality();

	    assertEquals("Failed quality for Aged Brie after sellIn", OriginalQuality + 4, NewQuality);
	}
	@Test
	public void testBrieQualityMaxAfterSellIn() {
	    GildedRose inn = new GildedRose();
	    inn.setItem(new Item("Aged Brie", 0, 49));
	    List<Item> items = inn.getItems();

	    inn.oneDay();
	    inn.oneDay();


	    int NewQuality = items.get(0).getQuality();

	    assertEquals("Failed quality for Aged Brie after sellIn", 50, NewQuality);
	}
	
	@Test
	public void testPassQualityMaxAfterSellIn() {
	    GildedRose inn = new GildedRose();
	    inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49));
	    List<Item> items = inn.getItems();

	    inn.oneDay();
	    inn.oneDay();


	    int NewQuality = items.get(0).getQuality();

	    assertEquals("Failed quality for Backstage pass after sellin and going past 50", 0, NewQuality);
	}
	
	@Test
	public void testNormalItemNegativeQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 0));
		
		List<Item> items = inn.getItems();
		
		inn.oneDay();	// -1
			
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed Quality for Elixir (should not be negative)", 0, NewQuality);
	}
	@Test
	public void testNormalItemNegativeQualityAfterSellIn() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 0, 0));
		
		List<Item> items = inn.getItems();
		
		inn.oneDay();	// -2
			
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed Quality for Elixir (should not be negative)", 0, NewQuality);
	}
	
	@Test
	public void testSulfurasQualityAfterSellIn() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		List<Item> items = inn.getItems();
		int OriginalQuality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int NewQuality = items.get(0).getQuality();
		
		assertEquals("Failed quality for Sulfuras ", OriginalQuality , NewQuality);
	}
	
}
	
