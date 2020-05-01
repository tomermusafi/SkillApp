package com.musafi.skillapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.musafi.skillapp.Call_Back.Fragment_Call_Back;
import com.musafi.skillapp.Fragments.HomeFragment;
import com.musafi.skillapp.Fragments.LessonInfoFragment;
import com.musafi.skillapp.Fragments.LessonsFragment;
import com.musafi.skillapp.Fragments.StoreFragment;
import com.musafi.skillapp.info.Lesson;
import com.musafi.skillapp.info.SubCategory;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;
    private final int SETTINGS = 1;
    private final int HOME = 2;
    private final int STORE = 3;
    private final int NEW_LESSON = 4;

    public static TextView coins;
    public static ImageView back;
    public static int counter;

    HomeFragment homeFragment;
    LessonsFragment lessonsFragment;
    LessonInfoFragment lessonInfoFragment;
    StoreFragment storeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;

        coins = findViewById(R.id.main_TV_coins);
        back = findViewById(R.id.main_back);

        homeFragment = new HomeFragment(this);
        lessonsFragment = new LessonsFragment(this);
        lessonInfoFragment = new LessonInfoFragment(this);
        storeFragment = new StoreFragment(this);

        homeFragment.setCall_Back(fragment_call_back);
        lessonsFragment.setCall_Back(fragment_call_back);
        lessonInfoFragment.setCall_Back(fragment_call_back);
        storeFragment.setCall_Back(fragment_call_back);

        showFragment(homeFragment);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(SETTINGS, R.drawable.ic_settings_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(HOME, R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(STORE, R.drawable.ic_store_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(NEW_LESSON, R.drawable.ic_new_releases_black_24dp));

        bottomNavigation.show(HOME,true);

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case HOME: showFragment(homeFragment);
                    break;
                    case STORE: showFragment(storeFragment);
                    break;
                }
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (counter){
                    case 0:
                        break;
                    case 1: {counter = 0; showFragment(homeFragment);}
                    break;
                    case 2: { counter = 1;showFragment(lessonsFragment);}
                }
            }
        });
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_FL_page, fragment);
        transaction.commit();
    }

    private Fragment_Call_Back fragment_call_back = new Fragment_Call_Back() {
        @Override
        public void goToHomeFragment() {
            counter = 0;
            showFragment(homeFragment);
        }

        @Override
        public void goToLessonsFragment(SubCategory subCategory) {
            counter = 1;
            lessonsFragment.setSubcategory(subCategory);
            showFragment(lessonsFragment);
        }

        @Override
        public void goToStoreFragment() {
            showFragment(storeFragment);
        }

        @Override
        public void goToSettingsFragment() {

        }

        @Override
        public void goToLessonInfoFragment(Lesson lesson) {
            counter = 2;
            lessonInfoFragment.setLesson(lesson);
            showFragment(lessonInfoFragment);
        }
    };
}
