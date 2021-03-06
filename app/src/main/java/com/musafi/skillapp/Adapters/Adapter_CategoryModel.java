package com.musafi.skillapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.musafi.skillapp.R;
import com.musafi.skillapp.info.Category;

import java.util.ArrayList;
import java.util.List;

public class Adapter_CategoryModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Category> categories;
    private OnItemClickListener mItemClickListener;

    public Adapter_CategoryModel(Context context, List<Category> category) {
        this.context = context;
        this.categories = category;
    }

    public void updateList(ArrayList<Category> category) {
        this.categories = category;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final Category category = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.category_name.setText(category.getName());
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    private Category getItem(int position) {
        return categories.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView category_name;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.category_name = itemView.findViewById(R.id.category_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }
    }

    public void removeAt(int position) {
        categories.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, categories.size());
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Category category);
    }
}