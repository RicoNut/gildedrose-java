package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

    /**
     * 过期了就会加倍坏掉
     */
    @Test
    public void foo_out_date() {
        Item[] items = new Item[]{new Item("foo", -1, 5)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(3));
        assertThat(app.items[0].sell_in, is(-2));
    }

    /**
     * Aged Brie 越放越值钱
     * 陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高。
     */
    @Test
    public void aged_brie() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Aged Brie", app.items[0].name);
        assertThat(app.items[0].quality, is(6));
        assertThat(app.items[0].sell_in, is(0));
    }

    /**
     * Aged Brie 价值不会超过50
     * 商品的价值永远不会小于0，也永远不会超过50。
     */
    @Test
    public void aged_brie_not_over_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Aged Brie", app.items[0].name);
        assertThat(app.items[0].quality, is(50));
        assertThat(app.items[0].sell_in, is(0));
    }

    /**
     * Sulfuras, Hand of Ragnaros
     * 萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑。
     */
    @Test
    public void silfuras_hand_of_ragnaros_not_reduce() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertThat(app.items[0].quality, is(10));
        assertThat(app.items[0].sell_in, is(1));
    }

    /**
     * Backstage passes to a TAFKAL80ETC concert
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     */
    @Test
    public void back_storage_passes_to_concert_1_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(13));
        assertThat(app.items[0].sell_in, is(0));
    }

    /**
     * Backstage passes to a TAFKAL80ETC concert
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     */
    @Test
    public void back_storage_passes_to_concert_7_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(12));
        assertThat(app.items[0].sell_in, is(6));
    }

    /**
     * Backstage passes to a TAFKAL80ETC concert
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，
     * 随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     */
    @Test
    public void back_storage_passes_to_concert_12_10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertThat(app.items[0].quality, is(11));
        assertThat(app.items[0].sell_in, is(11));
    }

}
