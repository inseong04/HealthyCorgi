package com.example.digitalcontent_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.digitalcontent_project.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment5 extends Fragment {

    private ListView listView;

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
        listView = (ListView) getView().findViewById(R.id.listview);

        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data); // fragment이기때문에 첫번째 인자에 this를 쓸 경우 오류 발생.
        listView.setAdapter(adapter);

        data.add("내정보");
        data.add("정보수정");
        data.add("회원탈퇴");
        adapter.notifyDataSetChanged();

        return view;
        // 오류
    }
}