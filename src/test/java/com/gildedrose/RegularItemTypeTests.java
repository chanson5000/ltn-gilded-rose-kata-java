package com.gildedrose;

import com.gildedrose.ItemType.RegularItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class RegularItemTypeTests {

    private static final String REGULAR_DEFAULT_NAME = "Regular Item";
    private static final int REGULAR_DEFAULT_SELL_IN = 5;
    private static final int REGULAR_DEFAULT_QUALITY = 6;
    private static RegularItemType regularItemType;

    @RunWith(Parameterized.class)
    public static class QualityParameterizedTests {

        private final int startingSellIn;
        private final int startingQuality;
        private final int expectedQuality;

        public QualityParameterizedTests(int startingSellIn, int startingQuality, int expectedQuality) {
            this.startingSellIn = startingSellIn;
            this.startingQuality = startingQuality;
            this.expectedQuality = expectedQuality;
        }

        @Parameterized.Parameters
        public static Collection parameters() {
            return Arrays.asList(new Object[][]{
                    {-1, 50, 48},
                    {-1, 49, 47},
                    {-1, 3, 1},
                    {-1, 2, 0},
                    {-1, 1, 0},
                    {-1, 0, 0},
                    {0, 50, 48},
                    {0, 49, 47},
                    {0, 3, 1},
                    {0, 2, 0},
                    {0, 1, 0},
                    {0, 0, 0},
                    {1, 50, 49},
                    {1, 49, 48},
                    {1, 3, 2},
                    {1, 2, 1},
                    {1, 1, 0},
                    {1, 0, 0},
            });
        }

        @Before
        public void SetUp() {
            regularItemType = new RegularItemType(
                    REGULAR_DEFAULT_NAME,
                    REGULAR_DEFAULT_SELL_IN,
                    REGULAR_DEFAULT_QUALITY);
        }

        @Test
        public void WhenUpdated_QualityChangesCorrectly() {
            regularItemType.sellIn = startingSellIn;
            regularItemType.quality = startingQuality;

            regularItemType.updateItem();

            assertEquals(expectedQuality, regularItemType.quality);
        }
    }

    public static class NonParameterizedTests {

        @Before
        public void SetUp() {
            regularItemType = new RegularItemType(
                    REGULAR_DEFAULT_NAME,
                    REGULAR_DEFAULT_SELL_IN,
                    REGULAR_DEFAULT_QUALITY);
        }

        @Test
        public void WhenRegularItemTypeCreated_ConstructorsMatchFields() {
            assertEquals(REGULAR_DEFAULT_NAME, regularItemType.name);
            assertEquals(REGULAR_DEFAULT_SELL_IN, regularItemType.sellIn);
            assertEquals(REGULAR_DEFAULT_QUALITY, regularItemType.quality);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = REGULAR_DEFAULT_SELL_IN - 1;

            regularItemType.updateItem();

            assertEquals(expectedSellIn, regularItemType.sellIn);
        }

        @Test
        public void ToString_ReturnsCorrectValuesString() {
            String expectedString = REGULAR_DEFAULT_NAME
                    + ", " + REGULAR_DEFAULT_SELL_IN
                    + ", " + REGULAR_DEFAULT_QUALITY;

            assertEquals(expectedString, regularItemType.toString());
        }
    }
}
