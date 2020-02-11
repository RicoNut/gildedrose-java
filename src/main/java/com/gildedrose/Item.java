package com.gildedrose;

import static com.gildedrose.GildedRose.SULFURAS_HAND_OF_RAGNAROS;

public class Item {

    public String name;

    public int sell_in;

    public int quality;

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

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
