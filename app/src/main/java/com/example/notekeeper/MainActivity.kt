package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_listview.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            startActivity(Intent(this, EditNote::class.java))

        }
        listNotes.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, DataManager.notes)

        //click any note
        listNotes.setOnItemClickListener { parent, view, position, id ->
            startActivity(Intent(this, EditNote::class.java).putExtra(NOTE_POSITION, position))

        }

    }
    //adding and saving a new note
    override fun onResume() {
        super.onResume()
        (listNotes.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}