package com.gildedrose.ItemType;

public class ConjuredItemType extends RegularItemType {

    public ConjuredItemType(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (sellIn <= 0) quality -= 4;
        else quality -= 2;

        if (quality < 0) quality = 0;

        sellIn--;
    }
}
