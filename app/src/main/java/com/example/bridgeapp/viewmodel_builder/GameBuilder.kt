package com.example.bridgeapp.viewmodel_builder

import com.example.bridgeapp.enums.Bid
import com.example.bridgeapp.enums.Player
import com.example.bridgeapp.models.Game

class GameBuilder {

    fun apply(dealer: Player?, bid: Bid?, currentPlayer: Player?) : Game {
        val game = Game()

        game.dealer = dealer
        game.bidHistory?.add(bid)
        game.currentPlayerTurn = currentPlayer

        return game
    }
}