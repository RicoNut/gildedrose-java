package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals(ItemName.AGED_BRIE.getName())
                    && !items[i].name.equals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName())){

                if (items[i].quality > 0) {
                    if (!items[i].name.equals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName())) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else{
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName())){
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            // 处理保质期
            items[i].setSellIn();

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(ItemName.AGED_BRIE.getName())) {
                    if (!items[i].name.equals(ItemName.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getName())){
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName())) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else{
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

}
