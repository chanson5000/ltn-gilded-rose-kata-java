package com.gildedrose;

import com.gildedrose.ItemType.BackstagePassItemType;
import com.gildedrose.ItemType.SulfurasItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class SulfurasItemTypeTests {

    @RunWith(Parameterized.class)
    public static class QualityParameterizedTests {
        private int startingSellIn;
        private int startingQuality;
        private int expectedQuality;
        private SulfurasItemType sulfurasItemType;

        @Before
        public void SetUp(){
            sulfurasItemType = new SulfurasItemType("Sulfurus", 5, 80);
        }

        public QualityParameterizedTests(int startingSellIn, int startingQuality, int expectedQuality){
            this.startingSellIn = startingSellIn;
            this.startingQuality = startingQuality;
            this.expectedQuality = expectedQuality;
        }

        @Parameterized.Parameters
        public static Collection parameters() {
            return Arrays.asList(new Object[][] {
                    {-1, 50, 80},
                    {0, 50, 80},
                    {0, 80, 80}
            });
        }

        @Test
        public void WhenUpdated_QualityChangesCorrectly() {
            sulfurasItemType.sellIn = startingSellIn;
            sulfurasItemType.quality = startingQuality;

            sulfurasItemType.updateItem();

            assertEquals(expectedQuality, sulfurasItemType.quality);
        }
    }

    public static class NonParameterizedTests {
        private SulfurasItemType sulfurasItemType;

        @Before
        public void SetUp() {
            sulfurasItemType = new SulfurasItemType("Sulfurus", 5, 80);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = 5;

            sulfurasItemType.updateItem();

            assertEquals(expectedSellIn, sulfurasItemType.sellIn);
        }
    }
}
