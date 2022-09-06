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

    }

    private fun criaRecycler() {
        dataBind.rvList.layoutManager = LinearLayoutManager(this)

        val conteudo = mutableListOf<ItemObject>()

        conteudo.add(ItemObject("Aneis do Poder", "Aventura", true))
        conteudo.add(ItemObject("Stranger Things", "Suspense", true))
        conteudo.add(ItemObject("Avatar: A lenda de Aang", "Aventura", true))
        conteudo.add(ItemObject("Mandalorian", "Ação", true))

        listItemAdapter.setItensList(conteudo)

        dataBind.rvList.adapter = listItemAdapter

    }
}