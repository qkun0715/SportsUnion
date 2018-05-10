package com.fy.baselibrary.application;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import com.fy.baselibrary.widget.GlideImageLoader;
import com.kmwlyy.core.net.HttpClient;
import com.kmwlyy.core.net.HttpCode;
import com.kmwlyy.login.sdk.SdkApplication;
import com.lzy.ninegrid.NineGridView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 基础 application
 * Created by fangs on 2017/5/5.
 */
public class BaseApplication extends SdkApplication {

    private static BaseApplication mApplication; // 单例模式

    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "afb9b266b0", false);
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);

        mApplication = this;
//        设置activity 生命周期回调
        registerActivityLifecycleCallbacks(new BaseActivityLifecycleCallbacks());

//        bugly
        CrashReport.initCrashReport(getApplicationContext(), "b51864b95a", false);

        NineGridView.setImageLoader(new GlideImageLoader());

        HttpCode.setAppKey("JSKMEHospAndroid", "0123456789android#2016", "JSKMEHospAndroid@2016");
        HttpClient.setUrl(HttpClient.RELEASE);
//        HttpClient.setH5Url("https://tuser.kmwlyy.com:8060//h5/wuhan-student/"); 测试地址
        HttpClient.setH5Url("https://user.kmwlyy.com/h5/wuhan-student/"); //正式地址
    }

    /**
     * 单例模式，获取BTApplication的实例
     *
     * @return
     */
    public static BaseApplication getApplication() {
        return mApplication;
    }

    //    //设置 使用指定的 Header 和 Footer 全局设置
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {

                return new ClassicsHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context);
            }
        });
    }
}
