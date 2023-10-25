package com.example.bridgeapp.enums

import com.example.bridgeapp.R

enum class Bid(val suit: Suit, val image: Int, val value: Int) {
    ONE_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, 1),
    ONE_DIAMONDS(Suit.DIAMONDS, R.drawable.card_suit_diamonds, 1),
    ONE_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, 1),
    ONE_SPADES(Suit.SPADES, R.drawable.card_suit_spades, 1),
    ONE_NO_TRUMPS(Suit.NO_TRUMP, R.drawable.card_suit_spades, 1),
    TWO_CLUBS(Suit.CLUBS, R.drawable.card_suit_clubs, 2),
    TWO_DIAMOND(Suit.DIAMONDS, R.drawable.card_suit_diamonds, 2),
    TWO_HEARTS(Suit.HEARTS, R.drawable.card_suit_heats, 2),
    TWO_SPADES(Suit.SPADES, R.drawable.card_suit_spades, 2),
    TWO_NO_TRUMP(Suit.NO_TRUMP, R.drawable.card_suit_spades, 2)
}