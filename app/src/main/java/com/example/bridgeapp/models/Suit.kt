package com.example.bridgeapp.models

import com.example.bridgeapp.enums.Rank

data class Suit (
    val count: Int?,
    val image: String?,
    val cards: Set<Rank>
)