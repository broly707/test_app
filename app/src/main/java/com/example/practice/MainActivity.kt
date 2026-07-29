package com.example.practice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - Empty PR Description Verification
 * // asdfghjkl comment update
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)
        tvInfo.text = getString(R.string.info_text)
    }
}
