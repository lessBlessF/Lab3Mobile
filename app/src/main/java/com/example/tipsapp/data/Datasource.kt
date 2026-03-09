package com.example.tipsapp.data

import com.example.tipsapp.R
import com.example.tipsapp.model.Tip

class Datasource(private val context: android.content.Context) {

    fun loadTips(): List<Tip> {
        val tips = mutableListOf<Tip>()
        val packageName = context.packageName
        val res = context.resources

        for (i in 1..30) {
            val titleRes = res.getIdentifier("title_$i", "string", packageName)

            val shortDescRes = res.getIdentifier("short_desc_$i", "string", packageName)

            val longDescRes = res.getIdentifier("long_desc_$i", "string", packageName)

            val imageRes = res.getIdentifier("d$i", "drawable", packageName)

            if (titleRes != 0 && imageRes != 0) {
                tips.add(
                    Tip(
                        dayNumber = i,
                        titleRes = titleRes,
                        shortDescRes = shortDescRes,
                        longDescRes = longDescRes,
                        imageRes = imageRes
                    )
                )
            }
        }
        return tips
    }
}