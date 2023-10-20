package com.example.bridgeapp.modules.beginningScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.bridgeapp.R
import com.example.bridgeapp.modules.cardSelection.CardSelectionActivity

class MainActivity : ComponentActivity() {

    private val mainPresenter : MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        createStartButton()
    }

    private fun createStartButton() {
        val startButton = findViewById<Button>(R.id.start_button)
        setupStartButtonClickFunctionality(startButton)

    }

    private fun setupStartButtonClickFunctionality(startButton : Button) {
        startButton.setOnClickListener {
            val cardSelectionActivity = Intent(this, CardSelectionActivity::class.java)
            startActivity(cardSelectionActivity)
        }
    }
}

