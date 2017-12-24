package com.weex.sample;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.weex.sample.fragment.*;
import com.weex.sample.fragment.TestFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjingchou on 2017/12/14.
 */

public class NavigationActivity extends FragmentActivity{

    private int mCurrentFragment;
    private RadioGroup radioGroup;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorEleStatusBar));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation);
        initTabbar();
        initFragment();

        radioGroup = (RadioGroup)findViewById(R.id.rg);
        viewPager = (ViewPager)findViewById(R.id.fragment_master);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0,false);break;
                    case R.id.rb_find:
                        viewPager.setCurrentItem(1,false);break;
                    case R.id.rb_order:
                        viewPager.setCurrentItem(2,false);break;
                    case R.id.rb_mine:
                        viewPager.setCurrentItem(3,false);break;
                    default:
                        viewPager.setCurrentItem(0,true);
                }
            }
        });
    }


    public  void initFragment(){
        ViewPager viewpager = (ViewPager)findViewById(R.id.fragment_master);
        List<Fragment> list = new ArrayList<Fragment>();
//        list.add(TestFragment.newInstance("diy.js"));
        list.add(TestFragment.newInstance("home.js"));
        list.add(TestFragment.newInstance("web.js"));
        list.add(TestFragment.newInstance("shoppingcart.js"));
        list.add(TestFragment.newInstance("hello.js"));
        FragmentPagerAdapater fpa = new FragmentPagerAdapater(getSupportFragmentManager(),list);
        viewpager.setAdapter(fpa);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                System.out.print(position);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.rb_home);break;
                    case 1:
                        radioGroup.check(R.id.rb_find);break;
                    case 2:
                        radioGroup.check(R.id.rb_order);break;
                    case 3:
                        radioGroup.check(R.id.rb_mine);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewpager.setCurrentItem(0);
    }

    public void initTabbar(){
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        RadioButton rb_home = (RadioButton)findViewById(R.id.rb_home);
        RadioButton rb_find = (RadioButton)findViewById(R.id.rb_find);
        RadioButton rb_order = (RadioButton)findViewById(R.id.rb_order);
        RadioButton rb_mine = (RadioButton)findViewById(R.id.rb_mine);
        rb_home.setChecked(true);

        int width = 60;

        Drawable h_icon = getResources().getDrawable(R.drawable.home_selector);
        h_icon.setBounds(0,0,width,width);
        rb_home.setCompoundDrawables(null,h_icon,null,null);

        Drawable f_icon = getResources().getDrawable(R.drawable.find_selector);
        f_icon.setBounds(0,0,width,width);
        rb_find.setCompoundDrawables(null,f_icon,null,null);

        Drawable o_icon = getResources().getDrawable(R.drawable.order_selector);
        o_icon.setBounds(0,0,width,width);
        rb_order.setCompoundDrawables(null,o_icon,null,null);

        Drawable u_icon = getResources().getDrawable(R.drawable.user_selector);
        u_icon.setBounds(0,0,width,width);
        rb_mine.setCompoundDrawables(null,u_icon,null,null);

    }
}
