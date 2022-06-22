package com.gildedrose;

class GildedRose {
    private static final int SIX = 6;
	private static final int ELEVEN = 11;
	private static final int ZERO = 0;
	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isEqualsAgedBrieOrBackstagePass(item)) {
                if (item.quality > ZERO) {
                    if (!isSulfuras(item)) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (isUnderMaximumQualityValue(item)) {
                    increaseQuality(item);

                    if (isBackstagePass(item)) {
                        if (item.sellIn < ELEVEN) {
                            if (isUnderMaximumQualityValue(item)) {
                                increaseQuality(item);
                            }
                        }

                        if (item.sellIn < SIX) {
                            if (isUnderMaximumQualityValue(item)) {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(item)) {
                decreaseSellIn(item);
            }

            if (item.sellIn < ZERO) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePass(item)) {
                        if (item.quality > ZERO) {
                            if (!isSulfuras(item)) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        setQualityToZero(item);
                    }
                } else {
                    if (isUnderMaximumQualityValue(item)) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

	private int setQualityToZero(Item item) {
		return item.quality = item.quality - item.quality;
	}

	private boolean isAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	private int decreaseSellIn(Item item) {
		return item.sellIn = item.sellIn - 1;
	}

	private int decreaseQuality(Item item) {
		return item.quality = item.quality - 1;
	}

	private boolean isBackstagePass(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private int increaseQuality(Item item) {
		return item.quality = item.quality + 1;
	}

	private boolean isSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isEqualsAgedBrieOrBackstagePass(Item item) {
		return isAgedBrie(item)
		        || isBackstagePass(item);
	}

	private boolean isUnderMaximumQualityValue(Item item) {
		return item.quality < 50;
	}
}