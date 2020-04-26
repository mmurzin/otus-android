package com.example.homework1.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework1.R
import com.example.homework1.network.models.Character

class CharactersAdapter(val items: List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageAvatar = itemView.findViewById<ImageView>(R.id.imageAvatar)
        val textName = itemView.findViewById<TextView>(R.id.textName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textName.text = items[position].name
        holder.imageAvatar.loadImage(items[position].image)

    }
}

private fun ImageView.loadImage(link: String) {
    Glide.with(this.context)
        .load(link)
        .into(this)
}
