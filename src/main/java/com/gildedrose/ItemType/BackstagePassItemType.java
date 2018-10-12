package com.gildedrose.ItemType;

public class BackstagePassItemType extends RegularItemType {

    public BackstagePassItemType(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (sellIn <= 0) quality = 0;
        else if (sellIn <= 5)  quality+=3;
        else if (sellIn <= 10) quality+=2;
        else quality++;

        if (quality > 50) quality = 50;

        sellIn--;
    }
}
