package com.minggliangg.flutter_native_sso

import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import io.flutter.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "ssoChannel"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            if (call.method == "startSSO") {
                Log.d("from Android", "MethodCalled")
                startNewActivity()
            } else {
                result.notImplemented()
            }
        }

        }
    private fun startNewActivity() {
        val intent = Intent(this, SSOActivity().javaClass)
        startActivity(intent)
//        flutterEngine.plugins.add(MyPlugin())
    }

}

