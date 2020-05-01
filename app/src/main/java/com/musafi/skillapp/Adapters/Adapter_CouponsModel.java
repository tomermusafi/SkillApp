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
import com.musafi.skillapp.info.Coupon;
import com.musafi.skillapp.info.Lesson;

import java.util.ArrayList;
import java.util.List;

public class Adapter_CouponsModel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Coupon> coupons;
    private OnItemClickListener mItemClickListener;

    public Adapter_CouponsModel(Context context, List<Coupon> coupons) {
        this.context = context;
        this.coupons = coupons;
    }

    public void updateList(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
        notifyDataSetChanged();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coupons_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final Coupon coupon = getItem(position);
            final ViewHolder genericViewHolder = (ViewHolder) holder;
// TODO: 5/1/2020

            genericViewHolder.coupon_name.setText(coupon.getName());
            genericViewHolder.company_name.setText(""+coupon.getCompany());
            genericViewHolder.price.setText(""+coupon.getPrice());
            Glide.with(context).load(coupon.getUrl()).into(genericViewHolder.coupon_img);







        }
    }

    @Override
    public int getItemCount() {
        return coupons.size();
    }

    private Coupon getItem(int position) {
        return coupons.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView coupon_name, company_name, price;
        private ImageView coupon_img;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.coupon_name = itemView.findViewById(R.id.coupon_name);
            this.company_name = itemView.findViewById(R.id.company_name);
            this.price = itemView.findViewById(R.id.price);
            this.coupon_img = itemView.findViewById(R.id.coupon_img);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }
    }

    public void removeAt(int position) {
        coupons.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, coupons.size());
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, Coupon coupon);
    }
}