package com.minggliangg.flutter_native_sso

import android.content.Context
import android.view.View
import android.widget.TextView
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.platform.PlatformView
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import io.flutter.Log
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class MyFlutterView(context: Context, messenger: BinaryMessenger, viewId: Int, args: Map<String, Any>?) : PlatformView,
    MethodChannel.MethodCallHandler {

    private val textView: TextView = TextView(context)
    private var methodChannel: MethodChannel

    init {
        textView.text = "I am Android View"
        methodChannel = MethodChannel(messenger, "ssoChannel")
        methodChannel.setMethodCallHandler(this)
    }

    override fun getView(): View {

        return textView
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        if (call.method == "startSSO") {
           Log.d("from Android", "MethodCalled")
        } else {
            result.notImplemented()
        }
    }

}