package hci.onilearn.onilearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.ResultTrueFalseAdapter;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.model.QuestionTrueFalse;

public class ResultActivity extends AppCompatActivity {

    ListView resultList;
    ArrayList<QuestionTrueFalse> list = MyData.questionTrueFalses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultList = (ListView)findViewById(R.id.listResult);
        ResultTrueFalseAdapter adapter = new ResultTrueFalseAdapter(this, list);

        resultList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
