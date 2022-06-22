package com.gildedrose.item;

public class BackstagePass implements PersonalizedItem {

	Item item;
	private int degradationRate;

	public BackstagePass(Item item) {
		this.item = item;
		this.degradationRate = 0;
	}

	@Override
	public void updateQuality() {
		item.sellIn--;

		if (item.sellIn < 0) {
			item.quality = 0;
			return;
		}
		
		if (item.quality == 50) {
			return;
		}

		increaseQuality(item);

		if (item.sellIn < 10) {
			increaseQuality(item);
		}

		if (item.sellIn < 5) {
			increaseQuality(item);
		}
	}

	public void increaseQuality(Item item) {
		if (item.quality == 50) {
			return;
		}
		item.quality++;
	}

	@Override
	public int getDegradationRate() {
		return this.degradationRate;
	}
}