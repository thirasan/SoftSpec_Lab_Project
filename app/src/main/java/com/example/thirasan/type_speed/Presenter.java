package com.example.thirasan.type_speed;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public class Presenter implements Observer{

    TypeView view;

    public Presenter(TypeView view){
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void selectLevel(int levels) {
        Level level = (new LevelFactory()).getLevel(levels);
        view.update(level.getWord());
    }
}