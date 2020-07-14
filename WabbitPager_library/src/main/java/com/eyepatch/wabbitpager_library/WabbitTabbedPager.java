package com.eyepatch.wabbitpager_library;

import android.os.Handler;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class WabbitTabbedPager extends FragmentStateAdapter {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private List<String> stringList = new ArrayList<>();

    public WabbitTabbedPager(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }

    public void SummonTabbedPager(final WabbitTabbedPager wabbitPager, final ViewPager2 viewPager, final TabLayout tabLayout) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPager.setAdapter(wabbitPager);
                TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(stringList.get(position));
                    }
                });
                tabLayoutMediator.attach();
            }
        });
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;

    }
    public enum TabbedPagerScrollFashion{
        HORIZONTAL, VERTICAL;

        TabbedPagerScrollFashion() {}
    }

    public void setScrollFashion(TabbedPagerScrollFashion scrollFashion){
        switch (scrollFashion){
            case VERTICAL:{
                viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
            }break;
            case HORIZONTAL:{
                viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
            }break;
            default:{
                throw new IllegalArgumentException();
            }
        }
    }
}