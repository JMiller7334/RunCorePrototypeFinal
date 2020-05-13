package com.example.runcoreprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class WorkoutScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_screen)
        val savedShoes = intent.getStringExtra("runningShoe")
        val currentShoes = findViewById<TextView>(R.id.idCurrentShoes)
        if (savedShoes != null) {
            if (savedShoes != "") {
                currentShoes.text = ("Current shoes: $savedShoes")
            }
        }

        val buttonLogout = findViewById<Button>(R.id.idButtonLogout)
        buttonLogout.setOnClickListener {
            val screenLogin = Intent(this,MainActivity::class.java)
            startActivity(screenLogin) // connection
        }

        val buttonTracker = findViewById<Button>(R.id.idButtonShoeTracker)
        buttonTracker.setOnClickListener {
            val screenTracker = Intent(this, ShoeTracker::class.java)
            startActivity(screenTracker)
        }

        val buttonStartWorkout = findViewById<Button>(R.id.idButtonStartWorkout)
        buttonStartWorkout.setOnClickListener {
            Toast.makeText(applicationContext, "Workout will now start...", Toast.LENGTH_SHORT).show()
        }
    }
}
