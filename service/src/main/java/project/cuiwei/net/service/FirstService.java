package project.cuiwei.net.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FirstService extends Service {
    public FirstService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void onCreate(){
        super.onCreate();
       System.out.println("cwService is Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("cwService is Started");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("cwService is Destroy");
    }
}
