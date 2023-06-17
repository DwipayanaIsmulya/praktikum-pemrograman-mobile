package com.example.uasdwi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasdwi.data.BooksData
import com.example.uasdwi.data.MovieTVData
import com.example.uasdwi.fragment.BooksFragment
import com.example.uasdwi.fragment.MovieTVFragment

class BooksDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val books = intent.getParcelableExtra<BooksData>(BooksFragment.INTENT_PARCELABLE)

        val booksimg = findViewById<ImageView>(R.id.movietvimage)
        val bookstitle = findViewById<TextView>(R.id.movietv_title)
        val booksdescription = findViewById<TextView>(R.id.movietv_isi_deskripsi)

        booksimg.setImageResource(books?.booksImg!!)
        bookstitle.text = books.booksTitle
        booksdescription.text = books.booksDescription
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}