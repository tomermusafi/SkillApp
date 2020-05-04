package com.musafi.skillapp.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flatdialoglibrary.dialog.FlatDialog;
import com.musafi.skillapp.Adapters.Adapter_CouponsModel;
import com.musafi.skillapp.Adapters.Adapter_LessonModel;
import com.musafi.skillapp.Call_Back.Fragment_Call_Back;
import com.musafi.skillapp.MainActivity;
import com.musafi.skillapp.R;
import com.musafi.skillapp.UTIL.Recycler_util;
import com.musafi.skillapp.info.Coupon;
import com.musafi.skillapp.info.Lesson;
import com.musafi.skillapp.info.Main;
import com.musafi.skillapp.info.SubCategory;

import java.util.List;

public class StoreFragment extends Fragment {
    private View view;
    private RecyclerView list_RV_coupon;
    private Context context;
    private Adapter_CouponsModel adapter_couponsModel;

    private List<Coupon> coupons;
    
    private Fragment_Call_Back call_back;

    public StoreFragment(Context context){
        this.context = context;

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
            view = inflater.inflate(R.layout.store_fragment, container, false);
        }

        findViews(view);
        coupons = Main.getAllCoupons();
        adapter_couponsModel = new Adapter_CouponsModel(context, coupons);
        initLessons();

        // TODO: 5/1/2020  
        adapter_couponsModel.SetOnItemClickListener(new Adapter_CouponsModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, final Coupon coupon) {
                Toast.makeText(context,coupon.getName(),Toast.LENGTH_SHORT).show();


                final FlatDialog flatDialog = new FlatDialog(context);
                flatDialog.setTitle("Thank you! \uD83C\uDF81\uD83C\uDF89\uD83D\uDE4F")
                        .setSubtitle("The coupon has been added to your wallet")
                        .setFirstButtonText("OK")
                        .setFirstButtonColor(R.color.category_bg_color)

                        .withFirstButtonListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                MainActivity.amountOfCoins -= coupon.getPrice();
                                MainActivity.coins.setText(""+MainActivity.amountOfCoins);
                                flatDialog.dismiss();
                            }
                        }).show();

            }

        });

        return view;
    }

    private void initLessons() {
        Recycler_util.initList(context,adapter_couponsModel,list_RV_coupon,1);
    }


    private void findViews(View view) {
        list_RV_coupon = view.findViewById(R.id.list_RV_coupon);

    }




}
