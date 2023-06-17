package com.example.uasdwi.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uasdwi.MovieTVDetailActivity
import com.example.uasdwi.MusicDetailActivity
import com.example.uasdwi.R
import com.example.uasdwi.adapter.MovieTVAdapter
import com.example.uasdwi.adapter.MusicAdapter
import com.example.uasdwi.data.BooksData
import com.example.uasdwi.data.MovieTVData
import com.example.uasdwi.data.MusicData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MusicFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MusicFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: MusicAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var musiclist: List<MusicData>

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
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment MusicFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            MusicFragment().apply {
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
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_music)
        recyclerView.setHasFixedSize(true)
        adapter = MusicAdapter(requireContext(), musiclist) { music ->
            val intent = Intent(requireContext(), MusicDetailActivity::class.java)
            intent.putExtra(MusicFragment.INTENT_PARCELABLE, music)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        musiclist = listOf<MusicData>(
            MusicData(
                R.drawable.music3,
                musicTitle = "Somebody Pleasure",
                musicDescription = "Somebody pleasure merupakan karya dari Aziz Hedra. Lagu ini diambil dari pengalaman pribadinya. Saat itu dirinya sedang berada di titik terendah di hidupnya. Namun, dengan cobaan yang datang bersamaan, ia harus bangkit dari keterpurukan."
            ),
            MusicData(
                R.drawable.music2,
                musicTitle = "Seandainya",
                musicDescription = "Makna lagu “Seandainya” dari Vierra adalah menceritakan tentang situasi perpisahan di dalam hubungan percintaan yang salah satunya masih menyimpan cinta yang cukup kuat namun enggan untuk mengutarakannya secara terang-terangan."
            ),
            MusicData(
                R.drawable.music1,
                musicTitle = "Lumpuhkanlah Ingatanku",
                musicDescription = "Lagu Lumpuhkanlah Ingatanku mengisahkan tentang seseorang yang ingin melupakan kenangan-kenangan dengan pasangannya. Rasa cinta memang tidak selamanya bisa berakhir indah, terkadang juga bisa berakhir dengan rasa sakit yang tiada terkira."
            )
        )
    }
}