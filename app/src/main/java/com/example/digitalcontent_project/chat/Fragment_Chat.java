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
        final EditText chat_input = view.findViewById(R.id.chat_input);
        RecyclerView recyclerView = view.findViewById(R.id.chat_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        arrayList = new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        Button send_btn = view.findViewById(R.id.send_btn);
        final ChatAdapter adapter = new ChatAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = chat_input.getText().toString().trim();
                Log.e(TAG,message);
                ChatData chatData = new ChatData(message);
                arrayList.add(chatData);
                adapter.notifyDataSetChanged();
            }
        });
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }
}