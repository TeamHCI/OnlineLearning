package hci.onilearn.onilearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.ResultTrueFalseAdapter;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.model.QuestionTrueFalse;

public class ResultActivity extends AppCompatActivity {

    ListView resultList;
    TextView txtResult;
    int subjectId;
    ArrayList<QuestionTrueFalse> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        actionBar();

        resultList = (ListView)findViewById(R.id.listResult);
        txtResult = findViewById(R.id.txtResult);
        txtResult.setText(getIntent().getStringExtra("result"));

        subjectId = getIntent().getIntExtra("SubjectId", 0);
        list = MyData.subjectAndQuestion.get(subjectId);
        ResultTrueFalseAdapter adapter = new ResultTrueFalseAdapter(this, list);

        resultList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void actionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTrueFalse);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
