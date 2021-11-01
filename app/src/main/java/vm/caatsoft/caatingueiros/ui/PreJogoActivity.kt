package vm.caatsoft.caatingueiros.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.View.*
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import vm.caatsoft.caatingueiros.R
import vm.caatsoft.caatingueiros.databinding.PopupConfiguracoesBinding
import vm.caatsoft.caatingueiros.ui.game_cidade.*
import vm.caatsoft.caatingueiros.utils.displaymetrics
import vm.caatsoft.caatingueiros.utils.tocarSomMedia
import java.util.*

class PreJogoActivity : AppCompatActivity() {

    var textView: TextView? = null
    var iv_wheel: ImageView? = null
    var iv_wheel2: ImageView? = null
    var settingImage: ImageView? = null
    var random1: Random? = null
    var degree = 0
    var degree_old = 0
    var vindo = 0
    var ligaSom = 1
    var settings: SharedPreferences? = null
    var guardarSom= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_jogo_roleta)
        textView = findViewById<View>(R.id.textView3) as TextView
        iv_wheel = findViewById<View>(R.id.imageViewObjeto) as ImageView
        iv_wheel2 = findViewById<View>(R.id.imageViewObjeto2) as ImageView
        settingImage = findViewById<View>(R.id.somImageView) as ImageView

        vindo = intent.getIntExtra("VINDO", 0)
        if (vindo == 0) {
            tocarSomMedia(1, true, this)
            tocarSomMedia(2, true, this)
            settings = getSharedPreferences("som", Context.MODE_PRIVATE)
            guardarSom = settings!!.getInt("guardarSom", 1)
            settingImage!!.setOnClickListener {
                settings()
            }
            roleta()
        } else {
            finish()
        }
    }

    fun roleta (){
        iv_wheel!!.visibility = VISIBLE
        textView!!.text = ""
        random1 = Random()
        iv_wheel!!.setOnClickListener {
            rodarRoleta()
        }
    }

    fun roleta2 (){
        iv_wheel!!.visibility = VISIBLE
        iv_wheel!!.setImageResource(R.drawable.roulette_monster)
        iv_wheel2!!.visibility = INVISIBLE
        textView!!.text = ""
        random1 = Random()
        rodarRoleta()
    }

    private fun currentNumber(degrees: Int): String {
        var text = ""
        iv_wheel2!!.visibility = VISIBLE
        iv_wheel!!.setImageResource(R.drawable.a_a_transparente)
        iv_wheel!!.visibility = INVISIBLE

        if (degrees >= FACTOR * 5 && degrees < FACTOR * 6) { // Esse é o 1
            Toast.makeText(this@PreJogoActivity, getString(R.string.clique_na_roleta), Toast.LENGTH_LONG).show()
            text = "QUEIXADA" //1
            iv_wheel2!!.setOnClickListener {
                val intent = Intent(this@PreJogoActivity, GameQueixadaActivity::class.java)
                startActivity(intent)
            }
            iv_wheel2!!.setImageResource(R.drawable.ic_queixada)
        }
        else if (degrees >= FACTOR * 6 && degrees < 360 || degrees >= 0 && degrees < FACTOR * 1) { //Esse é o 6 //
            Toast.makeText(this@PreJogoActivity, getString(R.string.clique_na_roleta), Toast.LENGTH_LONG).show()
            text = "SACÍ" //2
            iv_wheel2!!.setOnClickListener {
                val intent = Intent(this@PreJogoActivity, GameSaciActivity::class.java)
                startActivity(intent)
            }
            iv_wheel2!!.setImageResource(R.drawable.ic_saci)

        } else if (degrees >= FACTOR * 1 && degrees < FACTOR * 2) { // Esse é o 5
            Toast.makeText(this@PreJogoActivity, getString(R.string.clique_na_roleta), Toast.LENGTH_LONG).show()
            text = "CURUPIRA" //3
            iv_wheel2!!.setOnClickListener {
                val intent = Intent(this@PreJogoActivity, GameCurupiraActivity::class.java)
                startActivity(intent)
            }
            iv_wheel2!!.setImageResource(R.drawable.ic_curupira)

        } else if (degrees >= FACTOR * 2 && degrees < FACTOR * 3) { // Esse é o 4
            Toast.makeText(this@PreJogoActivity, getString(R.string.clique_na_roleta), Toast.LENGTH_LONG).show()
            text = "BERRADOR" //4
            iv_wheel2!!.setOnClickListener {
                val intent = Intent(this@PreJogoActivity, GameBerradorActivity::class.java)
                startActivity(intent)
            }
            iv_wheel2!!.setImageResource(R.drawable.ic_berrador)


        } else if (degrees >= FACTOR * 3 && degrees < FACTOR * 4) { // Esse é o 3
            Toast.makeText(this@PreJogoActivity, getString(R.string.clique_na_roleta), Toast.LENGTH_LONG).show()
            text = "MULA SEM CABEÇA" //5
            iv_wheel2!!.setOnClickListener {
                val intent = Intent(this@PreJogoActivity, GameMulaActivity::class.java)
                startActivity(intent)
            }
            iv_wheel2!!.setImageResource(R.drawable.ic_mula)

        } else if (degrees >= FACTOR * 4 && degrees < FACTOR * 5) { // Esse é o 2
            Toast.makeText(this@PreJogoActivity, getString(R.string.clique_na_roleta), Toast.LENGTH_LONG).show()
            text = "BOITATÁ" //6
            iv_wheel2!!.setOnClickListener {
                val intent = Intent(this@PreJogoActivity, GameBoitataActivity::class.java)
                startActivity(intent)
            }
            iv_wheel2!!.setImageResource(R.drawable.ic_boitata)
        } else {
            roleta2()
        }
        return text
    }

    companion object {
        private const val FACTOR = 360f / 6f
    }

    fun rodarRoleta (){
        degree_old = degree % 360
        degree = random1!!.nextInt(360) + 2880
        val rotate = RotateAnimation(degree_old.toFloat(), degree.toFloat(),
                RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 3600
        rotate.fillAfter = true
        rotate.interpolator = DecelerateInterpolator()
        rotate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                textView!!.text = ""
            }

            override fun onAnimationEnd(animation: Animation) {
                textView!!.text = currentNumber(360 - degree % 360)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        iv_wheel!!.startAnimation(rotate)
    }

    override fun onDestroy() {
        tocarSomMedia(4, false, this)
        tocarSomMedia(4, false, this)
        super.onDestroy()
    }

    fun settings() {
        val popupConfiguracoesBinding = PopupConfiguracoesBinding.inflate(layoutInflater)
        val dialog2 = Dialog (this)
        dialog2.setContentView(popupConfiguracoesBinding.root)

        if (guardarSom == 2){
            popupConfiguracoesBinding.imageSom.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
        } else{
            popupConfiguracoesBinding.imageSom.setImageResource(R.drawable.ic_baseline_play_circle_filled_24_on)
        }

        popupConfiguracoesBinding.sair.setOnClickListener {
            dialog2.dismiss()
        }
        popupConfiguracoesBinding.imageSom.setOnClickListener {
            if (guardarSom == 1){
                tocarSomMedia(1, false, this)
                tocarSomMedia(2, false, this)
                ligaSom = 2
                guardarSom = ligaSom
                popupConfiguracoesBinding.imageSom.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
                val editor = settings!!.edit()
                editor.putInt("guardarSom", guardarSom)
                editor.apply()
            } else{
                ligaSom = 1
                guardarSom = ligaSom
                popupConfiguracoesBinding.imageSom.setImageResource(R.drawable.ic_baseline_play_circle_filled_24_on)
                val editor = settings!!.edit()
                editor.putInt("guardarSom", guardarSom)
                editor.apply()
                tocarSomMedia(1, true, this)
                tocarSomMedia(2, true, this)
            }
        }

        val layoutParams = WindowManager.LayoutParams()
        val windowAlDl: Window = dialog2.window!!
        layoutParams.width = (displaymetrics().width*0.95).toInt()
        layoutParams.height = (displaymetrics().height*0.85).toInt()
        windowAlDl.attributes = layoutParams
        dialog2.setCancelable(false)
        dialog2.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog2.show()
    }
}