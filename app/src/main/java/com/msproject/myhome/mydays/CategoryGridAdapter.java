package com.msproject.myhome.mydays;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.*;

public class CategoryGridAdapter extends BaseAdapter {
    ArrayList<Category> categories;

    public CategoryGridAdapter(ArrayList<Category> categories){
        this.categories = categories;
    }
    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        TextView categoryName = view.findViewById(R.id.category_name);
        LinearLayout colorView = view.findViewById(R.id.color_view);

        categoryName.setText(categories.get(position).getCategoryName());
        Log.d("colorInteger==", hexToInteger(categories.get(position).getColor())+ " ");
        colorView.setBackgroundColor(Color.parseColor(categories.get(position).getColor()));
        return view;
    }

    public int hexToInteger(String str){
        int hex = 0;
        int hexIndex = 1;
        for(int i = str.length() - 1; i > 0; i--){
            char c = str.charAt(i);
            int tmp = 0;
            if(c > 96){//소문자
                tmp = 10 + 97 - c;
            }
            else{//숫자
                tmp = Integer.parseInt(String.valueOf(c));
            }
            hex += hexIndex * tmp;
            hexIndex *= 16;
        }
        return hex;
    }
}
