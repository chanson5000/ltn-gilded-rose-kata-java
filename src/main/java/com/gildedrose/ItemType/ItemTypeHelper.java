package com.gildedrose.ItemType;

import com.gildedrose.Item;

public class ItemTypeHelper {
    public static final String AgedBrie = "Aged Brie";
    public static final String Sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String BackstagePassTafka = "Backstage passes to a TAFKAL80ETC concert";
    public static final String ConjuredManaCake = "Conjured Mana Cake";

    public static UpdateableItem convert(Item item) {

        switch (item.name) {
            case AgedBrie:
                return new AgeableBrieItemType(item.name, item.sellIn, item.quality);
            case Sulfuras:
                return new SulfurasItemType(item.name, item.sellIn, item.quality);
            case BackstagePassTafka:
                return new BackstagePassItemType(item.name, item.sellIn, item.quality);
            case ConjuredManaCake:
                return new ConjuredItemType(item.name, item.sellIn, item.quality);
            default:
                return new RegularItemType(item.name, item.sellIn, item.quality);
        }
    }
}
