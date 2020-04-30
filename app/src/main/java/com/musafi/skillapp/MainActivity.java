package com.musafi.skillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    private final int HOME = 1;
    private final int EXPLORE = 2;
    private final int MESSAGE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(HOME, R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(EXPLORE, R.drawable.ic_explore_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(MESSAGE, R.drawable.ic_message_black_24dp));

        bottomNavigation.show(HOME,true);

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                return null;
            }
        });
    }
}
