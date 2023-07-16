package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    private FelineLifeCycle felineLifeCycle;

    public Lion(String sex, FelineLifeCycle felineLifeCycle) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
        this.felineLifeCycle = felineLifeCycle;
    }

    public int getKittens() {
        return felineLifeCycle.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return felineLifeCycle.getFood("Хищник");
    }
}

