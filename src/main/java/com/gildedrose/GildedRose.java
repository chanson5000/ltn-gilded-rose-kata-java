package com.gildedrose;

import com.gildedrose.ItemType.RegularItemType;
import com.gildedrose.ItemType.ItemTypeHelper;

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
                ItemTypeHelper.convert(item).updateItem();
            }
        }
    }
}