package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
// Fungsi ketika tombol roll di klik
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // membuat variabel rollButton untuk button yang akan di digunakan
        val rollButton: Button = findViewById(R.id.button)

        // ketika button ditekan, akan menjalankan fungsi rollDice
        rollButton.setOnClickListener { rollDice() }

        // untuk menampilkan gambar dadu diawalan
        rollDice()
    }

    private fun rollDice() {
        // Membuat objek dadu dengan 6 kemungkinan dan mengacaknya
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // membuat variabel baru untuk image
        val diceImage: ImageView = findViewById(R.id.imageView)

        // membuat gambar dadu sesuai dengan acakan
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // set image sesuai dengan kondisi dari drawable
        diceImage.setImageResource(drawableResource)

        // set konten gambar dengan angka
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    // Fungsi untuk mengacak angka 1 sampai dengan 6
    fun roll(): Int {
        return (1..numSides).random()
    }
}