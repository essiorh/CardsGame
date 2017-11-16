package com.mygdx.game

import com.badlogic.gdx.Gdx

class CardsWorld {

    private val card1  = Card(100, 10)
    private val card2  = Card(100, 10)
    private val card3  = Card(100, 10)
    private val card4  = Card(100, 10)
    private val card5  = Card(100, 10)

    private val card6  = Card(100, 10)
    private val card7  = Card(100, 10)
    private val card8  = Card(100, 10)
    private val card9  = Card(100, 10)
    private val card10 =Card(100, 10)

    init {
        card1.initBody(225f, 50f, 50f, 80f)
        card2.initBody(300f, 50f, 50f, 80f)
        card3.initBody(375f, 50f, 50f, 80f)
        card4.initBody(450f, 50f, 50f, 80f)
        card5.initBody(525f, 50f, 50f, 80f)
        card6.initBody(225f, 350f, 50f, 80f)
        card7.initBody(300f, 350f, 50f, 80f)
        card8.initBody(375f, 350f, 50f, 80f)
        card9.initBody(450f, 350f, 50f, 80f)
        card10.initBody(525f, 350f, 50f, 80f)
    }

    fun getCard1() = card1
    fun getCard2() = card2
    fun getCard3() = card4
    fun getCard4() = card5
    fun getCard5() = card3

    fun getCard6() = card6
    fun getCard7() = card7
    fun getCard8() = card8
    fun getCard9() = card9
    fun getCard10() = card10

    fun update(delta: Float) {
        if (Gdx.input.justTouched()) {
            getCard1().moveToCenter(delta)
        }
    }
}
