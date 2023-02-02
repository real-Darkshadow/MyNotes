package com.example.mynotes.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.mynotes.Database.database
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentHomeScreenBinding
import com.example.mynotes.recyclerview.MainAdapter
import kotlinx.coroutines.DelicateCoroutinesApi


class homeScreen : Fragment() {
    private var _binding: FragmentHomeScreenBinding?=null
    private val binding get() =_binding!!
    private lateinit var db:database
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeScreenBinding.inflate(inflater,container,false)
        val view=binding.root
        db=database.getDatabase(requireContext())
        val data=db.dao().getnote().reversed()
        bgimgdatacheck()
        binding.addnotesbutton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeScreen_to_editnotes)
        }
        binding.search.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreen_to_search2)
        }

        val adapter=MainAdapter(::onnoteclick,data)
        binding.homerecycler.adapter=adapter
        binding.homerecycler.layoutManager=LinearLayoutManager(view.context, VERTICAL,false)

        return view
    }

    private fun bgimgdatacheck() {
        val data=db.dao().getnote()
        if (data.isNotEmpty()){
            binding.startimg.visibility=View.INVISIBLE
            binding.starttxt.visibility=View.INVISIBLE
        }    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
    private fun onnoteclick(){
        Toast.makeText(context,"hellyeah",Toast.LENGTH_SHORT).show()
        view?.findNavController()?.navigate(R.id.action_homeScreen_to_viewnotes)

    }
}