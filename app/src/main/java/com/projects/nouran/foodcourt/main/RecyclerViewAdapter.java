package com.projects.nouran.foodcourt.main;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.projects.nouran.foodcourt.R;
import com.projects.nouran.foodcourt.main.pojos.Store;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MainViewHolder> {

    private List<Store> stores;
    private Context context;

    public RecyclerViewAdapter(List<Store> stores, Context context) {
        this.stores = stores;
        this.context = context;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_cell,
                viewGroup, false);
        return new MainViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MainViewHolder viewHolder, int i) {
        viewHolder.nameTextView.setText(stores.get(i).getStoreName());
        viewHolder.descriptionTextView.setText(stores.get(i).getStoreDescription());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder);
        requestOptions.error(R.drawable.placeholder);

        viewHolder.imageView.setImageDrawable(Drawable.createFromPath("R.drawable.placeholder"));
        Glide.with(context).setDefaultRequestOptions(requestOptions).load(stores.get(i).getStoreLogo())
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView, descriptionTextView;
        ImageView imageView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = (TextView)itemView.findViewById(R.id.storeName);
            descriptionTextView = (TextView)itemView.findViewById(R.id.storeDescription);
            imageView = (ImageView) itemView.findViewById(R.id.storeLogo);

        }
    }

}
