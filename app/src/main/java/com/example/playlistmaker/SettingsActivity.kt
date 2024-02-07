package com.example.playlistmaker

import android.os.Bundle
import com.google.android.material.button.MaterialButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val backButton = findViewById<MaterialButton>(R.id.back_button)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
