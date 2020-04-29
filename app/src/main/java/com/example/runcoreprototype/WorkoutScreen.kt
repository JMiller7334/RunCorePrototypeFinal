package com.example.runcoreprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WorkoutScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_screen)

        val buttonLogout = findViewById<Button>(R.id.idButtonLogout)
        buttonLogout.setOnClickListener {
            val screenLogin = Intent(this,MainActivity::class.java)
            startActivity(screenLogin) // connection
        }
    }
}
