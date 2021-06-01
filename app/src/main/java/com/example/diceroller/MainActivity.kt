package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // My Code starts here
        val rollButton: Button = findViewById(R.id.button_roll)
        rollButton.setOnClickListener {
            rollDice()
            //val toast1 = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
            //toast1.show()
        }

    }

    private fun rollDice() {
        // Create a Dice object and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Update the screen with the value of the dice
        val resultText: TextView = findViewById(R.id.textView)
        resultText.text = diceRoll.toString()

    }
}
// The Dice Class takes number of sides as argument
// returns a random number
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}