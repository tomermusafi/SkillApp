package com.musafi.skillapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.musafi.skillapp.info.Category;

import java.util.ArrayList;
import java.util.Locale;

public class Adapter_CategoryModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Category> notes;
    private OnItemClickListener mItemClickListener;

    public Adapter_CategoryModel(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    public void updateList(ArrayList<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // TODO: 4/29/2020
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_note, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final Note note = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.note_LBL_title.setText(note.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    private Note getItem(int position) {
        return notes.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView note_LBL_title;

        public ViewHolder(final View itemView) {
            super(itemView);
            this.note_LBL_title = itemView.findViewById(R.id.note_LBL_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }
    }

    public void removeAt(int position) {
        notes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, notes.size());
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Note note);
    }
}