package hci.onilearn.onilearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.adapter.ListMonHocAdapter;
import hci.onilearn.onilearn.model.MonHoc;

public class ListMonHoc extends AppCompatActivity {

    ArrayList<MonHoc> listMonHoc;
    ListView listView;
    Toolbar toolbar;
    TextView textViewAction;
    ListMonHocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mon_hoc);
        reflect();
        actionBar();
        setListMonHoc();
        countAction();
    }

    private void countAction() {
        textViewAction.setText("Hôm nay có "+listMonHoc.size()+" hoạt động");
    }

    private void reflect() {
        listMonHoc = new ArrayList<>();
        listView = (ListView)findViewById(R.id.listViewMonHoc);
        toolbar = (Toolbar)findViewById(R.id.toolbarListMonHoc);
        textViewAction = (TextView)findViewById(R.id.txtHoatDongListMonHoc);
        adapter = new ListMonHocAdapter(this,listMonHoc);
        listView.setAdapter(adapter);
    }
    private void setListMonHoc(){
        listMonHoc.add(new MonHoc("English","19:30","20:30","Bài kiểm tra tốc độ","Cơ bản",R.drawable.english));
        listMonHoc.add(new MonHoc("Toán","9:30","10:30","Trắc nghiệm thông thường ","Cơ bản",R.drawable.toan));
        //listMonHoc.add(new MonHoc("Java","15:30","16:30","Trắc nghiệm thông thường","Nâng cao",R.drawable.java));

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mon_hoc,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuHome:
//                Intent intentHome = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intentHome);
                break;
            case R.id.menuDatLich:
                Intent intentCart = new Intent(getApplicationContext(),DatLichActivity.class);
                startActivity(intentCart);
                break;
            case R.id.menuThongKe:
                Intent intentSearch = new Intent(getApplicationContext(),ThongKeActi.class);
                startActivity(intentSearch);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}
