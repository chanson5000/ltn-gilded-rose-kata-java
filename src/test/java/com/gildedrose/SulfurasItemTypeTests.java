package com.gildedrose;

import com.gildedrose.ItemType.ItemTypeHelper;
import com.gildedrose.ItemType.RegularItemType;
import com.gildedrose.ItemType.SulfurasItemType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class SulfurasItemTypeTests {

    private static final String SULFURUS_DEFAULT_NAME = ItemTypeHelper.Sulfuras;
    private static final int SULFURUS_DEFAULT_SELL_IN = 5;
    private static final int SULFURUS_DEFAULT_QUALITY = 80;
    private static SulfurasItemType sulfurasItemType;

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
                    {-1, 50, 80},
                    {0, 50, 80},
                    {0, 80, 80}
            });
        }

        @Before
        public void SetUp() {
            sulfurasItemType = new SulfurasItemType(
                    SULFURUS_DEFAULT_NAME,
                    SULFURUS_DEFAULT_SELL_IN,
                    SULFURUS_DEFAULT_QUALITY);
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

        @Before
        public void SetUp() {
            sulfurasItemType = new SulfurasItemType(
                    SULFURUS_DEFAULT_NAME,
                    SULFURUS_DEFAULT_SELL_IN,
                    SULFURUS_DEFAULT_QUALITY);
        }

        @Test
        public void WhenSulfurusItemTypeCreated_IsInstanceOfRegularItem() {
            assertThat(sulfurasItemType, instanceOf(RegularItemType.class));
        }

        @Test
        public void WhenSulfurusItemTypeCreated_ConstructorsMatchFields() {
            assertEquals(SULFURUS_DEFAULT_NAME, sulfurasItemType.name);
            assertEquals(SULFURUS_DEFAULT_SELL_IN, sulfurasItemType.sellIn);
            assertEquals(SULFURUS_DEFAULT_QUALITY, sulfurasItemType.quality);
        }

        @Test
        public void WhenUpdated_SellInStaysTheSame() {
            int expectedSellIn = SULFURUS_DEFAULT_SELL_IN;

            sulfurasItemType.updateItem();

            assertEquals(expectedSellIn, sulfurasItemType.sellIn);
        }

        @Test
        public void ToString_ReturnsCorrectValuesString() {
            String expectedString = SULFURUS_DEFAULT_NAME
                    + ", " + SULFURUS_DEFAULT_SELL_IN
                    + ", " + SULFURUS_DEFAULT_QUALITY;

            assertEquals(expectedString, sulfurasItemType.toString());
        }
    }
}
