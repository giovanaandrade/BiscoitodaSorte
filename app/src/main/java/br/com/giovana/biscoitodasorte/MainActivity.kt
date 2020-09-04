package br.com.giovana.biscoitodasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnMainSortear.setOnClickListener {
            val nome = edtMainNome.text.toString().trim()

            if (nome.isEmpty()) {
                edtMainNome.error = "Campo Obrigatório"
                edtMainNome.requestFocus()
            } else {
                Toast.makeText(this, "Bem-vindo(a)!", Toast.LENGTH_SHORT).show()
                    val mIntent = Intent(this, BiscoitoActivity::class.java)
                    mIntent.putExtra("INTENT_NOME", nome)
                            startActivity(mIntent)
                        finish()

                }
            }
        }

    }
