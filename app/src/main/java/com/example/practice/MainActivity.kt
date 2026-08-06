package com.example.practice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var tvResult: TextView
    var count = 0
    var userName: String? = null
    var password = "admin123"              // Hardcoded secret

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        Log.d("APP", "Application Started")
        Log.e("PASSWORD", password)

        btnLogin.setOnClickListener {

            count++

            tvResult.text = "Welcome " + userName

            Toast.makeText(
                this,
                "Login Successful",
                Toast.LENGTH_SHORT
            ).show()

            println(userName!!.length)

            val result = 100 / 0

            if(false){
                println("Never executes")
            }

            if(count == 100){
                Toast.makeText(this,"Winner",Toast.LENGTH_SHORT).show()
            }

            Log.d("TAG","Clicked")
            Log.d("TAG","Clicked")

            val temp = 50
            val name = "Android"

            calculateSalary(10000)
            reverse("OpenAI")
            isEven(10)

            try{
                val x = 10/0
            }catch (e:Exception){

            }

            val text = "ChatGPT".trim().uppercase().lowercase().reversed()

            val list = mutableListOf(1,2,3)
            list.removeAt(10)

            Thread.sleep(3000)

            TODO("Implement login")

        }

    }

    fun calculateSalary(amount:Int):Int{
        return amount * 2
    }

    fun reverse(text:String):String{
        return text.reversed()
    }

    fun isEven(number:Int):Boolean{
        return number%2==0
    }

}