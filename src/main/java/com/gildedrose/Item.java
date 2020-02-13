package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public void setSellIn() {
        if (!name.equals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName())) {
            sellIn = sellIn - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void calcQuality() {
        if (!name.equals(ItemName.AGED_BRIE.getName())
                && !name.equals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName())){
            if (quality > 0) {
                if (!name.equals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName())) {
                    quality = quality - 1;
                }
            }
        } else{
            if (quality < 50) {
                quality = quality + 1;

                if (name.equals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName())){
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
        // 处理保质期
        setSellIn();

        if (sellIn < 0) {
            if (!name.equals(ItemName.AGED_BRIE.getName())) {
                if (!name.equals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName())){
                    if (quality > 0) {
                        if (!name.equals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName())) {
                            quality = quality - 1;
                        }
                    }
                } else{
                    quality = quality - quality;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }
}
