package com.example.bridgeapp.modules.bidscreen

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.example.bridgeapp.R
import com.example.bridgeapp.enums.Bid
import com.example.bridgeapp.enums.Suit
import android.graphics.Color

class BidScreenActivity : ComponentActivity(), BidScreenInterface {

    private lateinit var gridView : GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter()

        setContentView(R.layout.activity_bid_screen)

        setView()

        initializeBidGridView()


    }

    private fun getPresenter() {

    }

    private fun setView() {
        gridView = findViewById(R.id.bid_grid_view)
    }

    private fun initializeBidGridView() {
        var bids = enumValues<Bid>()
        val params = ViewGroup.MarginLayoutParams(100, 100)
        params.setMargins(10, 10, 10, 10)

        bids.forEach { bid: Bid ->
            initializeBidCard(bid, params)
        }
    }

    private fun initializeBidCard(bid: Bid, params: ViewGroup.LayoutParams) {
        var bidImage = TextView(this)
        var blackImages = listOf(Suit.SPADES, Suit.CLUBS)

        bidImage.setPadding(10,10,10,10)
        bidImage.background = ContextCompat.getDrawable(this, bid.image)
        bidImage.layoutParams = params
        bidImage.elevation = 4.0f
        bidImage.text = "" + bid.value
        bidImage.gravity = Gravity.CENTER
        bidImage.setTextColor(if (blackImages.contains(bid.suit)) Color.WHITE else Color.BLACK)

        bidImage.setOnClickListener {

        }

        gridView.addView(bidImage)
    }
}