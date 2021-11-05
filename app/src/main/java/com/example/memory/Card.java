package com.example.memory;

public class Card {

    private boolean visible;
    private int value;



    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return "Card [visible=" + visible + ", value=" + value + "]";
    }


}
