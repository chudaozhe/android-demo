package net.cuiwei.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TwoService extends Service {
    public TwoService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        long endtime = System.currentTimeMillis() + 20 * 1000;
        System.out.println("cwService start");
        while (System.currentTimeMillis()< endtime){
            synchronized (this){
                try {
                    wait(endtime - System.currentTimeMillis());
                }catch (Exception e){

                }
            }
        }
        System.out.println("cwService 执行完成");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
