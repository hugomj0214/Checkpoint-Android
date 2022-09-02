package com.example.hugomartins_rm88422

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hugomartins_rm88422.databinding.ActivityMainBinding
import com.example.hugomartins_rm88422.model.ItemObject

class MainActivity : AppCompatActivity() {

    lateinit var dataBind: ActivityMainBinding
    val listItemAdapter = ListItemAdapter()
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBind.root)

        criaRecycler()

        dataBind.addItem.setOnClickListener(){
            listItemAdapter.AddListItem(ItemObject("valor auto$count", "Descrição conteudo gerado auto$count"))
            count++
        }

    }

    private fun criaRecycler() {
        dataBind.lista.layoutManager = LinearLayoutManager(this)

        val conteudo = mutableListOf<ItemObject>()

        conteudo.add(ItemObject("valor 1", "descrição do conteudo 1 "))
        conteudo.add(ItemObject("valor 2", "descrição do conteudo 2 "))
        conteudo.add(ItemObject("valor 3", "descrição do conteudo 3 "))
        conteudo.add(ItemObject("valor 4", "descrição do conteudo 4 "))

        listItemAdapter.setItensList(conteudo)

        dataBind.lista.adapter = listItemAdapter

    }
}