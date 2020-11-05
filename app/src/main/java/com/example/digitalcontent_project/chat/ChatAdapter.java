package com.example.digitalcontent_project.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.digitalcontent_project.R;
import com.example.digitalcontent_project.chat.data.AlarmData;
import com.example.digitalcontent_project.chat.data.ChatData;
import com.example.digitalcontent_project.chat.data.InformationData;
import com.example.digitalcontent_project.chat.data.TodaymedicineData;
import com.example.digitalcontent_project.chat.data.VaccinationData;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    private ArrayList<ChatData> arrayList ;
    private ArrayList<AlarmData> alarm_arrayList;
    private ArrayList<InformationData> information_arrayList;
    private ArrayList<TodaymedicineData> todaymedicine_arrayList;
    private ArrayList<VaccinationData> vaccination_arrayList;

    public ChatAdapter(@NonNull ArrayList<ChatData> arrayList, ArrayList<AlarmData> alarm_arrayList, ArrayList<InformationData> information_arrayList, ArrayList<TodaymedicineData> todaymedicine_arrayList, ArrayList<VaccinationData> vaccination_arrayList) {
        this.arrayList = arrayList;
        this.alarm_arrayList = alarm_arrayList;
        this.information_arrayList = information_arrayList;
        this.todaymedicine_arrayList = todaymedicine_arrayList;
        this.vaccination_arrayList = vaccination_arrayList;
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

        else if (viewType == Code.viewType.HEALTHY_INFORMATION){
            view = inflater.inflate(R.layout.information_item,parent,false);
            return new InformationViewHolder(view);
        }

        else if (viewType == Code.viewType.HEALTHY_TODAYMEDICINE){
            view = inflater.inflate(R.layout.todaymedicine_item,parent,false);
            return new TodaymedicineViewHolder(view);
        }
        else if (viewType == Code.viewType.HEALTHY_ALARM){
            view = inflater.inflate(R.layout.alarm_item,parent,false);
            return new AlarmViewHolder(view);
        }
        else if (viewType == Code.viewType.HEALTHY_VACCINATION){
            view = inflater.inflate(R.layout.vaccination_item,parent,false);
            return new VaccinationViewHolder(view);
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
        }
        else if(holder instanceof  InformationViewHolder){
            ((InformationViewHolder)holder).information_name.setText(information_arrayList.get(position).getName());
            ((InformationViewHolder)holder).information_age.setText(information_arrayList.get(position).getAge());
            ((InformationViewHolder)holder).information_gender.setText(information_arrayList.get(position).getGender());
            ((InformationViewHolder)holder).information_disease.setText(information_arrayList.get(position).getDisease());
            ((InformationViewHolder)holder).information_nowcondition.setText(information_arrayList.get(position).getNowcondition());
            ((InformationViewHolder)holder).information_precaution.setText(information_arrayList.get(position).getPrecaution());
        }
        else if(holder instanceof TodaymedicineViewHolder){
            ((TodaymedicineViewHolder)holder).todayitem_medicine_name.setText(todaymedicine_arrayList.get(position).getName());
            ((TodaymedicineViewHolder)holder).todayitem_administrationway.setText(todaymedicine_arrayList.get(position).getAdministrationway());
            ((TodaymedicineViewHolder)holder).todayitem_precaution.setText(todaymedicine_arrayList.get(position).getPrecaution());
        }
        else if(holder instanceof  AlarmViewHolder){
            ((AlarmViewHolder)holder).alarm1.setText(alarm_arrayList.get(position).getAlarm1());
            ((AlarmViewHolder)holder).alarm2.setText(alarm_arrayList.get(position).getAlarm2());
            ((AlarmViewHolder)holder).alarm3.setText(alarm_arrayList.get(position).getAlarm3());
        }
        else if(holder instanceof VaccinationViewHolder){
            ((VaccinationViewHolder)holder).vaccination_date.setText(vaccination_arrayList.get(position).getDate1());
            ((VaccinationViewHolder)holder).vaccination_date2.setText(vaccination_arrayList.get(position).getDate2());
            ((VaccinationViewHolder)holder).vaccination_place.setText(vaccination_arrayList.get(position).getPlace1());
            ((VaccinationViewHolder)holder).vaccination_place2.setText(vaccination_arrayList.get(position).getPlace2());
        }
        else {
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

    private class InformationViewHolder extends RecyclerView.ViewHolder {
        TextView information_name;
        TextView information_age;
        TextView information_gender;
        TextView information_disease;
        TextView information_nowcondition;
        TextView information_precaution;

        public InformationViewHolder(View itemView) {
            super(itemView);
            information_name = itemView.findViewById(R.id.information_name);
            information_age = itemView.findViewById(R.id.information_age);
            information_gender = itemView.findViewById(R.id.information_gender);
            information_disease = itemView.findViewById(R.id.information_disease);
            information_nowcondition = itemView.findViewById(R.id.information_nowcondition);
            information_precaution = itemView.findViewById(R.id.information_precaution);
        }
    }
    private class AlarmViewHolder extends RecyclerView.ViewHolder {
        TextView alarm1;
        TextView alarm2;
        TextView alarm3;

        public AlarmViewHolder(View itemView) {
            super(itemView);

            alarm1 = itemView.findViewById(R.id.alarm1);
            alarm2 = itemView.findViewById(R.id.alarm2);
            alarm3 = itemView.findViewById(R.id.alarm3);
        }
    }



    private class TodaymedicineViewHolder extends RecyclerView.ViewHolder {
        TextView todayitem_administrationway;
        TextView todayitem_precaution;
        TextView todayitem_medicine_name;
        public TodaymedicineViewHolder(View itemView) {
            super(itemView);
            todayitem_medicine_name = itemView.findViewById(R.id.info_medicine_name);
            todayitem_administrationway = itemView.findViewById(R.id.todayitem_administrationway);
            todayitem_precaution = itemView.findViewById(R.id.todayitem_precaution);
        }
    }

    private class VaccinationViewHolder extends RecyclerView.ViewHolder {
        TextView vaccination_date;
        TextView vaccination_place;
        TextView vaccination_date2;
        TextView vaccination_place2;
        public VaccinationViewHolder(View itemView) {
            super(itemView);
            vaccination_date = itemView.findViewById(R.id.vaccination_date);
            vaccination_place = itemView.findViewById(R.id.vaccination_place);
            vaccination_date2 = itemView.findViewById(R.id.vaccination_date2);
            vaccination_place2 = itemView.findViewById(R.id.vaccination_place2);
        }
    }
}
