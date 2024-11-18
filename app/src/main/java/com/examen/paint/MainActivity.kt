package com.examen.paint

import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.examen.paint.PaintView.Companion.colorList
import com.examen.paint.PaintView.Companion.currentBrush
import com.examen.paint.PaintView.Companion.pathList


class MainActivity : ComponentActivity() {

    companion object {
        var path = Path()
        var paintBrush = Paint()
        //var currentBrushColor = paintBrush.color
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        // Referencias a los botones
        val redButton = findViewById<ImageButton>(R.id.color_red)
        val eraserButton = findViewById<ImageButton>(R.id.goma)
        val blueButton = findViewById<ImageButton>(R.id.color_blue)
        val blackButton = findViewById<ImageButton>(R.id.color_black)
        val brownButton = findViewById<ImageButton>(R.id.color_brown)
        val eraser = findViewById<ImageButton>(R.id.eraseAll)

        redButton.setOnClickListener {
            currentBrush = resources.getColor(R.color.red, theme)
            paintBrush.color = currentBrush
            path= Path()
        }

        eraserButton.setOnClickListener {
            currentBrush = resources.getColor(android.R.color.white, theme)
            paintBrush.color = currentBrush
            path= Path()
        }

        blueButton.setOnClickListener {
            currentBrush = resources.getColor(R.color.blue, theme)
            paintBrush.color = currentBrush
            path= Path()
        }

        blackButton.setOnClickListener {
            currentBrush = resources.getColor(R.color.black, theme)
            paintBrush.color = currentBrush
            path= Path()
        }

        brownButton.setOnClickListener {
            currentBrush = resources.getColor(R.color.brown, theme)
            paintBrush.color = currentBrush
            path= Path()
        }
        eraser.setOnClickListener {
            pathList.clear()
            colorList.clear()
            path.reset()
        }

    }
}