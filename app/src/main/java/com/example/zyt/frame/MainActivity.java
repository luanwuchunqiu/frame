package com.example.zyt.frame;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.zyt.frame.adapter.MianViewPaperAdapter;
import com.example.zyt.frame.fragment.FriendsFragment;
import com.example.zyt.frame.fragment.MatchFragment;
import com.example.zyt.frame.fragment.PersonalFragment;
import com.example.zyt.frame.fragment.SportsFragment;
import com.example.zyt.frame.fragment.TrainFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Fragment> fragments;
    private MianViewPaperAdapter adapter ;
    private ViewPager mainViewPaper;
    private  MenuItem  prevMenuItem=null ;








    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_sports:
                    mainViewPaper.setCurrentItem(0);
                    SportsFragment sportsFragment = (SportsFragment) fragments.get(0);
                    sportsFragment.fresh("运动fragment");



                    return true;
                case R.id.navigation_train:
                    mainViewPaper.setCurrentItem(1);
                    TrainFragment trainFragment = (TrainFragment) fragments.get(1);
                    trainFragment.fresh("训练fragment");

                    return true;
                case R.id.navigation_friends:
                    mainViewPaper.setCurrentItem(2);
                    FriendsFragment friendsFragment = (FriendsFragment) fragments.get(2);
                    friendsFragment.fresh("圈子fragment");

                    return true;
                case R.id.navigation_match:
                    mainViewPaper.setCurrentItem(3);
                    MatchFragment matchFragment = (MatchFragment) fragments.get(3);
                    matchFragment.fresh("竞技fragment");

                    return true;
                case R.id.navigation_personal:
                    mainViewPaper.setCurrentItem(4);


                    return true;
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mainViewPaper = (ViewPager) findViewById(R.id.main_view_paper);

        fragments = new ArrayList<Fragment>();
        fragments.add(new SportsFragment());
        fragments.add(new TrainFragment());
        fragments.add(new FriendsFragment());
        fragments.add( new MatchFragment());
        fragments.add( new PersonalFragment());
        adapter = new MianViewPaperAdapter(getSupportFragmentManager(),fragments);
        mainViewPaper.setAdapter(adapter);
        mainViewPaper.setCurrentItem(0);//设置当前位置
        navigation.getMenu().getItem(0).setChecked(true);//设置默认选中


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            BottomNavigationViewHelper.disableShiftMode(navigation);
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mainViewPaper.setOffscreenPageLimit(2);
        mainViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:{
                        SportsFragment sportsFragment = (SportsFragment) fragments.get(0);
                        sportsFragment.fresh("运动fragment");}break;
                    case 1:{  TrainFragment trainFragment = (TrainFragment) fragments.get(1);
                        trainFragment.fresh("训练fragment");}break;
                    case 2:{FriendsFragment friendsFragment = (FriendsFragment) fragments.get(2);
                        friendsFragment.fresh("圈子fragment");}break;
                    case 3:{  MatchFragment matchFragment = (MatchFragment) fragments.get(3);
                        matchFragment.fresh("竞技fragment");}break;
                    case 4:{}break;

                }



                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position) ;


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
