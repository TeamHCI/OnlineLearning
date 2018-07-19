package hci.onilearn.onilearn.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import hci.onilearn.onilearn.activity.AlarmActivity;
import hci.onilearn.onilearn.model.MyData;
import hci.onilearn.onilearn.service.RingToneService;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String actionStr = intent.getStringExtra("action");
        Intent musicIntent = new Intent(context, RingToneService.class);
        musicIntent.putExtra("action", actionStr);
        context.startService(musicIntent);
        if (actionStr.equals("on")) {
            Intent alarmIntent = new Intent(context, AlarmActivity.class);
            alarmIntent.putExtra("SubjectId", intent.getIntExtra("SubjectId", 0));
            alarmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(alarmIntent);
        }
    }
}
