package com.musafi.skillapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.musafi.skillapp.Adapters.Adapter_LessonModel;
import com.musafi.skillapp.Call_Back.Fragment_Call_Back;
import com.musafi.skillapp.R;
import com.musafi.skillapp.UTIL.Recycler_util;
import com.musafi.skillapp.info.Lesson;
import com.musafi.skillapp.info.Main;
import com.musafi.skillapp.info.SubCategory;

import java.util.List;

public class LessonInfoFragment extends Fragment {
    private View view;
    private CardView pay_button;
    private ImageView person_avatar;
    private TextView lesson_name, lesson_date,lesson_time,lesson_participate, lesson_duration, person_rating, person_name, lesson_description;
    private Context context;
    private Lesson lesson;


    private Fragment_Call_Back call_back;

    public LessonInfoFragment(Context context){
        this.context = context;

    }
    public void setLesson(Lesson lesson){
        this.lesson = lesson;
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
            view = inflater.inflate(R.layout.lessons_info_fragment, container, false);
        }

        findViews(view);

        setAttributes();

        return view;
    }

    private void setAttributes() {
        Glide.with(context).load(lesson.getLecturer().getUrl()).into(person_avatar);
        lesson_name.setText(lesson.getName());
        lesson_date.setText(lesson.getStartTimeDate());
        lesson_time.setText(lesson.getStartTimeHourMinute());
        lesson_participate.setText(lesson.getNumOfStudentsRolled()+"/"+lesson.getMaxStudents() + " Enrolled");
        lesson_duration.setText(""+lesson.getDuration() + " Minuets");
        person_rating.setText(""+lesson.getLecturer().getRating());
        person_name.setText(lesson.getLecturer().getName());
        lesson_description.setText(lesson.getBio());
    }

    private void findViews(View view) {
        pay_button = view.findViewById(R.id.pay_button);
        person_avatar = view.findViewById(R.id.person_avatar);
        lesson_name = view.findViewById(R.id.lesson_name);
        lesson_date = view.findViewById(R.id.lesson_date);
        lesson_time = view.findViewById(R.id.lesson_time);
        lesson_participate = view.findViewById(R.id.lesson_participate);
        lesson_duration = view.findViewById(R.id.lesson_duration);
        person_rating = view.findViewById(R.id.person_rating);
        person_name = view.findViewById(R.id.person_name);
        lesson_description = view.findViewById(R.id.lesson_description);

    }




}
