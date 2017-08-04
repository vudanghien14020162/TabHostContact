package com.example.hien.contactviewpager;

import android.app.SearchManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private TabLayout mTbLayout;

    private ViewPager viewPager;

    private FragmentPagerAdapter mAdapter;

    private SearchView mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIds();
        initComponents();
        setEvents();
    }

    private void findViewByIds() {

        mToolbar = (Toolbar) findViewById(R.id.tb_contact);

        mTbLayout = (TabLayout) findViewById(R.id.tablayout);

        viewPager = (ViewPager) findViewById(R.id.vp_contact);


    }

    private void initComponents() {

        //add toolbar activity
        setSupportActionBar(mToolbar);



        mAdapter = new FragmentManagerPage(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);

        mTbLayout.setupWithViewPager(viewPager);

        mTbLayout.setSelectedTabIndicatorColor(Color.WHITE);

        mTbLayout.getTabAt(0).setText("Favourite");

        mTbLayout.getTabAt(1).setText("Contact");

    }

    private void setEvents() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);

        mSearch = (SearchView) menu.findItem(R.id.id_menu_search).getActionView();

        return true;
    }


    //page fragment manager

    private class FragmentManagerPage extends FragmentPagerAdapter{

        public FragmentManagerPage(FragmentManager fm) {
            super(fm);

        }
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:

                    FragmentFavorite favorite = new FragmentFavorite();
                    return favorite;
                case 1:

                    FragmentContact fragment = new FragmentContact();
                    return fragment;
                default:
                    break;
            }
            return null;
        }
        @Override
        public int getCount() {
            return 2;
        }
    }
}
