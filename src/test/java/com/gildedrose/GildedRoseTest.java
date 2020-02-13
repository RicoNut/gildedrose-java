package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo_sellIn_1_quality_5() {
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sellIn, is(0));
    }

    /**
     * 一旦过了保质期，"Quality"就以双倍的速度下滑。
     */
    @Test
    public void foo_sellIn_0_quality_5() {
        Item[] items = new Item[]{new Item("foo", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(3));
        assertThat(app.items[0].sellIn, is(-1));
    }

    /**
     * 陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高。
     */
    @Test
    public void AgedBrie_sellIn_1_quality_5() {
        Item[] items = new Item[]{new Item(ItemName.AGED_BRIE.getName(), 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.AGED_BRIE.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(6));
        assertThat(app.items[0].sellIn, is(0));
    }

    /**
     * 商品的价值永远不会小于0，也永远不会超过50。
     */
    @Test
    public void AgedBrie_sellIn_1_quality_0() {
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(0));
    }

    /**
     * 商品的价值永远不会小于0，也永远不会超过50。
     */
    @Test
    public void AgedBrie_sellIn_1_quality_50() {
        Item[] items = new Item[]{new Item(ItemName.AGED_BRIE.getName(), 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.AGED_BRIE.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(50));
        assertThat(app.items[0].sellIn, is(0));
    }

    /**
     * 萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑。
     */
    @Test
    public void Sulfuras_sellIn_1_quality_50() {
        Item[] items = new Item[]{new Item(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName(), 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(50));
        assertThat(app.items[0].sellIn, is(1));
    }

    /**
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     * 在演出前10天，价值每天上升2点；演出前5天，价值每天上升3点。但一旦过了演出日，价值就马上变成0。
     */
    @Test
    public void Backstage_sellIn_11_quality_11() {
        Item[] items = new Item[]{new Item(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), 11, 11)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(12));
        assertThat(app.items[0].sellIn, is(10));
    }

    /**
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     * 在演出前10天，价值每天上升2点；演出前5天，价值每天上升3点。但一旦过了演出日，价值就马上变成0。
     */
    @Test
    public void Backstage_sellIn_9_quality_11() {
        Item[] items = new Item[]{new Item(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), 9, 11)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(13));
        assertThat(app.items[0].sellIn, is(8));
    }

    /**
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     * 在演出前10天，价值每天上升2点；演出前5天，价值每天上升3点。但一旦过了演出日，价值就马上变成0。
     */
    @Test
    public void Backstage_sellIn_3_quality_11() {
        Item[] items = new Item[]{new Item(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), 3, 11)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(14));
        assertThat(app.items[0].sellIn, is(2));
    }

    /**
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     * 在演出前10天，价值每天上升2点；演出前5天，价值每天上升3点。但一旦过了演出日，价值就马上变成0。
     */
    @Test
    public void Backstage_sellIn_negetive_quality_11() {
        Item[] items = new Item[]{new Item(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), 0, 11)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName(), app.items[0].name);
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(-1));
    }

}
