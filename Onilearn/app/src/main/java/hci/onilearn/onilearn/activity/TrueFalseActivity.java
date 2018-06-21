package hci.onilearn.onilearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import hci.onilearn.onilearn.R;

public class TrueFalseActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button buttonFalse, buttonTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false3);
        reflect();
        actionBar();
        click();
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void reflect() {
        toolbar = (Toolbar)findViewById(R.id.toolbarTrueFalse);
        buttonFalse = (Button)findViewById(R.id.btnFalse);
        buttonTrue = (Button)findViewById(R.id.btnTrue);
    }

    private void click() {
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FalseActivity.class);
                startActivity(intent);
            }
        });

        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrueActivity.class);
                startActivity(intent);
            }
        });
    }
}
