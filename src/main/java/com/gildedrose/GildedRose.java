package com.gildedrose;

import com.gildedrose.ItemType.RegularItemType;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (Item item : items) {
            if (item instanceof RegularItemType) {
                ((RegularItemType) item).updateItem();
            } else {
                if (item.sellIn <= 0) item.quality -= 2;
                else item.quality--;
                if (item.quality < 0) item.quality = 0;

                item.sellIn--;
            }
        }
    }
}