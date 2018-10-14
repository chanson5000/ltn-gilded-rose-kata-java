package com.gildedrose;

import com.gildedrose.ItemType.AgeableBrieItemType;
import com.gildedrose.ItemType.ItemTypeHelper;
import com.gildedrose.ItemType.RegularItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class GildedRoseTests {

    private static GildedRose gildedRose;

    private static final int DEFAULT_SELL_IN = 5;
    private static final int DEFAULT_QUALITY = 6;

    private static int getItemSellIn(Item item) {
        return item.sellIn;
    }

    private static int getItemQuality(Item item) {
        return item.quality;
    }

    public static class UnconvertedItemsTests {

        private static Item regularItem;
        private static Item ageableBrieItem;

        @Before
        public void SetUp() {
            regularItem = new Item("Regular Item", DEFAULT_SELL_IN, DEFAULT_QUALITY);
            ageableBrieItem = new Item(ItemTypeHelper.AgedBrie, DEFAULT_SELL_IN, DEFAULT_QUALITY);

            Item[] items = new Item[] { regularItem, ageableBrieItem };

            gildedRose = new GildedRose(items);
        }

        @Test
        public void UpdateQuality_ItemsAreModified() {
            gildedRose.updateQuality();

            int regularItemSellIn = getItemSellIn(gildedRose.items[0]);
            int ageableBrieItemSellIn = getItemSellIn(gildedRose.items[1]);

            int regularItemQuality = getItemQuality(gildedRose.items[0]);
            int ageableBrieItemQuality = getItemQuality(gildedRose.items[1]);

            assertNotEquals(DEFAULT_SELL_IN, regularItemSellIn);
            assertNotEquals(DEFAULT_SELL_IN, ageableBrieItemSellIn);

            assertNotEquals(DEFAULT_QUALITY, regularItemQuality);
            assertNotEquals(DEFAULT_QUALITY, ageableBrieItemQuality);
        }
    }

    public static class ConvertedItemTypeTests {

        private static RegularItemType regularItemType;
        private static AgeableBrieItemType ageableBrieItemType;

        @Before
        public void SetUp() {
            regularItemType = new RegularItemType("Regular Item", DEFAULT_SELL_IN, DEFAULT_QUALITY);
            ageableBrieItemType = new AgeableBrieItemType(ItemTypeHelper.AgedBrie, DEFAULT_SELL_IN, DEFAULT_QUALITY);

            Item[] items = new Item[] { ageableBrieItemType, regularItemType };

            gildedRose = new GildedRose(items);
        }

        @Test
        public void UpdateQuality_ItemsAreModified() {
            gildedRose.updateQuality();

            int regularItemTypeSellIn = getItemSellIn(gildedRose.items[1]);
            int ageableBrieItemTypeSellIn = getItemSellIn(gildedRose.items[0]);

            int regularItemTypeQuality = getItemQuality(gildedRose.items[1]);
            int ageableBrieItemTypeQuality = getItemQuality(gildedRose.items[0]);

            assertNotEquals(DEFAULT_SELL_IN, regularItemTypeSellIn);
            assertNotEquals(DEFAULT_SELL_IN, ageableBrieItemTypeSellIn);

            assertNotEquals(DEFAULT_QUALITY, regularItemTypeQuality);
            assertNotEquals(DEFAULT_QUALITY, ageableBrieItemTypeQuality);
        }
    }
}
