package com.irena.robertkaczmarek.drogi_bhp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class road extends AppCompatActivity {
    public static final String RESULT = "result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
        getSupportActionBar().hide();
        Intent take = getIntent();
        String res = take.getStringExtra(RESULT);


        TextView show = (TextView)findViewById(R.id.show);
        show.setText(res+" "+ "cm");
    }
}
