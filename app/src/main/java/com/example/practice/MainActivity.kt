package com.example.practice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    private val apiUrl = "http://api.example.com/register"
    private val apiKey = "123456789abcdef"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            Log.d("REGISTER", "Email : $email")
            Log.d("REGISTER", "Password : $password")

            if(email == ""){
                Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show()
            }

            if(password == ""){
                Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show()
            }

            if(email.contains("@")){
                Log.d("EMAIL","Valid")
            }else{
                Log.d("EMAIL","Invalid")
            }

            val result = 100 / 0

            val temp = "Testing"

            val number = 9999

            if(false){
                println("Never executed")
            }

            try{
                Thread.sleep(5000)
            }catch (e:Exception){

            }

            registerUser(email,password)

            registerUser(email,password)

            TODO("Implement API call")
        }
    }

    fun registerUser(email:String,password:String):Boolean{

        Log.d("API",apiUrl)

        val response = true

        return response
    }
}