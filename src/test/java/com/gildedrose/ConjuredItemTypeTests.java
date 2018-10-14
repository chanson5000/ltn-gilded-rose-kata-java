package com.gildedrose;

import com.gildedrose.ItemType.ConjuredItemType;
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
public class ConjuredItemTypeTests {

    private static final String DEFAULT_NAME = ItemTypeHelper.ConjuredManaCake;
    private static final int CONJURED_DEFAULT_SELL_IN = 5;
    private static final int CONJURED_DEFAULT_QUALITY = 6;
    private static ConjuredItemType conjuredItemType;

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

        @Before
        public void SetUp() {
            conjuredItemType = new ConjuredItemType(
                    DEFAULT_NAME,
                    CONJURED_DEFAULT_SELL_IN,
                    CONJURED_DEFAULT_QUALITY);
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

        @Before
        public void SetUp() {
            conjuredItemType = new ConjuredItemType(
                    DEFAULT_NAME,
                    CONJURED_DEFAULT_SELL_IN,
                    CONJURED_DEFAULT_QUALITY);
        }

        @Test
        public void WhenConjuredItemTypeCreated_IsInstanceOfRegularItemType() {
            assertThat(conjuredItemType, instanceOf(RegularItemType.class));
        }

        @Test
        public void WhenConjuredItemTypeCreated_ConstructorsMatchFields() {
            assertEquals(DEFAULT_NAME, conjuredItemType.name);
            assertEquals(CONJURED_DEFAULT_SELL_IN, conjuredItemType.sellIn);
            assertEquals(CONJURED_DEFAULT_QUALITY, conjuredItemType.quality);
        }

        @Test
        public void WhenUpdated_SellInDecreasedByOne() {
            int expectedSellIn = CONJURED_DEFAULT_SELL_IN - 1;

            conjuredItemType.updateItem();

            assertEquals(expectedSellIn, conjuredItemType.sellIn);
        }

        @Test
        public void ToString_ReturnsCorrectValuesString() {
            String expectedString = DEFAULT_NAME
                    + ", " + CONJURED_DEFAULT_SELL_IN
                    + ", " + CONJURED_DEFAULT_QUALITY;

            assertEquals(expectedString, conjuredItemType.toString());
        }
    }
}

