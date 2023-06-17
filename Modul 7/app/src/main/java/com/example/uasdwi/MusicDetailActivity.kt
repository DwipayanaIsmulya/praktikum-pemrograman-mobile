package com.example.uasdwi

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uasdwi.data.MovieTVData
import com.example.uasdwi.data.MusicData
import com.example.uasdwi.fragment.MovieTVFragment
import com.example.uasdwi.fragment.MusicFragment

class MusicDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val music = intent.getParcelableExtra<MusicData>(MusicFragment.INTENT_PARCELABLE)

        val musicimg = findViewById<ImageView>(R.id.movietvimage)
        val musictitle = findViewById<TextView>(R.id.movietv_title)
        val musicdescription = findViewById<TextView>(R.id.movietv_isi_deskripsi)

        musicimg.setImageResource(music?.musicImg!!)
        musictitle.text = music.musicTitle
        musicdescription.text = music.musicDescription
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}