package hci.onilearn.onilearn.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

import hci.onilearn.onilearn.R;
import hci.onilearn.onilearn.receiver.AlarmReceiver;

public class AlarmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        final Calendar cal = Calendar.getInstance();
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        TextView txtTime = (TextView) findViewById(R.id.txtTime);
        String strHour = (hourOfDay > 9)? (hourOfDay + "") : ("0" + hourOfDay);
        String strMinute = (minute > 9)? (minute + "") : ("0" + minute);
        txtTime.setText(strHour + ":" + strMinute);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBarSwipe);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                if (progress < 80 && progress > 20) {
                    seekBar.setProgress(50);
                } else if (progress <= 20) {
                    seekBar.setProgress(5);
                    skipTask(seekBar.getRootView());
                } else if (progress >= 80) {
                    seekBar.setProgress(95);
                    doTask(seekBar.getRootView());
                }
            }
        });
    }

//    public void clickToStopAlarm(View view) {
//        stopAlarm(view);
//        finish();
//    }

    public void skipTask(View view) {
        stopAlarm(view);
        finish();
    }

    public void doTask(View view) {
        stopAlarm(view);
        finish();
    }

    public void stopAlarm(View view) {
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        intent.putExtra("action", "off");
        sendBroadcast(intent);
    }


}
