package com.gildedrose.item;

public class Conjured implements PersonalizedItem {

	Item item;

	public Conjured(Item item) {
		this.item = item;
	}

	@Override
	public int getDegradationRate() {
		return ItemDegradationConsultant.getDegradationRate(new Normal()) * 2;
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
		for(int i = getDegradationRate() ; i > 0 ; i--) {
			if (item.quality == 0) {
				return;
			}
			item.quality--;
		}
	}

}