package com.example.thirasan.type_speed;

import android.text.Editable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public class Presenter{

    TypeView view;
    String word;
    double timeStart;
    double timeEnd;

    public Presenter(TypeView view){
        this.view = view;
    }

    public void selectLevel(int levels) {
        Level level = (new LevelFactory()).getLevel(levels);
        word = level.getWord();
        this.timeStart = System.currentTimeMillis();
        view.update(word);
    }

    public void type(String s) {
        if(s.equals(word.substring(0,s.length()))) {
            if(s.length() != word.length())
                view.updateType(true);
            else {
                timeEnd = System.currentTimeMillis();
                view.end(word.length()/((timeEnd - timeStart)/1000));
            }
        }
        else
            view.updateType(false);
    }
}