package com.example.music

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.R
import android.annotation.SuppressLint

import android.widget.TextView

import android.widget.LinearLayout

class SongAdapter(mainActivity: MainActivity, songList: ArrayList<Song>) :BaseAdapter() {

    private var songs: ArrayList<Song>?=null
    private var songInf: LayoutInflater?=null

    fun SongAdapter(c: Context?, theSongs: ArrayList<Song?>) {
        songs=theSongs
        songInf=LayoutInflater.from(c)
    }

    override fun getCount(): Int {
        return songs!!.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        //map to song layout
        var songLay = songInf.inflate()
        //get title and artist views
        val songView=songLay.findViewById<View>(R.id.befikre) as TextView
        val artistView=songLay.findViewById<View>(R.id.song_artist) as TextView
        //get song using position
        val currSong=songs!![position]
        //get title and artist strings
        songView.text=currSong.getTitle()
        artistView.text=currSong.getArtist()
        //set position as tag
        songLay.tag=position
        return songLay
    }

    val songLay=songInf.inflate(R.layout.song, parent, false) as LinearLayout
}