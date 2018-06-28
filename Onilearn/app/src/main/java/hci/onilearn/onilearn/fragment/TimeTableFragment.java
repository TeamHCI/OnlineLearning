package hci.onilearn.onilearn.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.TaskAdapter;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.model.Subject;
import hci.onilearn.onilearn.model.Task;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeTableFragment extends Fragment {
    private final int REQUEST_CODE_TASK = 001;
    private List<Task> taskList;
    private TaskAdapter taskAdapter;

    public TimeTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_time_table, container, false);
        RecyclerView lvTask = (RecyclerView) view.findViewById(R.id.lsTask);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        taskList = MyData.tasks;

        lvTask.setLayoutManager(linearLayoutManager);
        taskAdapter = new TaskAdapter(getContext(),taskList);
        lvTask.setAdapter(taskAdapter);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_TASK && resultCode == RESULT_OK && data != null) {
            Task task =(Task) data.getSerializableExtra("task");
            taskList.add(task);
            taskAdapter.notifyDataSetChanged();
            Log.d("lalala","2");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
