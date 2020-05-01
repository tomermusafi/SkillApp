package com.musafi.skillapp.Call_Back;

import com.musafi.skillapp.info.Lesson;
import com.musafi.skillapp.info.SubCategory;

public interface Fragment_Call_Back {
    public void goToHomeFragment();
    public void goToLessonsFragment(SubCategory subCategory);
    public void goToStoreFragment();
    public void goToSettingsFragment();
    public void goToLessonInfoFragment(Lesson lesson);
}
