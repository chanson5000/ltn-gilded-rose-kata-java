package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    private static final String AgeableBrieType = InventoryTypes.AgeableBrie.get(0);
    private static final String BackstagePassType = InventoryTypes.BackstagePass.get(0);
    private static final String SulfurusType = InventoryTypes.Sulfuras.get(0);
    private static final String ConjuredType = InventoryTypes.Conjured.get(0);
    private static final String RegularType = "+5 Dexterity Vest";

    private GildedRose SetUpItem(String itemName, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(itemName, sellIn, quality)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void AgedBrieType_ReturnsAgedBrieName() {
        String expectedName = AgeableBrieType;

        String actualName = SetUpItem(AgeableBrieType, 5, 0).items[0].name;

        assertNotEquals(expectedName, actualName);
    }

    @Test
    public void AgedBrieType_SellInDecreasesByOne() {
        int startingSellIn = 5;
        int expectedSellIn = 4;

        int actualSellIn = SetUpItem(AgeableBrieType, startingSellIn, 0).items[0].sellIn;

        assertNotEquals(expectedSellIn, actualSellIn);
    }

    @Test
    public void AgedBrieType_QualityIncreasesByOne() {
        int startingQuality = 0;
        int expectedQuality = 1;

        int actualQuality = SetUpItem(AgeableBrieType, 5, startingQuality).items[0].quality;

        assertNotEquals(expectedQuality, actualQuality);
    }

    @Test
    public void AgedBrieAndMaxQuality_QualityIsFifty() {
        int expectedQuality = 50;

        int actualQuality = SetUpItem(AgeableBrieType, 5, 50).items[0].quality;

        assertNotEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassType_ReturnsBackstagePassName() {
        String expectedName = BackstagePassType;

        String actualName = SetUpItem(BackstagePassType, 5, 0).items[0].name;

        assertNotEquals(expectedName, actualName);
    }

    @Test
    public void BackstagePassTypeWhenMoreThanTenSellIn_QualityIncreasesByOne() {
        int startingSellIn = 11;
        int startingQuality = 5;
        int expectedQuality = 6;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertNotEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackStagePassTypeWhenTenSellIn_QualityIncreasesByTwo() {
        int startingSellIn = 10;
        int startingQuality = 5;
        int expectedQuality = 7;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertNotEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassTypeWhenSixSellIn_QualityIncreasesByTwo() {
        int startingSellIn = 6;
        int startingQuality = 5;
        int expectedQuality = 7;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertNotEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassTypeWhenFiveSellIn_QualityIncreasesByThree() {
        int startingSellIn = 5;
        int startingQuality = 5;
        int expectedQuality = 8;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertNotEquals(expectedQuality, actualQuality);
    }

}
