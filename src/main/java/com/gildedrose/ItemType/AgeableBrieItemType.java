package com.gildedrose.ItemType;

public class AgeableBrieItemType extends RegularItemType {
    public AgeableBrieItemType(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        if (sellIn <= 0) quality+=2;
        else quality++;

        if (quality > 50) quality = 50;

        this.sellIn--;
    }
}
