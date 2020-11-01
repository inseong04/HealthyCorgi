package com.example.digitalcontent_project.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.digitalcontent_project.ItemData;
import com.example.digitalcontent_project.MyAdapter;
import com.example.digitalcontent_project.R;


public class Fragment4 extends Fragment {

    private MyAdapter adapter = new MyAdapter();

    public Fragment4() {
        // Required empty public constructor
    }

    @Override
    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_4);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter.addItem(new ItemData("첫번째 아이템","꾸엑"));
        adapter.addItem(new ItemData("두번째 아이템","우엑"));

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_4, container, false);
    }
}