package com.example.notekeeper

object DataManager {
    //HashMAp is used for lookup

    val notes=ArrayList<NoteInfo>()
    init {

        initializeNotes()
    }

    private fun initializeNotes(){


        var note = NoteInfo("Meetup up", "Meeting to discuss android 11")
        notes.add(note)

        note = NoteInfo("Fixing Bugs", "Running tests")
        notes.add(note)

        note = NoteInfo("Reading about Intents", "Deep understanding about intents")
        notes.add(note)

        note = NoteInfo("Exploring JetPack", "Jetpack encompasses a collection of Android libraries that incorporate best practices and provide backwards compatibility in your Android apps.\n" +
                "\n" +
                "The Jetpack guide to app architecture provides an overview of the best practices and recommended architecture to consider as you build your Android app.")
        notes.add(note)



    }



}