package com.zura.midtermtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        findViewById<Button>(R.id.btn).setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", "zura")
            startActivity(intent)

            // finish()
        })
    }
}