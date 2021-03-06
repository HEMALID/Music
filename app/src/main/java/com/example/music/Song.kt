package com.example.music

import android.R.id

class Song {
    constructor(thisId: Long, thisTitle: String?, thisArtist: String?)

    private var id: Long=0
    private var title: String?=null
    private var artist: String?=null

    fun Song(songID: Long, songTitle: String, songArtist: String) {
        id=songID
        title=songTitle
        artist=songArtist
    }

    fun getID(): Long {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    fun getArtist(): String? {
        return artist
    }
}