package com.example.uasdwi.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasdwi.MovieTVDetailActivity
import com.example.uasdwi.R
import com.example.uasdwi.adapter.BooksAdapter
import com.example.uasdwi.adapter.MovieTVAdapter
import com.example.uasdwi.data.BooksData
import com.example.uasdwi.data.MovieTVData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieTVFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieTVFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: MovieTVAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movietvlist: List<MovieTVData>

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
        return inflater.inflate(R.layout.fragment_movie_t_v, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment MovieTVFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            MovieTVFragment().apply {
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
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_movietv)
        recyclerView.setHasFixedSize(true)
        adapter = MovieTVAdapter(requireContext(), movietvlist) { movietv ->
            val intent = Intent(requireContext(), MovieTVDetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, movietv)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        movietvlist = listOf<MovieTVData>(
            MovieTVData(
                R.drawable.movie1,
                movietvTitle = "Transformers: Rise of the Beasts",
                movietvDescription = "Berlatar tahun 1994, Noah Diaz (Anthony Ramos) dan Elena Wallace (Dominique Fishback) memulai petualangan menjelajahi dunia bersama para Autobots dan Transformers lainnya. Mereka bersama-sama berusaha menyelamatkan bumi dari ancaman besar Unicron."
            ),
            MovieTVData(
                R.drawable.movie2,
                movietvTitle = "The Flash",
                movietvDescription = "Barry Allen menggunakan kecepatan supernya untuk mengubah masa lalu, tetapi upayanya untuk menyelamatkan keluarganya menyebabkan masalah.\n" +
                        "Kini Barry berlomba demi hidupnya dan menyelamatkan masa depan."
            ),
            MovieTVData(
                R.drawable.movie3,
                movietvTitle = "Fast X",
                movietvDescription = "Musuh dari masa lalu kini menghampiri Dom (Vin Diesel) dan keluarganya. Dante (Jason Momoa) putra gembong narkoba Hernan Reyes (Joaquim de Almeida) yang dihancurkan Dom dan kelompoknya di seri kelima kini datang dan berusaha balas dendam atas kematian sang ayah."
            )
        )
    }
}