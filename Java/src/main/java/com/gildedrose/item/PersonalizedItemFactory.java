package com.gildedrose.item;

import java.util.HashMap;
import java.util.Map;

public class PersonalizedItemFactory {

	@SuppressWarnings("serial")
	private final static Map<String, String> ITEM_TYPES = new HashMap<String, String>() {
		{
			put("BACKSTAGE_PASS", "BACKSTAGE PASSES TO A TAFKAL80ETC CONCERT");
			put("BRIE", "AGED BRIE");
			put("SULFURAS", "SULFURAS, HAND OF RAGNAROS");
			put("CONJURED", "CONJURED");
		}
	};

	public static PersonalizedItem getPersonalizedItem(Item item) {

		if ((item.name.toUpperCase().contains(ITEM_TYPES.get("BACKSTAGE_PASS")))) {
			return new BackstagePass(item);
		}

		if ((item.name.toUpperCase().contains(ITEM_TYPES.get("BRIE")))) {
			return new AgedBrie(item);
		}

		if ((item.name.toUpperCase().contains(ITEM_TYPES.get("SULFURAS")))) {
			return new Sulfuras(item);
		}

		if ((item.name.toUpperCase().contains(ITEM_TYPES.get("CONJURED")))) {
			return new Conjured(item);
		}

		return new Normal(item);
	}

}
