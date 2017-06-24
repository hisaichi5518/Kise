package com.github.hisaichi5518.kise.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.hisaichi5518.kise.Kise;
import com.github.hisaichi5518.kise.example.units.HelloTextUnit;
import com.github.hisaichi5518.kise.example.units.ViewVisibleUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kise.fetch();
        setContentView(R.layout.activity_main);

        TextView view = (TextView) findViewById(R.id.activity_main__text);
        assert view != null;
        new ViewVisibleUnit(view).invoke();

        view.setText(new HelloTextUnit().invoke());
    }
}
