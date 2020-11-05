package com.example.digitalcontent_project.chat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.digitalcontent_project.R;
import com.example.digitalcontent_project.chat.data.AlarmData;
import com.example.digitalcontent_project.chat.data.ChatData;
import com.example.digitalcontent_project.chat.data.InformationData;
import com.example.digitalcontent_project.chat.data.TodaymedicineData;
import com.example.digitalcontent_project.chat.data.VaccinationData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Fragment_Chat extends Fragment {

    private String TAG;
    private ChatAdapter adapter;
    private ArrayList<ChatData> arrayList;
    private ArrayList<AlarmData> alarm_arrayList;
    private ArrayList<InformationData> information_arrayList;
    private ArrayList<TodaymedicineData> todaymedicine_arrayList;
    private ArrayList<VaccinationData> vaccination_arrayList;

    private EditText chat_input;
    private RecyclerView recyclerView;
    private Button send_btn;
    private TextView today_medicine;
    private TextView vaccination;
    private TextView information_btn;
    private TextView alarm_btn;
    private TextView setting_alarm_btn;
    private TextView alarm_delete_btn;
    private TextView count_date_btn;

    int i=0;
    public Fragment_Chat() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        chat_input = view.findViewById(R.id.chat_input);
        recyclerView = view.findViewById(R.id.chat_recyclerview);
        send_btn = view.findViewById(R.id.send_btn);
        information_btn = view.findViewById(R.id.information);
        today_medicine = view.findViewById(R.id.today_medicine);
        vaccination = view.findViewById(R.id.vaccination);
        alarm_btn = view.findViewById(R.id.alarm_btn);
        setting_alarm_btn = view.findViewById(R.id.setting_alarm_btn);
        alarm_delete_btn = view.findViewById(R.id.alarm_delete_btn);
        count_date_btn = view.findViewById(R.id.count_date_btn);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebaseAuth의 인스턴스를 가져온다.
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String user_uid = user.getUid();
//        first_arrayList = new ArrayList<>();

        ChatData chatData = new ChatData("안녕하세요 헬시코기입니다. 무엇을 도와드릴까요?",Code.viewType.LEFT_MESSAGE);
        AlarmData alarmData = new AlarmData("","","");
        InformationData informationData = new InformationData("","","","","","");
        TodaymedicineData todaymedicineData = new TodaymedicineData("","","");
        VaccinationData vaccinationData = new VaccinationData("","","","");

        //    java.lang.NullPointerException: Attempt to invoke virtual method 'boolean java.util.ArrayList.add(java.lang.Object)' on a null object reference
        arrayList.add(chatData);
        alarm_arrayList.add(alarmData);
        information_arrayList.add(informationData);
        todaymedicine_arrayList.add(todaymedicineData);
        vaccination_arrayList.add(vaccinationData);

        adapter.notifyDataSetChanged();
        arrayList = new ArrayList<>();


        alarm_arrayList = new ArrayList<>();
        information_arrayList = new ArrayList<>();
        todaymedicine_arrayList = new ArrayList<>();
        vaccination_arrayList = new ArrayList<>();

        adapter = new ChatAdapter(arrayList,alarm_arrayList,information_arrayList,todaymedicine_arrayList,vaccination_arrayList);
        recyclerView.setAdapter(adapter);

        information_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firestoreDB.collection("users").document(user_uid)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if(task.isSuccessful()){
                                    DocumentSnapshot document = task.getResult();
                                    String name = document.get("Name").toString();
                                    String age = document.get("Age").toString();
                                    String gender = document.get("Gender").toString();
                                    String disease = document.get("Disease").toString();
                                    String nowcondition = document.get("Nowcondition").toString();
                                    String precaution = document.get("Precaution").toString();
                                    ChatData chatData = new ChatData("건강정보를 확인하시려면 이 메세지를 클릭해주세요!",Code.viewType.HEALTHY_INFORMATION);
                                    arrayList.add(chatData);
                                    adapter.notifyDataSetChanged();
                                    InformationData informationData = new InformationData(name,age,gender,disease,nowcondition,precaution);
                                    information_arrayList.add(informationData);
                                    adapter.notifyDataSetChanged();

                                }
                                else{
                                    Log.e(TAG, "No such document");
                                }
                            }
                        });
                ChatData chatData = new ChatData("건강정보를 확인하시려면 이 메세지를 클릭해주세요!",Code.viewType.LEFT_MESSAGE);
                arrayList.add(chatData);
                adapter.notifyDataSetChanged();
            }
        });

        today_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatData chatData = new ChatData("오늘 복용할 약을 확인하시려면 이 메세지를 클릭해주세요!",Code.viewType.LEFT_MESSAGE);
                arrayList.add(chatData);
                adapter.notifyDataSetChanged();
            }
        });

        vaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatData chatData = new ChatData("예방접종 내역을 확인하시려면 이 메세지를 클릭해주세요!",Code.viewType.LEFT_MESSAGE);
                arrayList.add(chatData);
                adapter.notifyDataSetChanged();
            }
        });

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Map<String, Object> user_chating = new HashMap<>();
                final String message = chat_input.getText().toString();
                i++;
                user_chating.put("message"+i,message);
                firestoreDB.collection("users").document(user_uid)
                        .update(user_chating)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.e(TAG,message);
                                ChatData chatData = new ChatData(message,Code.viewType.RIGHT_MESSAGE);
                                arrayList.add(chatData);
                                adapter.notifyDataSetChanged();
                                chat_input.setText("");
                            }
                        });

            }
        });
        return view;
    }
}