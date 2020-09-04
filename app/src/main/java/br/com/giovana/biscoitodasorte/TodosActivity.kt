package br.com.giovana.biscoitodasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import kotlinx.android.synthetic.main.activity_biscoito.*
import kotlinx.android.synthetic.main.activity_todos.*

class TodosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        val nome = intent.getStringExtra("INTENT_NOME")
        txvTodosNome.text = "$nome,\n aqui estão\ntodos os biscoitos!\n"

        val listaSorte = arrayListOf(
            "Tomara\n" + "Que a tristeza te convença\n" + "Que a saudade não compensa\n" + "- Vinícius de Moraes",
            "Não morre aquele\n" + "que deixou na terra\n" + "a melodia de seu cântico\n" + "na música de seus versos.\n" + "- Cora Coralina",
            "Que pode uma\n" + "criatura senão,\n" + "entre criaturas,\n" + "amar?\n" + "- Carlos Drummond de Andrade",
            "Deixa o teu corpo\n" + "entender-se com outro corpo.\n" + "Porque os corpos se entendem,\n" + "mas as almas não.\n" + "- Manuel Bandeira",
            "Ver nossas vidas\n" + "quais dois mansos rios,\n" + "Juntos, juntos\n" + "perderem-se no oceano,\n" + "- Castro Alves",
            "Mesmo sem querer fala em verso\n" + "Quem fala a partir da emoção\n" + "- João Cabral de Melo Neto",
            "Lúcidos? São poucos.\n" + "Mas se farão milhares\n" + "Se à lucidez dos poucos\n" + "Te juntares.\n" + "- Hilda Hilst",
            "não discuto\n" + "com o destino\n" + "o que pintar\n" + "eu assino\n" + "- Paulo Leminski",
            "Todos esses que aí estão\n" + "Atravancando meu caminho,\n" + "Eles passarão...\n" + "Eu passarinho!\n" + "- Mario Quintana",
            "Aprendi com as primaveras\n" + "a deixar-me cortar\n" + "e a voltar sempre inteira.\n" + "- Cecília Meireles")

        for (element in listaSorte) {
            txvTodosBiscoito.text = txvTodosBiscoito.text.toString() + element + "\n\n"
        }



        btnTodosVoltar.setOnClickListener {
            val mIntent = Intent(this, BiscoitoActivity::class.java)
            mIntent.putExtra("INTENT_NOME", nome)
            startActivity(mIntent)
            finish()
        }

    }
}