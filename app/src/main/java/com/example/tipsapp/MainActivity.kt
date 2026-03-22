package com.example.tipsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tipsapp.adapter.TipAdapter
import com.example.tipsapp.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tipsData = Datasource(this).loadTips()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TipAdapter(tipsData) { tip ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("DAY", tip.dayNumber)
                putExtra("TITLE", tip.titleRes)
                putExtra("DESC", tip.longDescRes)
                putExtra("IMAGE", tip.imageRes)
            }
            startActivity(intent)
        }
    }
}