package com.example.uasdwi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.uasdwi.databinding.ActivityMainBinding
import com.example.uasdwi.fragment.BooksFragment
import com.example.uasdwi.fragment.MovieTVFragment
import com.example.uasdwi.fragment.MusicFragment
import com.example.uasdwi.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MovieTVFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.navigation_movie-> replaceFragment(MovieTVFragment())
                R.id.navigation_music -> replaceFragment(MusicFragment())
                R.id.navigation_books -> replaceFragment(BooksFragment())
                R.id.navigation_profile -> replaceFragment(ProfileFragment())

                else -> {

                }
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }


}