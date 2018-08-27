package com.projects.nouran.foodcourt.main;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.nouran.foodcourt.R;
import com.projects.nouran.foodcourt.main.pojos.Store;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MainViewHolder> {

    private List<Store> stores;

    public RecyclerViewAdapter(List<Store> stores) {
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
