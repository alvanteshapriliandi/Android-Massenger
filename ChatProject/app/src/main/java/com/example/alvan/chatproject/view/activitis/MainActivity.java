package com.example.alvan.chatproject.view.activitis;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.alvan.chatproject.view.fragments.AcountFragment;
import com.example.alvan.chatproject.view.fragments.FeedbackFragment;
import com.example.alvan.chatproject.view.fragments.InboxFragment;
import com.example.alvan.chatproject.view.fragments.ProfileFragment;
import com.example.alvan.chatproject.R;
import com.example.alvan.chatproject.view.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        setSupportActionBar(toolbar);
        viewPagerAdapter.addFragments(new InboxFragment(), "Inbox");
        viewPagerAdapter.addFragments(new FeedbackFragment(), "Feedback");
        viewPagerAdapter.addFragments(new AcountFragment(), "Follow");
        viewPagerAdapter.addFragments(new ProfileFragment(), "Profile");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }
}
