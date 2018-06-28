package hci.onilearn.onilearn.activity;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.model.Question;
import hci.onilearn.onilearn.model.QuestionTrueFalse;

public class TrueFalseActivity extends AppCompatActivity {
    private List<QuestionTrueFalse> questionTrueFalses;
    private int pos;
    Toolbar toolbar;
    Button buttonFalse, buttonTrue;
    TextView txtQuestion;
    ConstraintLayout imgTrue, imgFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);
        reflect();
        actionBar();
        click();
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbarTrueFalse);
        buttonFalse = (Button) findViewById(R.id.btnFalse);
        buttonTrue = (Button) findViewById(R.id.btnTrue);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        imgTrue = (ConstraintLayout) findViewById(R.id.imgTrue);
        imgFalse = (ConstraintLayout) findViewById(R.id.imgFalse);
        questionTrueFalses = MyData.questionTrueFalses;
        pos = 0;
    }

    private void initQuestion() {
        txtQuestion.setText(questionTrueFalses.get(pos).getContent());
    }

    private void click() {
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!questionTrueFalses.get(pos).isAnswers()) {
                    imgTrue.setVisibility(View.VISIBLE);
                } else {
                    imgFalse.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (questionTrueFalses.get(pos).isAnswers()) {
                    imgTrue.setVisibility(View.VISIBLE);
                } else {
                    imgFalse.setVisibility(View.VISIBLE);
                }
            }
        });

        imgTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgTrue.setVisibility(View.INVISIBLE);
                pos++;
                if (pos >= questionTrueFalses.size()) {
                    finish();
                    return;
                }
                initQuestion();
            }
        });
        imgFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFalse.setVisibility(View.INVISIBLE);
            }
        });
    }
}
