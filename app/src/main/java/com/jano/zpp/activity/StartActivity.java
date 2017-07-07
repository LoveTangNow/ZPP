package com.jano.zpp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import com.amap.api.maps.AMap;
//import com.amap.api.maps.MapView;
import com.jano.zpp.R;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


//        MapView mapView = (MapView) findViewById(R.id.map);
//        mapView.onCreate(savedInstanceState);// 此方法必须重写
//        AMap aMap = mapView.getMap();
    }
}
