package com.jano.zpp.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jano.zpp.R;
import com.jano.zpp.model.MacAdresss;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NotificationManager myManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.Main_button1);
        Button button2 = (Button) findViewById(R.id.Main_button2);
        Button button3 = (Button) findViewById(R.id.Main_button3);
        Button button4 = (Button) findViewById(R.id.Main_button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        myManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Main_button1:
                //3.定义一个PendingIntent，点击Notification后启动一个Activity
                showNotification(1);
                break;
            case R.id.Main_button2:
                showNotification(2);
                break;
            case R.id.Main_button3:
                showNotification(3);
                break;
            case R.id.Main_button4:
                showNotification(4);
                break;
            default:break;
        }
    }

    private  void showNotification(int id){
        PendingIntent pi = PendingIntent.getActivity(
                MainActivity.this,
                100,
                new Intent(MainActivity.this, StartActivity.class),
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        //2.通过Notification.Builder来创建通知
        Notification.Builder myBuilder = new Notification.Builder(MainActivity.this);

        myBuilder.setContentTitle("QQ" + id)
                .setContentText("这是内容")
                .setSubText("这是补充小行内容")
                .setTicker("您收到新的消息")
                //设置状态栏中的小图片，尺寸一般建议在24×24，这个图片同样也是在下拉状态栏中所显示
                .setSmallIcon(R.mipmap.ic_launcher)
                //设置默认声音和震动
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)//点击后取消
                .setWhen(System.currentTimeMillis())//设置通知时间
                .setPriority(Notification.PRIORITY_HIGH)//高优先级
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                //android5.0加入了一种新的模式Notification的显示等级，共有三种：
                //VISIBILITY_PUBLIC  只有在没有锁屏时会显示通知
                //VISIBILITY_PRIVATE 任何情况都会显示通知
                //VISIBILITY_SECRET  在安全锁和没有锁屏的情况下显示通知
                .setContentIntent(pi);//3.关联PendingIntent
        Notification myNotification = myBuilder.build();
        //4.通过通知管理器来发起通知，ID区分通知
        myManager.notify(id, myNotification);

        TelephonyManager TelephonyMgr = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        String szImei = TelephonyMgr.getDeviceId();

        Toast.makeText(this, szImei, Toast.LENGTH_SHORT).show();
    }
}
