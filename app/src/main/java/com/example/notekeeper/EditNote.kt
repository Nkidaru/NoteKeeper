package com.example.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_note.*

class EditNote : AppCompatActivity() {
    private var noteposition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)


//Retrieving the position of the note if the activity is destroyed and recreatead
        noteposition =
            savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?: intent.getIntExtra(
                NOTE_POSITION,
                POSITION_NOT_SET
            )

        if (noteposition != POSITION_NOT_SET) {

            displayNote()
        }
        //Creating a new Note
        else {
            DataManager.notes.add(NoteInfo())
            //displaying the note below the already created notes
            noteposition = DataManager.notes.lastIndex

        }


    }

    //display a course selected from the list
    private fun displayNote() {
        val note = DataManager.notes[noteposition]
        textTitle.setText(note.title)
        noteText.setText(note.text)


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)


//            if (menu?.findItem(R.id.action_share)!=null){
//                val sendIntent: Intent = Intent().apply {
//                    action = Intent.ACTION_SEND
//                    putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
//                    type = "text/plain"
//                }
//
//                val shareIntent = Intent.createChooser(sendIntent, null)
//                startActivity(shareIntent)
//
//            }


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return when (item.itemId) {

            R.id.action_save -> {
                saveNote()
                true
            }
            R.id.action_share -> {

                shareNote()
                true
            }


//                try {
//                    if (R.id.action_share !=null){
//                     shareNote()
//                    }
//                    true
//                }catch ()


            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
        val note = DataManager.notes[noteposition]

        note.title = textTitle.text.toString()
        note.text = noteText.text.toString()

    }

    private fun shareNote() {
        val title = textTitle.text.toString()
        val text = noteText.text.toString()
        if (title.isNotEmpty() && text.isNotEmpty()) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "$title")
            startActivity(shareIntent)

        } else {
            Toast.makeText(this, "Enter Text to Share", Toast.LENGTH_LONG).show()

        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}




