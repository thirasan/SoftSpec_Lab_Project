package com.example.thirasan.type_speed;

import java.util.List;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public interface TypeView {
    void update(String word);
    void updateType(boolean equal);
    void end(double runtime);

    void test(String substring);
}