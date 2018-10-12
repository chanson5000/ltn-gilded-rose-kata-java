package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.ItemType.BackstagePassItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class BackStagePassItemTypeTests {


    @RunWith(Parameterized.class)
    public static class QualityParameterizedTests {

        private int startingSellIn;
        private int startingQuality;
        private int expectedQuality;
        private BackstagePassItemType backstagePassItemType;

        @Before
        public void SetUp() {
            backstagePassItemType = new BackstagePassItemType("Back Stage Pass" , 5, 5);
        }

        public QualityParameterizedTests(int startingSellIn, int startingQuality, int expectedQuality) {
            this.startingSellIn = startingSellIn;
            this.startingQuality = startingQuality;
            this.expectedQuality = expectedQuality;
        }

        @Parameterized.Parameters
        public static Collection parameters() {
            return Arrays.asList(new Object[][]{
                    {0, 50, 0},
                    {0, 49, 0},
                    {0, 1, 0},
                    {0, 0, 0},
                    {1, 0, 3},
                    {1, 1, 4},
                    {1, 46, 49},
                    {1, 47, 50},
                    {1, 48, 50},
                    {1, 49, 50},
                    {1, 50, 50},
                    {5, 46, 49},
                    {5, 47, 50},
                    {5, 48, 50},
                    {5, 49, 50},
                    {5, 50, 50},
                    {6, 0, 2},
                    {6, 1, 3},
                    {6, 47, 49},
                    {6, 48, 50},
                    {6, 49, 50},
                    {6, 50, 50},
                    {10, 0, 2},
                    {10, 1, 3},
                    {10, 47, 49},
                    {10, 48, 50},
                    {10, 49, 50},
                    {10, 50, 50},
                    {11, 0, 1},
                    {11, 1, 2},
                    {11, 48, 49},
                    {11, 49, 50}
            });
        }

        @Test
        public void WhenUpdated_QualityChangesCorrectly() {
            backstagePassItemType.sellIn = startingSellIn;
            backstagePassItemType.quality = startingQuality;

            backstagePassItemType.updateItem();

            assertEquals(expectedQuality, backstagePassItemType.quality);
        }
    }

    public static class NonParameterizedTests {
        private BackstagePassItemType backstagePassItemType;

        @Before
        public void SetUp() {
            backstagePassItemType = new BackstagePassItemType("Backstage Pass", 5, 5);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = 4;

            backstagePassItemType.updateItem();

            assertEquals(expectedSellIn, backstagePassItemType.sellIn);
        }
    }
}
