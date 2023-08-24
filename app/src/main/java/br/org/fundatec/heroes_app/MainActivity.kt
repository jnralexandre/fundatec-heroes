package br.org.fundatec.heroes_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = Test(
            label1 = "Usuário",
            label2 = null,
        )

        if (test.label2 != null) {
            executaAcao1(value1 = test.label1, value2 = test.label2)
        }
        
        test.label2?.let {
            executaAcao1(value1 = test.label1, value2 = it)
        }

        test.label2.let {
            executaAcao1(value1 = it.label1, value2 = it.label2)
        }
    }

    private fun executaAcao1(value1: String, value2: String) {}

    private fun executaAcao2(value1: String, value2: String?) {}

}

data class Test(
    val label1: String,
    val label2: String?,
)