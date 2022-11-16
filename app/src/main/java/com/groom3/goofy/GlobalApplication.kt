package com.groom3.goofy

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    companion object {
        var instance: GlobalApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "8855edea7e857b1d74255151a86d8477")
    }
}