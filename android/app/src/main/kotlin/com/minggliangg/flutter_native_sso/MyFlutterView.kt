package com.minggliangg.flutter_native_sso

import android.content.Context
import android.view.View
import android.widget.TextView
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.platform.PlatformView
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

class MyFlutterView(context: Context, messenger: BinaryMessenger, viewId: Int, args: Map<String, Any>?) : PlatformView {

    private val textView: TextView = TextView(context)

    init {
        textView.text = "I am Android View"
    }

    override fun getView(): View {

        return textView
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }
}