package com.example.thirasan.type_speed;

/**
 * Created by thirasan on 6/4/2017 AD.
 */

public class Easy implements Level {

    String[] word = {"I took some money out of the bank.","The shop stays open until 9 p.m,",
                    "Can I help you?","Could you open the door?","You're driving too fast!"};

    @Override
    public String getWord() {
        return word[(int)(Math.random() * word.length)];
    }
}
