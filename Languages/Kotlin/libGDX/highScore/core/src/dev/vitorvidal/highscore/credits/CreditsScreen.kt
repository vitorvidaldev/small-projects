package dev.vitorvidal.highscore.credits

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.FrameBuffer
import com.badlogic.gdx.graphics.glutils.ShaderProgram
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.I18NBundle
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class CreditsScreen(val assets: AssetManager) : ScreenAdapter() {

    private lateinit var viewport: Viewport
    private lateinit var fixedViewport: Viewport
    private lateinit var stage: Stage
    private lateinit var zeMap: OrthogonalTiledMapRenderer
    private lateinit var batch: SpriteBatch

    private lateinit var frameBuffer: FrameBuffer

    private lateinit var shader: ShaderProgram
    private lateinit var alpha: (Float) -> Float

    private lateinit var labelTxt: Label

    override fun show() {
        info { "Clean input processor" }
        Gdx.input.inputProcessor = null

        info { "Loading Title screen" }

        info { "Create Fields objects" }
        batch = SpriteBatch()
        viewport = FitViewport(screenWidth, screenHeight)
        viewport.centerCamera()

        fixedViewport = FitViewport(screenWidth, screenHeight)
        fixedViewport.centerCamera()

        stage = Stage(fixedViewport, batch)
        info { "Load background map" }
        val tmxMap = TmxMapLoader().load("credit.tmx")
        zeMap = OrthogonalTiledMapRenderer(tmxMap)

        info { "Creating scene2D" }
        val root = container {
            setSize(screenWidth, screenHeight)
            setPosition(0f, 0f)
            val i18n: I18NBundle = assets["i18n/messages"]
            align(Align.top)
            padTop(30f)
            verticalGroup {

                label(i18n["credit.text"]) {
                    setSize(screenWidth, screenHeight)
                    setWrap(true)
                    setAlignment(Align.top)
                    setPosition(0f, 0f)
                }
                space(8f)
                textButton(i18n["credit.author"]) {
                    setSize(screenWith, screenHeight)
                    setPosition(0f, 0f)
                    addListener(object: ClickListener() {
                        override fun clicked(event: InputEvent?, x: Float, y: Float) {
                            Gdx.net.openURI("https://twitter.com")
                        }
                    })
                }
            }
        }

        stage.addActor(root)
        stage.isDebugAll = Config.scene2d
        stage.addListener(
            object : ClickListener() {
                override fun clicked(event: InputEvent?, x: Float, y: Float) {
                    HighScore.title()
                }
            }
        )
        Gdx.input.inputProcessor = stage
    }
}