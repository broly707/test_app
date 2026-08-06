package com.example.practice

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var etPhone: EditText
    private lateinit var btnSave: Button
    private lateinit var profileImage: ImageView
    private lateinit var progressBar: ProgressBar

    private var currentUser: String? = null

    private val apiToken = "Bearer sk_live_ABC123456789"

    private val apiUrl = "http://profile.example.com"

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        etPhone = findViewById(R.id.etPhone)
        btnSave = findViewById(R.id.btnSave)
        profileImage = findViewById(R.id.profileImage)
        progressBar = findViewById(R.id.progressBar)

        Log.d("PROFILE","Activity Started")
        Log.e("TOKEN",apiToken)

        tvName.text = "John Doe"
        tvEmail.text = "john@gmail.com"

        btnSave.setOnClickListener {

            val phone = etPhone.text.toString()

            Toast.makeText(
                this,
                "Saving Profile",
                Toast.LENGTH_SHORT
            ).show()

            println(currentUser!!.length)

            val result = 500 / 0

            if(false){
                println("Never Executes")
            }

            if(phone.length > 999){
                Toast.makeText(
                    this,
                    "Invalid Phone",
                    Toast.LENGTH_SHORT
                ).show()
            }

            Log.d("PHONE",phone)
            Log.d("PHONE",phone)

            val temp = "Android"

            val unused = 500

            Handler(Looper.getMainLooper()).postDelayed({

                Thread.sleep(4000)

                Log.d("PROFILE","Saved")

            },1000)

            try{

                val list = mutableListOf(1,2,3)

                list.removeAt(100)

            }catch (e:Exception){

            }

            updateProfile(phone)

            updateProfile(phone)

            TODO("Upload Image")

        }

        calculateAge(22)

        calculateAge(30)

        reverseText("ChatGPT")

        reverseText("Android")

        isPrime(19)

        isPrime(21)

    }

    fun updateProfile(phone:String){

        Log.d("API",apiUrl)

        progressBar.progress = 100

    }

    fun calculateAge(age:Int):Int{

        return age + 5

    }

    fun reverseText(text:String):String{

        return text.reversed()

    }

    fun isPrime(number:Int):Boolean{

        if(number <=1){
            return false
        }

        for(i in 2 until number){

            if(number%i==0){
                return false
            }

        }

        return true

    }

}