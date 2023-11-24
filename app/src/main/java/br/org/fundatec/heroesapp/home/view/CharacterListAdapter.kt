package br.org.fundatec.heroesapp.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.heroesapp.home.domain.CharacterModel
import br.org.fundatec.heroesapp.databinding.CharacterListItemBinding

class CharacterListAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val list: MutableList<CharacterModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addList(items: List<CharacterModel>) {
        list.addAll(items)
    }

    fun remove(position: Int) {
        list.removeAt(position)
        notifyItemChanged(position)
    }

}