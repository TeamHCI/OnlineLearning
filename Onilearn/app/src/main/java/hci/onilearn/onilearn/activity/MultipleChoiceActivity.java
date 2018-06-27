package hci.onilearn.onilearn.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hci.onilearn.onilearn.R;

public class MultipleChoiceActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button buttonSubmit;
    TextView txtA, txtB, txtC, txtD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);
        reflect();
        actionBar();
        chooseOption();
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void reflect() {
        toolbar = (Toolbar)findViewById(R.id.toolbarTrueFalse);
        buttonSubmit = (Button) findViewById(R.id.btnSubmit);
        txtA = (TextView) findViewById(R.id.txtA);
        txtB = (TextView) findViewById(R.id.txtB);
        txtC = (TextView) findViewById(R.id.txtC);
        txtD = (TextView) findViewById(R.id.txtD);
    }

    private void chooseOption() {
        txtA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtA.setBackgroundColor(Color.GREEN);
                txtA.setTextColor(Color.WHITE);
                buttonSubmit.setText("NEXT");
                txtB.setEnabled(false);
                txtC.setEnabled(false);
                txtD.setEnabled(false);

                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AnswerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        txtB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtB.setBackgroundColor(Color.RED);
                txtB.setTextColor(Color.WHITE);
                buttonSubmit.setText("NEXT");
                txtA.setEnabled(false);
                txtC.setEnabled(false);
                txtD.setEnabled(false);

                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AnswerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        txtC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtC.setBackgroundColor(Color.RED);
                txtC.setTextColor(Color.WHITE);
                buttonSubmit.setText("NEXT");
                txtA.setEnabled(false);
                txtB.setEnabled(false);
                txtD.setEnabled(false);

                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AnswerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        txtD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtD.setBackgroundColor(Color.RED);
                txtD.setTextColor(Color.WHITE);
                buttonSubmit.setText("NEXT");
                txtA.setEnabled(false);
                txtB.setEnabled(false);
                txtC.setEnabled(false);

                buttonSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AnswerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
