package hci.onilearn.onilearn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.TaskAdapter;
import hci.onilearn.onilearn.model.Subject;
import hci.onilearn.onilearn.model.Task;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeTableFragment extends Fragment {
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
        taskList = new ArrayList<>();

        lvTask.setLayoutManager(linearLayoutManager);
        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Android",""));
        subjects.add(new Subject("Java",""));
        subjects.add(new Subject("HTML",""));
        subjects.add(new Subject("C#",""));
        subjects.add(new Subject("Ruby",""));
        subjects.add(new Subject("Javascript",""));
        subjects.add(new Subject("Python",""));
        taskList.add(new Task(subjects.get(0), Calendar.getInstance().getTime(),Calendar.getInstance().getTime(),true,""));
        taskAdapter = new TaskAdapter(getContext(),taskList);
        lvTask.setAdapter(taskAdapter);
        return view;
    }

}
