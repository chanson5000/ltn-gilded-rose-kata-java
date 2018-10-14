package com.gildedrose;

import com.gildedrose.ItemType.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTypeHelperTests {

    private static final int DEFAULT_SELL_IN = 5;
    private static final int DEFAULT_QUALITY = 6;
    private static Item itemToConvert;

    private Class getItemConvertedClass(Item item) {
        return ItemTypeHelper.convertToUpdateable(item).getClass();
    }

    @Test
    public void ConvertWithAgedBrieName_ReturnsClassOfAgeableBrieItemType() {
        itemToConvert = new Item(ItemTypeHelper.AgedBrie, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        Class actualClass = getItemConvertedClass(itemToConvert);

        assertEquals(actualClass, AgeableBrieItemType.class);
    }

    @Test
    public void ConvertWithSulfurusName_ReturnsClassOfSulfurusItemType() {
        itemToConvert = new Item(ItemTypeHelper.Sulfuras, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        Class actualClass = getItemConvertedClass(itemToConvert);

        assertEquals(actualClass, SulfurasItemType.class);
    }

    @Test
    public void ConvertWithBackstagePassName_ReturnsClassOfBackstagePassItemType() {
        itemToConvert = new Item(ItemTypeHelper.BackstagePassTafka, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        Class actualClass = getItemConvertedClass(itemToConvert);

        assertEquals(actualClass, BackstagePassItemType.class);
    }

    @Test
    public void ConvertWithConjuredName_ReturnsClassOfConjuredItemType() {
        itemToConvert = new Item(ItemTypeHelper.ConjuredManaCake, DEFAULT_SELL_IN, DEFAULT_QUALITY);

        Class actualClass = getItemConvertedClass(itemToConvert);

        assertEquals(actualClass, ConjuredItemType.class);
    }

    @Test
    public void WhenOtherName_ReturnsClassOfRegularItemType() {
        itemToConvert = new Item("Any other item name string", DEFAULT_SELL_IN, DEFAULT_QUALITY);

        Class actualClass = getItemConvertedClass(itemToConvert);

        assertEquals(actualClass, RegularItemType.class);
    }
}
