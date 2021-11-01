package vm.caatsoft.caatingueiros.utils

import android.app.Activity
import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Adapter
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import vm.caatsoft.caatingueiros.R
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt
import android.media.AudioAttributes
import android.media.MediaPlayer

import android.os.Build
import java.io.IOException
import java.lang.Exception


fun Fragment.tocarSomMedia(som: Int, ligado: Boolean, context: Context) {

    val asa_branca = MediaPlayer.create(context, R.raw.asa_branca)
    val fundo = MediaPlayer.create(context, R.raw.musica_inicio)
    val fundoGame = MediaPlayer.create(context, R.raw.background_game)

    if (som == 1){
        if (ligado) {
            asa_branca?.start()
        } else {
            asa_branca?.pause()
        }
    }else if (som == 2){
        if (ligado) {
            fundo?.start()
            fundo.isLooping = true
        } else {
            fundo.isLooping = false
            fundo?.stop()
        }
    } else if (som == 3){
        if (ligado) {
            fundoGame?.start()
            fundoGame.isLooping = true
        } else {
            fundoGame?.pause()
        }
    }
}

fun Activity.tocarSomMedia(som: Int, ligado: Boolean, context: Context) {

    val asa_branca = MediaPlayer.create(context, R.raw.asa_branca)
    val fundo = MediaPlayer.create(context, R.raw.musica_inicio)
    val fundoGame = MediaPlayer.create(context, R.raw.background_game)

    val settings = getSharedPreferences("som", Context.MODE_PRIVATE)
    val guardarSom = settings.getInt("guardarSom", 1)

    val editor = settings.edit()
    editor.putInt("guardarSom", guardarSom)
    editor.apply()

    if (guardarSom == 1) {
        if (som == 1) {
            if (ligado) {
                asa_branca?.start()
            } else {
                asa_branca?.pause()
            }
        } else if (som == 2) {
            if (ligado) {
                fundo?.start()
                fundo.isLooping = true
            } else {
                fundo.isLooping = false
                fundo?.pause()
            }
        } else if (som == 3) {
            if (ligado) {
                fundoGame?.start()
                fundoGame.isLooping = true
            } else {
                fundoGame.isLooping = false
                fundoGame?.pause()
            }
        } else if (som == 4) {
            asa_branca?.stop()
            fundo?.stop()
            fundoGame?.stop()
        }
    }
}

fun Activity.pontoSomMedia( ligado: Boolean, context: Context) {

    val ponto = MediaPlayer.create(context, R.raw.pontos)

    val settings = getSharedPreferences("som", Context.MODE_PRIVATE)
    val guardarSom = settings.getInt("guardarSom", 1)

    val editor = settings.edit()
    editor.putInt("guardarSom", guardarSom)
    editor.apply()

    if (guardarSom == 1){
        if (ligado) {
            ponto?.start()
        } else {
            ponto?.pause()
        }
    }
}

