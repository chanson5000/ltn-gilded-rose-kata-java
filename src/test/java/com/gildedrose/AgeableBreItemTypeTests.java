package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.ItemType.AgeableBrieItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class AgeableBreItemTypeTests {

    @RunWith(Parameterized.class)
    public static class QualityParameterizedTests {

        private int startingSellIn;
        private int startingQuality;
        private int expectedQuality;
        private AgeableBrieItemType ageableBreItemType;

        @Before
        public void SetUp() {
            ageableBreItemType = new AgeableBrieItemType("Aged Brie", 5, 5);
        }

        public QualityParameterizedTests(int startingSellIn, int startingQuality, int expectedQuality) {
            this.startingSellIn = startingSellIn;
            this.startingQuality = startingQuality;
            this.expectedQuality = expectedQuality;
        }

        @Parameterized.Parameters
        public static Collection parameters() {
            return Arrays.asList(new Object[][]{
                    {-1, 0, 2},
                    {-1, 1, 3},
                    {-1, 47, 49},
                    {-1, 48, 50},
                    {-1, 49, 50},
                    {-1, 50, 50},
                    {0, 0, 2},
                    {0, 1, 3},
                    {0, 47, 49},
                    {0, 48, 50},
                    {0, 49, 50},
                    {0, 50, 50},
                    {1, 0, 1},
                    {1, 1, 2},
                    {1, 48, 49},
                    {1, 49, 50},
                    {1, 50, 50}
            });
        }

        @Test
        public void WhenUpdated_QualityChangesCorrectlyBasedOnSellIn() {
            ageableBreItemType.sellIn = startingSellIn;
            ageableBreItemType.quality = startingQuality;

            ageableBreItemType.updateItem();

            assertEquals(expectedQuality, ageableBreItemType.quality);
        }
    }

    public static class NonParameterizedTests {

        private AgeableBrieItemType ageableBrieItemType;

        @Before
        public void SetUp() {
            ageableBrieItemType = new AgeableBrieItemType("Aged Brie", 5, 5);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = 4;

            ageableBrieItemType.updateItem();

            assertEquals(expectedSellIn, ageableBrieItemType.sellIn);
        }
    }


}
