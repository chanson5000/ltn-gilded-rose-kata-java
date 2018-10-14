package com.gildedrose;

import com.gildedrose.ItemType.AgeableBrieItemType;
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
public class AgeableBreItemTypeTests {

    private static final String DEFAULT_NAME = ItemTypeHelper.AgedBrie;
    private static final int DEFAULT_SELL_IN = 5;
    private static final int DEFAULT_QUALITY = 6;
    private static AgeableBrieItemType ageableBrieItemType;

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

        @Before
        public void SetUp() {
            ageableBrieItemType = new AgeableBrieItemType(
                    DEFAULT_NAME,
                    DEFAULT_SELL_IN,
                    DEFAULT_QUALITY);
        }

        @Test
        public void WhenUpdated_QualityChangesCorrectlyBasedOnSellIn() {
            ageableBrieItemType.sellIn = startingSellIn;
            ageableBrieItemType.quality = startingQuality;

            ageableBrieItemType.updateItem();

            assertEquals(expectedQuality, ageableBrieItemType.quality);
        }
    }

    public static class NonParameterizedTests {

        @Before
        public void SetUp() {
            ageableBrieItemType = new AgeableBrieItemType(
                    DEFAULT_NAME,
                    DEFAULT_SELL_IN,
                    DEFAULT_QUALITY);
        }

        @Test
        public void WhenAgeableBrieItemTypeCreated_IsInstanceOfRegularItemType() {
            assertThat(ageableBrieItemType, instanceOf(RegularItemType.class));
        }

        @Test
        public void WhenAgeableBrieItemTypeCreated_ConstructorsMatchFields() {
            assertEquals(DEFAULT_NAME, ageableBrieItemType.name);
            assertEquals(DEFAULT_SELL_IN, ageableBrieItemType.sellIn);
            assertEquals(DEFAULT_QUALITY, ageableBrieItemType.quality);
        }

        @Test
        public void WhenUpdated_SellInDecreasesByOne() {
            int expectedSellIn = DEFAULT_SELL_IN - 1;

            ageableBrieItemType.updateItem();

            assertEquals(expectedSellIn, ageableBrieItemType.sellIn);
        }

        @Test
        public void ToString_ReturnsCorrectValuesString() {
            String expectedString = DEFAULT_NAME
                    + ", " + DEFAULT_SELL_IN
                    + ", " + DEFAULT_QUALITY;

            assertEquals(expectedString, ageableBrieItemType.toString());
        }
    }
}
