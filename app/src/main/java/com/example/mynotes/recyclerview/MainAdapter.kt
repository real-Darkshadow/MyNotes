package com.example.mynotes.recyclerview

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.Database.User
import com.example.mynotes.R
import com.example.mynotes.Screens.homeScreenDirections
import com.google.android.material.card.MaterialCardView
import java.util.*

class MainAdapter(private val onnoteclick: () -> Unit, private val size: List<User>) : RecyclerView.Adapter<MainAdapter.vh>() {
    inner class vh(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.cardHead)
        val card = view.findViewById<MaterialCardView>(R.id.notescard)
        val c=view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        val layout: View =
            LayoutInflater.from(parent.context).inflate(R.layout.notescard, parent, false)
        return vh(layout)
    }

    override fun getItemCount(): Int = size.size

    override fun onBindViewHolder(holder: vh, position: Int) {
        holder.text.text = size[position].Note
        var i = mColors.random()
        holder.card.background.setTint(i.toColorInt())
        holder.card.setOnClickListener {
            //onnoteclick() //we can also use lambdas for navigation to another fragment but the one we are using is simpler as its not using lambdas
            val action=homeScreenDirections.actionHomeScreenToViewnotes(size[position].Note,size[position].headline,size[position].id)
            Navigation.findNavController(holder.c).navigate(action)
        }
    }

    var mColors = arrayOf(
        "#FD99FF", "#FF9E9E", "#91F48F", "#FFF599", "#9EFFFF",
        "#B69CFF"
    )
}