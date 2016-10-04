package com.zhuiji7.filedownloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.zhuiji7.filedownloader.download.DownLoadManager;
import com.zhuiji7.filedownloader.download.DownLoadService;

import demo.adapter.ListAdapter;

public class ListActivity extends AppCompatActivity {
    private ListAdapter adapter;

    /*使用DownLoadManager时只能通过DownLoadService.getDownLoadManager()的方式来获取下载管理器，不能通过new DownLoadManager()的方式创建下载管理器*/
    private DownLoadManager manager;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listview = (ListView)this.findViewById(R.id.listView);
        listview.setAdapter(DownLoadService.adapter);
    }


}
