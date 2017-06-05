package com.example.thirasan.type_speed;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TypeView {

    Presenter presenter;
    LinearLayout body;
    LinearLayout tail;
    EditText typeField;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewHolders();

        if(presenter == null) {
            presenter = new Presenter(this);
        }
    }

    private void initViewHolders() {
        this.body = (LinearLayout) findViewById(R.id.body);
        this.tail = (LinearLayout) findViewById(R.id.tail);

        this.typeField = (EditText) findViewById(R.id.typeField);
        typeField.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                presenter.type(String.valueOf(s));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

    }

    @Override
    public void update(String word) {
        body.removeAllViews();

        text = new TextView(this);
        text.setTextSize(30);
        text.setText(word);

        body.addView(text);

    }

    public void test(String x) {
        text.setText(x);
    }


    @Override
    public void updateType(boolean equal) {
        if(equal)
            typeField.setTextColor(Color.BLACK);
        else
            typeField.setTextColor(Color.RED);
    }

    @Override
    public void end(double runtime) {
        double time = runtime*100;
        time = Math.round(time);
        text.setText(time/100 + " word per second");
        typeField.setVisibility(View.INVISIBLE);
        tail.setVisibility(View.VISIBLE);
    }

    public void onSelectLevel(View view) {
        typeField.setVisibility(View.VISIBLE);
        if(view.getId() == R.id.button1){
            presenter.selectLevel(1);
        }

    }
}
