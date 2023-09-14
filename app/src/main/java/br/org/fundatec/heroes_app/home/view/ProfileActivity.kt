package br.org.fundatec.heroes_app.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.org.fundatec.heroes_app.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

}