package hci.onilearn.onilearn.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import hci.onilearn.onilearn.R;

public class DatLichActivity extends AppCompatActivity {

    Toolbar toolbar;
    Spinner baoLaiSpinner,loaiThongBaoSpinner,amThanhThongBaoSpinner;
    String selectedBaoLai = "",selectedThongbao="",selectedAmThanh="";
    EditText edtMonHoc, edtGhiChu;
    TextView timeDatLich, dateDatLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich);

        reflect();
        actionBar();
        catchSpinner();
        chonNgay();
        chonGio();
    }
    private void chonGio() {
        timeDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog();
            }
        });
    }

    private void chonNgay(){
        dateDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog();
            }
        });
    }

    private void timePickerDialog(){
        final Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR_OF_DAY);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0,hourOfDay,minute);
                timeDatLich.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },gio,phut,true);
        timePickerDialog.show();
    }
    private void datePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateDatLich.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_luu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLuu:
                //Intent intentHome = new Intent(getApplicationContext(),DatLichActivity.class);
                //startActivity(intentHome);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbardatlich);
        baoLaiSpinner = (Spinner) findViewById(R.id.spinnerthoigiabaolai);
        edtMonHoc = (EditText) findViewById(R.id.edtchonmonhocdatlich);
        edtGhiChu = (EditText) findViewById(R.id.edtghichudatlich);
        timeDatLich = (TextView) findViewById(R.id.timedatalich);
        dateDatLich = (TextView) findViewById(R.id.datedatalich);
        loaiThongBaoSpinner = (Spinner) findViewById(R.id.spinnerLoaiThongBao);
        amThanhThongBaoSpinner = (Spinner) findViewById(R.id.spinnerAmThanhThongBao);

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

    private void catchSpinner() {
        ArrayList<String> listBaoLai = new ArrayList<>();
        listBaoLai.add("10 phút");
        listBaoLai.add("20 phút");
        listBaoLai.add("30 phút");
        listBaoLai.add("40 phút");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listBaoLai);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        baoLaiSpinner.setAdapter(arrayAdapter1);
        baoLaiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBaoLai = parent.getItemAtPosition(position).toString();
                Log.e("SELECTED ", selectedBaoLai);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> listThongBao = new ArrayList<>();
        listThongBao.add("Âm Thanh & rung");
        listThongBao.add("Chỉ âm thanh");
        listThongBao.add("Chỉ rung");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listThongBao);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loaiThongBaoSpinner.setAdapter(arrayAdapter2);
        loaiThongBaoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedThongbao = parent.getItemAtPosition(position).toString();
                Log.e("SELECTED ", selectedThongbao);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> listAmThanh = new ArrayList<>();
        listAmThanh.add("Mặc định");
        listAmThanh.add("Alarm");
        listAmThanh.add("Barium");
        listAmThanh.add("Buzzer Alarm");
        listAmThanh.add("Carbon");
        listAmThanh.add("Platinum");
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listAmThanh);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        amThanhThongBaoSpinner.setAdapter(arrayAdapter3);
        amThanhThongBaoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedAmThanh = parent.getItemAtPosition(position).toString();
                Log.e("SELECTED ", selectedAmThanh);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}
