package com.example.user.retrifit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageListAdapter extends BaseAdapter {
    ArrayList<Hit> hits;
    Context ctx;
    Picasso picasso;

    public ImageListAdapter(Context ctx, ArrayList<Hit> hits, Picasso picasso) {
        this.ctx = ctx;
        this.hits = hits;
        this.picasso = picasso;
    }

    @Override
    public int getCount() {
        return hits.size();
    }

    @Override
    public Object getItem(int position) {
        return hits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Hit hit = hits.get(position);

        convertView = LayoutInflater.from(ctx).
                inflate(R.layout.image, parent, false);
        ImageView pic = convertView.findViewById(R.id.img);
        picasso.load(hit.previewURL).into(pic);
        return convertView;
    }
}
