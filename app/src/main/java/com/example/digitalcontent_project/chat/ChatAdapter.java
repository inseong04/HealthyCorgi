package com.example.digitalcontent_project.chat;

import android.content.Context;
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

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    private ArrayList<ChatData> arrayList ;

    public ChatAdapter(@NonNull ArrayList<ChatData> arrayList) {
        this.arrayList = arrayList;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(viewType == Code.viewType.RIGHT_MESSAGE){
            view = inflater.inflate(R.layout.item_list,parent,false);
            return new RightViewHolder(view);
        }
        else if (viewType == Code.viewType.LEFT_MESSAGE){
            view = inflater.inflate(R.layout.left_item_list,parent,false);
            return new LeftViewHolder(view);
        }
        else{
            view = inflater.inflate(R.layout.item_list,parent,false);
            return new RightViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(holder instanceof LeftViewHolder){
            ((LeftViewHolder)holder).chat_message.setText(arrayList.get(position).getUser_message());
        }
        else if(holder instanceof RightViewHolder){
            ((RightViewHolder)holder).chat_message.setText(arrayList.get(position).getUser_message());
        }else {
            ((RightViewHolder)holder).chat_message.setText(arrayList.get(position).getUser_message());
        }

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public int getItemViewType(int position){
        return arrayList.get(position).getViewType();
    }




    public class LeftViewHolder extends RecyclerView.ViewHolder{
        TextView chat_message;

        LeftViewHolder(View itemView){
            super(itemView);

            chat_message = itemView.findViewById(R.id.chat_message);
        }
    }
    public class  RightViewHolder extends  RecyclerView.ViewHolder{
        TextView chat_message;

        RightViewHolder(View itemView){
            super(itemView);

            chat_message = itemView.findViewById(R.id.chat_message);
        }
    }
}
