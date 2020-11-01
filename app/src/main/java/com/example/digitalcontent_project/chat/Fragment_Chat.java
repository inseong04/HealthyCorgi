package com.example.digitalcontent_project.chat;

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

    private String TAG;
    private ArrayList<ChatData> arrayList;
    ChatAdapter adapter;
    EditText chat_input;
    RecyclerView recyclerView;
    Button send_btn;
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

        arrayList = new ArrayList<>();
        adapter = new ChatAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = chat_input.getText().toString();
                Log.e(TAG,"awegwegawgwdafsgwaegewg");
                ChatData chatData = new ChatData(message);
                arrayList.add(chatData);
                adapter.notifyDataSetChanged();
                chat_input.setText("");
            }
        });
        return view;
    }
}