package com.example.music

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private var songList: ArrayList<Song>?=null
    private var songView: ListView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songView=findViewById(R.id.song_list)

        songList=ArrayList()

        val musicResolver=contentResolver
        val musicUri: Uri=MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val musicCursor: Cursor?=musicResolver.query(musicUri, null, null, null, null)

        if (musicCursor != null && musicCursor.moveToFirst()) {
            //get columns
            val titleColumn=musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
            val idColumn=musicCursor.getColumnIndex(MediaStore.Audio.Media._ID)
            val artistColumn=musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
            //add songs to list
            do {
                val thisId=musicCursor.getLong(idColumn)
                val thisTitle=musicCursor.getString(titleColumn)
                val thisArtist=musicCursor.getString(artistColumn)
                songList!!.add(Song(thisId, thisTitle, thisArtist))
            } while (musicCursor.moveToNext())
        }
        fun getSongList() {}

        Collections.sort(songList, object : Comparator<Song?> {
            override fun compare(p0: Song?, p1: Song?): Int {
                return p0?.getTitle()!!.compareTo(p1?.getTitle()!!)
            }
        })

        val songAdt=SongAdapter(this, songList!!)
        songView!!.setAdapter(songAdt)

    }

    fun getSongList() {
        //retrieve song info
    }
}