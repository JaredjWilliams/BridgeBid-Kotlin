package com.example.bridgeapp

import com.example.bridgeapp.enums.Player
import com.example.bridgeapp.enums.PlayingCard
import com.example.bridgeapp.enums.Suit
import com.example.bridgeapp.models.Points
import com.example.bridgeapp.modules.cardSelection.CardSelectionInterface
import com.example.bridgeapp.modules.cardSelection.CardSelectionPresenter
import com.example.bridgeapp.viewmodel_builder.PointBuilder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CardSelectionPresenterTests {


    @Mock lateinit var view: CardSelectionInterface

    private lateinit var presenter: CardSelectionPresenter
    private lateinit var pointBuilder: PointBuilder
    private lateinit var hand: List<PlayingCard>
    private lateinit var points: Points
    private var pointCount = 16

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        presenter = CardSelectionPresenter(view)

        pointBuilder = PointBuilder()
        points = Points()
        hand = listOf(
            PlayingCard.ACE_OF_CLUBS,
            PlayingCard.ACE_OF_DIAMONDS,
            PlayingCard.ACE_OF_HEARTS,
            PlayingCard.ACE_OF_SPADES,
        )


    }

    @Test
    fun `updateUser sets the users points`() {
        presenter.updateUser(hand, pointCount)

        assertEquals(Player.USER.points.highCardPoints, pointCount)
        assertEquals(Player.USER.points.distributionPoints, 8)
        assertEquals(Player.USER.points.totalPoints, 24)
    }

    @Test
    fun `userDistributionPoints returns the Users distribution points`() {
        presenter.updateUser(hand, pointCount)

        assertEquals(presenter.userDistributionPoints(), Player.USER.points.distributionPoints)
    }

    @Test
    fun `test userHandSize returns the Users hand size`() {
        presenter.updateUser(hand, pointCount)

        assertEquals(presenter.userHandSize(), Player.USER.hand.size)
    }

    @Test
    fun `test userTotalPoints returns the Users total points`() {
        presenter.updateUser(hand, pointCount)

        assertEquals(presenter.userTotalPoints(), Player.USER.points.totalPoints)
    }

    @Test
    fun `test setCurrentSuit updates the card grid layout with the selected suit`() {
        val suit = Suit.SPADES

        presenter.setCurrentSuit(suit)

        Mockito.verify(view).updateCardSelection(suit, true)
    }

    @Test
    fun `test setDealer sets the dealer to the player passed as a parameter`() {
        val player = Player.LEFT_OPPONENT

        presenter.updateDealer(player)

        assertEquals(presenter.dealer, player)
    }

    @Test
    fun `test addCardToHand adds the card that is passed as a parameter`() {
        val card = PlayingCard.ACE_OF_SPADES

        presenter.addCardToHand(card)

        assertEquals(presenter.hand.contains(card), true)
    }

    @Test
    fun `test removeCardFromHand removes the card that is passed as a parameter`() {
        val card = PlayingCard.ACE_OF_SPADES

        presenter.hand.add(PlayingCard.ACE_OF_SPADES)
        presenter.hand.add(PlayingCard.ACE_OF_HEARTS)

        presenter.removeCardFromHand(card)

        assertEquals(presenter.hand.size, 1)
        assertEquals(presenter.hand.contains(card), false)
    }

    @Test
    fun `test decreasePointCounter decreases the point counter based on the card passed in as a parameter`() {
        val card = PlayingCard.ACE_OF_SPADES

        presenter.pointCounter = 12
        presenter.decreasePointCounter(card)

        assertEquals(presenter.pointCounter, 12 - card.rank.value)
        Mockito.verify(view).setPointCounterTextView(presenter.pointCounter)
    }

    @Test
    fun `test increasePointCounter increases the point counter based on the parameter`() {
        val card = PlayingCard.ACE_OF_SPADES

        presenter.pointCounter = 12
        presenter.increasePointCounter(card)

        assertEquals(presenter.pointCounter, 12 + card.rank.value)
        Mockito.verify(view).setPointCounterTextView(presenter.pointCounter)
    }

    @Test
    fun `test updateCardCounter sets color to red if hand size is greater than 13`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES
        )
        val redColor = "#FF0000"
        Player.USER.hand = hand

        presenter.updateCardCounter()

        Mockito.verify(view).setCardCounterColor(redColor)
        assertEquals(Player.USER.hand.size, hand.size)
    }

    @Test
    fun `test updateCardCounter sets color to green when hand size is equal to 13`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
        )
        val greenColor = "#008000"

        Player.USER.hand = hand

        presenter.updateCardCounter()

        Mockito.verify(view).setCardCounterColor(greenColor)
        assertEquals(Player.USER.hand.size, hand.size)
    }

    @Test
    fun `test updateCardCounter sets color to black when size is less than 13`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES
        )
        val blackColor = "#000000"

        Player.USER.hand = hand

        presenter.updateCardCounter()

        Mockito.verify(view).setCardCounterColor(blackColor)
        assertEquals(Player.USER.hand.size, hand.size)
    }


    // WHEN : A dealer has been selected
    // AND : The user hand size is equal to 13
    // RESULT : next button is enabled
    @Test
    fun `test updateNextButton enables next button`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
        )

        presenter.dealer = Player.USER
        Player.USER.hand = hand

        presenter.updateNextButton()

        Mockito.verify(view).enabledNextButton(true)
        assertNotEquals(presenter.dealer, null)
    }

    // WHEN : A dealer is not selected
    // AND : The users hand size is equal to 13
    // RESULT : next button is disabled
    @Test
    fun `test updateNextButton disabled next button when no dealer`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
        )

        Player.USER.hand = hand

        presenter.updateNextButton()

        Mockito.verify(view).enabledNextButton(false)
        assertEquals(presenter.dealer, null)
    }

    // WHEN : A dealer has been selected
    // AND : the users hand size is less than 13
    // RESULT : next button is disabled
    @Test
    fun `test updateNextButton disables next button when hand size is less than 13`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES
        )

        presenter.dealer = Player.USER
        Player.USER.hand = hand

        presenter.updateNextButton()

        Mockito.verify(view).enabledNextButton(false)
        assertNotEquals(presenter.dealer, null)
    }

    // WHEN : A dealer has been selected
    // AND : the user hand size is more than 13
    // RESULT : next button is disabled
    @Test
    fun `test updateNextButton disables next button when hand size too large`() {
        val hand = listOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES
        )

        presenter.dealer = Player.USER
        Player.USER.hand = hand

        presenter.updateNextButton()

        Mockito.verify(view).enabledNextButton(false)
        assertEquals(presenter.dealer, Player.USER)
    }

    @Test
    fun `test updatePointViews updates the User and any point views`() {
        val hand = mutableListOf<PlayingCard>(PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES, PlayingCard.ACE_OF_SPADES,
            PlayingCard.ACE_OF_SPADES
        )
        presenter.hand = hand
        presenter.pointCounter = 12

        presenter.updatePointViews()

        assertEquals(Player.USER.points.highCardPoints, 12)
        Mockito.verify(view).setDistributionCountTextView(Player.USER.points.distributionPoints!!)
        Mockito.verify(view).setTotalPointCounterTextView(Player.USER.points.totalPoints!!)
        Mockito.verify(view).setCardCounterTextView(Player.USER.hand.size)
        Mockito.verify(view).setPointCounterTextView(presenter.pointCounter)

    }
}