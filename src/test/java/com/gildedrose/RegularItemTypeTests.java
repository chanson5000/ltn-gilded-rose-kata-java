package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.ItemType.RegularItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class RegularItemTypeTests {

    @RunWith(Parameterized.class)
    public static class QualityParameterizedTests {

        private int startingSellIn;
        private int startingQuality;
        private int expectedQuality;
        private RegularItemType regularItemType;

        @Before
        public void SetUp() {
            regularItemType = new RegularItemType("Regular Item", 5, 5);
        }

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

        @Test
        public void WhenUpdated_QualityChangesCorrectly() {
            regularItemType.sellIn = startingSellIn;
            regularItemType.quality = startingQuality;

            regularItemType.updateItem();

            assertEquals(expectedQuality, regularItemType.quality);
        }
    }

    public static class NonParameterizedTests {

        private RegularItemType regularItemType;

        @Before
        public void SetUp() {
            regularItemType = new RegularItemType("Regular Item", 5, 5);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = 4;

            regularItemType.updateItem();

            assertEquals(expectedSellIn, regularItemType.sellIn);
        }
    }
}
