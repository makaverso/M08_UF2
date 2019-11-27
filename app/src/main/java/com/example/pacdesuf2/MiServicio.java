package com.example.pacdesuf2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MiServicio extends Service {

    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.servicio), Toast.LENGTH_LONG);
        toast.show();

        if (player != null && player.isPlaying())
            player.stop();
        player = MediaPlayer.create(this, R.raw.musica);
        player.setLooping(false);
        player.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.servicioFin),Toast.LENGTH_LONG);
        if (player!=null){
            player.release();
            stopSelf();
        }
    }
}
