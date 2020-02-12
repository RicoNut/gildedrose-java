package com.gildedrose;

public class CommonQuality extends Quality {
    /**
     * 非特殊商品计算
     */
    @Override
    int calculatorQuality(String name, int sell_in, int quality) {
        if (quality > 0) {
            quality = quality - 1;
        }
        if (sell_in < 0) {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
        return quality;
    }
}
