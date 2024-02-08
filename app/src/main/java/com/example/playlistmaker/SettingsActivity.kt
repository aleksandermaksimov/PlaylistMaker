package com.example.playlistmaker
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.MaterialColors

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        window.statusBarColor = MaterialColors.getColor(
            findViewById<View>(android.R.id.content).rootView, R.attr.white_to_black
        )

        val backImage = findViewById<ImageView>(R.id.back_image)
        backImage.setOnClickListener {
            super.onBackPressedDispatcher.onBackPressed()
        }

        val shareImage = findViewById<ImageView>(R.id.share_image)
        shareImage.setOnClickListener {
            Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, getString(R.string.practicum_url))
                type = "text/plain"
                startActivity(Intent.createChooser(this, null))
            }
        }

        val supportImage = findViewById<ImageView>(R.id.support_image)
        supportImage.setOnClickListener {
            Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:" + getString(R.string.email_address))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_title_template))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body_template))
                startActivity(Intent.createChooser(this, null))
            }
        }

        val agreementImage = findViewById<ImageView>(R.id.agreement_image)
        agreementImage.setOnClickListener {
            Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(getString(R.string.license_agreement_url))
                startActivity(this)
            }
        }
    }
}
