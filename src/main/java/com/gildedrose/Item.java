package com.gildedrose;

public class Item {

    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }


    public void setSellIn() {
        if (!name.equals(ItemName.SULFURAS_HAND_OF_RAGNAROS.getName())) {
            sell_in = sell_in - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
