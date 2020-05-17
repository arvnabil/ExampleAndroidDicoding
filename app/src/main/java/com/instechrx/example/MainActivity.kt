package com.instechrx.example

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var editLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var btnNext: Button
    private lateinit var tvResult: TextView
    private lateinit var btnExList: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editWidth =  findViewById(R.id.edit_width)
        editHeight = findViewById(R.id.edit_height)
        editLength = findViewById(R.id.edit_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnNext = findViewById(R.id.btn_next)
        btnExList = findViewById(R.id.btn_ex_list)

        btnCalculate.setOnClickListener(this)

        btnNext.setOnClickListener(this)
        btnExList.setOnClickListener(this)

        if(savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_calculate -> {
                val inputLength = editLength.text.toString().trim()
                val inputWidth = editWidth.text.toString().trim()
                val inputHeight  = editHeight.text.toString().trim()

                var isEmptyFields = false

                if (inputLength.isEmpty()){
                    isEmptyFields = true
                    editLength.error = "Field ini tidak boleh kosong"
                }

                if (inputWidth.isEmpty()) {
                    isEmptyFields = true
                    editWidth.error = "Field ini tidak boleh kosong"
                }
                if (inputHeight.isEmpty()) {
                    isEmptyFields = true
                    editHeight.error = "Field ini tidak boleh kosong"
                }

                if (!isEmptyFields) {
                    val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    tvResult.text = volume.toString()
                }
            }
            R.id.btn_next -> {
                val moveIntent = Intent(this@MainActivity, MyIntentApp::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_ex_list -> {
                val moveIntent = Intent(this@MainActivity, MyListView::class.java)
                startActivity(moveIntent)
            }
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

}
