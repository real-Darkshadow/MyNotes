package com.example.mynotes.Screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mynotes.Database.User
import com.example.mynotes.Database.database
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentEditnotesBinding
import com.example.mynotes.recyclerview.MainAdapter
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class editnotes : Fragment() {
    private var _binding:FragmentEditnotesBinding?=null
    private val binding get()=_binding!!
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentEditnotesBinding.inflate(inflater,container,false)
        val view=binding.root
        binding.savebutton.setOnClickListener{
            Save()
        }
        binding.backbutton.setOnClickListener{
            findNavController().popBackStack()
        }
        return view
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
    fun Save(){
        val note=binding.usernoteinput.text
        val title=binding.title.text
        val db=database.getDatabase(requireContext())

        if (note != null) {
            if(note.isNotEmpty()){
                GlobalScope.launch {
                    db.dao().insertNote(User(0, title.toString(), note.toString()))
                }

                findNavController().popBackStack()

            }
            else {
                findNavController().popBackStack()
            }
        }
    }

}