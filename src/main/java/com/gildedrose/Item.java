package com.gildedrose;

import static com.gildedrose.GildedRose.SULFURAS_HAND_OF_RAGNAROS;
import static com.gildedrose.ItemName.AGED_BRIE;
import static com.gildedrose.ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT;

public class Item {

    public String name;

    public int sell_in;

    public int quality;

    private Quality qualityOpt;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    public void sellInCal() {
        if (!name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            sell_in = sell_in - 1;
        }
    }

    public void updateQuality() {
        quality = getQualityOpt().calculatorQuality(name, sell_in, quality);
    }

    public Quality getQualityOpt() {
        if (name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            qualityOpt = new BackStagePassQuality();
        }
        // 陈年干酪计算quality
        else if (name.equals(AGED_BRIE)) {
            qualityOpt = new BrieQuality();
        } else if (name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            qualityOpt = new SulfursQuality();
        } else {
            qualityOpt = new CommonQuality();
        }
        return qualityOpt;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
