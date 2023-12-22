package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*TABELA IMC
                menor que 18,5	Abaixo peso
        entre 18,5 e 24,9	 normal
        entre 25 e 29,9	sobrepeso
        entre 30 e 34,9	obesidade I
        entre 35 e 39,9	obesidade II
        maior que 40	obesidade GRAVE III*/

        var classificacao = if(result < 18.5f){
            "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f){
            "NORMAL"
        }else if (result in 25f..29.9f){
            "SOBREPESO"
        }else if (result in 30f..39.9f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE!"
        }
        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}