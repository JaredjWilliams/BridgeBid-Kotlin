package com.example.bridgeapp.modules.bidscreen

import android.util.Log
import com.example.bridgeapp.enums.Bid
import com.example.bridgeapp.enums.Player
import com.example.bridgeapp.models.Game

class BidScreenPresenter(private val view : BidScreenInterface) {


    var game : Game = Game()

    fun setPlayerBidText(currentPlayer : Player?) : String {
       return when (currentPlayer) {
            Player.USER -> "User's Turn"
            Player.LEFT_OPPONENT -> "Left Opponent's Turn"
            Player.RIGHT_OPPONENT -> "Right Opponent's Turn"
            Player.PARTNER -> "Partner's Turn"
           else -> {"No Player found"}
       }
    }

    fun onBidPressed(bid: Bid?) {
        game.bidHistory?.add(bid)
        setNextPlayer(game.currentPlayerTurn)
        view.createCurrentPlayerText()
    }

    fun setNextPlayer(currentPlayer: Player?) {
        Log.d("testing", "testing: " + currentPlayer)
        when (currentPlayer) {
            Player.USER -> game.currentPlayerTurn = Player.LEFT_OPPONENT
            Player.LEFT_OPPONENT -> game.currentPlayerTurn = Player.PARTNER
            Player.PARTNER -> game.currentPlayerTurn = Player.RIGHT_OPPONENT
            Player.RIGHT_OPPONENT -> game.currentPlayerTurn = Player.USER
            else -> {}
        }
    }
}