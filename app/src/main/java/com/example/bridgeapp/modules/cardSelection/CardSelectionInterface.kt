package com.example.bridgeapp.modules.cardSelection

import android.widget.ImageView
import com.example.bridgeapp.enums.PlayingCard
import com.example.bridgeapp.enums.Suit

interface CardSelectionInterface  {
    fun setCardCounterTextView(count: Int)
    fun setPointCounterTextView(count: Int)
    fun setCardCounterColor(color: String)
    fun enabledNextButton(isEnabled: Boolean)
    fun setDistributionCountTextView(count: Int)
    fun setTotalPointCounterTextView(count: Int)
    fun updateCardSelection(suit: Suit, update: Boolean)
}