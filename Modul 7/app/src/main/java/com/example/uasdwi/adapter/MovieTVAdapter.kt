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

class MovieTVAdapter (private val context: Context, private val movietv: List<MovieTVData>, val listener: (MovieTVData) -> Unit)
    : RecyclerView.Adapter<MovieTVAdapter.MovieViewHolder>(){
    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val movietvimg = view.findViewById<ImageView>(R.id.image)
        val movietvname = view.findViewById<TextView>(R.id.name)
        val movietvdeskripsi = view.findViewById<TextView>(R.id.brief)

        fun bindView(movietv: MovieTVData, listener: (MovieTVData) -> Unit){
            movietvimg.setImageResource(movietv.movietvImg)
            movietvname.text = movietv.movietvTitle
            movietvdeskripsi.text = movietv.movietvDescription
            itemView.setOnClickListener{
                (listener(movietv))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(movietv[position], listener)
    }

    override fun getItemCount(): Int = movietv.size

}