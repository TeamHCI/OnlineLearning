package hci.onilearn.onilearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import hci.onilearn.onilearn.R;

public class TrueActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout linearImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true);
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
        linearImg = (LinearLayout)findViewById(R.id.imgFalse);
    }

    private void click() {
        linearImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrueFalseActivity.class);
                startActivity(intent);
            }
        });
    }
}
