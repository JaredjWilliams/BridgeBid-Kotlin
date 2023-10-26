package com.example.bridgeapp.enums

import android.graphics.Color
import com.example.bridgeapp.R

enum class Bid(val suit: Suit, val image: Int, val label: String, val color: Int) {
    ONE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "1", Color.WHITE),
    ONE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "1", Color.BLACK),
    ONE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "1", Color.BLACK),
    ONE_SPADES(Suit.SPADES, R.drawable.card_suit_spades, "1", Color.WHITE),
    ONE_NO_TRUMPS(Suit.NO_TRUMP, R.drawable.no_trump_background, "1 NT", Color.WHITE),
    TWO_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "2", Color.WHITE),
    TWO_DIAMOND(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "2", Color.BLACK),
    TWO_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "2", Color.BLACK),
    TWO_SPADES(Suit.SPADES, R.drawable.card_suit_spades, "2", Color.WHITE),
    TWO_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "2 NT", Color.WHITE),
    THREE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, "3", Color.WHITE),
    THREE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, "3", Color.BLACK),
    THREE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, "3", Color.BLACK),
    THREE_SPADES(Suit.SPADES, R.drawable.card_suit_spades,"3", Color.WHITE),
    THREE_NO_TRUMP(Suit.NO_TRUMP, R.drawable.no_trump_background, "3 NT", Color.WHITE),

}