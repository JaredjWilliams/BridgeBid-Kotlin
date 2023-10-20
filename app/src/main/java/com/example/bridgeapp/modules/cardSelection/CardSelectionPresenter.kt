package com.example.bridgeapp.modules.cardSelection

import android.widget.ImageView
import com.example.bridgeapp.R
import com.example.bridgeapp.enums.Player
import com.example.bridgeapp.enums.PlayingCard
import com.example.bridgeapp.enums.Suit
import com.example.bridgeapp.models.Game
import com.example.bridgeapp.viewmodel_builder.PointBuilder

class CardSelectionPresenter(private val view: CardSelectionInterface) {

    var hand = mutableListOf<PlayingCard>()
    private var pointBuilder = PointBuilder()
    private var currentSuit = Suit.CLUBS
    var dealer: Player? = null
    var pointCounter = 0

    var game = Game()


    fun updateUser(hand : List<PlayingCard>, pointCounter : Int) {
        Player.USER.updateUser(pointBuilder.apply(hand, pointCounter), hand)
    }

    fun userDistributionPoints() : Int {
        return Player.USER.points.distributionPoints!!
    }

    fun userHandSize() : Int {
        return Player.USER.hand.size
    }

    fun userTotalPoints() : Int {
        return Player.USER.points.totalPoints ?: 0
    }

    fun setCurrentSuit(suit : Suit) {
        view.updateCardSelection(suit, true)
    }

    fun onCardPressed(cardImage: ImageView, card: PlayingCard) : ImageView {
        return if (card.selected) {
            card.selected = false
            removeCardFromHand(card)
            updateCardCounter()
            updateNextButton()
            decreasePointCounter(card)
            updatePointViews()
            cardImage.setBackgroundResource(0)
            cardImage
        } else {
            card.selected = true
            addCardToHand(card)
            updateCardCounter()
            updateNextButton()
            increasePointCounter(card)
            updatePointViews()
            cardImage.setBackgroundResource(R.drawable.selected_card_background)
            cardImage
        }
    }

    fun updateDealer(player: Player) {
        this.dealer = player
    }

    fun addCardToHand(card: PlayingCard) {
        hand.add(card)
    }

    fun removeCardFromHand(card: PlayingCard) {
        hand.remove(card)
    }

    fun decreasePointCounter(card: PlayingCard) {
        pointCounter -= card.rank.value
        view.setPointCounterTextView(pointCounter)
    }

    fun increasePointCounter(card: PlayingCard) {
        pointCounter += card.rank.value
        view.setPointCounterTextView(pointCounter)
    }

    fun updateCardCounter() {
        if (userHandSize() > 13) {
            view.setCardCounterColor("#FF0000")
        } else if (userHandSize() == 13) {
            view.setCardCounterColor("#008000")
        } else {
            view.setCardCounterColor("#000000")
        }
    }

    fun updateNextButton() {
        if (userHandSize() == 13 && dealer != null) {
            view.enabledNextButton(true)
        } else {
            view.enabledNextButton(false)
        }
    }

    fun updatePointViews() {
        updateUser(hand, pointCounter)

        view.setDistributionCountTextView(userDistributionPoints())
        view.setTotalPointCounterTextView(userTotalPoints())
        view.setCardCounterTextView(userHandSize())
        view.setPointCounterTextView(pointCounter)
    }
}