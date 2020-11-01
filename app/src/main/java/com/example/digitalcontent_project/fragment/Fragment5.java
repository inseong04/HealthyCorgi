package com.example.digitalcontent_project.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.digitalcontent_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Fragment5 extends Fragment {


    private String TAG;
    private ListView listView;
    private FirebaseAuth mAuth ;
    TextView withdrawal;
    TextView myprofile;
    TextView edit_profile;
    TextView logout;
    TextView tv_name;
    public Fragment5() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        mAuth = FirebaseAuth.getInstance();
        withdrawal= (TextView) view.findViewById(R.id.withdrawal);
        myprofile = (TextView) view.findViewById(R.id.myprofile);
        edit_profile = (TextView) view.findViewById(R.id.edit_profile);
        logout = (TextView) view.findViewById(R.id.logout);
        tv_name = (TextView) view.findViewById(R.id.name);
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseFirestore firestoreDB = FirebaseFirestore.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String user_uid = user.getUid(); // 유저 고유 uid값.

        firestoreDB.collection("users").document(user_uid)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot document = task.getResult();
                            String name = document.get("Name").toString();
                            tv_name.setText(name);
                        }
                        else{
                            Log.e(TAG, "No such document");
                        }
                    }
                });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("회원탈퇴");
                builder.setMessage("정말 탈퇴하시겠습니까?");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                revokeAccess();
                            }
                        });
                builder.setNegativeButton("아니오",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.e(TAG,"user choose negativebutton");
                            }
                        });
                revokeAccess();
            }
        });
        return view;
        // 오류
    }

    private void signOut() { // 로그아웃 함수.
        FirebaseAuth.getInstance().signOut();
    }

    private void revokeAccess() { // 회원탈퇴 함수.
        mAuth.getCurrentUser().delete();
    }
}