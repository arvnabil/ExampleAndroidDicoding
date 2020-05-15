package com.instechrx.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MoveActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_back -> {
                val backIntent = Intent(this@MoveActivity, MyIntentApp::class.java)
                startActivity(backIntent)
            }
        }
    }

}
