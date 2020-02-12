package com.gildedrose;

public class BrieQuality extends Quality{
    @Override
    int calculatorQuality(String name, int sell_in, int quality) {
        // 陈年干酪计算quality
        int inCre = 0;
        if (quality < 50) {
            inCre++;
        }
        quality = quality + inCre;
        return quality;
    }
}
