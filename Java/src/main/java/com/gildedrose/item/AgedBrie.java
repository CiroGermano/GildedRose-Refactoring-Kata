package com.gildedrose.item;

public class AgedBrie implements PersonalizedItem {

	
	Item item;
	private int degradationRate;

	public AgedBrie(Item item) {
		this.item = item;
		this.degradationRate = 0;
	}

	@Override
	public void updateQuality() {
		item.sellIn--;

		if (item.quality >= 50) {
			return;
		}

		increaseQuality(item);

		if (item.sellIn < 0) {
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