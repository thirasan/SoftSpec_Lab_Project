package com.example.thirasan.type_speed;

/**
 * Created by thirasan on 6/5/2017 AD.
 */

public class Normal implements Level {

    String[] word = {"Four score and seven years ago our fathers brought forth, upon this continent, a new nation, conceived in liberty and dedicated to the proposition that all men are created equal.",
            "And so even though we face the difficulties of today and tomorrow, I still have a dream. It is a dream deeply rooted in the American dream.",
            "I have a dream that one day this nation will rise up and live out the true meaning of its creed: We hold these truths to be self-evident, that all men are created equal.",
            "The number of Germans who inwardly supported the Weimar Constitution in spite of the suggestive significance and ruthless exploitation of the executive power dwindled, in the end, to a mere fraction of the entire nation.",
            "The dissolution permeates all of the basic principles of social order. The completely opposite approaches of the individuals to the concepts of state, society, religion, morality, family, and economy rips open differences which will lead to a war of all against all. Starting with the liberalism of the past century, this development will end, as the laws of nature dictate, in Communist chaos."};

    @Override
    public String getWord() {
        return word[(int)(Math.random() * word.length)];
    }
}
