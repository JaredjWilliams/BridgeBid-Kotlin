package com.example.bridgeapp.modules.bidscreen

import com.example.bridgeapp.enums.Player

class BidScreenPresenter {


    fun setPlayerBidText(currentPlayer : Player?) : String {
       return when (currentPlayer) {
            Player.USER -> "User's Turn"
            Player.LEFT_OPPONENT -> "Left Opponent's Turn"
            Player.RIGHT_OPPONENT -> "Right Opponent's Turn"
            Player.PARTNER -> "Partner's Turn"
           else -> {"No Player found"}
       }
    }
}