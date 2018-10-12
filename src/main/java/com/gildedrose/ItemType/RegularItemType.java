package com.gildedrose.ItemType;

import com.gildedrose.Item;

public class RegularItemType extends Item implements ItemType {

    public RegularItemType(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        if (sellIn <= 0) quality-=2;
        else quality--;

        if (quality < 0) quality = 0;

        sellIn--;
    }
}
