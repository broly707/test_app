package com.example.practice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var tvCounter: TextView
    var count = 0
    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvCounter = findViewById(R.id.tvCounter)

        val btnIncrement = findViewById<Button>(R.id.btnIncrement)
        val btnDecrement = findViewById<Button>(R.id.btnDecrement)

        Log.d("DEBUG", "Application Started")
        Log.e("ERROR", "This is just a test error")

        btnIncrement.setOnClickListener {

            count++

            tvCounter.text = count.toString()

            Toast.makeText(
                this,
                "Incremented",
                Toast.LENGTH_SHORT
            ).show()

            Log.d("Counter", count.toString())

            val result = addNumbers(10,20)
        }

        btnDecrement.setOnClickListener {

            count--

            tvCounter.text = count.toString()

            Toast.makeText(
                this,
                "Decremented",
                Toast.LENGTH_SHORT
            ).show()

            Log.d("Counter", count.toString())
        }

        // Unsafe null assertion
        println(userName!!.length)

        // Division by zero
        val x = 10 / 0

        // Dead code
        if (false) {
            println("Never Executes")
        }

        // Duplicate code
        Log.d("TAG","Duplicate")
        Log.d("TAG","Duplicate")

        // Unused variables
        val temp = 100
        val temp2 = "Hello"

        // Magic numbers
        if(count > 999){
            Toast.makeText(this,"Large Count",Toast.LENGTH_SHORT).show()
        }

        // Empty catch block
        try{
            val y = 10 / 0
        }catch (e:Exception){

        }

        // Hardcoded string
        tvCounter.text = "Counter Value"

        // Long method chain
        val text = "ChatGPT".trim().uppercase().lowercase().reversed()

        // Unused method calls
        addNumbers(4,5)
        subtractNumbers(8,2)
        reverseText("Android")
        isEven(6)
        isOdd(7)

    }

    fun addNumbers(a:Int,b:Int):Int{
        return a+b
    }

    fun subtractNumbers(a:Int,b:Int):Int{
        return a-b
    }

    fun reverseText(text:String):String{
        return text.reversed()
    }

    fun isEven(number:Int):Boolean{
        return number%2==0
    }

    fun isOdd(number:Int):Boolean{
        return number%2!=0
    }

}