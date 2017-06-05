package com.example.thirasan.type_speed;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    int level = 1;

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
        tail.setVisibility(View.INVISIBLE);
        typeField.setVisibility(View.VISIBLE);
        body.removeAllViews();

        text = new TextView(this);
        text.setTextSize(30);
        text.setText(word);

        body.addView(text);

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
        typeField.setText("");
        typeField.setVisibility(View.INVISIBLE);
        tail.setVisibility(View.VISIBLE);
    }

    public void onSelectLevel(View view) {
        if(view.getId() == R.id.button1){
            this.level = 1;
            presenter.selectLevel(1);
        }

    }

    public void onRestart(View view) {
        presenter.selectLevel(this.level);
    }

    public void onHome(View view) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(i);
    }
}
