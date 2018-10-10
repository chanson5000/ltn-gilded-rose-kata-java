package com.gildedrose;

class InventoryUpdateRules {

    private static Item UpdateItem(Item item, int qualityChange) {
        if (qualityChange < 0 && item.quality > 0) {
            item.quality += qualityChange;
            if (item.quality < 0) {
                item.quality = 0;
            }
        } else if (qualityChange > 0 && item.quality < 50) {
            item.quality += qualityChange;
            if (item.quality > 50) {
                item.quality = 50;
            }
        }

        return DecreaseItemSellIn(item);
    }

    private static Item DecreaseItemSellIn(Item item) {
        item.sellIn--;

        return item;
    }

    static Item RegularItem(Item item) {
        return UpdateItem(item, -1);
    }

    static Item AgedBrie(Item item) {
        return UpdateItem(item, 1);
    }

    static Item Sulfuras(Item item) {
        return item;
    }

    static Item BackstagePass(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
            return DecreaseItemSellIn(item);
        } else if (item.sellIn <= 5) {
            return UpdateItem(item, 3);
        } else if (item.sellIn <= 10) {
            return UpdateItem(item, 2);
        } else {
            return UpdateItem(item, 1);
        }
    }

    static Item Conjured(Item item) {
        return UpdateItem(item, -2);
    }
}
