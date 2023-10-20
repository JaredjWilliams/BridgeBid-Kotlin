package com.example.bridgeapp.viewmodel_builder

import com.example.bridgeapp.enums.PlayingCard
import com.example.bridgeapp.enums.Suit
import com.example.bridgeapp.models.Points

class PointBuilder {

    fun apply(hand : List<PlayingCard>, highCardPoints: Int) : Points {
        val points = Points()

        points.totalPoints = buildDistributionPoints(hand) + highCardPoints
        points.distributionPoints = buildDistributionPoints(hand)
        points.highCardPoints = highCardPoints

        return points
    }

    private fun buildDistributionPoints(hand : List<PlayingCard>) : Int {
        var points = 0

        val clubs = hand.count { it.suit == Suit.CLUBS }
        val diamonds = hand.count { it.suit == Suit.DIAMONDS }
        val hearts = hand.count { it.suit == Suit.HEARTS }
        val spades = hand.count { it.suit == Suit.SPADES }

        val distribution = listOf<Int>(clubs, diamonds, hearts, spades)

        distribution.forEach { suitCount ->
            when(suitCount) {
                0 -> points += 3
                1 -> points += 2
                2 -> points += 1
            }
        }

        return points
    }
}