package com.example.practice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - asdfghjkl Test Activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvText = findViewById<TextView>(R.id.tvText)
        tvText.text = getString(R.string.asdfghjkl_label)
    }
}
