package br.com.giovana.biscoitodasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_biscoito.*

class BiscoitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biscoito)

        val nome = intent.getStringExtra("INTENT_NOME")
        txvBiscoitoNome.text = "Olá, $nome!"




        var listaSorte = arrayListOf(
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

        listaSorte.shuffle()

        var sorteio = listaSorte[0]

        txvBiscoitoMensagem.text = sorteio




        btnBiscoitoSortear.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Atenção!")
                .setMessage("Você deseja sortear outro biscoito?")
                .setPositiveButton("Sim"){_,_->
                    if(listaSorte.size == 1){
                        txvBiscoitoBiscoito.text = "Você já sorteou todos biscoitos!"
                        txvBiscoitoMensagem.text = ""
                    } else {
                        listaSorte.removeAt(0)
                        listaSorte.shuffle()

                        var sorteio = listaSorte[0]

                        txvBiscoitoMensagem.text = sorteio
                    }

                }
                .setNeutralButton("Não"){_,_->}
                .setCancelable(false)
                .create()
                .show()

        }


        btnBiscoitoShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                val mensagem = txvBiscoitoMensagem.text
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Meu biscoito da sorte é:\n$mensagem")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


        btnBiscoitoVertodos.setOnClickListener {
            val mIntent = Intent(this, TodosActivity::class.java)
            mIntent.putExtra("INTENT_NOME", nome)
            startActivity(mIntent)
            finish()
        }


    }
}