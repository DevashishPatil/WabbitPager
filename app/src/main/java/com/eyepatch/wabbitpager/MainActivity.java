package com.eyepatch.wabbitpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.eyepatch.wabbitpager_library.WabbitPager;
import com.eyepatch.wabbitpager_library.WabbitTabbedPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPagerWabbit;
    TabLayout tabLayout;
    Button next, prev;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerWabbit = findViewById(R.id.viewPagerWabbit);
        tabLayout = findViewById(R.id.tab_indicator);
        next = findViewById(R.id.btn_next);
        prev = findViewById(R.id.btn_prv);
        skip = findViewById(R.id.btn_skip);
        ArrayList<Fragment> fragList = new ArrayList<Fragment>(Arrays.asList(new Fragment1(), new Fragment2(), new Fragment3()));

//        WabbitPager wabbitPager = new WabbitPager(getSupportFragmentManager(), getLifecycle());
//        wabbitPager.addFragment(fragList);
//        wabbitPager.SummonPagerSkip(wabbitPager, viewPagerWabbit, next, prev, skip, MainActivity.this, MainActivity2.class);
//        wabbitPager.setPagerScrollFashion(WabbitPager.PagerScrollFashion.HORIZONTAL);

//        WabbitPager wabbitPager = new WabbitPager(getSupportFragmentManager(), getLifecycle());
//        wabbitPager.addFragment(fragList);
//        wabbitPager.SummonPager(wabbitPager, viewPagerWabbit, next, prev, MainActivity.this, MainActivity2.class);
//        wabbitPager.setPagerScrollFashion(WabbitPager.PagerScrollFashion.HORIZONTAL);

        WabbitTabbedPager wabbitTabbedPager = new WabbitTabbedPager(getSupportFragmentManager(), getLifecycle());
        wabbitTabbedPager.addFragment(fragList);
        wabbitTabbedPager.SummonTabbedPagerSkip(wabbitTabbedPager, viewPagerWabbit, tabLayout, next, prev, skip, MainActivity.this, MainActivity2.class);
        wabbitTabbedPager.setTabbedPagerScrollFashion(WabbitTabbedPager.TabbedPagerScrollFashion.HORIZONTAL);

//        WabbitTabbedPager wabbitTabbedPager = new WabbitTabbedPager(getSupportFragmentManager(), getLifecycle());
//        wabbitTabbedPager.addFragment(fragList);
//        wabbitTabbedPager.SummonTabbedPager(wabbitTabbedPager, viewPagerWabbit, tabLayout, next, prev, MainActivity.this, MainActivity2.class);
//        wabbitTabbedPager.setTabbedPagerScrollFashion(WabbitTabbedPager.TabbedPagerScrollFashion.HORIZONTAL);
    }
}