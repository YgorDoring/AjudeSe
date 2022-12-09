package dev.ygordoring.ajude_se.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         //Visit the official folder at: https://github.com/YgorDoring/AjudeSe

data class MainItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val textStringId: Int,
)
