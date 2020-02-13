package com.gildedrose;

public enum ItemName {
    AGED_BRIE("Aged Brie"), BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"), SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros");

    ItemName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
