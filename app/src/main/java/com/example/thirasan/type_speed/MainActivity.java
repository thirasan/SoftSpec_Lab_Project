package com.example.thirasan.type_speed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TypeView {

    Presenter presenter;
    LinearLayout body;

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
    }

    @Override
    public void update(String word) {
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setVisibility(View.GONE);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setVisibility(View.GONE);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setVisibility(View.GONE);

        TextView text = new TextView(this);
        text.setTextSize(30);
        text.setText(word);

        body.addView(text);

    }

    public void onSelectLevel(View view) {
        EditText typeField = (EditText) findViewById(R.id.typeField);
        typeField.setVisibility(View.VISIBLE);

        if(view.getId() == R.id.button1){
            presenter.selectLevel(1);
        }

    }
}
