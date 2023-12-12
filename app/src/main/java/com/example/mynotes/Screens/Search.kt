package com.example.mynotes.Screens

import NoteAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.Database.dao
import com.example.mynotes.Database.database
import com.example.mynotes.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Search : Fragment() {
    private lateinit var adapter: NoteAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var noteDao: dao // Assuming you have a NoteDao
    private lateinit var textView:TextView
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        val db = database.getDatabase(requireContext())
        noteDao = db.dao()

        val searchInput = view.findViewById<EditText>(R.id.searchInput)
        adapter = NoteAdapter(emptyList())
        recyclerView = view.findViewById<RecyclerView>(R.id.searchResultsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

         textView = view.findViewById<TextView>(R.id.text)
         imageView = view.findViewById<ImageView>(R.id.imageView)

        searchInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchNotes(s.toString())
            }
        })

        return view
    }

    private fun searchNotes(query: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val results = noteDao.searchNotes("%$query%")
            withContext(Dispatchers.Main) {
                if (results.isNotEmpty() || results!=null) {
                    adapter.updateNotes(results)
                    recyclerView.visibility = View.VISIBLE
                    textView.visibility = View.GONE
                    imageView.visibility = View.GONE
                } else {
                    recyclerView.visibility = View.GONE
                    textView.visibility = View.VISIBLE
                    imageView.visibility = View.VISIBLE
                }
            }
        }
    }
}
