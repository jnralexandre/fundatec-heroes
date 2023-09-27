package br.org.fundatec.heroesapp.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroesapp.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

}