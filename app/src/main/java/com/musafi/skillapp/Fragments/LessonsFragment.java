package com.musafi.skillapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.musafi.skillapp.Adapters.Adapter_CategoryModel;
import com.musafi.skillapp.Adapters.Adapter_LessonModel;
import com.musafi.skillapp.Adapters.Adapter_SubCategoryModel;
import com.musafi.skillapp.Call_Back.Fragment_Call_Back;
import com.musafi.skillapp.R;
import com.musafi.skillapp.UTIL.Recycler_util;
import com.musafi.skillapp.info.Category;
import com.musafi.skillapp.info.Lesson;
import com.musafi.skillapp.info.Main;
import com.musafi.skillapp.info.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class LessonsFragment extends Fragment {
    private View view;
    private RecyclerView list_RV_lesson;
    private Context context;
    private Adapter_LessonModel adapter_lessonModel;

    private List<Lesson> lessons;
    private SubCategory subCategory;

    private Fragment_Call_Back call_back;

    public LessonsFragment(Context context){
        this.context = context;

    }

    public void setSubcategory(SubCategory subcategory){
        this.subCategory = subcategory;
        Log.d("pttt", subCategory.toString());
        lessons = Main.getAllLessons(10, subCategory);
    }
    public void setCall_Back(Fragment_Call_Back call_back){
        this.call_back = call_back;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        Log.d("pttt", "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("pttt", "onCreateView");
        if(view==null){
            view = inflater.inflate(R.layout.lessons_fragment, container, false);
        }

        findViews(view);
        adapter_lessonModel = new Adapter_LessonModel(context, lessons);
        initLessons();

        adapter_lessonModel.SetOnItemClickListener(new Adapter_LessonModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Lesson lesson) {
                Toast.makeText(context,lesson.getName(),Toast.LENGTH_SHORT).show();
                call_back.goToLessonInfoFragment(lesson);
            }
        });

        return view;
    }

    private void initLessons() {
        Recycler_util.initList(context,adapter_lessonModel,list_RV_lesson,1);
    }


    private void findViews(View view) {
        list_RV_lesson = view.findViewById(R.id.list_RV_lesson);

    }






    private List<Lesson> initList(){

            return lessons;

    }


}
