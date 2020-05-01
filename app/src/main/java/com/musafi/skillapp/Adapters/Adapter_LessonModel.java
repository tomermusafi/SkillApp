package com.musafi.skillapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.musafi.skillapp.R;
import com.musafi.skillapp.info.Category;
import com.musafi.skillapp.info.Lesson;

import java.util.ArrayList;
import java.util.List;

public class Adapter_LessonModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Lesson> lessons;
    private OnItemClickListener mItemClickListener;

    public Adapter_LessonModel(Context context, List<Lesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }

    public void updateList(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lessons_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final Lesson lesson = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;
// TODO: 5/1/2020
            genericViewHolder.lesson_name.setText(lesson.getName());
            genericViewHolder.person_name.setText("By: "+lesson.getLecturer().getName());
            genericViewHolder.lesson_duration.setText(""+lesson.getDuration());
            genericViewHolder.person_rating.setText(""+lesson.getLecturer().getRating());
            genericViewHolder.num_of_participant.setText(lesson.getNumOfStudentsRolled()+"/"+lesson.getMaxStudents());
            genericViewHolder.lesson_date.setText(lesson.getStartTimeDate());
            genericViewHolder.Lesson_time.setText(lesson.getStartTimeHourMinute());

            Glide.with(context).load(lesson.getLecturer().getUrl()).into(genericViewHolder.avatar);



        }
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    private Lesson getItem(int position) {
        return lessons.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView lesson_name, person_name, lesson_duration, person_rating, num_of_participant, lesson_date, Lesson_time;
        private ImageView avatar;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.lesson_name = itemView.findViewById(R.id.lesson_name);
            this.person_name = itemView.findViewById(R.id.pperson_name);
            this.lesson_duration = itemView.findViewById(R.id.lesson_duration);
            this.person_rating = itemView.findViewById(R.id.rating);
            this.num_of_participant = itemView.findViewById(R.id.num_of_participant);
            this.lesson_date = itemView.findViewById(R.id.lesson_date);
            this.Lesson_time = itemView.findViewById(R.id.Lesson_time);
            this.avatar = itemView.findViewById(R.id.avatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }
    }

    public void removeAt(int position) {
        lessons.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, lessons.size());
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Lesson lesson);
    }
}