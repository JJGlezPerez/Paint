package com.examen.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.examen.paint.MainActivity.Companion.paintBrush
import com.examen.paint.MainActivity.Companion.path

class PaintView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    var params: ViewGroup.LayoutParams? = null

    companion object {
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.RED
    }

    init {
        paintBrush.isAntiAlias = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 15f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                pathList.add(Path(path)) // Clona el Path para evitar que todos los trazos cambien juntos
                colorList.add(currentBrush)
            }
            else -> return false
        }

        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for (i in pathList.indices) {
            paintBrush.color = colorList[i]
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()
        }
    }

    fun changeBrushColor(color: Int) {
        currentBrush = color
        paintBrush.color = currentBrush
    }
}