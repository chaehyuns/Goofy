package com.groom3.goofy.onboard

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

public class GlobalApplication : Application() {
    public var applicationGrade : Int = 0
    companion object {
        var instance: GlobalApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "8855edea7e857b1d74255151a86d8477")
    }
}