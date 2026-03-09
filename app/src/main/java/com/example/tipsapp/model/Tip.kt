package com.example.tipsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val dayNumber: Int,
    @StringRes val titleRes: Int,
    @StringRes val shortDescRes: Int,
    @StringRes val longDescRes: Int,
    @DrawableRes val imageRes: Int
)