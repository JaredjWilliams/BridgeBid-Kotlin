package com.example.bridgeapp.modules.cardSelection

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.bridgeapp.R
import com.example.bridgeapp.enums.Player
import com.example.bridgeapp.enums.PlayingCard
import com.example.bridgeapp.enums.Suit
import com.example.bridgeapp.modules.bidscreen.BidScreenActivity

class CardSelectionActivity : ComponentActivity(), CardSelectionInterface {

    private var cards = enumValues<PlayingCard>()
    private var currentSuit = Suit.CLUBS

    private lateinit var distributionCounterTextView: TextView
    private lateinit var totalPointCounterTextView: TextView
    private lateinit var presenter : CardSelectionPresenter
    private lateinit var rightOppRadioButton: RadioButton
    private lateinit var pointCounterTextView : TextView
    private lateinit var partnerRadioButton: RadioButton
    private lateinit var leftOppRadioButton: RadioButton
    private lateinit var cardCounterTextView: TextView
    private lateinit var userRadioButton: RadioButton
    private lateinit var cardSelection : GridLayout
    private lateinit var nextButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter()

        setContentView(R.layout.activity_card_selection)

        setViews()

        updateCardSelection(currentSuit, false)

        initializeSuitLayout()
        initializeRadioButtons()
        initializeNextButton()

        presenter.updatePointViews()
    }

    private fun getPresenter() {
        presenter = CardSelectionPresenter(this)
    }

    private fun setViews() {
        distributionCounterTextView = findViewById(R.id.distribution_counter)
        totalPointCounterTextView = findViewById(R.id.total_point_counter)
        rightOppRadioButton = findViewById(R.id.right_opp_radio_button)
        leftOppRadioButton = findViewById(R.id.left_opp_radio_button)
        partnerRadioButton = findViewById(R.id.partner_radio_button)
        pointCounterTextView = findViewById(R.id.point_counter)
        userRadioButton = findViewById(R.id.user_radio_button)
        cardCounterTextView = findViewById(R.id.card_counter)
        cardSelection = findViewById(R.id.card_selection)
        nextButton = findViewById(R.id.next_button)
    }

    override fun updateCardSelection(suit: Suit, update: Boolean) {
        val params = ViewGroup.MarginLayoutParams(324, 424)
        params.setMargins(10, 10, 10, 10)

        if (update) {
            cardSelection.removeAllViews()
        }

        cards.forEach { card ->
            when (suit) {
                card.suit -> initializeCard(cardSelection, params, card)
                else -> {}
            }
        }
    }

    private fun initializeCard(cardSelection : GridLayout?, params: ViewGroup.LayoutParams, card: PlayingCard) {
        var cardImage = ImageView(this)

        cardImage.setBackgroundResource(if (card.selected) R.drawable.selected_card_background else 0)
        cardImage.setPadding(10,10,10,10)
        cardImage.setImageResource(card.image)
        cardImage.layoutParams = params
        cardImage.elevation = 4.0f

        cardImage.setOnClickListener {
            cardImage = presenter.onCardPressed(cardImage, card)
        }

        cardSelection?.addView(cardImage)
    }

    override fun setTotalPointCounterTextView(count: Int) {
        totalPointCounterTextView.text = "Total points: $count"
    }

    override fun enabledNextButton(isEnabled: Boolean) {
        nextButton.isEnabled = isEnabled
    }

    override fun setPointCounterTextView(count: Int) {
        pointCounterTextView.text = "Current HCP: $count"
    }

    override fun setCardCounterColor(color: String) {
        cardCounterTextView.setTextColor(Color.parseColor(color))
    }

    override fun setCardCounterTextView(count: Int) {
        cardCounterTextView.text = "Cards Selected: $count"
    }

    override fun setDistributionCountTextView(count: Int) {
        distributionCounterTextView.text = "Current distribution count: $count"
    }

    private fun initializeSuitLayout() {
        initializeSuitSelectionImage(R.id.club_suit, R.drawable.card_suit_clubs, Suit.CLUBS)
        initializeSuitSelectionImage(R.id.diamond_suit, R.drawable.card_suit_diamonds, Suit.DIAMONDS)
        initializeSuitSelectionImage(R.id.heart_suit, R.drawable.card_suit_heats, Suit.HEARTS)
        initializeSuitSelectionImage(R.id.spade_suit, R.drawable.card_suit_spades, Suit.SPADES)
    }

    private fun initializeRadioButtons() {
        initializeRadioButton(rightOppRadioButton, Player.RIGHT_OPPONENT)
        initializeRadioButton(leftOppRadioButton, Player.LEFT_OPPONENT)
        initializeRadioButton(partnerRadioButton, Player.PARTNER)
        initializeRadioButton(userRadioButton, Player.USER)
    }

    private fun initializeRadioButton(button: RadioButton, player: Player) {
        button.setOnClickListener {
            presenter.updateDealer(player)
            presenter.updateNextButton()
        }
    }

    private fun initializeNextButton() {
        nextButton.setOnClickListener {
            val bidScreenActivity = Intent(this, BidScreenActivity::class.java)
            bidScreenActivity.putExtra("gameObjectAsString", presenter.gameToGSON())
            startActivity(bidScreenActivity)
        }
    }

    private fun initializeSuitSelectionImage(id : Int, image : Int, suit: Suit) {
        val suitImage = findViewById<ImageView>(id)

        suitImage.setImageResource(image)
        suitImage.setOnClickListener { onSuitClicked(suit) }
    }

    private fun onSuitClicked(suit: Suit) {
        presenter.setCurrentSuit(suit)
    }

}