package com.example.pokeglass.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeglass.R
import com.example.pokeglass.remote.models.Pokemon
import com.squareup.picasso.Picasso

class PokemonAdapter(
    private var pokemonList: List<Pokemon>,
    private val onAddClicked: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.pokemon_name)
        val addButton: Button = itemView.findViewById(R.id.add_button)
        val spriteImageView: ImageView = itemView.findViewById(R.id.pokemon_sprite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.nameTextView.text = pokemon.name
        holder.addButton.setOnClickListener {
            onAddClicked(pokemon)
        }
        Picasso.get().load(pokemon.spriteUrl).into(holder.spriteImageView)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    fun updateData(newPokemonList: List<Pokemon>) {
        pokemonList = newPokemonList
        notifyDataSetChanged()
    }
}