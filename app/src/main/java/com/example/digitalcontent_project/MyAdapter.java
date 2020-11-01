package com.example.digitalcontent_project;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {
    private ArrayList<ItemData> listData = new ArrayList<>();
    @NonNull
    public ItemViewHolder onCreatViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem4,parent,false);
        return new ItemViewHolder(view);

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){
        holder.onBind(listData.get(position));
    }
    @Override
    public int getItemCount(){
        return listData.size();
    }
    public void addItem(ItemData data){
        listData.add(data);
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;

        ItemViewHolder(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.item4_title);
            textView2 = itemView.findViewById(R.id.item4_subtitle);
        }
        void onBind(ItemData data){
            textView1.setText(data.title);
            textView2.setText(data.subtitle);
        }
    }

}
