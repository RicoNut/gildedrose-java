package com.gildedrose;

public class BackStagePassQuality extends Quality{
    public int calculatorQuality(String name, int sell_in, int quality){
        int inCre = 0;
        if (quality < 50) {
            inCre++;
        }
        if (sell_in < 11) {
            inCre++;
        }
        if (sell_in < 6) {
            inCre++;
        }
        quality = quality + inCre;
        // 如果过期，马上失去价值
        if (sell_in < 0) {
            quality = 0;
        }
        return quality;
    }
}
