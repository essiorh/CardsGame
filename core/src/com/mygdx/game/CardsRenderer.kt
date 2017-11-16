package com.mygdx.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class CardsRenderer(private val myWorld: CardsWorld) {

    private val shapeRenderer = ShapeRenderer()
    private val cam = OrthographicCamera()

    init {
        cam.setToOrtho(true, 800f, 480f)
        shapeRenderer.projectionMatrix = cam.combined
    }

    fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // Говорим shapeRenderer начинать отрисовывать формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        // Выбираем RGB Color 87, 109, 120, не прозрачный
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1f)
        // Отрисовываем квадрат из myWorld (Используем ShapeType.Filled)
        shapeRenderer.rect(myWorld.getCard1().body.x, myWorld.getCard1().body.y, myWorld.getCard1().body.width, myWorld.getCard1().body.height)
        shapeRenderer.rect(myWorld.getCard2().body.x, myWorld.getCard2().body.y, myWorld.getCard2().body.width, myWorld.getCard2().body.height)
        shapeRenderer.rect(myWorld.getCard3().body.x, myWorld.getCard3().body.y, myWorld.getCard3().body.width, myWorld.getCard3().body.height)
        shapeRenderer.rect(myWorld.getCard4().body.x, myWorld.getCard4().body.y, myWorld.getCard4().body.width, myWorld.getCard4().body.height)
        shapeRenderer.rect(myWorld.getCard5().body.x, myWorld.getCard5().body.y, myWorld.getCard5().body.width, myWorld.getCard5().body.height)

        shapeRenderer.rect(myWorld.getCard6().body.x, myWorld.getCard6().body.y, myWorld.getCard6().body.width, myWorld.getCard6().body.height)
        shapeRenderer.rect(myWorld.getCard7().body.x, myWorld.getCard7().body.y, myWorld.getCard7().body.width, myWorld.getCard7().body.height)
        shapeRenderer.rect(myWorld.getCard8().body.x, myWorld.getCard8().body.y, myWorld.getCard8().body.width, myWorld.getCard8().body.height)
        shapeRenderer.rect(myWorld.getCard9().body.x, myWorld.getCard9().body.y, myWorld.getCard9().body.width, myWorld.getCard9().body.height)
        shapeRenderer.rect(myWorld.getCard10().body.x, myWorld.getCard10().body.y, myWorld.getCard10().body.width, myWorld.getCard10().body.height)

        // говорим shapeRenderer прекратить отрисовку
        // Мы ДОЛЖНЫ каждый раз это делать
        shapeRenderer.end()


        /*
         * 3. Мы отрисовываем рамку для квадрата
         */
//
//        // Говорим shapeRenderer нарисовать рамку следующей формы
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
//        // Выбираем цвет RGB Color 255, 109, 120, не прозрачный
//        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1f)
//        // Отрисовываем квадрат из myWorld (Using ShapeType.Line)
//        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
//                myWorld.getRect().width, myWorld.getRect().height)
//        shapeRenderer.end()
    }
}