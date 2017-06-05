package com.example.thirasan.type_speed;

/**
 * Created by thirasan on 6/5/2017 AD.
 */

public class Hard implements Level {

    String[] word = {"drive.google.com/drive/u/4/folders/0B4JvzTdt3eV2MFJUZjVIZk5mOG8",
            "www.facebook.com/groups/1339396752802374/?fref=ts",
            "www.goethe.de/ins/th/th/spr/kur/gia/tup.cfm",
            "www.tafasu.com/watch?v=qfspnjeUD1","www.youtube.com/watch?v=1oAfHtgkB2k&t=2974s"};

    @Override
    public String getWord() {
        return word[(int)(Math.random() * word.length)];
    }
}
