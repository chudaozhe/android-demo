package project.cuiwei.net.service;

import android.app.IntentService;
import android.content.Intent;

public class FirstIntentService extends IntentService {

    public FirstIntentService() {
        super("FirstIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long endtime = System.currentTimeMillis() + 5 * 1000;
        System.out.println("cwService22 start");
        while (System.currentTimeMillis()< endtime){
            synchronized (this){
                try {
                    wait(endtime - System.currentTimeMillis());
                }catch (Exception e){

                }
            }
        }
        //发送广播
        Intent i2 = new Intent();
        i2.setAction("android.intent.action.CW_NOTIFY");
        i2.putExtra("msg", "cwService22 执行完成");
        sendBroadcast(i2);
//        System.out.println("cwService22 执行完成");

    }

}
