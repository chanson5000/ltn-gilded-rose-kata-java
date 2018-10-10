package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if (InventoryTypes.AgeableBrie.contains(items[i].name)) {
                items[i] = InventoryUpdateRules.AgedBrie(items[i]);

            } else if (InventoryTypes.BackstagePass.contains(items[i].name)) {
                items[i] = InventoryUpdateRules.BackstagePass(items[i]);

            } else if (InventoryTypes.Sulfuras.contains(items[i].name)) {
                items[i] = InventoryUpdateRules.Sulfuras(items[i]);

            } else if (InventoryTypes.Conjured.contains(items[i].name)) {
                items[i] = InventoryUpdateRules.Conjured(items[i]);

            } else {
                items[i] = InventoryUpdateRules.RegularItem(items[i]);

            }
        }
    }
}