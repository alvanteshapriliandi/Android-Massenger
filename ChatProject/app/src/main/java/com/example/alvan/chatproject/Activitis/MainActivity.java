package com.example.alvan.chatproject.Activitis;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.alvan.chatproject.Fragments.AcountFragment;
import com.example.alvan.chatproject.Fragments.FeedbackFragment;
import com.example.alvan.chatproject.Fragments.ProfileFragment;
import com.example.alvan.chatproject.R;
import com.example.alvan.chatproject.Fragments.RecyclerViewFragment;
import com.example.alvan.chatproject.Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        setSupportActionBar(toolbar);
        viewPagerAdapter.addFragments(new RecyclerViewFragment(), "Home");
        viewPagerAdapter.addFragments(new FeedbackFragment(), "Feedback");
        viewPagerAdapter.addFragments(new AcountFragment(), "Follow");
        viewPagerAdapter.addFragments(new ProfileFragment(), "Profile");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
