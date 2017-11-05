package com.mygdx.game

import com.badlogic.gdx.Game

class MyGdxGame : Game() {

    override fun create() {
        setScreen(CardsScreen())
    }
}
