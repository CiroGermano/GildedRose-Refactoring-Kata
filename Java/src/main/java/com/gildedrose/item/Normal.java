package com.gildedrose.item;

public class Normal implements PersonalizedItem {

	Item item;
	private int degradationRate;

	public Normal() {
		this.degradationRate = 1;
	}

	public Normal(Item item) {
		this.item = item;
		this.degradationRate = 1;
	}

	@Override
	public void updateQuality() {
		item.sellIn--;

		if (item.quality == 0) {
			return;
		}

		decreaseQuality(item);

		if (item.sellIn < 0) {
			decreaseQuality(item);
		}
	}

	public void decreaseQuality(Item item) {
		for (int i = getDegradationRate(); i > 0; i--) {
			if (item.quality == 0) {
				return;
			}
			item.quality--;
		}
	}

	@Override
	public int getDegradationRate() {
		return degradationRate;
	}

}