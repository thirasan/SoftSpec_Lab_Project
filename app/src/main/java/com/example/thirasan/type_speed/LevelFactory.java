package com.example.thirasan.type_speed;

/**
 * Created by thirasan on 6/4/2017 AD.
 */

public class LevelFactory {
    public Level getLevel(int level){
        Level levels = null;
        if(level == 1){
            levels = new Easy();
        }
        return levels;
    }
}
