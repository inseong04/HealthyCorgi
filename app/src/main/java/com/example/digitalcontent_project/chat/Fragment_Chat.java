package com.example.digitalcontent_project.chat;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.digitalcontent_project.R;
import com.example.digitalcontent_project.main.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Fragment_Chat extends Fragment {

    private String TAG;
    private ChatAdapter adapter;
    private ArrayList<ChatData> arrayList;
    //    private ArrayList<ChatData> first_arrayList;
    private EditText chat_input;
    private RecyclerView recyclerView;
    private Button send_btn;
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




        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebaseAuth의 인스턴스를 가져온다.
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String user_uid = user.getUid();
//        first_arrayList = new ArrayList<>();

        arrayList = new ArrayList<>();

        adapter = new ChatAdapter(arrayList);
        recyclerView.setAdapter(adapter);


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