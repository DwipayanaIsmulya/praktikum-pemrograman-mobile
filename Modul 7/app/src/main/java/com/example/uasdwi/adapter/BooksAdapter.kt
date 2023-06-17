package com.example.uasdwi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uasdwi.R
import com.example.uasdwi.data.BooksData

class BooksAdapter (private val context: Context, private val books: List<BooksData>, val listener: (BooksData) -> Unit)
    : RecyclerView.Adapter<BooksAdapter.MovieViewHolder>(){
    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val booksimg = view.findViewById<ImageView>(R.id.image)
        val bookstitle = view.findViewById<TextView>(R.id.name)
        val booksdeskripsi = view.findViewById<TextView>(R.id.brief)

        fun bindView(books: BooksData, listener: (BooksData) -> Unit){
            booksimg.setImageResource(books.booksImg)
            bookstitle.text = books.booksTitle
            booksdeskripsi.text = books.booksDescription
            itemView.setOnClickListener{
                (listener(books))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(books[position], listener)
    }

    override fun getItemCount(): Int = books.size

}