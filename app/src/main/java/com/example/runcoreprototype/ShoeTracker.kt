package com.example.runcoreprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShoeTracker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoe_tracker)

        val displayShoeName = findViewById<TextView>(R.id.idDisplayShoeName)
        val displayShoeMileage = findViewById<TextView>(R.id.idDisplayShoeMileage)

        val enterShoeName = findViewById<TextView>(R.id.idEnterShoeName)
        val enterShoeMileage = findViewById<TextView>(R.id.idEnterShoeMileage)
        val buttonTrackerSave = findViewById<TextView>(R.id.idButtonShoeSave)
        buttonTrackerSave.setOnClickListener {
            val newName = enterShoeName.text.toString()
            val newMileage = enterShoeMileage.text.toString()

            displayShoeName.text = newName
            displayShoeMileage.text = newMileage
        }

        val buttonBack = findViewById<Button>(R.id.idButtonBack1)
        buttonBack.setOnClickListener {
            val screenWorkout = Intent(this, WorkoutScreen::class.java)
            screenWorkout.putExtra("runningShoe", "${displayShoeName.text}")
            startActivity(screenWorkout)
        }

    }
}
