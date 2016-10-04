package demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;

import com.zhuiji7.filedownloader.ListActivity;
import com.zhuiji7.filedownloader.R;
import com.zhuiji7.filedownloader.download.DownLoadService;
import com.zhuiji7.filedownloader.download.TaskInfo;

import demo.adapter.ListAdapter;


public class MainActivity extends Activity {
    private Button addbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        //下载管理器需要启动一个Service,在刚启动应用的时候需要等Service启动起来后才能获取下载管理器，所以稍微延时获取下载管理器
        handler.sendEmptyMessageDelayed(1, 50);

        addbutton = (Button)this.findViewById(R.id.button);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
    public void loadData(){
        DownLoadService.downLoadManager = DownLoadService.getDownLoadManager();
        DownLoadService.downLoadManager.setSupportBreakpoint(true);
        DownLoadService.adapter = new ListAdapter(MainActivity.this,DownLoadService.downLoadManager);
        TaskInfo info = new TaskInfo();
        String date = (DateFormat.format("dd-MM-yyyy hh:mm:ss", new java.util.Date()).toString());
        info.setFileName(date);
        info.setTaskID(date);
        info.setOnDownloading(true);
        DownLoadService.downLoadManager.addTask(date, "https://player.vimeo.com/play/438248049?s=145240480_2938002578_4c7feba6aa93eee2ba8c54c69a113abf&loc=external&context=Vimeo%5CController%5CApi%5CResources%5CUser%5CVideoController.&download=1&filename=Untitled116.mp4", date);
        DownLoadService.adapter.addItem(info);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            loadData();
        }
    };

}
