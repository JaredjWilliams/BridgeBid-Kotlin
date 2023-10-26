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
import android.util.Log
import com.example.bridgeapp.models.Game

class BidScreenActivity : ComponentActivity(), BidScreenInterface {
    private fun retrieveGameFromGSON() {
        val gameJson = intent.getStringExtra("gameObjectAsString")

        if (gameJson != null) {
            val gameObject = Game.fromJson(gameJson)
            game = gameObject
        }
    }

    private lateinit var gridView : GridLayout
    private lateinit var currentPlayer : TextView
    private lateinit var presenter: BidScreenPresenter

    var game : Game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter()
        retrieveGameFromGSON()

        setContentView(R.layout.activity_bid_screen)

        setView()

        initializeViews()
    }

    private fun getPresenter() {
        presenter = BidScreenPresenter()
    }

    private fun setView() {
        gridView = findViewById(R.id.bid_grid_view)
        currentPlayer = findViewById(R.id.current_player)

    }

    private fun initializeViews() {
        createCurrentPlayerText(game)
        initializeBidGridView()
    }

    private fun createCurrentPlayerText(game: Game) {
        currentPlayer.text = presenter.setPlayerBidText(game.currentPlayerTurn)
    }

    private fun initializeBidGridView() {
        var bids = enumValues<Bid>()
        val params = ViewGroup.MarginLayoutParams(200, 200)
        params.setMargins(10, 10, 10, 10)

        bids.forEach { bid: Bid ->
            initializeBidCard(bid, params)
        }
    }

    private fun initializeBidCard(bid: Bid, params: ViewGroup.LayoutParams) {
        val bidImage = TextView(this)

        bidImage.setPadding(10,10,10,10)
        bidImage.background = ContextCompat.getDrawable(this, bid.image)
        bidImage.layoutParams = params
        bidImage.elevation = 4.0f
        bidImage.text = bid.label
        bidImage.gravity = Gravity.CENTER
        bidImage.setTextColor(bid.color)

        bidImage.setOnClickListener {

        }

        gridView.addView(bidImage)
    }
}