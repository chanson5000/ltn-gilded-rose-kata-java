package com.gildedrose;

import com.gildedrose.ItemType.ConjuredItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class ConjuredItemTypeTests {

    @RunWith(Parameterized.class)
    public static class QualityParameterizedTests {

        private int startingSellIn;
        private int startingQuality;
        private int expectedQuality;
        private ConjuredItemType conjuredItemType;

        @Before
        public void SetUp() {
            conjuredItemType = new ConjuredItemType("Conjured Item", 5, 5);
        }

        public QualityParameterizedTests(int startingSellIn, int startingQuality, int expectedQuality) {
            this.startingSellIn = startingSellIn;
            this.startingQuality = startingQuality;
            this.expectedQuality = expectedQuality;
        }

        @Parameterized.Parameters
        public static Collection parameters() {
            return Arrays.asList(new Object[][]{
                    {-1, 50, 46},
                    {-1, 49, 45},
                    {-1, 5, 1},
                    {-1, 4, 0},
                    {-1, 3, 0},
                    {-1, 2, 0},
                    {-1, 1, 0},
                    {-1, 0, 0},
                    {0, 50, 46},
                    {0, 49, 45},
                    {0, 5, 1},
                    {0, 4, 0},
                    {0, 3, 0},
                    {0, 2, 0},
                    {0, 1, 0},
                    {0, 0, 0},
                    {1, 50, 48},
                    {1, 49, 47},
                    {1, 3, 1},
                    {1, 2, 0},
                    {1, 1, 0},
                    {1, 0, 0}
            });
        }

        @Test
        public void WhenUpdated_QualityChangesCorrectly() {
            conjuredItemType.sellIn = startingSellIn;
            conjuredItemType.quality = startingQuality;

            conjuredItemType.updateItem();

            assertEquals(expectedQuality, conjuredItemType.quality);
        }
    }

    public static class NonParameterizedTests {

        private ConjuredItemType conjuredItemType;

        @Before
        public void SetUp() {
            conjuredItemType = new ConjuredItemType("Conjured Item", 5, 5);
        }

        @Test
        public void WhenUpdated_SellInDecreasedByOne() {
            int expectedSellIn = 4;

            conjuredItemType.updateItem();

            assertEquals(expectedSellIn, conjuredItemType.sellIn);
        }
    }
}

