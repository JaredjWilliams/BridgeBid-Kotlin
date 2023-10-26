package com.example.bridgeapp.models

import android.os.Parcel
import android.os.Parcelable
import com.example.bridgeapp.enums.Bid
import com.example.bridgeapp.enums.Player
import com.example.bridgeapp.enums.PlayingCard
import com.google.gson.Gson

data class Game (
    var bidHistory : MutableList<Bid?>? = null,
    var dealer : Player? = null,
    var currentPlayerTurn: Player? = null
) {
    fun toJson() : String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String) : Game {
            return Gson().fromJson(json, Game::class.java)
        }
    }
}
