package com.gildedrose;

import com.gildedrose.ItemType.ItemTypeHelper;
import com.gildedrose.ItemType.RegularItemType;
import com.gildedrose.ItemType.UpdateableItem;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (int i = 0; i < items.length ; i++) {
            if (items[i] instanceof RegularItemType) {
                ((RegularItemType) items[i]).updateItem();
            } else {
                UpdateableItem updateableItem = ItemTypeHelper.convertToUpdateable(items[i]);
                updateableItem.updateItem();
                items[i] = (Item) updateableItem;
            }
        }
    }
}
