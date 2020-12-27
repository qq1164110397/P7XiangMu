package com.example.p7xiangmu;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7xiangmu.fragment.ClassFragment;
import com.example.p7xiangmu.fragment.ShoppingCarFragment;
import com.example.p7xiangmu.fragment.HomeFragment;
import com.example.p7xiangmu.fragment.MyFragment;
import com.example.p7xiangmu.fragment.ZhuanFragment;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioHome;
    private RadioButton radioZhuan;
    private RadioButton radioClass;
    private RadioButton radioShoppingcar;
    private RadioButton radioMy;
    private FrameLayout frame;
    private HomeFragment homeFragment;
    private ZhuanFragment zhuanFragment;
    private ClassFragment classFragment;
    private ShoppingCarFragment goufWuFragment;
    private MyFragment myFragment;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        initData();
        initData();
    }

    private void initData() {
        homeFragment = new HomeFragment();
        zhuanFragment = new ZhuanFragment();
        classFragment = new ClassFragment();
        goufWuFragment = new ShoppingCarFragment();
        myFragment = new MyFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,homeFragment)
                .commit();

        radioHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,homeFragment)
                        .commit();
            }
        });

        radioZhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, zhuanFragment)
                        .commit();
            }
        });

        radioClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, classFragment)
                        .commit();
            }
        });

        radioShoppingcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,goufWuFragment)
                        .commit();
            }
        });

        radioMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,myFragment)
                        .commit();
            }
        });
    }

    //    private void initData() {
//
//
//        setSelect(1);
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId){
//                    case R.id.radio_home:
//                        setSelect(1);
//                        break;
//                    case R.id.radio_zhuan:
//                        setSelect(2);
//                        break;
//                    case R.id.radio_class:
//                        setSelect(3);
//                        break;
//                    case R.id.radio_shoppingcar:
//                        setSelect(4);
//                        break;
//                    case R.id.radio_my:
//                        setSelect(5);
//                        break;
//
//                }
//            }
//        });
//    }
//
//    private void setSelect(int checkedId) {
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft = supportFragmentManager.beginTransaction();
//        hideFragment(ft);
//
//        switch (checkedId){
//            case 1:
//                FragmentTransaction ft1 = supportFragmentManager.beginTransaction();
//                ft1.show(homeFragment);
//                ft1.commit();
//                break;
//
//            case 2:
//                FragmentTransaction ft2 = supportFragmentManager.beginTransaction();
//                ft2.show(zhuanTiFragment);
//                ft2.commit();
//                break;
//
//            case 3:
//                FragmentTransaction ft3 = supportFragmentManager.beginTransaction();
//                ft3.show(fenLeiFragment);
//                ft3.commit();
//                break;
//
//            case 4:
//                FragmentTransaction ft4 = supportFragmentManager.beginTransaction();
//                ft4.show(goufWuFragment);
//                ft4.commit();
//                break;
//
//            case 5:
//                FragmentTransaction ft5 = supportFragmentManager.beginTransaction();
//                ft5.show(myFragment);
//                ft5.commit();
//                break;
//        }
//
//    }
//
//    private void hideFragment(FragmentTransaction ft) {
//        if (homeFragment != null) {
//            ft.hide(homeFragment);
//        } else if (zhuanTiFragment != null) {
//            ft.hide(zhuanTiFragment);
//        } else if (fenLeiFragment != null) {
//            ft.hide(fenLeiFragment);
//        } else if (goufWuFragment != null) {
//            ft.hide(goufWuFragment);
//        } else if (myFragment != null) {
//            ft.hide(myFragment);
//        }
//    }
//
    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        radioHome = (RadioButton) findViewById(R.id.radio_home);
        radioZhuan = (RadioButton) findViewById(R.id.radio_zhuan);
        radioClass = (RadioButton) findViewById(R.id.radio_class);
        radioShoppingcar = (RadioButton) findViewById(R.id.radio_shoppingcar);
        radioMy = (RadioButton) findViewById(R.id.radio_my);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
    }
}