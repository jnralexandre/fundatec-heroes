package br.org.fundatec.heroesapp

import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun Context.showSnackbarMessage(
    editText: EditText,
    @StringRes snackbarMessage: Int,
    @ColorRes colorBackgroud: Int,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(
        editText,
        snackbarMessage,
        duration,
    ).setBackgroundTint(ContextCompat.getColor(this, colorBackgroud)).show()
    editText.error = getString(snackbarMessage)
}
