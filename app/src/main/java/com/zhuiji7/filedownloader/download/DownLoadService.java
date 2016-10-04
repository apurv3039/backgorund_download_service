package com.zhuiji7.filedownloader.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import demo.adapter.ListAdapter;

/**
 * 类功能描述：下载器后台服务</br>
 *
 * @author zhuiji7  (470508081@qq.com)
 * @version 1.0
 * </p>
 */

public class DownLoadService extends Service {
    public static DownLoadManager  downLoadManager;
    public static ListAdapter adapter;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static DownLoadManager getDownLoadManager(){

        return downLoadManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        downLoadManager = new DownLoadManager(DownLoadService.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(downLoadManager == null){
            downLoadManager = new DownLoadManager(DownLoadService.this);
        }
    }
}
