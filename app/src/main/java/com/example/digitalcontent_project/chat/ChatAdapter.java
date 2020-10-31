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
    private String myname;


    public ChatAdapter(ArrayList<ChatData> arrayList,String ismine) {
        this.arrayList = arrayList;
        this.myname = ismine;
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
        ChatData chat = arrayList.get(position);

        holder.chat_input.setText(arrayList.get(position).getUser_input());




    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView chat_input;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.chat_input = (TextView) itemView.findViewById(R.id.chat_input);
        }
    }

    public void addchat(ChatData chat){
        arrayList.add(chat);
        notifyItemInserted(arrayList.size()-1);
    }
}
