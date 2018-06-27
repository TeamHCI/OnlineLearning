package hci.onilearn.onilearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import hci.onilearn.onilearn.R;

public class AnswerActivity extends AppCompatActivity {

    TextView txtView1, txtView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }

    private void reflect() {
        txtView1 = (TextView) findViewById(R.id.txtView1);
        txtView2 = (TextView) findViewById(R.id.txtView2);
    }

    private void show() {
        txtView1.setText("Câu 1: Tìm nghiệm của phương trình sau\n" +
                "a2 + 2ab +c = 0\n\nAnswer:\nA. 3");
        txtView2.setText("Câu 2: Tìm nghiệm của phương trình sau\n" +
                "a2 + 2ab +c = 0\n\nAnswer:\nC. 5");
    }
}
