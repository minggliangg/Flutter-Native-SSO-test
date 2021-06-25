package com.minggliangg.flutter_native_sso

import android.content.Context
import android.view.View

import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.platform.PlatformView
import io.flutter.Log
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import  com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import java.util.*

class MyFlutterView(context: Context, messenger: BinaryMessenger, viewId: Int, args: Map<String, Any>?) : PlatformView,
    MethodChannel.MethodCallHandler {

    private var methodChannel: MethodChannel = MethodChannel(messenger, "ssoChannel")
    private var loginButton: LoginButton
    private var callbackManager: CallbackManager

    init {
        methodChannel.setMethodCallHandler(this)
        loginButton = LoginButton(context)
        callbackManager = CallbackManager.Factory.create()
        // loginButton.setPermissions(listOf("user_gender, user_friends"))
        loginButton.registerCallback(callbackManager,object: FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                Log.d("from Facebook Button", "Success")
            }

            override fun onCancel() {
                Log.d("from Facebook Button", "Cancel")
            }

            override fun onError(error: FacebookException?) {
                Log.d("from Facebook Button", "Error")
            }

        })
    }

    override fun getView(): View {
        return loginButton
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