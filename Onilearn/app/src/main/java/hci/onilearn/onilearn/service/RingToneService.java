package hci.onilearn.onilearn.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import hci.onilearn.onilearn.R;

public class RingToneService extends Service {
    private MediaPlayer mediaPlayer;
    private boolean isPlay;

    public RingToneService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String actionStr = intent.getStringExtra("action");
        if (actionStr.equals("on")) {
            isPlay = true;
        } else if (actionStr.equals("off")) {
            isPlay = false;
        }

        if (isPlay){
            mediaPlayer = MediaPlayer.create(this, R.raw.eruku_samurai);
            mediaPlayer.start();
            isPlay = false;
        } else if (!isPlay) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
