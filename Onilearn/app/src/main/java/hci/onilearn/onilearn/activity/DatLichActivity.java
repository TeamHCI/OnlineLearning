package hci.onilearn.onilearn.activity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
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
import java.util.Date;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.model.Subject;
import hci.onilearn.onilearn.model.Task;
import hci.onilearn.onilearn.receiver.AlarmReceiver;

public class DatLichActivity extends AppCompatActivity {
    final int REQUEST_CODE_SUBJECT = 123;
    private Subject subject;
    private Calendar taskTime;
    Toolbar toolbar;
    Spinner baoLaiSpinner, loaiThongBaoSpinner, amThanhThongBaoSpinner;
    String selectedBaoLai = "", selectedThongbao = "", selectedAmThanh = "";
    EditText edtGhiChu;
    TextView txtMonHoc, timeDatLich, dateDatLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_lich);

        reflect();
        actionBar();
        catchSpinner();
        chonNgay();
        chonGio();
        init();
    }

    private void init(){
        subject = MyData.subjects.get(2);
        txtMonHoc.setText(subject.getName());

        taskTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        timeDatLich.setText(simpleDateFormat.format(taskTime.getTime()));
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateDatLich.setText(simpleDateFormat.format(taskTime.getTime()));
    }

    private void chonGio() {
        timeDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog();
            }
        });
    }

    private void chonNgay() {
        dateDatLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog();
            }
        });
    }

    private void timePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR_OF_DAY);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                calendar.set(0, 0, 0, hourOfDay, minute);
                taskTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                taskTime.set(Calendar.MINUTE, minute);
                timeDatLich.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, gio, phut, true);
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
                calendar.set(year, month, dayOfMonth);
                taskTime.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateDatLich.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
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
                saveTask();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveTask() {
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("action", "on");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, taskTime.getTimeInMillis(), pendingIntent);
        Intent saveTaskIntent = new Intent();
        Date startTime = taskTime.getTime();
        taskTime.add(Calendar.HOUR_OF_DAY,1);
        Date endTime = taskTime.getTime();

        Task task = new Task(subject,startTime,endTime,true,"Multiple choice");

        saveTaskIntent.putExtra("task",task);
        setResult(RESULT_OK,saveTaskIntent);
        finish();

    }

    private void reflect() {
        toolbar = (Toolbar) findViewById(R.id.toolbardatlich);
        baoLaiSpinner = (Spinner) findViewById(R.id.spinnerthoigiabaolai);
        txtMonHoc = (TextView) findViewById(R.id.edtchonmonhocdatlich);
        edtGhiChu = (EditText) findViewById(R.id.edtghichudatlich);
        timeDatLich = (TextView) findViewById(R.id.timedatalich);
        dateDatLich = (TextView) findViewById(R.id.datedatalich);
        loaiThongBaoSpinner = (Spinner) findViewById(R.id.spinnerLoaiThongBao);
        amThanhThongBaoSpinner = (Spinner) findViewById(R.id.spinnerAmThanhThongBao);

    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    public void clickToChooseSubject(View view) {
        Intent intent = new Intent(this, SubjectChoiceActivity.class);
        intent.putExtra("type", "make a task");
        startActivityForResult(intent, REQUEST_CODE_SUBJECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_SUBJECT && resultCode == RESULT_OK && data != null) {
            subject = MyData.subjects.get(data.getIntExtra("SubjectId", 0));
            txtMonHoc.setText(subject.getName());
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
