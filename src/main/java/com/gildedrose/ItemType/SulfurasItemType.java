package com.gildedrose.ItemType;

public class SulfurasItemType extends RegularItemType {

    public SulfurasItemType(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateItem() {
        quality = 80;
    }
}
