package com.example.bridgeapp.enums

import com.example.bridgeapp.models.Points

enum class Player(var points: Points, var hand: List<PlayingCard>) {
    USER(Points(), mutableListOf()),
    LEFT_OPPONENT(Points(), mutableListOf()),
    PARTNER(Points(), mutableListOf()),
    RIGHT_OPPONENT(Points(), mutableListOf());

    fun updateUser(points: Points, hand: List<PlayingCard>) {
        USER.points = points
        USER.hand = hand
    }
}