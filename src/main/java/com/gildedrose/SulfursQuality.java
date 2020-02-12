package com.gildedrose;

public class SulfursQuality extends Quality {
    /**
     * Sulfuras 不需要处理quality，不会改变价值
     */
    @Override
    int calculatorQuality(String name, int sell_in, int quality) {
        return quality;
    }
}
