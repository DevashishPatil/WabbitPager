package com.eyepatch.wabbitpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.eyepatch.wabbitpager_library.WabbitPager;
import com.eyepatch.wabbitpager_library.WabbitTabbedPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPagerWabbit;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerWabbit = findViewById(R.id.viewPagerWabbit);
        tabLayout = findViewById(R.id.tabLayout);

//        WabbitPager wabbitPager = new WabbitPager(getSupportFragmentManager(), getLifecycle());
//        wabbitPager.addFragment(new Fragment1());
//        wabbitPager.addFragment(new Fragment2());
//        wabbitPager.addFragment(new Fragment3());
//        wabbitPager.SummonPager(wabbitPager, viewPagerWabbit);
//        wabbitPager.setPagerScrollFashion(WabbitPager.PagerScrollFashion.VERTICAL);

        WabbitTabbedPager wabbitTabbedPager = new WabbitTabbedPager(getSupportFragmentManager(), getLifecycle());
        wabbitTabbedPager.addFragment(new Fragment1(), "Fragment1");
        wabbitTabbedPager.addFragment(new Fragment2(), "Fragment2");
        wabbitTabbedPager.addFragment(new Fragment3(), "Fragment3");
        wabbitTabbedPager.SummonTabbedPager(wabbitTabbedPager, viewPagerWabbit, tabLayout);
        wabbitTabbedPager.setTabbedPagerScrollFashion(WabbitTabbedPager.TabbedPagerScrollFashion.VERTICAL);
    }
}