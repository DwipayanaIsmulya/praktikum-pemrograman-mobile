package com.example.uasdwi.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasdwi.BooksDetailActivity
import com.example.uasdwi.MovieTVDetailActivity
import com.example.uasdwi.R
import com.example.uasdwi.adapter.BooksAdapter
import com.example.uasdwi.adapter.MovieTVAdapter
import com.example.uasdwi.data.BooksData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BooksFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: BooksAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var booksList: List<BooksData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment BooksFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            BooksFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_books)
        recyclerView.setHasFixedSize(true)
        adapter = BooksAdapter(requireContext(), booksList) { books ->
            val intent = Intent(requireContext(), BooksDetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, books)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        booksList = listOf<BooksData>(
            BooksData(
                R.drawable.buku1,
                booksTitle = "Atomic Habits “Cara Mudah dan Terbukti Untuk Membentuk kebiasaan Baik dan Menghilangkan Kebiasaan Buruk”",
                booksDescription = "Orang mengira ketika Anda ingin mengubah hidup, Anda perlu memikirkan hal-hal besar. Namun pakar kebiasaan terkenal kelas dunia James Clear telah menemukan sebuah cara lain. Ia tahu bahwa perubahan nyata berasal dari efek gabungan ratusan keputusan kecil—dari mengerjakan dua push-up sehari, bangun lima menit lebih awal, sampai menahan sebentar hasrat untuk menelepon. Ia menyebut semua tadi atomic habits."
            ),
            BooksData(
                R.drawable.buku2,
                booksTitle = "Filosofi Teras",
                booksDescription = "Buku ini pada awalnya menceritakan tentang sebuah survei kekhawatiran nasional yang semakin masif sekaligus menyajikan tentang sekilas kehidupan si penulis yang dipenuhi oleh emosi negatif yang berlebihan. Lalu, lebih dari 2000 tahun lalu sebuah mazhab filsafat menemukan akar masalah dan solusi dari banyaknya emosi negatif. Ya, Stoisisme atau\n" +
                        "filosofi Stoa, namun penulis lebih memperkenalkannya dengan “Filosofi Teras” yang merupakan filsafat Yunani-Romawi Kuno yang dapat membantu kita dalam mengatasi emosi negatif serta menghasilkan mental seseorang menjadi tangguh dalam menghadapi naik turunnya kehidupan. Dalam buku tersebut, filsafat Stoa digambarkan secara sederhana dengan inti dikotomi kendali nasib manusia sehingga dari dikotomi kendali tersebut, manusia dapat menentukan hal-hal yang dapat membuatnya bahagia maupun tidak. Namun, Wiliam Irvine menawarkan trikotomi kendali di mana memuat apa yang menjadi kendali kita, tidak\n" +
                        "menjadi kendali kita, dan juga menjadi bagian dari kendali kita."
            ),
            BooksData(
                R.drawable.buku3,
                booksTitle = "Insecurity Is My Middle Name",
                booksDescription = "Insecurity is My Middle Name merupakan buku self-healing yang ditulis oleh Alvi Syahrin. Melalui buku ini akan banyak menjawab pertanyaan-pertanyaan yang selama ini bersarang di dalam kepala. Pada buku ini, penulis akan mengajak pembaca untuk berdamai dengan ‘insecurity’ yang selama ini dialami dengan cara yang positif, terus bertumbuh, terus berkembang dan menjadi versi yang lebih baik dari diri kita sebelumnya. Pembaca akan diajak lebih mengenali makna insecurity dan tips untuk berdamai dengan diri sendiri."
            )
        )
    }
}