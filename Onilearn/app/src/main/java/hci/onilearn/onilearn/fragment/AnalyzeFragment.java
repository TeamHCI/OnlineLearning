package hci.onilearn.onilearn.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.ListThongKeAdapter;
import hci.onilearn.onilearn.model.ThongKe;

public class AnalyzeFragment extends Fragment {
    ArrayList<ThongKe> listThongKe;
    ListView listView;
    ListThongKeAdapter adapter;
    View view;
    public AnalyzeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_analyze, container, false);
        reflect();
        setListMonHoc();
        return view;
    }
    private void reflect() {
        listThongKe = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listViewThongKe);
        adapter = new ListThongKeAdapter(getContext(),listThongKe);
        listView.setAdapter(adapter);
    }
    private void setListMonHoc(){

        listThongKe.add(new ThongKe(19,293,"150 phút",12,"Tháng 5"));
        listThongKe.add(new ThongKe(10,503,"180 phút",5,"Tháng 6"));
        listThongKe.add(new ThongKe(30,302,"250 phút",10,"Tháng 7"));


    }
}
