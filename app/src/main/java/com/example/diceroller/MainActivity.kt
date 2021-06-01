package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // My Code starts here
        val rollButton: Button = findViewById(R.id.button_roll)
        rollButton.setOnClickListener { rollDice() }

        // Do a rollDice when the app starts
        rollDice()

    }

    private fun rollDice() {
        // Create a Dice object and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)

        // select the image that corresponcds with the value of diceRoll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // update the correct image to display
        diceImage.setImageResource(drawableResource)
        
        // to facilitate screen reading, must give content description to images
        diceImage.contentDescription = diceRoll.toString()
    }
}
// The Dice Class takes number of sides as argument
// returns a random number
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}