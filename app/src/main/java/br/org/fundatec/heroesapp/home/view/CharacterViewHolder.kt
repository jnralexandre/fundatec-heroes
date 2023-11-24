package br.org.fundatec.heroesapp.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.heroesapp.home.domain.CharacterModel
import br.org.fundatec.heroesapp.databinding.CharacterListItemBinding
import br.org.fundatec.heroesapp.gone
import com.bumptech.glide.Glide

class CharacterViewHolder(
    private val binding: CharacterListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.cliImageView)
        binding.textViewNomeHeroi.text = character.name

        binding.textViewNomeHeroi.setOnClickListener {
            binding.cliImageView.gone()
        }

    }
}