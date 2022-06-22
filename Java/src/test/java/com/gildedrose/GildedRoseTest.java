package com.gildedrose;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

import com.gildedrose.item.Item;

class GildedRoseTest {

	@Test
	void given_item_when_updateQuality_then_sellInDecrease() {
		Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(1, equalTo(items[0].sellIn));
	}

	@Test
	void given_item_when_updateQuality_then_qualityIsNeverNegative() {
		Item[] items = new Item[] { new Item("Giant Sword", -1, 1), new Item("Axe", 1, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(0, equalTo(items[0].quality));
		assertThat(0, equalTo(items[1].quality));
	}

	@Test
	void given_item_when_updateQuality_then_qualityIsNeverMoreThanFifty() {
		Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();
		assertThat(items[0].quality, lessThanOrEqualTo(50));

		app.updateQuality();
		assertThat(items[0].quality, lessThanOrEqualTo(50));
	}

	@Test
	void given_defaultItemWithSellInLessThanZero_when_updateQuality_then_decreaseQualityByTwo() {
		Item[] items = new Item[] { new Item("Giant Sword", -1, 5) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(3, equalTo(items[0].quality));
	}

	@Test
	void given_agedBrieItemWithSellInMoreThanOrEqualZero_when_updateQuality_then_improveQualityByOne() {
		Item[] items = new Item[] { new Item("Aged Brie", 12, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(1, equalTo(items[0].quality));
	}

	@Test
	void given_agedBrieItemWithSellInLessThanZero_when_updateQuality_then_improveQualityByTwo() {
		Item[] items = new Item[] { new Item("Aged Brie", -1, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(2, equalTo(items[0].quality));
	}

	@Test
	void given_sulfurasItem_when_updateQuality_then_qualityNotChange() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(80, equalTo(items[0].quality));
	}

	@Test
	void given_sulfurasItem_when_updateQuality_then_sellInNotChange() {
		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(10, equalTo(items[0].sellIn));
	}
	
	@Test
	void given_backstagePassesItemWithSellInLessThanOrEqualTeen_when_updateQuality_then_improveQualityByTwo() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 2) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		assertThat(4, equalTo(items[0].quality));
	}

	@Test
	void given_backstagePassesItemWithSellInLessThanOrEqualFive_when_updateQuality_then_improveQualityByThree() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2) };
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		assertThat(5, equalTo(items[0].quality));
		
		app.updateQuality();
		assertThat(8, equalTo(items[0].quality));
	}
	
	@Test
	void given_backstagePassesItemWithSellInLessThanZero_when_updateQuality_then_decreaseQualityToZero() {
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30) };
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		assertThat(0, equalTo(items[0].quality));
	}
	
	@Test
	void given_conjuredItemWithSellInMoreThanZero_when_updateQuality_then_decreaseQualityTwiceFastAsNormalItem() {
		Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6), new Item("Axe", 3, 6) };
		GildedRose app = new GildedRose(items);
		
		app.updateQuality();
		assertThat(4, equalTo(items[0].quality));
		assertThat(5, equalTo(items[1].quality));
	}
}
