package com.mygdx.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen

class CardsScreen : Screen {

    private val world = CardsWorld()
    private val render = CardsRenderer(world)

    override fun hide() {}

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.app.log("fps", (1 / delta).toString())
        world.update(delta)
        render.render()
    }

    override fun pause() {}

    override fun resume() {}

    override fun resize(width: Int, height: Int) {}

    override fun dispose() {}

}