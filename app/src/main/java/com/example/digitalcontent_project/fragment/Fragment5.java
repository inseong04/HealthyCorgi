package com.example.digitalcontent_project.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.digitalcontent_project.R;
import com.google.firebase.auth.FirebaseAuth;

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