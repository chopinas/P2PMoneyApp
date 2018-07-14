package chopin.pzy.com.p2pmoney.common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;



public class MyApplication extends Application {
    public static Context mContext=null;
    public static Handler mHandler=null;
    public static Thread mainThread=null;
    public static int mainThreadId=0;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        mHandler=new Handler();
        mainThread= Thread.currentThread();
        mainThreadId=android.os.Process.myTid();
    }
}
