package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<LinearLayout>(R.id.first_button)
        val button2 = findViewById<LinearLayout>(R.id.second_button)
        val button3 = findViewById<LinearLayout>(R.id.third_button)
        //анонимный
        button1.setOnClickListener{
            val intent = Intent(this, ActivitySearch::class.java)
            startActivity(intent)
        }
        //лямбда
        button2.setOnClickListener {
            val intent = Intent(this, ActivityMedia::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}