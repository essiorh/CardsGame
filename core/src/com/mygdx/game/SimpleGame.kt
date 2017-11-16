package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.TimeUtils

class SimpleGame : ApplicationAdapter() {
    private lateinit var dropImage: Texture
    private lateinit var bucketImage: Texture
    private lateinit var dropSound: Sound
    private lateinit var rainMusic: Music
    private lateinit var batch: SpriteBatch
    private lateinit var camera: OrthographicCamera
    private lateinit var bucket: Rectangle
    private lateinit var raindrops: Array<Rectangle>
    private var lastDropTime: Long = 0

    companion object {
        const val DROPLET = "droplet.png"
        const val BUCKET = "bucket.png"
        const val DROP = "drop.wav"
        const val RAIN = "rain.mp3"
    }

    override fun create() {

        dropImage = Texture(Gdx.files.internal(DROPLET))
        bucketImage = Texture(Gdx.files.internal(BUCKET))
        dropSound = Gdx.audio.newSound(Gdx.files.internal(DROP))
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal(RAIN))
        batch = SpriteBatch()
        camera = OrthographicCamera()
        bucket = Rectangle()
        raindrops = Array()

        // start the playback of the background music immediately
        rainMusic.isLooping = true
        rainMusic.play()

        // init the camera
        camera.setToOrtho(false, 800f, 480f)

        // init a Rectangle to logically represent the bucket
        bucket.x = (800 / 2 - 64 / 2).toFloat() // center the bucket horizontally
        bucket.y = 20f // bottom left corner of the bucket is 20 pixels above the bottom screen edge
        bucket.width = 64f
        bucket.height = 64f

        // spawn the first raindrop from array
        spawnRaindrop()
    }

    private fun spawnRaindrop() {
        val raindrop = Rectangle()
        raindrop.x = MathUtils.random(0, 800 - 64).toFloat()
        raindrop.y = 480f
        raindrop.width = 64f
        raindrop.height = 64f
        raindrops.add(raindrop)
        lastDropTime = TimeUtils.nanoTime()
    }

    override fun render() {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // tell the camera to update its matrices.
        camera.update()

        batch.apply {
            // tell the SpriteBatch to render in the
            // coordinate system specified by the camera.
            projectionMatrix = camera.combined

            // begin a new batch and draw the bucket and
            // all drops
            begin()
            draw(bucketImage, bucket.x, bucket.y)
            raindrops.forEach { draw(dropImage, it.x, it.y) }
            end()
        }

        // process user input
        if (Gdx.input.isTouched) {
            val touchPos = Vector3()
            touchPos.set(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 0f)
            camera.unproject(touchPos)
            bucket.x = touchPos.x - 64 / 2
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 500 * Gdx.graphics.deltaTime
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 500 * Gdx.graphics.deltaTime

        // make sure the bucket stays within the screen bounds
        if (bucket.x < 0) bucket.x = 0f
        if (bucket.x > 800 - 64) bucket.x = (800 - 64).toFloat()

        // check if we need to create a new raindrop
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop()

        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we play back
        // a sound effect as well.

        val iter = raindrops.iterator()
        while (iter.hasNext()) {
            val raindrop = iter.next()
            raindrop.y -= 200 * Gdx.graphics.deltaTime
            if (raindrop.y + 64 < 0) iter.remove()
            if (raindrop.overlaps(bucket)) {
                dropSound.play()
                iter.remove()
            }
        }
    }

    override fun dispose() {
        // dispose of all the native resources
        dropImage.dispose()
        bucketImage.dispose()
        dropSound.dispose()
        rainMusic.dispose()
        batch.dispose()
    }
}