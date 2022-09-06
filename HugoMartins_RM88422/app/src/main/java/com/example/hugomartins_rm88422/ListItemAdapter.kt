package com.example.hugomartins_rm88422

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hugomartins_rm88422.databinding.ItemCellBinding
import com.example.hugomartins_rm88422.model.ItemObject

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ItemHolder>() {
    private val items: MutableList<ItemObject> = mutableListOf()

    class ItemHolder(val itemCell: ItemCellBinding) : RecyclerView.ViewHolder(itemCell.root) {
        fun bind(itemObject: ItemObject) {
            itemCell.tvSerie.text = itemObject.nome
            itemCell.tvGenero.text = itemObject.genero
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(items[position])
        holder.itemCell.btnRemove.setOnClickListener(){
            removeListItem(items[position])
        }
    }

    override fun getItemCount(): Int =
        items.size

    fun setItensList(listItems: List<ItemObject>){
        items.clear()
        items.addAll(listItems)
        notifyDataSetChanged()
    }

    fun AddListItem(item:ItemObject){
        items.add(item)
        notifyItemInserted(items.size)
    }

    fun removeListItem(item:ItemObject){
        val removeIndex = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(removeIndex)
        notifyItemRangeChanged(removeIndex, items.size)
    }
}