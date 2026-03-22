package com.example.tipsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val day = intent.getIntExtra("DAY", 0)
        val titleRes = intent.getIntExtra("TITLE", 0)
        val descRes = intent.getIntExtra("DESC", 0)
        val imageRes = intent.getIntExtra("IMAGE", 0)

        findViewById<TextView>(R.id.tvDetailTitle).text = getString(R.string.day_label, day) + ": " + getString(titleRes)
        findViewById<TextView>(R.id.tvDetailDesc).setText(descRes)
        findViewById<ImageView>(R.id.ivDetailImage).setImageResource(imageRes)
    }
}