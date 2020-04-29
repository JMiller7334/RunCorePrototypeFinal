package com.example.runcoreprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_workout_screen.*
import java.util.*

class MainActivity : AppCompatActivity() {

    enum class LoginStatus
        constructor(val intValue: Int){
        InvalidUsername(1),
        InvalidPassword(2),
        Success(0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterUsername = findViewById<TextView>(R.id.idEnterUsername)
        val enterPassword = findViewById<TextView>(R.id.idEnterPassword)
        val buttonLogin = findViewById<TextView>(R.id.idButtonLogin)

        buttonLogin.setOnClickListener {
            when (checkLogin(enterUsername.text.toString().toLowerCase(Locale.ENGLISH),enterPassword.text.toString())){
                LoginStatus.InvalidUsername ->{
                    Toast.makeText(applicationContext, "Invalid username", Toast.LENGTH_SHORT).show()
                    enterUsername.requestFocus()
                }
                LoginStatus.InvalidPassword ->{
                    Toast.makeText(applicationContext, "Invalid password", Toast.LENGTH_SHORT).show()
                    enterUsername.requestFocus()
                }
                else ->{
                    val screenWorkout = Intent(this,WorkoutScreen::class.java)
                    startActivity(screenWorkout) // connection
                }
            }
        }
    }

    fun checkLogin (attemptUsername: String, attemptPassword: String): LoginStatus{
        val storedUsername = "1"
        val storedPassword = "1"
        if (attemptUsername != storedUsername){
            return LoginStatus.InvalidUsername
        }
        return if (attemptPassword != storedPassword){
            return LoginStatus.InvalidPassword
        }else LoginStatus.Success
    }
}
