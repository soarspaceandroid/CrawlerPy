package com.yonglibao.android.net;

import com.yonglibao.android.mainscreen.home.WebUrlHelper;
import com.yonglibao.corelibrary.interfaces.EnvConfigInter;


/**
 * Created by GodXj on 2016/5/12.
 */
public class Config implements EnvConfigInter {

    public static String APIV = "/";
    public static String ONLINE_HOST;
    /**
     * 生成环境
     */
    public static String onLine = "https://app.yonglibao.com";//----> 6
    /**
     * 灰度环境
     */
    public static String huiDu = "http://121.42.195.42:9501";//----> 8
    /**
     * 测试环境
     */
    public static String test100 = "http://test100.yonglibao.com";//----> 13
    public static String test114 = "http://114.215.133.153:480";//----> 15
    public static String test134 = "http://test134.yonglibao.com";//----> 19
    public static String test139 = "http://139.129.230.57:9501";//----> 22
    public static String testdev = "https://devapi.yonglibao.com";//----> 23
    public static String testpre = "https://preapi.yonglibao.com";//----> 24
    public static String test240 = "https://api240.yonglibao.com";//----> 27
    public static String test103 = "https://api103.yonglibao.com";//----> 28
    public static String test13 = "https://api13.yonglibao.com";//----> 29
    public static String test17 = "https://api17.yonglibao.com";//----> 30
    public static String test163 = "https://api163.yonglibao.com";//----> 31
    public static String test57 = "https://api57.yonglibao.com";//----> 32
    public static String test117 = "https://api117.yonglibao.com";//----> 33


    public static String devlopIp = "http://118.190.99.217:8081";//----> 34
    public static String test31 = "http://api104.ylb.net"; //-----> 35

    public static String TemporaryOnLine = "http://106.15.72.225";//36

    public static String localDev = "http://192.168.10.200:81";//37

    public static String testCore121 = "https://pingan121.ylb.net"; // 38

    public static String testapi104 = "http://api73.ylb.net"; // 39
    public static String testapi40 = "http://api31.ylb.net"; // 40
//    public static String testapi104 = "https://gray-api.yonglibao.com"; // 39

    public static boolean isCloseBetaTest = false;
    public static boolean canChoiceEnv = false;
    public static final int DEFAULLT_ENV = 35;

    static {
        getURL(DEFAULLT_ENV);
    }

    /**
     * @param i 6代表生产环境，其他均为测试环境
     */
    public static void getURL(int i) {
        switch (i) {
            case 5: // 此处是从服务器获取请求ip
                ONLINE_HOST = DomainEnum.SERVICEIP.getUrl() + APIV;
                break;
            case 6:
                ONLINE_HOST = onLine + APIV;
                break;
            case 8:
                ONLINE_HOST = huiDu + APIV;
                break;
            case 13:
                ONLINE_HOST = test100 + APIV;
                break;

            case 15:
                ONLINE_HOST = test114 + APIV;
                break;
            case 19:
                ONLINE_HOST = test134 + APIV;
                break;
            case 20:
                ONLINE_HOST = test100 + APIV;
                break;
            case 22:
                ONLINE_HOST = test139 + APIV;
                break;
            case 23:
                ONLINE_HOST = testdev + APIV;
                break;
            case 24:
                isCloseBetaTest = true;
                ONLINE_HOST = testpre + APIV;
                break;
            case 27:
                ONLINE_HOST = test240 + APIV;
                break;
            case 28:
                ONLINE_HOST = test103 + APIV;
                break;
            case 29:
                ONLINE_HOST = test13 + APIV;
                break;
            case 30:
                ONLINE_HOST = test17 + APIV;
                break;
            case 31:
                ONLINE_HOST = test163 + APIV;
                break;
            case 32:
                ONLINE_HOST = test57 + APIV;
                break;
            case 33:
                ONLINE_HOST = test117 + APIV;
                break;
            case 34:
                ONLINE_HOST = devlopIp + APIV;
                break;
            case 35:
                ONLINE_HOST = test31 + APIV;
                break;
            case 36:
                ONLINE_HOST = TemporaryOnLine + APIV;
                break;
            case 37:
                ONLINE_HOST = localDev + APIV;
                break;
            case 38:
                ONLINE_HOST = testCore121 + APIV;
                break;
            case 39:
                ONLINE_HOST = testapi104 + APIV;
                break;
            case 40:
                ONLINE_HOST = testapi40 + APIV;
                break;
            default:
                break;
        }
    }

    public static String getHybridOnLineHost(String online_URL) {
        String hybridschemeurl = onLine;
        if (online_URL.startsWith(onLine))
            hybridschemeurl = "release";
        else if (online_URL.startsWith(testpre)) {
            hybridschemeurl = "gray";
        } else {
            hybridschemeurl = "test";
        }
        return hybridschemeurl;
    }


    public static String getCurrentHost() {
        if (ONLINE_HOST.contains(APIV)) {
            return ONLINE_HOST.replace(APIV, "");
        } else {
            return ONLINE_HOST;
        }
    }

    @Override
    public void resetDefaultEnv() {
        if (canChoiceEnv) {
            getURL(DEFAULLT_ENV);
            WebUrlHelper.getInstance().reset();
        }
    }


}
