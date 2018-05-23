package com.example.jingjing.blogv6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        navigation.setSelectedItemId(R.id.navigation_home);

    }


    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment=null;

        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment=new Homefragment();
                break;
            case R.id.navigation_news:
                fragment=new Newsfragment();
                break;
            case R.id.navigation_blog:
                fragment=new Blogfragment();
                break;
            case R.id.navigation_mine:
                fragment=new Minefragment();
                break;

        }
        return loadFragment(fragment);
    }
}
