package vm.caatsoft.caatingueiros.mecanica_de_jogo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

class JoyStickClass(
    private val mContext: Context,
    layout: ViewGroup,
    stick_res_id: Int
) {
    private var STICK_ALPHA = 200
    private var LAYOUT_ALPHA = 200
    var offset = 0
    private val mLayout: ViewGroup
    private val params: ViewGroup.LayoutParams
    private var stick_width: Int
    private var stick_height: Int
    private var position_x = 0
    private var position_y = 0
    var minimumDistance = 0
    private var distance = 0f
    private var angle = 0f
    private val draw: DrawCanvas
    private val paint: Paint
    private var stick: Bitmap
    private var touch_state = false
    fun drawStick(arg1: MotionEvent) {
        position_x = (arg1.x - params.width / 2).toInt()
        position_y = (arg1.y - params.height / 2).toInt()
        distance = Math.sqrt(
            Math.pow(
                position_x.toDouble(),
                2.0
            ) + Math.pow(
                position_y.toDouble(),
                2.0
            )
        ).toFloat()
        angle = cal_angle(position_x.toFloat(), position_y.toFloat()).toFloat()
        if (arg1.action == MotionEvent.ACTION_DOWN) {
            if (distance <= params.width / 2 - offset) {
                draw.position(arg1.x, arg1.y)
                draw()
                touch_state = true
            }
        } else if (arg1.action == MotionEvent.ACTION_MOVE && touch_state) {
            if (distance <= params.width / 2 - offset) {
                draw.position(arg1.x, arg1.y)
                draw()
            } else if (distance > params.width / 2 - offset) {
                var x = (Math.cos(
                    Math.toRadians(
                        cal_angle(
                            position_x.toFloat(),
                            position_y.toFloat()
                        )
                    )
                ) * (params.width / 2 - offset)).toFloat()
                var y = (Math.sin(
                    Math.toRadians(
                        cal_angle(
                            position_x.toFloat(),
                            position_y.toFloat()
                        )
                    )
                ) * (params.height / 2 - offset)).toFloat()
                x += (params.width / 2).toFloat()
                y += (params.height / 2).toFloat()
                draw.position(x, y)
                draw()
            } else {
                mLayout.removeView(draw)
            }
        } else if (arg1.action == MotionEvent.ACTION_UP) {
            mLayout.removeView(draw)
            touch_state = false
        }
    }

    val position: IntArray
        get() = if (distance > minimumDistance && touch_state) {
            intArrayOf(position_x, position_y)
        } else intArrayOf(0, 0)

    val x: Int
        get() = if (distance > minimumDistance && touch_state) {
            position_x
        } else 0

    val y: Int
        get() = if (distance > minimumDistance && touch_state) {
            position_y
        } else 0

    fun getAngle(): Float {
        return if (distance > minimumDistance && touch_state) {
            angle
        } else 0F
    }

    fun getDistance(): Float {
        return if (distance > minimumDistance && touch_state) {
            distance
        } else 0F
    }

    fun get8Direction(): Int {
        if (distance > minimumDistance && touch_state) {
            if (angle >= 247.5 && angle < 292.5) {
                return STICK_UP
            } else if (angle >= 292.5 && angle < 337.5) {
                return STICK_UPRIGHT
            } else if (angle >= 337.5 || angle < 22.5) {
                return STICK_RIGHT
            } else if (angle >= 22.5 && angle < 67.5) {
                return STICK_DOWNRIGHT
            } else if (angle >= 67.5 && angle < 112.5) {
                return STICK_DOWN
            } else if (angle >= 112.5 && angle < 157.5) {
                return STICK_DOWNLEFT
            } else if (angle >= 157.5 && angle < 202.5) {
                return STICK_LEFT
            } else if (angle >= 202.5 && angle < 247.5) {
                return STICK_UPLEFT
            }
        } else if (distance <= minimumDistance && touch_state) {
            return STICK_NONE
        }
        return 0
    }

    fun get4Direction(): Int {
        if (distance > minimumDistance && touch_state) {
            if (angle >= 225 && angle < 315) {
                return STICK_UP
            } else if (angle >= 315 || angle < 45) {
                return STICK_RIGHT
            } else if (angle >= 45 && angle < 135) {
                return STICK_DOWN
            } else if (angle >= 135 && angle < 225) {
                return STICK_LEFT
            }
        } else if (distance <= minimumDistance && touch_state) {
            return STICK_NONE
        }
        return 0
    }

    var stickAlpha: Int
        get() = STICK_ALPHA
        set(alpha) {
            STICK_ALPHA = alpha
            paint.alpha = alpha
        }

    var layoutAlpha: Int
        get() = LAYOUT_ALPHA
        set(alpha) {
            LAYOUT_ALPHA = alpha
            mLayout.background.alpha = alpha
        }

    fun setStickSize(width: Int, height: Int) {
        stick = Bitmap.createScaledBitmap(stick, width, height, false)
        stick_width = stick.width
        stick_height = stick.height
    }

    var stickWidth: Int
        get() = stick_width
        set(width) {
            stick = Bitmap.createScaledBitmap(stick, width, stick_height, false)
            stick_width = stick.width
        }

    var stickHeight: Int
        get() = stick_height
        set(height) {
            stick = Bitmap.createScaledBitmap(stick, stick_width, height, false)
            stick_height = stick.height
        }

    fun setLayoutSize(width: Int, height: Int) {
        params.width = width
        params.height = height
    }

    val layoutWidth: Int
        get() = params.width

    val layoutHeight: Int
        get() = params.height

    private fun cal_angle(x: Float, y: Float): Double {
        if (x >= 0 && y >= 0) return Math.toDegrees(Math.atan(y / x.toDouble())) else if (x < 0 && y >= 0) return Math.toDegrees(
            Math.atan(y / x.toDouble())
        ) + 180 else if (x < 0 && y < 0) return Math.toDegrees(Math.atan(y / x.toDouble())) + 180 else if (x >= 0 && y < 0) return Math.toDegrees(
            Math.atan(y / x.toDouble())
        ) + 360
        return 0.0
    }

    private fun draw() {
        try {
            mLayout.removeView(draw)
        } catch (e: Exception) {
        }
        mLayout.addView(draw)
    }

    private inner class DrawCanvas(mContext: Context) :
        View(mContext) {
        var xi = 0f
        var yi = 0f
        public override fun onDraw(canvas: Canvas) {
            canvas.drawBitmap(stick, xi, yi, paint)
        }

        fun position(pos_x: Float, pos_y: Float) {
            xi = pos_x - stick_width / 2
            yi = pos_y - stick_height / 2
        }
    }

    companion object {
        const val STICK_NONE = 0
        const val STICK_UP = 1
        const val STICK_UPRIGHT = 2
        const val STICK_RIGHT = 3
        const val STICK_DOWNRIGHT = 4
        const val STICK_DOWN = 5
        const val STICK_DOWNLEFT = 6
        const val STICK_LEFT = 7
        const val STICK_UPLEFT = 8
    }

    init {
        stick = BitmapFactory.decodeResource(
            mContext.resources,
            stick_res_id
        )
        stick_width = stick.width
        stick_height = stick.height
        draw = DrawCanvas(mContext)
        paint = Paint()
        mLayout = layout
        params = mLayout.layoutParams
    }
}