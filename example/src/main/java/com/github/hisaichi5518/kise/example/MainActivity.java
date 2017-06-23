package com.github.hisaichi5518.kise.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.hisaichi5518.kise.example.units.ViewVisibleUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.activity_main__text);
        assert view != null;
        new ViewVisibleUnit().invoke(view);
    }
}
