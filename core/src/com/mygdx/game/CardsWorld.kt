package com.mygdx.game

import com.badlogic.gdx.math.Rectangle

class CardsWorld {

    private val rect = Rectangle(0f, 0f, 17f, 12f)

    fun update(delta: Float) {
        rect.x++
        if (rect.x > 137) {
            rect.x = 0f
        }
    }

    fun getRect(): Rectangle {
        return rect
    }
}