package com.example.digitalcontent_project.chat;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.digitalcontent_project.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    @NonNull
    private ArrayList<ChatData> arrayList;

    public ChatAdapter(@NonNull ArrayList<ChatData> arrayList) {
        this.arrayList = arrayList;
    }

    public ChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ViewHolder holder, int position) {
        ChatData chat_Data = arrayList.get(position);
        holder.chat_message.setText(arrayList.get(position).getUser_message());

        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView chat_message;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.chat_message = (TextView) itemView.findViewById(R.id.chat_message);
        }
    }
}
