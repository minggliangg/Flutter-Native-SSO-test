package com.minggliangg.flutter_native_sso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.*

import com.facebook.login.widget.LoginButton
import com.facebook.login.LoginResult
import io.flutter.Log

class SSOActivity : AppCompatActivity() {

    private lateinit var callbackManager: CallbackManager
    private lateinit var loginButton: LoginButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_s_s_o)
        loginButton = findViewById(R.id.login_button)
        callbackManager = CallbackManager.Factory.create()
        loginButton.setPermissions(listOf("email"))
        loginButton.registerCallback(callbackManager,object: FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                Log.d("from Facebook Button", "Success")
            }

            override fun onCancel() {
                Log.d("from Facebook Button", "Cancel")
            }

            override fun onError(error: FacebookException?) {
                Log.d("from Facebook Button", "error: $error")
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode,resultCode,data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}