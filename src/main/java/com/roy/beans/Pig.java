package com.roy.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * description：
 * author：dingyawu
 * date：created in 10:05 2020/12/7
 * history:
 */
@Component
public class Pig {
    private Cat1 cat1;

    public Cat1 getCat1() {
        return cat1;
    }

    @Autowired
    public Pig setCat1(Cat1 cat1) {
        this.cat1 = cat1;
        return this;
    }

    @Override
    public String toString() {
        return cat1.toString();
    }

}
