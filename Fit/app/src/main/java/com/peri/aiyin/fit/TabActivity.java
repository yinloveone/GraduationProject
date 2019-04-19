package com.peri.aiyin.fit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private RadioGroup radioGroup;
    private List<Fragment> listFragment;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_bottom);
        initView();
    }
    private void initView(){
        mViewPager=findViewById(R.id.fragment_vp);
        radioGroup=findViewById(R.id.tabs_rg);
        listFragment=new ArrayList<>(4);
        listFragment.add(BlankFragment.newInstance("团体约课"));
        listFragment.add(BlankFragment.newInstance("私教约课"));
        listFragment.add(BlankFragment.newInstance("消息"));
        listFragment.add(BlankFragment.newInstance("我"));
        fragmentPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),listFragment);
        mViewPager.setAdapter(fragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(pageChangeListener);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.removeOnPageChangeListener(pageChangeListener);
    }

    private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
            radioButton.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
   private RadioGroup.OnCheckedChangeListener onCheckedChangeListener=new RadioGroup.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(RadioGroup group, int checkedId) {
        for(int i=0;i<group.getChildCount();i++){
            if(group.getChildAt(i).getId()==checkedId){
                mViewPager.setCurrentItem(i);
                return;
            }
        }
       }
   } ;


    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return this.mList == null ? null : this.mList.get(position);
        }

        @Override
        public int getCount() {
            return this.mList == null ? 0 : this.mList.size();
        }
    }

}
