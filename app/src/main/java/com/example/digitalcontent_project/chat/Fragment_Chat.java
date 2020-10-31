package com.example.digitalcontent_project.chat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.digitalcontent_project.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Chat extends Fragment {

    private ArrayList<ChatData> arrayList;
    private ChatAdapter mAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private  EditText user_input;
    private Button send_btn;
    private DatabaseReference myRef;
    ChatData chatData;
    public Fragment_Chat() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*        final EditText user_input = getView().findViewById(R.id.user_input);
        Button send_btn = getView().findViewById(R.id.send_btn);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_input_string = user_input.getText().toString().trim();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue(user_input_string); // RealtimeDatabase에 작성

            }
        });*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        send_btn = view.findViewById(R.id.send_btn);
        user_input = view.findViewById(R.id.user_input);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = user_input.getText().toString();

                if (msg != null){
                    chatData = new ChatData(msg);
                    myRef.setValue(chatData);
                }
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.chat_recyclerview);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String user_uid = user.getUid();
        arrayList = new ArrayList<>();
        mAdapter = new ChatAdapter(arrayList,user_uid);
        recyclerView.setAdapter(mAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                snapshot.getValue(ChatData.class);
                mAdapter.addchat(chatData);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // send_btn 추가해야함.
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }
}