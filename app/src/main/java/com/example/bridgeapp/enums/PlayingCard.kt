package com.example.bridgeapp.enums

import android.graphics.drawable.Drawable
import com.example.bridgeapp.R

enum class PlayingCard(val rank: Rank, val suit: Suit, val image: Int, var selected: Boolean) {
    TWO_OF_CLUBS(Rank.TWO, Suit.CLUBS, R.drawable.two_clubs, false),
    THREE_OF_CLUBS(Rank.THREE, Suit.CLUBS, R.drawable.three_clubs, false),
    FOUR_OF_CLUBS(Rank.FOUR, Suit.CLUBS, R.drawable.four_clubs, false),
    FIVE_OF_CLUBS(Rank.FIVE, Suit.CLUBS, R.drawable.five_clubs, false),
    SIX_OF_CLUBS(Rank.SIX, Suit.CLUBS, R.drawable.six_clubs, false),
    SEVEN_OF_CLUBS(Rank.SEVEN, Suit.CLUBS, R.drawable.seven_clubs, false),
    EIGHT_OF_CLUBS(Rank.EIGHT, Suit.CLUBS, R.drawable.eight_clubs, false),
    NINE_OF_CLUBS(Rank.NINE, Suit.CLUBS, R.drawable.nine_clubs, false),
    TEN_OF_CLUBS(Rank.TEN, Suit.CLUBS, R.drawable.ten_clubs, false),
    JACK_OF_CLUBS(Rank.JACK, Suit.CLUBS, R.drawable.jack_clubs_, false),
    QUEEN_OF_CLUBS(Rank.QUEEN, Suit.CLUBS, R.drawable.jack_clubs_, false),
    KING_OF_CLUBS(Rank.KING, Suit.CLUBS, R.drawable.king_clubs_, false),
    ACE_OF_CLUBS(Rank.ACE, Suit.CLUBS, R.drawable.ace_clubs, false),

    TWO_OF_DIAMONDS(Rank.TWO, Suit.DIAMONDS, R.drawable.two_diamonds, false),
    THREE_OF_DIAMONDS(Rank.THREE, Suit.DIAMONDS, R.drawable.three_diamonds, false),
    FOUR_OF_DIAMONDS(Rank.FOUR, Suit.DIAMONDS, R.drawable.four_diamonds, false),
    FIVE_OF_DIAMONDS(Rank.FIVE, Suit.DIAMONDS, R.drawable.five_diamonds, false),
    SIX_OF_DIAMONDS(Rank.SIX, Suit.DIAMONDS, R.drawable.six_diamonds, false),
    SEVEN_OF_DIAMONDS(Rank.SEVEN, Suit.DIAMONDS, R.drawable.seven_diamonds, false),
    EIGHT_OF_DIAMONDS(Rank.EIGHT, Suit.DIAMONDS, R.drawable.eight_diamonds, false),
    NINE_OF_DIAMONDS(Rank.NINE, Suit.DIAMONDS, R.drawable.nine_diamonds, false),
    TEN_OF_DIAMONDS(Rank.TEN, Suit.DIAMONDS, R.drawable.ten_diamonds, false),
    JACK_OF_DIAMONDS(Rank.JACK, Suit.DIAMONDS, R.drawable.jack_diamonds_, false),
    QUEEN_OF_DIAMONDS(Rank.QUEEN, Suit.DIAMONDS, R.drawable.jack_diamonds_, false),
    KING_OF_DIAMONDS(Rank.KING, Suit.DIAMONDS, R.drawable.king_diamonds_, false),
    ACE_OF_DIAMONDS(Rank.ACE, Suit.DIAMONDS, R.drawable.ace_diamonds, false),

    TWO_OF_HEARTS(Rank.TWO, Suit.HEARTS, R.drawable.two_hearts, false),
    THREE_OF_HEARTS(Rank.THREE, Suit.HEARTS, R.drawable.three_hearts, false),
    FOUR_OF_HEARTS(Rank.FOUR, Suit.HEARTS, R.drawable.four_hearts, false),
    FIVE_OF_HEARTS(Rank.FIVE, Suit.HEARTS, R.drawable.five_hearts, false),
    SIX_OF_HEARTS(Rank.SIX, Suit.HEARTS, R.drawable.six_hearts, false),
    SEVEN_OF_HEARTS(Rank.SEVEN, Suit.HEARTS, R.drawable.seven_hearts, false),
    EIGHT_OF_HEARTS(Rank.EIGHT, Suit.HEARTS, R.drawable.eight_hearts, false),
    NINE_OF_HEARTS(Rank.NINE, Suit.HEARTS, R.drawable.nine_hearts, false),
    TEN_OF_HEARTS(Rank.TEN, Suit.HEARTS, R.drawable.ten_hearts, false),
    JACK_OF_HEARTS(Rank.JACK, Suit.HEARTS, R.drawable.jack_hearts, false),
    QUEEN_OF_HEARTS(Rank.QUEEN, Suit.HEARTS, R.drawable.jack_hearts, false),
    KING_OF_HEARTS(Rank.KING, Suit.HEARTS, R.drawable.king_hearts, false),
    ACE_OF_HEARTS(Rank.ACE, Suit.HEARTS, R.drawable.ace_hearts, false),

    TWO_OF_SPADES(Rank.TWO, Suit.SPADES, R.drawable.two_spades, false),
    THREE_OF_SPADES(Rank.THREE, Suit.SPADES, R.drawable.three_spades, false),
    FOUR_OF_SPADES(Rank.FOUR, Suit.SPADES, R.drawable.four_spades, false),
    FIVE_OF_SPADES(Rank.FIVE, Suit.SPADES, R.drawable.five_spades, false),
    SIX_OF_SPADES(Rank.SIX, Suit.SPADES, R.drawable.six_spades, false),
    SEVEN_OF_SPADES(Rank.SEVEN, Suit.SPADES, R.drawable.seven_spades, false),
    EIGHT_OF_SPADES(Rank.EIGHT, Suit.SPADES, R.drawable.eight_spades, false),
    NINE_OF_SPADES(Rank.NINE, Suit.SPADES, R.drawable.nine_spades, false),
    TEN_OF_SPADES(Rank.TEN, Suit.SPADES, R.drawable.ten_spades, false),
    JACK_OF_SPADES(Rank.JACK, Suit.SPADES, R.drawable.jack_spades_, false),
    QUEEN_OF_SPADES(Rank.QUEEN, Suit.SPADES, R.drawable.jack_spades_, false),
    KING_OF_SPADES(Rank.KING, Suit.SPADES, R.drawable.king_spades_, false),
    ACE_OF_SPADES(Rank.ACE, Suit.SPADES, R.drawable.ace_spades, false),

}