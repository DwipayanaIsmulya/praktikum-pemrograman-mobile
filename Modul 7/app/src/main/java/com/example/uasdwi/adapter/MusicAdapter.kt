package com.example.uasdwi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uasdwi.R
import com.example.uasdwi.data.MovieTVData
import com.example.uasdwi.data.MusicData

class MusicAdapter (private val context: Context, private val music: List<MusicData>, val listener: (MusicData) -> Unit)
    : RecyclerView.Adapter<MusicAdapter.MovieViewHolder>(){
    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val musicimg = view.findViewById<ImageView>(R.id.image)
        val musicname = view.findViewById<TextView>(R.id.name)
        val musicdeskripsi = view.findViewById<TextView>(R.id.brief)

        fun bindView(music: MusicData, listener: (MusicData) -> Unit){
            musicimg.setImageResource(music.musicImg)
            musicname.text = music.musicTitle
            musicdeskripsi.text = music.musicDescription
            itemView.setOnClickListener{
                (listener(music))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(music[position], listener)
    }

    override fun getItemCount(): Int = music.size

}