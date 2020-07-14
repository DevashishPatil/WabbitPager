package com.eyepatch.wabbitpager_library;

import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class WabbitPager extends FragmentStateAdapter {

    ViewPager2 viewPager;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public WabbitPager(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
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

    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

    public void SummonPager(final WabbitPager wabbitPager, final ViewPager2 viewPager) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPager.setAdapter(wabbitPager);
            }
        });
        this.viewPager = viewPager;
    }
    public enum PagerScrollFashion{
        HORIZONTAL, VERTICAL;

        PagerScrollFashion() {}
    }

    public void setPagerScrollFashion(PagerScrollFashion scrollFashion){
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
