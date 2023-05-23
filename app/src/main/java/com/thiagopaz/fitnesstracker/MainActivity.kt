package com.thiagopaz.fitnesstracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private lateinit var btnImc: LinearLayout
    private lateinit var  rvMain : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val  adapter = MainAdapter()
        rvMain = findViewById(R.id.rv_main)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager (this)



//        btnImc = findViewById(R.id.btn_imc)
//
//        btnImc.setOnClickListener {
//            //nav next screen
//            val i = Intent(this, ImcActivity::class.java)
//            startActivity(i)
//        }

    }

    private inner class MainAdapter: RecyclerView.Adapter <MainViewHolder>() {
        // Qual o XML da celula especifica
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
           val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return  MainViewHolder(view)

        }

        // quantidade de celulas  que terá na listagem
        override fun getItemCount(): Int {
           return 30
        }

        //disparo toda vez que houver uma rolagem na tela e for necessario conteudo da celula
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        }

    }

    private class MainViewHolder(view:View): RecyclerView.ViewHolder(view){

    }
}