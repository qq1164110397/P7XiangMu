package com.example.p7xiangmu;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.p7xiangmu.fragment.FenLeiFragment;
import com.example.p7xiangmu.fragment.GouWuFragment;
import com.example.p7xiangmu.fragment.HomeFragment;
import com.example.p7xiangmu.fragment.MyFragment;
import com.example.p7xiangmu.fragment.ZhuanTiFragment;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioHome;
    private RadioButton radioZhuan;
    private RadioButton radioClass;
    private RadioButton radioShoppingcar;
    private RadioButton radioMy;
    private FrameLayout frame;
    private HomeFragment homeFragment;
    private ZhuanTiFragment zhuanTiFragment;
    private FenLeiFragment fenLeiFragment;
    private GouWuFragment goufWuFragment;
    private MyFragment myFragment;
    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        homeFragment = new HomeFragment();
        zhuanTiFragment = new ZhuanTiFragment();
        fenLeiFragment = new FenLeiFragment();
        goufWuFragment = new GouWuFragment();
        myFragment = new MyFragment();

        setSelect(1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_home:
                        setSelect(1);
                        break;
                    case R.id.radio_zhuan:
                        setSelect(2);
                        break;
                    case R.id.radio_class:
                        setSelect(3);
                        break;
                    case R.id.radio_shoppingcar:
                        setSelect(4);
                        break;
                    case R.id.radio_my:
                        setSelect(5);
                        break;

                }
            }
        });
    }

    private void setSelect(int checkedId) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        hideFragment(ft);

        switch (checkedId){
            case 1:
                if (homeFragment == null){
                    ft.add(R.id.frame,homeFragment);
                }else {
                    ft.show(homeFragment);
                }
                ft.commit();
                break;

            case 2:
                if (zhuanTiFragment == null){
                    ft.add(R.id.frame,zhuanTiFragment);
                }else {
                    ft.show(zhuanTiFragment);
                }
                ft.commit();
                break;

            case 3:
                if (fenLeiFragment == null){
                    ft.add(R.id.frame,fenLeiFragment);
                }else {
                    ft.show(fenLeiFragment);
                }
                ft.commit();
                break;

            case 4:
                if (goufWuFragment == null){
                    ft.add(R.id.frame,goufWuFragment);
                }else {
                    ft.show(goufWuFragment);
                }
                ft.commit();
                break;

            case 5:
                if (myFragment == null){
                    ft.add(R.id.frame,myFragment);
                }else {
                    ft.show(myFragment);
                }
                ft.commit();
                break;
        }

    }

    private void hideFragment(FragmentTransaction ft) {
        if (homeFragment != null) {
            ft.hide(homeFragment);
        } else if (zhuanTiFragment != null) {
            ft.hide(zhuanTiFragment);
        } else if (fenLeiFragment != null) {
            ft.hide(fenLeiFragment);
        } else if (goufWuFragment != null) {
            ft.hide(goufWuFragment);
        } else if (myFragment != null) {
            ft.hide(myFragment);
        }
    }

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