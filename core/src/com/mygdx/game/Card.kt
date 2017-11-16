package com.mygdx.game

import com.badlogic.gdx.math.Rectangle

class Card(var hp: Int, var damage: Int) {
    var isEnemy = false
    lateinit var body: Rectangle

    fun initBody(x: Float, y: Float, width: Float, height: Float) {
        body = Rectangle(x, y, width, height)
    }

    fun moveToCenter(delta: Float) {
        if (isEnemy) {
            body.y += 10
        } else {
            body.y -= 10
        }
    }
}