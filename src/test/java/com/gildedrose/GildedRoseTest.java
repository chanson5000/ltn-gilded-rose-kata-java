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
    public void AgedBrieType_ReturnsAgedBrieName() {
        String expectedName = AgeableBrieType;

        String actualName = SetUpItem(AgeableBrieType, 5, 0).items[0].name;

        assertEquals(expectedName, actualName);
    }

    @Test
    public void AgedBrieType_SellInDecreasesByOne() {
        int startingSellIn = 5;
        int expectedSellIn = 4;

        int actualSellIn = SetUpItem(AgeableBrieType, startingSellIn, 0).items[0].sellIn;

        assertEquals(expectedSellIn, actualSellIn);
    }

    @Test
    public void AgedBrieType_QualityIncreasesByOne() {
        int startingQuality = 0;
        int expectedQuality = 1;

        int actualQuality = SetUpItem(AgeableBrieType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void AgedBrieTypeWhenSellInIsOne_QualityIncreasesByOne() {
        int startingSellIn = 1;
        int startingQuality = 5;
        int expectedQuality = 6;

        int actualQuality = SetUpItem(AgeableBrieType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void AgedBrieTypeWhenSellInIsZero_QualityIncreasesByTwo() {
        int startingSellIn = 0;
        int startingQuality = 5;
        int expectedQuality = 7;

        int actualQuality = SetUpItem(AgeableBrieType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void AgedBrieTypeWhenSellInIsNegative_QualityIncreasesByTwo() {
        int startingSellIn = -1;
        int startingQuality = 5;
        int expectedQuality = 7;

        int actualQuality = SetUpItem(AgeableBrieType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality,actualQuality);
    }

    @Test
    public void AgedBrieTypeWhenSellInIsNegativeAndQualityCloseToFifty_QualityIsFifty() {
        int startingSellIn = -1;
        int startingQuality = 49;
        int expectedQuality = 50;

        int actualQuality = SetUpItem(AgeableBrieType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void AgedBrieAndMaxQuality_QualityIsFifty() {
        int expectedQuality = 50;

        int actualQuality = SetUpItem(AgeableBrieType, 5, 50).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassType_ReturnsBackstagePassName() {
        String expectedName = BackstagePassType;

        String actualName = SetUpItem(BackstagePassType, 5, 0).items[0].name;

        assertEquals(expectedName, actualName);
    }

    @Test
    public void BackstagePassTypeWhenMoreThanTenSellIn_QualityIncreasesByOne() {
        int startingSellIn = 11;
        int startingQuality = 5;
        int expectedQuality = 6;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackStagePassTypeWhenTenSellIn_QualityIncreasesByTwo() {
        int startingSellIn = 10;
        int startingQuality = 5;
        int expectedQuality = 7;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassTypeWhenSixSellIn_QualityIncreasesByTwo() {
        int startingSellIn = 6;
        int startingQuality = 5;
        int expectedQuality = 7;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassTypeWhenFiveSellIn_QualityIncreasesByThree() {
        int startingSellIn = 5;
        int startingQuality = 5;
        int expectedQuality = 8;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassTypeWhenOneSellIn_QualityIncreasesByThree() {
        int startingSellIn = 1;
        int startingQuality = 5;
        int expectedQuality = 8;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void BackstagePassTypeWhenZeroSellIn_QualityIsZero() {
        int startingSellIn = 0;
        int startingQuality = 5;
        int expectedQuality = 0;

        int actualQuality = SetUpItem(BackstagePassType, startingSellIn, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void SulfurasType_StaysTheSame() {
        int startingSellIn = 5;
        int startingQuality = 80;
        int expectedSellIn = 5;
        int expectedQuality = 80;
        String expectedName = SulfurusType;

        Item sulfurusItem = SetUpItem(SulfurusType, startingSellIn, startingQuality).items[0];

        assertEquals(expectedName, sulfurusItem.name);
        assertEquals(expectedQuality, sulfurusItem.quality);
        assertEquals(expectedSellIn, sulfurusItem.sellIn);
    }

    @Test
    public void ConjuredType_ReturnsSameName() {
        String expectedName = ConjuredType;

        String actualName = SetUpItem(ConjuredType, 5, 5).items[0].name;

        assertEquals(expectedName, actualName);
    }

    @Test
    public void ConjuredTypeWhenQualityNotMin_QualityDecreasesByTwo() {
        int startingQuality = 5;
        int expectedQuality = 3;

        int actualQuality = SetUpItem(ConjuredType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void ConjuredTypeWhenQualityIsTwo_QualityDecreasesByTwo() {
        int startingQuality = 2;
        int expectedQuality = 0;

        int actualQuality = SetUpItem(ConjuredType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void ConjuredTypeWhenQualityIsOne_QualityDecreasesByOne() {
        int startingQuality = 1;
        int expectedQuality = 0;

        int actualQuality = SetUpItem(ConjuredType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void ConjuredTypeWhenQualityIsZero_QualityStaysZero() {
        int startingQuality = 0;
        int expectedQuality = 0;

        int actualQuality = SetUpItem(ConjuredType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void NormalTypeWhenQualityNotMin_QualityDecreasesByOne() {
        int startingQuality = 5;
        int expectedQuality = 4;

        int actualQuality = SetUpItem(RegularType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void NormalTypeWhenQualityIsTwo_QualityDecreasesByOne() {
        int startingQuality = 2;
        int expectedQuality = 1;

        int actualQuality = SetUpItem(RegularType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void NormalTypeWhenQualityIsOne_QualityDecreasesByOne() {
        int startingQuality = 1;
        int expectedQuality = 0;

        int actualQuality = SetUpItem(RegularType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void NormalTypeWhenQualityIsZero_QualityStaysZero() {
        int startingQuality = 0;
        int expectedQuality = 0;

        int actualQuality = SetUpItem(RegularType, 5, startingQuality).items[0].quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void NormalTypeWhenSellInIsZero_SellByDecreasesByOne() {
        int startingSellIn = 0;
        int expectedSellIn = -1;

        int actualSellIn = SetUpItem(RegularType, startingSellIn, 5).items[0].sellIn;

        assertEquals(expectedSellIn, actualSellIn);
    }
}
