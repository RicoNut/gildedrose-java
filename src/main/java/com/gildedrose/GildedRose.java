package com.gildedrose;

class GildedRose {
    /**
     * 陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高。
     */
    public static final String AGED_BRIE = "Aged Brie";
    /**
     * 后台通行证（Backstage pass）和陈年干酪有相似之处：越是接近演出日，随着"SellIn"值的增加，商品价值"Quality"值反而上升。
     * 在演出前10天，价值每天上升2点；演出前5天，价值每天上升3点。但一旦过了演出日，价值就马上变成0。
     */
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    /**
     * 萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑。
     */
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            // 计算变质期：递减1
            items[i].sellInCal();

            items[i].updateQuality();
            // 后台通行证计算quality
//            if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
//                backStagePassQuality(items[i]);
//            }
//            // 陈年干酪计算quality
//            else if (items[i].name.equals(AGED_BRIE)) {
//                agedBrieQuality(items[i]);
//            } else if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
//                sulfursQuality();
//            } else {
//                commonQuality(items[i]);
//            }
        }
    }

    /**
     * 非特殊商品计算
     */
    public void commonQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        if (item.sell_in < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

    }

    /**
     * Sulfuras 不需要处理quality，不会改变价值
     */
    public void sulfursQuality() {


    }

    /**
     * 陈年干酪计算quality
     */
    public void agedBrieQuality(Item item) {
        int inCre = 0;
        if (item.quality < 50) {
            inCre++;
        }
        item.quality = item.quality + inCre;
    }

    /**
     * back stage 计算方法
     */
    public void backStagePassQuality(Item item) {
        int inCre = 0;
        if (item.quality < 50) {
            inCre++;
        }
        if (item.sell_in < 11) {
            inCre++;
        }
        if (item.sell_in < 6) {
            inCre++;
        }
        item.quality = item.quality + inCre;
        // 如果过期，马上失去价值
        if (item.sell_in < 0) {
            item.quality = 0;
        }
    }
}
