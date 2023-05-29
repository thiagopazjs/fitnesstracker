package com.thiagopaz.fitnesstracker


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_directions_run_24,
                textStringId = R.string.imc,
                color = Color.GREEN
            )
        )
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_directions_run_24,
                textStringId = R.string.tmb,
                color = Color.GREEN
            )
        )


        val adapter = MainAdapter(mainItems)
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

    }

    private inner class MainAdapter(private val mainItems: List<MainItem>) :
        RecyclerView.Adapter<MainViewHolder>() {
        // Qual o XML da celula especifica
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)

        }

        // quantidade de celulas  que terá na listagem
        override fun getItemCount(): Int {
            return mainItems.size
        }

        //disparo toda vez que houver uma rolagem na tela e for necessario conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val itemCurrent = mainItems[position]
            holder.bind(itemCurrent)

        }

    }

    private class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MainItem) {
            val buttonTest: Button = itemView.findViewById(R.id.btn_item)
            buttonTest.setText(item.textStringId)
        }
    }
}