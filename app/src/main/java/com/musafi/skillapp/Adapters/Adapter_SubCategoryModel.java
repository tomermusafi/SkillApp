package com.musafi.skillapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.musafi.skillapp.R;
import com.musafi.skillapp.info.Category;
import com.musafi.skillapp.info.SubCategory;

import java.util.ArrayList;

public class Adapter_SubCategoryModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<SubCategory> subCategories;
    private OnItemClickListener mItemClickListener;

    public Adapter_SubCategoryModel(Context context, ArrayList<SubCategory> SubCategories) {
        this.context = context;
        this.subCategories = SubCategories;
    }

    public void updateList(ArrayList<SubCategory> subCategory) {
        this.subCategories = subCategory;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_category_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final SubCategory subCategory = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.subCategory_name.setText(subCategory.getName());
        }
    }

    @Override
    public int getItemCount() {
        return subCategories.size();
    }

    private SubCategory getItem(int position) {
        return subCategories.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


       private TextView subCategory_name;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.subCategory_name = itemView.findViewById(R.id.subcategory_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }
    }

    public void removeAt(int position) {
        subCategories.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, subCategories.size());
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, SubCategory subCategory);
    }
}