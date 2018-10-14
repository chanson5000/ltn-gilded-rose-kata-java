package com.gildedrose;

import com.gildedrose.ItemType.*;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] oldItems = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item now works properly
                new Item("Conjured Mana Cake", 3, 6) };

        Item[] newItems = new Item[] {
                new RegularItemType("+5 Dexterity Vest", 10, 20), //
                new AgeableBrieItemType("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new SulfurasItemType("Sulfuras, Hand of Ragnaros", 0, 80), //
                new SulfurasItemType("Sulfuras, Hand of Ragnaros", -1, 80),
                new BackstagePassItemType("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new BackstagePassItemType("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new BackstagePassItemType("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item now works properly
                new ConjuredItemType("Conjured Mana Cake", 3, 6) };

        GildedRose oldApp = new GildedRose(oldItems);
        GildedRose newApp = new GildedRose(newItems);

        int days = 4;
        boolean isNewItems = false;

        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        GildedRose app;
        Item[] items;

        if (isNewItems) {
            app = newApp;
            items = newItems;
        } else {
            app = oldApp;
            items = oldItems;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");

            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
