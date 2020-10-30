package com.example.digitalcontent_project.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.digitalcontent_project.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.CustomViewHolder> {

    private ArrayList<ChatData> arrayList;



    public ChatAdapter(ArrayList<ChatData> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ChatAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.CustomViewHolder holder, int position) {
        holder.chat_input.setText(arrayList.get(position).getMessage());
        holder.chat_image.setImageResource(arrayList.get(position).getChat_image());

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView chat_image;
        protected TextView chat_input;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.chat_image = (ImageView) itemView.findViewById(R.id.chat_image);
            this.chat_input = (TextView) itemView.findViewById(R.id.chat_input);
        }
    }
}
