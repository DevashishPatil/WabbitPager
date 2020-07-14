package com.eyepatch.wabbitpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.eyepatch.wabbitpager_library.WabbitPager;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerWabbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerWabbit = findViewById(R.id.viewPagerWabbit);

        WabbitPager wabbitPager = new WabbitPager(getSupportFragmentManager());
        wabbitPager.addFragment(new Fragment2());
        wabbitPager.addFragment(new Fragment1());
        wabbitPager.SummonPager(wabbitPager, viewPagerWabbit);
    }
}