package com.example.testchaylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThucAnAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ThucAn> thucAnList;

    public ThucAnAdapter(Context context, int layout, List<ThucAn> thucAnList) {
        this.context = context;
        this.layout = layout;
        this.thucAnList = thucAnList;
    }

    @Override
    public int getCount() {
        return thucAnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView textTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView textMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        ThucAn thucAn = thucAnList.get(i);
        textTen.setText(thucAn.getTen());
        textMoTa.setText(thucAn.getMota());
        imgHinh.setImageResource(thucAn.getHinh());
        return view;
    }

}
