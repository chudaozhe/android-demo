package net.cuiwei.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BindService extends Service {

    private int count;
    private boolean quit;
    private MyBinder binder = new MyBinder();
    public BindService() {
    }
    public class MyBinder extends Binder
    {
        public int getCount(){
            return count;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("cwService isbind Binded");
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("cwService isbind Created");
        new Thread()
        {
            @Override
            public void run() {
                while (!quit)
                {
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                    count ++;
                }
            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("cwService isbind onUnbind");
        return true;
//        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        System.out.println("cwService isbind onDestroy");
    }
}
