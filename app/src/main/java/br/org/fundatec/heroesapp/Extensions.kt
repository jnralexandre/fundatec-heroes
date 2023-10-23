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
    if (snackbarMessage.equals(R.string.informe_nome_de_usuario)) {
        Snackbar.make(
            editText,
            R.string.informe_nome_de_usuario,
            duration,
        ).setBackgroundTint(ContextCompat.getColor(this, colorBackgroud)).show()
        editText.error = getString(snackbarMessage)
    } else if (snackbarMessage.equals(R.string.informe_e_mail)) {
        Snackbar.make(
            editText,
            R.string.informe_e_mail,
            duration,
        ).setBackgroundTint(ContextCompat.getColor(this, colorBackgroud)).show()
        editText.error = getString(snackbarMessage)
    } else if (snackbarMessage.equals(R.string.informe_senha)) {
        Snackbar.make(
            editText,
            R.string.informe_senha,
            duration,
        ).setBackgroundTint(ContextCompat.getColor(this, colorBackgroud)).show()
        editText.error = getString(snackbarMessage)
    }
}
