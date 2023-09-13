package br.org.fundatec.heroes_app.home.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.org.fundatec.heroes_app.R;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarHomeActivity();
            }
        }, 3000);
    }

    private void mostrarHomeActivity() {
        Intent intent = new Intent(
                SplashActivity.this, HomeActivity.class
        );
        startActivity(intent);
        finish();
    }
}
