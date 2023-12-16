package br.org.fundatec.heroesapp.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.heroesapp.home.domain.CharacterModel
import br.org.fundatec.heroesapp.databinding.CharacterListItemBinding
import com.bumptech.glide.Glide

class CharacterViewHolder(
    private val binding: CharacterListItemBinding,
    private val click: (CharacterModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.cliImageView)
        binding.textViewNomeHeroi.text = character.name

        binding.androidConstraintLayoutAc.setOnClickListener {
            click(character)
        }

    }
}