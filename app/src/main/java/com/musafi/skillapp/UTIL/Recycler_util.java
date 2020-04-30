package com.musafi.skillapp.UTIL;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_util {

    public static void initList(Context context, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, RecyclerView recyclerView, int orientation) {

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context,orientation,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }


}
