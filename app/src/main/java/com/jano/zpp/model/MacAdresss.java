package com.jano.zpp.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/**
 * *       Created on 2017/7/3 , 七月.
 * * @@=@@@=@@  @@@
 * * @  @@@  @  @@@$@@@    -@@@@@   @@@@$@@@ @@@$    @@@@@    @@@@@$
 * *    @@@     @@@  @@$  @@@  @@@   @@@$#@@#;@@@   @@, @@@  @@@
 * *    @@@     @@@  @@@  @@@   @@@  @@@  @@@  @@        @@  @@@@@@!
 * *    @@@     @@@  @@@  @@@   @@@  @@@  @@=  @@   @@@@@@@   @@@@@@@
 * *    @@@     @@@  @@@  @@@   @@!  @@@  @@=  @@  @@@   @@       *@@
 * *   @@@@#   @@@@  @@@:  @@@@@@@  #@@@ ;@@@ =@@@  @@@@@@@@ *@@@@@@~
 * *       --by ThomasLiu
 **/

public class MacAdresss {

    public  String getMacAddress(Context context) {
        // 获取mac地址：
        String macAddress = "000000000000";
        try {
            WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = (null == wifiMgr ? null : wifiMgr
                    .getConnectionInfo());
            if (null != info) {
                if (!TextUtils.isEmpty(info.getMacAddress()))
                    macAddress = info.getMacAddress().replace(":", "");
                else
                    return macAddress;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return macAddress;
        }
        return macAddress;
    }
}
