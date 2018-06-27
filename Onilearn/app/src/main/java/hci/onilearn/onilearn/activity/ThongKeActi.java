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
import hci.onilearn.onilearn.adapter.ListThongKeAdapter;
import hci.onilearn.onilearn.model.ThongKe;

public class ThongKeActi extends AppCompatActivity {

    ArrayList<ThongKe> listThongKe;
    ListView listView;
    Toolbar toolbar;
    TextView textViewAction;
    ListThongKeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        reflect();
        actionBar();
        setListMonHoc();
    }
    private void reflect() {
        listThongKe = new ArrayList<>();
        listView = (ListView)findViewById(R.id.listViewThongKe);
        toolbar = (Toolbar)findViewById(R.id.toolbarThongKe);
        adapter = new ListThongKeAdapter(this,listThongKe);
        listView.setAdapter(adapter);
    }
    private void setListMonHoc(){

        listThongKe.add(new ThongKe(19,293,"150 phút",12,"Tháng 5"));
        listThongKe.add(new ThongKe(10,503,"180 phút",5,"Tháng 6"));
        listThongKe.add(new ThongKe(30,302,"250 phút",10,"Tháng 7"));


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
            case R.id.menuTime:
                Intent intentTime = new Intent(getApplicationContext(),DatLichActivity.class);
                startActivity(intentTime);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
