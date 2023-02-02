package com.example.mynotes.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mynotes.Database.User
import com.example.mynotes.Database.database
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentViewnotesBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class viewnotes : Fragment() {
     val args:viewnotesArgs by navArgs()
    var _binding:FragmentViewnotesBinding?=null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentViewnotesBinding.inflate(inflater,container,false)
        val view=binding.root
        updateScreen()
        binding.savebutton.setOnClickListener{
            Save()
        }
        binding.backbutton.setOnClickListener{
            findNavController().popBackStack()
        }

        return view
    }

    private fun updateScreen() {
        binding.title.setText(args.title)
        binding.usernoteinput.setText(args.note)
    }

    fun Save(){
        val note=binding.usernoteinput.text
        val title=binding.title.text
        val db= database.getDatabase(requireContext())
        if (note != null) {
            if(note.isNotEmpty()){
                GlobalScope.launch {
                    db.dao().updateNote(User(args.id, title.toString(), note.toString()))
                }
            }
        }
    }
    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}