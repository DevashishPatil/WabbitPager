package com.eyepatch.wabbitpager_library;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

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
    int FragPos = 0;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

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

    public void addFragment(ArrayList<Fragment> fragment){
        fragmentList = fragment;
    }

    public void SummonTabbedPager(final WabbitTabbedPager wabbitPager, final ViewPager2 viewPager, final TabLayout tabLayout, final Button nextBtn, final Button prevBtn, final Context currentContext, final Class nextClass) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPager.setAdapter(wabbitPager);
                TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, final int position) {

                        FragPos = viewPager.getCurrentItem();
                        if(FragPos == 0){
                            prevBtn.setVisibility(View.INVISIBLE);
                        }


                        nextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                FragPos = viewPager.getCurrentItem();

                                if (FragPos < fragmentList.size()) {

                                    FragPos++;
                                    viewPager.setCurrentItem(FragPos);
                                    prevBtn.setVisibility(View.VISIBLE);

                                }

                                if (FragPos == fragmentList.size()) {
                                    Intent intent = new Intent(currentContext,nextClass);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    currentContext.startActivity(intent);
                                }
                            }
                        });

                        prevBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                FragPos = viewPager.getCurrentItem();

                                if (FragPos > 0) {

                                    FragPos--;
                                    viewPager.setCurrentItem(FragPos);

                                }

                                if(FragPos == 0){
                                    prevBtn.setVisibility(View.INVISIBLE);
                                }
                            }
                        });
                    }
                });
                tabLayoutMediator.attach();
            }
        });
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;

    }

    public void SummonTabbedPagerSkip(final WabbitTabbedPager wabbitPager, final ViewPager2 viewPager, final TabLayout tabLayout, final Button nextBtn, final Button prevBtn, final TextView skipBtn, final Context currentContext, final Class nextClass) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPager.setAdapter(wabbitPager);
                TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, final int position) {

                        FragPos = viewPager.getCurrentItem();
                        if(FragPos == 0){
                            prevBtn.setVisibility(View.INVISIBLE);
                        }


                        nextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                FragPos = viewPager.getCurrentItem();

                                if (FragPos < fragmentList.size()) {

                                    FragPos++;
                                    viewPager.setCurrentItem(FragPos);
                                    prevBtn.setVisibility(View.VISIBLE);

                                }

                                if (FragPos == fragmentList.size()) {
                                    Intent intent = new Intent(currentContext,nextClass);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    currentContext.startActivity(intent);
                                }
                            }
                        });

                        prevBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                FragPos = viewPager.getCurrentItem();

                                if (FragPos > 0) {

                                    FragPos--;
                                    viewPager.setCurrentItem(FragPos);

                                }

                                if(FragPos == 0){
                                    prevBtn.setVisibility(View.INVISIBLE);
                                }
                            }
                        });

                        skipBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                viewPager.setCurrentItem(fragmentList.size());
                                prevBtn.setVisibility(View.VISIBLE);
                            }
                        });
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

    public void setTabbedPagerScrollFashion(TabbedPagerScrollFashion scrollFashion){
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