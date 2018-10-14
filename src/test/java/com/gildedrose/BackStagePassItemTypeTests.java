package com.gildedrose;

import com.gildedrose.ItemType.BackstagePassItemType;
import com.gildedrose.ItemType.ItemTypeHelper;
import com.gildedrose.ItemType.RegularItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class BackStagePassItemTypeTests {

    private static final String DEFAULT_NAME = ItemTypeHelper.BackstagePassTafka;
    private static final int DEFAULT_SELL_IN = 5;
    private static final int DEFAULT_QUALITY = 6;
    private static BackstagePassItemType backstagePassItemType;

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

        @Before
        public void SetUp() {
            backstagePassItemType = new BackstagePassItemType(
                    DEFAULT_NAME,
                    DEFAULT_SELL_IN,
                    DEFAULT_QUALITY);
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

        @Before
        public void SetUp() {
            backstagePassItemType = new BackstagePassItemType(
                    DEFAULT_NAME,
                    DEFAULT_SELL_IN,
                    DEFAULT_QUALITY);
        }

        @Test
        public void WhenBackstagePassItemType_IsInstanceOfRegularItemType() {
            assertThat(backstagePassItemType, instanceOf(RegularItemType.class));
        }

        @Test
        public void WhenBackstagePassItemTypeCreated_ConstructorsMatchFields() {
            assertEquals(DEFAULT_NAME, backstagePassItemType.name);
            assertEquals(DEFAULT_SELL_IN, backstagePassItemType.sellIn);
            assertEquals(DEFAULT_QUALITY, backstagePassItemType.quality);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = DEFAULT_SELL_IN - 1;

            backstagePassItemType.updateItem();

            assertEquals(expectedSellIn, backstagePassItemType.sellIn);
        }

        @Test
        public void ToString_ReturnsCorrectValuesString() {
            String expectedString = DEFAULT_NAME
                    + ", " + DEFAULT_SELL_IN
                    + ", " + DEFAULT_QUALITY;

            assertEquals(expectedString, backstagePassItemType.toString());
        }
    }
}
