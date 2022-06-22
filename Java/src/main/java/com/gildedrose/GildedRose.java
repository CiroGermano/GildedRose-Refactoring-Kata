package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.PersonalizedItem;
import com.gildedrose.item.PersonalizedItemFactory;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			PersonalizedItem personalizedItem = PersonalizedItemFactory.getPersonalizedItem(item);
			personalizedItem.updateQuality();
		}
	}
}