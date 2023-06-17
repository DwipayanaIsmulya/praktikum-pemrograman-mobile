package com.example.uasdwi

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasdwi.data.MovieTVData
import com.example.uasdwi.fragment.MovieTVFragment

class MovieTVDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movietv = intent.getParcelableExtra<MovieTVData>(MovieTVFragment.INTENT_PARCELABLE)

        val movietvimg = findViewById<ImageView>(R.id.movietvimage)
        val movietvtitle = findViewById<TextView>(R.id.movietv_title)
        val movietvdescription = findViewById<TextView>(R.id.movietv_isi_deskripsi)

        movietvimg.setImageResource(movietv?.movietvImg!!)
        movietvtitle.text = movietv.movietvTitle
        movietvdescription.text = movietv.movietvDescription
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}