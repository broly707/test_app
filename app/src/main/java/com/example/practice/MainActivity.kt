package com.example.practice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - Empty Description PR Test Activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvEmptyDesc = findViewById<TextView>(R.id.tvEmptyDesc)
        tvEmptyDesc.text = getString(R.string.empty_desc_label)
    }
}
