package com.gildedrose.item;

public class Sulfuras implements PersonalizedItem {
	Item item;
	private int degradationRate;

	public Sulfuras(Item item) {
		this.item = item;
		this.degradationRate = 0;
	}

	/**
	 * Sulfuras, being a legendary item, never has to be sold or decreases in
	 * Quality
	 */
	public void updateQuality() {

	}

	@Override
	public int getDegradationRate() {
		return this.degradationRate;
	}

}