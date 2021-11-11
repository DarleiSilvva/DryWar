package vm.caatsoft.caatingueiros.ui.game_cidade

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import vm.caatsoft.caatingueiros.mecanica_de_jogo.JoyStickClass
import vm.caatsoft.caatingueiros.R
import vm.caatsoft.caatingueiros.databinding.*
import vm.caatsoft.caatingueiros.utils.displaymetrics
import vm.caatsoft.caatingueiros.utils.pontoSomMedia
import vm.caatsoft.caatingueiros.utils.tocarSomMedia
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import java.util.concurrent.TimeUnit

class GameQueixadaActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    // Frame
    private var posicaoJogadorY = 0f
    private var posicaoJogadorX = 0f
    var cem = 0f
    var dez = 0f
    var um = 0f
    var um_metade = 0f
    private var frameHeight = 0
    private var frameWidthD = 0
    private var frameWidthE = 0
    var casas2Y = 0f
    var casas2X = 0f
    var casas3Y = 0f
    var casas3X = 0f
    var casas4Y = 0f
    var casas4X = 0f
    var casas5Y = 0f
    var casas5X = 0f
    var proibidoPerder = true

    var escolah = 0f
    var escolaw = 0f

    var escola1Y = 0f
    var escola1X = 0f

    var monstroHeight = 0f
    var monstroWidth = 0f

    var praca1Y = 0f
    var praca1X = 0f

    var desafio = 0f

    var praca2Y = 0f
    var praca2X = 0f
    var numberY:Float = 0f
    var numberX:Float = 0f

    var prefeitura1Y = 0f
    var prefeitura1X = 0f

    private var frameY = 0
    private var frameX = 0

    var checarSeIniciou = false
    var dialog: Dialog? = null
    var sensibilidade = 1f
    var pause = true
    var aceleracao = 1
    var pontos = 0f
    var desaceleracao = -1
    var desaceleracao2 = -1
    var on = true

    // Image
    var frameImage = 0
    var frameImageInimigoX = 0
    var frameImageInimigoY = 0
    var monsterBoolean = true
    var i = 0
    var xVariavel = 0f
    var yVariavel = 0f
    private var imagejogadorRight: Drawable? = null
    private var imagejogadorLeft: Drawable? = null
    private var imagejogadorUp: Drawable? = null
    private var imagejogadorDown: Drawable? = null
    private var imagejogadorUpL: Drawable? = null
    private var imagejogadorUpR: Drawable? = null
    private var imagejogadorDownL: Drawable? = null
    private var imagejogadorDownR: Drawable? = null

    var velocidade_inimigoY = 0
    var velocidade_cenarioY = 0f
    var velocidade_cenarioX = 0f

    var fundoCidadeY = 0f
    var fundoCidadeX = 0f
    var bateuCimaB = false
    var bateuBaixoB = false
    var bateuEsquerdaSerraB = false
    var bateuDireitaSerraB = false
    var bateuEsquerdaSerraNB = false
    var bateuEsquerdaSerraSB = false
    var bateuDireitaSerraNB = false
    var bateuDireitaSerraSB = false

    var liberaCimaB = false
    var liberaBaixoB = false
    var liberaEsquerdaSerraB = false
    var liberaDireitaSerraB = false
    var liberaEsquerdaSerraNB = false
    var liberaEsquerdaSerraSB = false
    var liberaDireitaSerraNB = false
    var liberaDireitaSerraSB = false

    var velocidadeInimigo = 2f
    var velocidadeJogador = 1.8f
    var velocidadeMonstroVirose = 1f
    var velocidadeMonstroMosquito = 3f

    var fundoQuadriculadoY = 0f
    var fundoQuadriculadoX = 0f

    var velocidadeToqueX = 0f
    var velocidadeToqueY = 0f

    var inimigo = 0
    var inimigo2 = 0
    var inimigo3 = 0
    var inimigo4 = 0
    var inimigo5 = 0
    var inimigo6 = 0
    var inimigo7 = 0
    var inimigo8 = 0
    var inimigo9 = 0
    var inimigo10 = 0
    var inimigo11 = 0

    var pontuacaoInimigo = 0
    var pontuacaoInimigo2 = 0
    var pontuacaoInimigo3 = 0
    var pontuacaoInimigo4 = 0
    var pontuacaoInimigo5 = 0
    var pontuacaoInimigo6 = 0
    var pontuacaoInimigo7 = 0
    var pontuacaoInimigo8 = 0
    var pontuacaoInimigo9 = 0
    var pontuacaoInimigo10 = 0
    var pontuacaoInimigo11 = 0

    var pontosValem = false

    var star = 0;
    // Tamanhos
    private var jogadorSize = 0

    var pontuacao = 0
    var casas1Y = 0f
    var casas1X = 0f

    var perdaVida = 0.25f

    // Posição
    private var jogadorX = 0f
    private var jogadorY = 0f
    private var inimigoX = 0f
    private var inimigoY = 0f
    private var inimigo2X = 0f
    private var inimigo2Y = 0f
    private var inimigo3X = 0f
    private var inimigo3Y = 0f
    private var inimigo4X = 0f
    private var inimigo4Y = 0f
    private var inimigo5X = 0f
    private var inimigo5Y = 0f
    private var inimigo6X = 0f
    private var inimigo6Y = 0f
    private var inimigo7X = 0f
    private var inimigo7Y = 0f
    private var inimigo8X = 0f
    private var inimigo8Y = 0f
    private var inimigo9X = 0f
    private var inimigo9Y = 0f
    private var inimigo10X = 0f
    private var inimigo10Y = 0f
    private var inimigo11X = 0f
    private var inimigo11Y = 0f

    private var inimigogX = -10f
    private var inimigogY = -10f
    private var inimigog2X = -10f
    private var inimigog2Y = -10f
    private var inimigog3X = -10f
    private var inimigog3Y = -10f
    private var inimigog4X = -10f
    private var inimigog4Y = -10f
    private var inimigog5X = -10f
    private var inimigog5Y = -10f
    private var inimigog6X = -10f
    private var inimigog6Y = -10f
    private var inimigog7X = -10f
    private var inimigog7Y = -10f
    private var inimigog8X = -10f
    private var inimigog8Y = -10f
    private var inimigog9X = -10f
    private var inimigog9Y = -10f
    private var inimigog10X = -10f
    private var inimigog10Y = -10f
    private var inimigog11X = -10f
    private var inimigog11Y = -10f

    private var inimigoxX = 0f
    private var inimigoyY = 0f
    private var inimigo2xX = 0f
    private var inimigo2yY = 0f
    private var inimigo3xX = 0f
    private var inimigo3yY = 0f
    private var inimigo4xX = 0f
    private var inimigo4yY = 0f
    private var inimigo5xX = 0f
    private var inimigo5yY = 0f
    private var inimigo6xX = 0f
    private var inimigo6yY = 0f
    private var inimigo7xX = 0f
    private var inimigo7yY = 0f
    private var inimigo8xX = 0f
    private var inimigo8yY = 0f
    private var inimigo9xX = 0f
    private var inimigo9yY = 0f
    private var inimigo10xX = 0f
    private var inimigo10yY = 0f
    private var inimigo11xX = 0f
    private var inimigo11yY = 0f

    private var monstroX = 0f
    private var monstroY = 0f
    private var monstroxX = 0f
    private var monstroyY = 0f
    private var monstro = 0

    private var mosquitoX = 0f
    private var mosquitoY = 0f
    private var mosquitoxX = 0f
    private var mosquitoyY = 0f
    private var mosquito = 0

    private var florestaEsquerdaY = 0f
    private var florestaEsquerdaX = 0f
    private var florestaDireitaY = 0f
    private var florestaDireitaX = 0f
    private var florestaCimaY = 0f
    private var florestaCimaX = 0f
    private var florestaBaixoY = 0f
    private var florestaBaixoX = 0f

    private var buracoX = 0f
    private var buracoY = 0f

    private var feira1X = 0f
    private var feira1Y = 0f

    private var feira2X = 0f
    private var feira2Y = 0f

    private var desafio1X = 0f
    private var desafio1Y = 0f
    private var desafio2X = 0f
    private var desafio2Y = 0f
    private var desafio3X = 0f
    private var desafio3Y = 0f
    private var desafio4X = 0f
    private var desafio4Y = 0f
    private var desafio5X = 0f
    private var desafio5Y = 0f
    private var desafio6X = 0f
    private var desafio6Y = 0f
    private var desafio7X = 0f
    private var desafio7Y = 0f
    private var desafio8X = 0f
    private var desafio8Y = 0f
    private var desafio9X = 0f
    private var desafio9Y = 0f
    private var desafio10X = 0f
    private var desafio10Y = 0f

    private var desafio1gX = -10f
    private var desafio1gY = -10f
    private var desafio2gX = -10f
    private var desafio2gY = -10f
    private var desafio3gX = -10f
    private var desafio3gY = -10f
    private var desafio4gX = -10f
    private var desafio4gY = -10f
    private var desafio5gX = -10f
    private var desafio5gY = -10f
    private var desafio6gX = -10f
    private var desafio6gY = -10f
    private var desafio7gX = -10f
    private var desafio7gY = -10f
    private var desafio8gX = -10f
    private var desafio8gY = -10f
    private var desafio9gX = -10f
    private var desafio9gY = -10f
    private var desafio10gX = -10f
    private var desafio10gY = -10f

    //6,1,1,4,3,3,2,1,5,2
    private var desafio1Pontos = 7
    private var desafio2Pontos = 1
    private var desafio3Pontos = 1
    private var desafio4Pontos = 4
    private var desafio5Pontos = 3
    private var desafio6Pontos = 3
    private var desafio7Pontos = 2
    private var desafio8Pontos = 1
    private var desafio9Pontos = 5
    private var desafio10Pontos = 2

    private var casas1xX = 0f
    private var casas1yY = 0f

    // Pontuação
    var contadorDeTempo = 0
    var controlesFuncaoes = true
    var fimDeJogo = false

    // Classes de tempo
    private var timer: Timer? = null
    private val handler = Handler()

    // Status
    private var start_booleana = false

    var cimaa = 0
    var baixoo = 0
    var ladoGiro = 0
    var joyStickClass: JoyStickClass? = null
    var direction:Int = 0
    /////////////////////////////////////////////////////
    var cimaB = false
    var baixoB = false
    var direitaSerraB = false
    var esquerdaSerraB = false
    var direitaSerraSB = false
    var esquerdaSerraSB = false
    var direitaSerraNB = false
    var esquerdaSerraNB = false
    private var gestureDetector: GestureDetector? = null
    private var x1 = 0f
    private var y1 = 0f
    private var x2 = 0f
    private var y2 = 0f
    private lateinit var binding: ActivityGameQueixadaBinding

    var caminhoA = false
    var caminhoB = false
    var caminhoC = false
    var caminhoD = false
    var caminhoE = false
    var caminhoF = false
    var caminhoG = false
    var caminhoH = false
    var caminhoI = false
    var caminhoJ = false
    var caminhoK = false
    var caminhoL = false
    var caminhoM = false
    var caminhoN = false

    var caminhoMosquitoA = false
    var caminhoMosquitoB = false
    var caminhoMosquitoC = false
    var caminhoMosquitoD = false
    var caminhoMosquitoE = false
    var caminhoMosquitoF = false
    var caminhoMosquitoG = false
    var caminhoMosquitoH = false
    var caminhoMosquitoI = false
    var caminhoMosquitoJ = false
    var caminhoMosquitoK = false
    var caminhoMosquitoL = false
    var caminhoMosquitoM = false
    var caminhoMosquitoN = false
    var tiroParou = false

    private var tiroInimigoX = 0f
    private var tiroInimigoY = 0f

    private var tiroInimigoxX = 0f
    private var tiroInimigoyY = 0f

    private var tiroInimigo = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameQueixadaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        tocarSomMedia(2, true, this)

        buracoX = florestaEsquerdaX - binding.inimigoGame.height
        buracoY = florestaEsquerdaY - binding.inimigoGame.height

        imagejogadorLeft = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_e, null)
        imagejogadorRight = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_d, null)
        imagejogadorUp = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_c, null)
        imagejogadorUpR = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_c, null)
        imagejogadorDownR = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_b, null)
        imagejogadorUpL = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_c, null)
        imagejogadorDownL = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_b, null)
        imagejogadorDown = ResourcesCompat.getDrawable(resources,
            R.drawable.ic_jogador_principal_2_h_b, null)

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                controlesFuncaoes = true
                Toast.makeText(this, getString(R.string.joystick), Toast.LENGTH_SHORT).show()
            } else if (!isChecked) {
                controlesFuncaoes = false
                Toast.makeText(this, getString(R.string.gestos), Toast.LENGTH_SHORT).show()
            }
        }

        dialog = Dialog(this)
        gestureDetector = GestureDetector(this@GameQueixadaActivity, this)
        binding.imagePause.setOnLongClickListener{
            onPause()

            velocidade_inimigoY = 0
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            controlesFuncao()
            false
        }
    }

    fun controlesFuncao() {
        if (controlesFuncaoes) {
            binding.imageGestos.visibility = View.GONE
            binding.layoutJoystick.visibility = View.VISIBLE
            joyStickClass = JoyStickClass(
                applicationContext
                , binding.layoutJoystick, R.drawable.joystick_bola
            )
            joyStickClass!!.setStickSize(100, 100)
            joyStickClass!!.setLayoutSize(300, 300)
            joyStickClass!!.layoutAlpha = 100
            joyStickClass!!.stickAlpha = 80
            joyStickClass!!.offset = 70
            joyStickClass!!.minimumDistance = 50
            binding.layoutJoystick.setOnTouchListener { arg0, arg1 ->
                joyStickClass!!.drawStick(arg1)
                if (arg1.action == MotionEvent.ACTION_DOWN
                    || arg1.action == MotionEvent.ACTION_MOVE
                ) {
                    direction = joyStickClass!!.get8Direction()
                    joyStick ()

                } else if (arg1.action == MotionEvent.ACTION_UP) {
                    if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                        esquerdaSerraB = false
                        direitaSerraB = false
                        cimaB = false
                        baixoB = false
                        esquerdaSerraNB = false
                        esquerdaSerraSB = false
                        direitaSerraSB = false
                        direitaSerraNB = false
                        movimento()
                        ladoGiro = 0
                    } else{
                        joyStick()
                    }

                } else {

                    ladoGiro = 9
                }

                binding.jogador.x = binding.gameFrame.x + binding.gameFrame.width / 2 - binding.jogador.width / 2
                binding.jogador.y = binding.gameFrame.y + binding.gameFrame.height / 2 - binding.jogador.height/2
                Atualizacao()
                true
            }
        } else {
            binding.layoutJoystick.visibility = View.GONE
            binding.imageGestos.visibility = View.VISIBLE
            binding.imageGestos.setOnTouchListener { v, touchevent ->
                gestureDetector!!.onTouchEvent(touchevent)
                when (touchevent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        x1 = touchevent.x
                        y1 = touchevent.y
                    }
                    MotionEvent.ACTION_MOVE -> {
                        x2 = touchevent.x
                        y2 = touchevent.y
                        val valueX = x2 - x1
                        val valueY = y2 - y1
                        if (Math.abs(valueX) < MIN_DISTANCE) {
                            if (x2 > x1) {
                                /** CIMA  */
                                /** CIMA  */
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    cimaB()
                                    bateuCimaB = true
                                } else{
                                    if (bateuCimaB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10 * -1
                                        bateuCimaB = false
                                    }
                                }
                            } else {
                                /** BAIXO  */
                                /** BAIXO  */
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    baixoB()
                                    bateuBaixoB = true
                                } else{
                                    if (bateuBaixoB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10
                                        bateuBaixoB = false
                                    }
                                }
                            }
                        } else if (Math.abs(valueY) < MIN_DISTANCE) {
                            if (y2 > y1) {
                                /** EsquerdaSerra  */
                                /** EsquerdaSerra  */
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    esquerdaSerraB()
                                    bateuEsquerdaSerraB = true
                                } else{
                                    if (bateuEsquerdaSerraB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10
                                        bateuEsquerdaSerraB = false
                                    }
                                }
                            } else {
                                /** DireitaSerra  */
                                /** DireitaSerra  */
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    direitaSerraB()
                                    bateuDireitaSerraB = true
                                } else{
                                    if (bateuDireitaSerraB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioX = cem/10 * -1
                                        bateuDireitaSerraB = false
                                    }
                                }
                            }
                        } else {
                            if (x1 < x2 && y1 < y2) {
                                /** Sudeste  */
                                /** Sudeste  */
                                //jogadorX += 25; //*sensibilidade;
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    direitaSerraSB()
                                    bateuDireitaSerraSB = true
                                } else{
                                    if (bateuDireitaSerraSB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10 * -1
                                        velocidade_cenarioX = cem/10 * -1
                                        bateuDireitaSerraSB = false
                                    }
                                }
                            }
                            if (x1 > x2 && y1 < y2) { //Sudoeste
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    esquerdaSerraSB()
                                    bateuEsquerdaSerraSB = true
                                } else{
                                    if (bateuEsquerdaSerraSB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10
                                        velocidade_cenarioX = cem/10
                                        bateuEsquerdaSerraSB = false
                                    }
                                }
                            }
                            if (x1 < x2 && y1 > y2) {
                                /** NORDESTE  */
                                /** NORDESTE  */
                                //jogadorX += 25;//*sensibilidade;
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    direitaSerraNB()
                                    bateuDireitaSerraNB = true
                                } else{
                                    if (bateuDireitaSerraNB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10
                                        velocidade_cenarioX = cem/10 * -1
                                        bateuDireitaSerraNB = false
                                    }
                                }
                            }
                            if (x1 > x2 && y1 > y2) { //Noroeste
                                //imageView.setImageResource(R.drawable.ic_lens_black_24dp);
                                //jogadorX -= 25; //*sensibilidade;
                                if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                                    esquerdaSerraNB()
                                    bateuEsquerdaSerraNB = true
                                } else{
                                    if (bateuEsquerdaSerraNB) {
                                        velocidade_cenarioY = 0f
                                        velocidade_cenarioX = 0f
                                        velocidade_cenarioY = cem/10 * -1
                                        velocidade_cenarioX = cem/10
                                        bateuEsquerdaSerraNB = false
                                    }
                                }
                            }
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        esquerdaSerraB = false
                        direitaSerraB = false
                        cimaB = false
                        baixoB = false
                        esquerdaSerraNB = false
                        esquerdaSerraSB = false
                        direitaSerraSB = false
                        direitaSerraNB = false

                        movimento()
                        ladoGiro = 0
                    }
                }
                true
            }
        }
    }

    fun Atualizacao() {
        jogadorX = binding.gameFrame.x + binding.gameFrame.width / 2 - binding.jogador.width / 2
        jogadorY = binding.gameFrame.y + binding.gameFrame.height / 2 - binding.jogador.height/2
        binding.jogador.x = jogadorX
        binding.jogador.y = jogadorY
        yVariavel += velocidade_cenarioY
        xVariavel += velocidade_cenarioX

        atualizacaoCasas1()
        contadorDeTempo += 20
        inimigo()
    }

    fun colisorCenarioTeste(
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        if (casas1X + binding.casas1.width >= x && casas1X <= x + z.width &&
            casas1Y + binding.casas1.height >= y && casas1Y <= y + z.height
        ) {
            return true
        } else if (casas2X + binding.casas2.width >= x && casas2X <= x + z.width &&
            casas2Y + binding.casas2.height >= y && casas2Y <= y + z.height
        ) {
            return true
        } else if (casas3X + binding.casas3.width >= x && casas3X <= x + z.width &&
            casas3Y + binding.casas3.height >= y && casas3Y <= y + z.height
        ) {
            return true
        } else if (casas4X + binding.casas4.width >= x && casas4X <= x + z.width &&
            casas4Y + binding.casas4.height >= y && casas4Y <= y + z.height
        ) {
            return true
        } else if (casas5X + binding.casas5.width >= x && casas5X <= x + z.width &&
            casas5Y + binding.casas5.height >= y && casas5Y <= y + z.height
        ) {
            return true
        } else if (escola1X + binding.escola1.width >= x && escola1X <= x + z.width &&
            escola1Y + binding.escola1.height >= y && escola1Y <= y + z.height
        ) {
            return true
        } else if (praca1X + binding.praca1.width >= x && praca1X <= x + z.width &&
            praca1Y + binding.praca1.height >= y && praca1Y <= y + z.height
        ) {
            return true
        } else if (praca2X + binding.praca2.width >= x && praca2X <= x + z.width &&
            praca2Y + binding.praca2.height >= y && praca2Y <= y + z.height
        ) {
            return true
        } else if (prefeitura1X + binding.prefeitura1.width >= x && prefeitura1X <= x + z.width &&
            prefeitura1Y + binding.prefeitura1.height >= y && prefeitura1Y <= y + z.height
        ) {
            return true
        } else if (feira1X + binding.feira1.width >= x && feira1X <= x + z.width &&
            feira1Y + binding.feira1.height >= y && feira1Y <= y + z.height
        ) {
            return true
        } else if (feira2X + binding.feira2.width >= x && feira2X <= x + z.width &&
            feira2Y + binding.feira2.height >= y && feira2Y <= y + z.height
        ) {
            return true
        } else if (florestaBaixoX + binding.florestaBaixo.width >= x && florestaBaixoX <= x + z.width &&
            florestaBaixoY + binding.florestaBaixo.height >= y && florestaBaixoY <= y + z.height
        ) {
            return true
        } else if (florestaCimaX + binding.florestaCima.width >= x && florestaCimaX <= x + z.width &&
            florestaCimaY + binding.florestaCima.height >= y && florestaCimaY <= y + z.height
        ) {
            return true
        } else if (florestaEsquerdaX + binding.florestaEsquerda.width >= x && florestaEsquerdaX <= x + z.width &&
            florestaEsquerdaY + binding.florestaEsquerda.height >= y && florestaEsquerdaY <= y + z.height
        ) {
            return true
        } else if (florestaDireitaX + binding.florestaDireita.width >= x && florestaDireitaX <= x + z.width &&
            florestaDireitaY + binding.florestaDireita.height >= y && florestaDireitaY <= y + z.height
        ) {
            return true
        }

        return false
    }

    fun colisorCenario(
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        if (jogadorX + binding.jogador.width >= x && jogadorX <= x + z.width &&
            jogadorY + binding.jogador.height >= y && jogadorY <= y + z.height
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            return true
        } else if (casas1X + binding.casas1.width >= x && casas1X <= x + z.width &&
            casas1Y + binding.casas1.height >= y && casas1Y <= y + z.height
        ) {
            return true
        } else if (casas2X + binding.casas2.width >= x && casas2X <= x + z.width &&
            casas2Y + binding.casas2.height >= y && casas2Y <= y + z.height
        ) {
            return true
        } else if (casas3X + binding.casas3.width >= x && casas3X <= x + z.width &&
            casas3Y + binding.casas3.height >= y && casas3Y <= y + z.height
        ) {
            return true
        } else if (casas4X + binding.casas4.width >= x && casas4X <= x + z.width &&
            casas4Y + binding.casas4.height >= y && casas4Y <= y + z.height
        ) {
            return true
        } else if (casas5X + binding.casas5.width >= x && casas5X <= x + z.width &&
            casas5Y + binding.casas5.height >= y && casas5Y <= y + z.height
        ) {
            return true
        } else if (escola1X + binding.escola1.width >= x && escola1X <= x + z.width &&
            escola1Y + binding.escola1.height >= y && escola1Y <= y + z.height
        ) {
            return true
        } else if (praca1X + binding.praca1.width >= x && praca1X <= x + z.width &&
            praca1Y + binding.praca1.height >= y && praca1Y <= y + z.height
        ) {
            return true
        } else if (praca2X + binding.praca2.width >= x && praca2X <= x + z.width &&
            praca2Y + binding.praca2.height >= y && praca2Y <= y + z.height
        ) {
            return true
        } else if (prefeitura1X + binding.prefeitura1.width >= x && prefeitura1X <= x + z.width &&
            prefeitura1Y + binding.prefeitura1.height >= y && prefeitura1Y <= y + z.height
        ) {
            return true
        } else if (feira1X + binding.feira1.width >= x && feira1X <= x + z.width &&
            feira1Y + binding.feira1.height >= y && feira1Y <= y + z.height
        ) {
            return true
        } else if (feira2X + binding.feira2.width >= x && feira2X <= x + z.width &&
            feira2Y + binding.feira2.height >= y && feira2Y <= y + z.height
        ) {
            return true
        } else if (florestaBaixoX + binding.florestaBaixo.width >= x && florestaBaixoX <= x + z.width &&
            florestaBaixoY + binding.florestaBaixo.height >= y && florestaBaixoY <= y + z.height
        ) {
            return true
        } else if (florestaCimaX + binding.florestaCima.width >= x && florestaCimaX <= x + z.width &&
            florestaCimaY + binding.florestaCima.height >= y && florestaCimaY <= y + z.height
        ) {
            return true
        } else if (florestaEsquerdaX + binding.florestaEsquerda.width >= x && florestaEsquerdaX <= x + z.width &&
            florestaEsquerdaY + binding.florestaEsquerda.height >= y && florestaEsquerdaY <= y + z.height
        ) {
            return true
        } else if (florestaDireitaX + binding.florestaDireita.width >= x && florestaDireitaX <= x + z.width &&
            florestaDireitaY + binding.florestaDireita.height >= y && florestaDireitaY <= y + z.height
        ) {
            return true
        }

        return false
    }

    fun colisorJogadorParar(
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        if (jogadorX + binding.jogador.width >= x && jogadorX <= x + z.width &&
            jogadorY + binding.jogador.height >= y && jogadorY <= y + z.height
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            //para = true

            binding.jogador.x = binding.gameFrame.x + binding.gameFrame.width / 2 - binding.jogador.width / 2
            binding.jogador.y = binding.gameFrame.y + binding.gameFrame.height / 2 - binding.jogador.height/2
            return true
        } //else{
        //para = false
        //}

        return false
    }
    fun colisorJogadorTocar(
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        if (jogadorX + binding.jogador.width >= x && jogadorX <= x + z.width &&
            jogadorY + binding.jogador.height >= y && jogadorY <= y + z.height
        ) {
            binding.jogador.x = binding.gameFrame.x + binding.gameFrame.width / 2 - binding.jogador.width / 2
            binding.jogador.y = binding.gameFrame.y + binding.gameFrame.height / 2 - binding.jogador.height/2
            return true
        }
        return false
    }

    fun colisorObjeto(
        x: Float,
        y: Float,
        z: ImageView
    ) {
        mudarMedidasObjeto(x,
            y,
            z)

        if (colisorJogadorParar(
                x,
                y,
                z
            )
            && baixoB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorUp)
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = true
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            velocidade_cenarioY += 3*um_metade //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && cimaB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorDown)
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = false
            baixoB = true
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            velocidade_cenarioY -= 3*um_metade //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && direitaSerraB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorLeft)
            esquerdaSerraB = true
            direitaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            velocidade_cenarioX += 3*um_metade //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && esquerdaSerraB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorRight)
            direitaSerraB = true
            esquerdaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            velocidade_cenarioX -= 3 //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && direitaSerraSB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorUp)
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = true
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            velocidade_cenarioY += 3*um_metade //+ pontuacao
            velocidade_cenarioX += 3*um_metade //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && esquerdaSerraNB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorUp)
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = true
            direitaSerraNB = false
            movimento()
            velocidade_cenarioY -= 3*um_metade //+ pontuacao
            velocidade_cenarioX -= 3*um_metade //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && direitaSerraNB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorUp)
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = true
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            velocidade_cenarioY -= 3*um_metade //+ pontuacao
            velocidade_cenarioX += 3*um_metade //+ pontuacao
        } else if (colisorJogadorParar(
                x,
                y,
                z
            )
            && esquerdaSerraSB
        ) {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.jogador.setImageDrawable(imagejogadorUp)
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = true
            movimento()
            velocidade_cenarioY += 3*um_metade //+ pontuacao
            velocidade_cenarioX -= 3*um_metade //+ pontuacao
        }
    }

    /*fun mudarFrenteJogador(
        y: Float,
        z: ImageView) {

        if (jogadorY < y){
            binding.gameFrame.removeView(binding.jogador)
            binding.gameFrame.removeView(z)
            binding.gameFrame.addView(binding.jogador)
            binding.gameFrame.addView(z)
        } else if (jogadorY > y){
            binding.gameFrame.removeView(binding.jogador)
            binding.gameFrame.removeView(z)
            binding.gameFrame.addView(z)
            binding.gameFrame.addView(binding.jogador)
        }
    }*/

    fun randomX (x: Float):Float
    {
        val listXU = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f, 17f, 18f)
        val numberXU:Float = (listXU.random()).toFloat()
        /*if (numberXU == 17f){
            val listXD = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f)
            val numberXD:Float = (listXD.random()/10).toFloat()
            val listXC = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f)
            val numberXC:Float = (listXC.random()/100).toFloat()
            numberX = numberXU + numberXD + numberXC
        }*/ //else{
        val listXD = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f)
        val numberXD:Float = (listXD.random()/10).toFloat()
        val listXC = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f)
        val numberXC:Float = (listXC.random()/100).toFloat()
        numberX = numberXU + numberXD + numberXC
        //}
        val medida = binding.casas1.width * 5

        if (numberX >= x + medida && numberX <= x - medida && x != -10f){ //Isso para os desafios não ficar tão próximos
            randomX(x)
        }

        return numberX
    }

    fun randomY (
        y: Float):Float
    {
        val listYU = listOf(-1f, 0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f)
        val numberYU:Float = (listYU.random()).toFloat()
        if (numberYU == 10f){
            val listYD = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f)
            val numberYD:Float = (listYD.random()/10).toFloat()
            val listYC = listOf(2f, 3f, 4f, 5f, 6f, 7f)
            val numberYC:Float = (listYC.random()/100).toFloat()
            numberY = numberYD + numberYC
        } else{
            val listYD = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f)
            val numberYD:Float = (listYD.random()/10).toFloat()
            val listYC = listOf(0f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f)
            val numberYC:Float = (listYC.random()/100).toFloat()
            numberY = numberYU + numberYD + numberYC
        }
        val medida = binding.casas1.width * 5

        if ( numberY >= y + medida && numberY <= y - medida && y != -10f){ //Isso para os desafios não ficar tão próximos
            randomY(y)
        }

        return numberY
    }

    fun mudarMedidasObjeto(
        x: Float,
        y: Float,
        z: ImageView
    ){
        z.x = x
        z.y = y
    }

    private fun heightCidade(
        z: ImageView,
        percentValue: Float
    ): Float{
        return (casas1Y + binding.casas1.height - z.height - ((binding.casas1.width * percentValue) + 0.08)).toFloat()
    }

    fun widthCidade(
        z: ImageView,
        percentValue: Float
    ): Float{
        return casas1X + binding.casas1.width + (binding.casas1.width * percentValue)
    }

    fun atualizacaoFundoCidade() {
        fundoCidadeY = (casas1Y + (binding.casas1.height/2) - (binding.casas1.height/2)-  (binding.casas1.width * 0.04f)).toFloat()
        fundoCidadeX = (casas1X + (binding.casas1.width/2) - (binding.casas1.width/2)-  (binding.casas1.width * 0.42f)).toFloat()

        binding.fundoCidade.x = fundoCidadeX
        binding.fundoCidade.y = fundoCidadeY
    }

    fun atualizacaoFundoQuadriculado() {
        fundoQuadriculadoY = fundoCidadeY
        fundoQuadriculadoX = fundoCidadeX

        binding.fundoQuadriculado.x = fundoQuadriculadoX
        binding.fundoQuadriculado.y = fundoQuadriculadoY
    }

    fun casas2(){

        casas2Y = heightCidade(binding.casas2, 10.87f)
        casas2X = widthCidade(binding.casas2, 0.25f)

        colisorObjeto(casas2X,
            casas2Y,
            binding.casas2)
    }

    fun casas3(){

        casas3Y = heightCidade(binding.casas3, 0.12f*-1)
        casas3X = widthCidade(binding.casas3, 8.71f)

        colisorObjeto(casas3X,
            casas3Y,
            binding.casas3)
    }

    fun casas4(){

        casas4Y = heightCidade(binding.casas4, 7.94f)
        casas4X = widthCidade(binding.casas4, 8.78f)

        colisorObjeto(casas4X,
            casas4Y,
            binding.casas4)
    }

    fun casas5(){

        casas5Y = heightCidade(binding.casas5, 0.07f * -1)
        casas5X = widthCidade(binding.casas5, 17.68f)

        colisorObjeto(casas5X,
            casas5Y,
            binding.casas5)
    }

    fun escola1(){

        escola1Y = heightCidade(binding.escola1, 1.65f)
        escola1X = widthCidade(binding.escola1, 2.02f)

        colisorObjeto(escola1X,
            escola1Y,
            binding.escola1)
    }

    fun praca1(){

        praca1Y = heightCidade(binding.praca1, 4.99f)
        praca1X = widthCidade(binding.praca1, 2.25f)

        colisorObjeto(praca1X,
            praca1Y,
            binding.praca1)
    }

    fun praca2(){

        praca2Y = heightCidade(binding.praca2, 5.02f)
        praca2X = widthCidade(binding.praca2, 12.56f)

        colisorObjeto(praca2X,
            praca2Y,
            binding.praca2)
    }

    fun prefeitura1(){

        prefeitura1Y = heightCidade(binding.prefeitura1, 1.63f)
        prefeitura1X = widthCidade(binding.prefeitura1, 12.49f)

        colisorObjeto(prefeitura1X,
            prefeitura1Y,
            binding.prefeitura1)
    }

    fun feira1(){

        feira1Y = heightCidade(binding.feira1, 6.19f)
        feira1X = widthCidade(binding.feira1, 16.78f)

        colisorObjeto(feira1X,
            feira1Y,
            binding.feira1)
    }

    fun feira2(){

        feira2Y = heightCidade(binding.feira2, 6.19f)
        feira2X = widthCidade(binding.feira2, 1.11f)

        colisorObjeto(feira2X,
            feira2Y,
            binding.feira2)
    }

    fun florestaEsquerda(){

        florestaEsquerdaY = fundoCidadeY
        florestaEsquerdaX = fundoCidadeX - binding.florestaBaixo.width

        colisorObjeto(florestaEsquerdaX,
            florestaEsquerdaY,
            binding.florestaEsquerda)
    }

    fun florestaDireita(){

        florestaDireitaY = fundoCidadeY
        florestaDireitaX = fundoCidadeX + binding.florestaBaixo.width

        colisorObjeto(florestaDireitaX,
            florestaDireitaY,
            binding.florestaDireita)
    }

    fun florestaCima(){

        florestaCimaY = fundoCidadeY - binding.florestaBaixo.height
        florestaCimaX = fundoCidadeX

        colisorObjeto(florestaCimaX,
            florestaCimaY,
            binding.florestaCima)
    }

    fun florestaBaixo(){

        florestaBaixoY = fundoCidadeY + binding.florestaBaixo.height
        florestaBaixoX = fundoCidadeX

        colisorObjeto(florestaBaixoX,
            florestaBaixoY,
            binding.florestaBaixo)
    }

    //DESAFIOS

    fun desafio1() {

        if (desafio1gX == -10f){
            desafio1gX = randomX(desafio1gX)
        }
        if (desafio1gY == -10f){
            desafio1gY = randomY(desafio1gY)
        }

        desafio1X = widthCidade(binding.desafio1Game, desafio1gX)
        desafio1Y = heightCidade(binding.desafio1Game, desafio1gY)

        if (colisorJogadorTocar(desafio1X, desafio1Y, binding.desafio1Game)) {
            //mudarFrenteJogador(desafio1Y, binding.desafio1Game)
            binding.desafio1Game.visibility = View.GONE

            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond6)

            binding.desafio1Game.visibility = View.VISIBLE
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacao += desafio1Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond6)
            pontos = (-100).toFloat()
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info6) + " " + desafio1Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info6v2),
                R.drawable.ic_diamond6
            )
        }
        binding.desafio1Game.x = desafio1X
        binding.desafio1Game.y = desafio1Y

        if (colisorCenario(desafio1X, desafio1Y, binding.desafio1Game)){
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
        }
    }

    fun desafio2() {

        if (desafio2gX == -10f){
            desafio2gX = randomX(desafio2gX)
        }
        if (desafio2gY == -10f){
            desafio2gY = randomY(desafio2gY)
        }

        desafio2X = widthCidade(binding.desafio2Game, desafio2gX)
        desafio2Y = heightCidade(binding.desafio2Game, desafio2gY)

        if (colisorJogadorTocar(desafio2X, desafio2Y, binding.desafio2Game)) {
            //mudarFrenteJogador(desafio2Y, binding.desafio2Game)
            binding.desafio2Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond1)

            binding.desafio2Game.visibility = View.VISIBLE
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacao += desafio2Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond1)
            if (pontos > 100){
                pontos = 80F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info1) + " " + desafio2Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info1v2),
                R.drawable.ic_diamond1
            )
        }
        binding.desafio2Game.x = desafio2X
        binding.desafio2Game.y = desafio2Y

        if (colisorCenario(desafio2X, desafio2Y, binding.desafio2Game)){
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
        }
    }

    fun desafio3() {

        if (desafio3gX == -10f){
            desafio3gX = randomX(desafio3gX)
        }
        if (desafio3gY == -10f){
            desafio3gY = randomY(desafio3gY)
        }

        desafio3X = widthCidade(binding.desafio3Game, desafio3gX)
        desafio3Y = heightCidade(binding.desafio3Game, desafio3gY)

        if (colisorJogadorTocar(desafio3X, desafio3Y, binding.desafio3Game)) {
            //mudarFrenteJogador(desafio3Y, binding.desafio3Game)
            binding.desafio3Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond1)

            binding.desafio3Game.visibility = View.VISIBLE
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacao += desafio3Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond1)
            if (pontos > 100){
                pontos = 80F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info1) + " " + desafio3Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info1v2),
                R.drawable.ic_diamond1
            )
        }
        binding.desafio3Game.x = desafio3X
        binding.desafio3Game.y = desafio3Y

        if (colisorCenario(desafio3X, desafio3Y, binding.desafio3Game)){
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
        }
    }

    fun desafio4() {

        if (desafio4gX == -10f){
            desafio4gX = randomX(desafio4gX)
        }
        if (desafio4gY == -10f){
            desafio4gY = randomY(desafio4gY)
        }

        desafio4X = widthCidade(binding.desafio4Game, desafio4gX)
        desafio4Y = heightCidade(binding.desafio4Game, desafio4gY)

        if (colisorJogadorTocar(desafio4X, desafio4Y, binding.desafio4Game)) {
            //mudarFrenteJogador(desafio4Y, binding.desafio4Game)
            binding.desafio4Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond4)

            binding.desafio4Game.visibility = View.VISIBLE
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacao += desafio4Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond4)
            if (pontos > 40){
                pontos = 20F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info4) + " " + desafio4Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info4v2),
                R.drawable.ic_diamond4
            )
        }
        binding.desafio4Game.x = desafio4X
        binding.desafio4Game.y = desafio4Y

        if (colisorCenario(desafio4X, desafio4Y, binding.desafio4Game)){
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
        }

    }

    fun desafio5() {

        if (desafio5gX == -10f){
            desafio5gX = randomX(desafio5gX)
        }
        if (desafio5gY == -10f){
            desafio5gY = randomY(desafio5gY)
        }

        desafio5X = widthCidade(binding.desafio5Game, desafio5gX)
        desafio5Y = heightCidade(binding.desafio5Game, desafio5gY)

        if (colisorJogadorTocar(desafio5X, desafio5Y, binding.desafio5Game)) {
            //mudarFrenteJogador(desafio5Y, binding.desafio5Game)
            binding.desafio5Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond3)

            binding.desafio5Game.visibility = View.VISIBLE
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacao += desafio5Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond3)
            if (pontos > 60){
                pontos = 40F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info3) + " " + desafio5Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info3v2),
                R.drawable.ic_diamond3
            )
        }
        binding.desafio5Game.x = desafio5X
        binding.desafio5Game.y = desafio5Y

        if (colisorCenario(desafio5X, desafio5Y, binding.desafio5Game)){
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
        }

    }

    fun desafio6() {

        if (desafio6gX == -10f){
            desafio6gX = randomX(desafio6gX)
        }
        if (desafio6gY == -10f){
            desafio6gY = randomY(desafio6gY)
        }

        desafio6X = widthCidade(binding.desafio6Game, desafio6gX)
        desafio6Y = heightCidade(binding.desafio6Game, desafio6gY)

        if (colisorJogadorTocar(desafio6X, desafio6Y, binding.desafio6Game)) {
            //mudarFrenteJogador(desafio6Y, binding.desafio6Game)
            binding.desafio6Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond3)

            binding.desafio6Game.visibility = View.VISIBLE
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacao += desafio6Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond3)
            if (pontos > 60){
                pontos = 40F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info3) + " " + desafio6Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info3v2),
                R.drawable.ic_diamond3
            )
        }
        binding.desafio6Game.x = desafio6X
        binding.desafio6Game.y = desafio6Y

        if (colisorCenario(desafio6X, desafio6Y, binding.desafio6Game)){
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
        }
    }

    fun desafio7() {

        if (desafio7gX == -10f){
            desafio7gX = randomX(desafio7gX)
        }
        if (desafio7gY == -10f){
            desafio7gY = randomY(desafio7gY)
        }

        desafio7X = widthCidade(binding.desafio7Game, desafio7gX)
        desafio7Y = heightCidade(binding.desafio7Game, desafio7gY)

        if (colisorJogadorTocar(desafio7X, desafio7Y, binding.desafio7Game)) {
            //mudarFrenteJogador(desafio7Y, binding.desafio7Game)
            binding.desafio7Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond2)

            binding.desafio7Game.visibility = View.VISIBLE
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacao += desafio7Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond2)
            if (pontos > 80){
                pontos = 60F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info2) + " " + desafio7Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info2v2),
                R.drawable.ic_diamond2
            )
        }
        binding.desafio7Game.x = desafio7X
        binding.desafio7Game.y = desafio7Y

        if (colisorCenario(desafio7X, desafio7Y, binding.desafio7Game)){
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
        }

    }

    fun desafio8() {

        if (desafio8gX == -10f){
            desafio8gX = randomX(desafio8gX)
        }
        if (desafio8gY == -10f){
            desafio8gY = randomY(desafio8gY)
        }

        desafio8X = widthCidade(binding.desafio8Game, desafio8gX)
        desafio8Y = heightCidade(binding.desafio8Game, desafio8gY)

        if (colisorJogadorTocar(desafio8X, desafio8Y, binding.desafio8Game)) {
            //mudarFrenteJogador(desafio8Y, binding.desafio8Game)
            binding.desafio8Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond1)

            binding.desafio8Game.visibility = View.VISIBLE
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacao += desafio8Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond1)
            if (pontos > 100){
                pontos = 80F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info1) + " " + desafio8Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info1v2),
                R.drawable.ic_diamond1
            )
        }
        binding.desafio8Game.x = desafio8X
        binding.desafio8Game.y = desafio8Y

        if (colisorCenario(desafio8X, desafio8Y, binding.desafio8Game)){
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
        }

    }

    fun desafio9() {

        if (desafio9gX == -10f){
            desafio9gX = randomX(desafio9gX)
        }
        if (desafio9gY == -10f){
            desafio9gY = randomY(desafio9gY)
        }

        desafio9X = widthCidade(binding.desafio9Game, desafio9gX)
        desafio9Y = heightCidade(binding.desafio9Game, desafio9gY)

        if (colisorJogadorTocar(desafio9X, desafio9Y, binding.desafio9Game)) {
            //mudarFrenteJogador(desafio9Y, binding.desafio9Game)
            binding.desafio9Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond5)

            binding.desafio9Game.visibility = View.VISIBLE
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacao += desafio9Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond5)
            if (pontos > 20){
                pontos = 0F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info5) + " " + desafio9Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info5v2),
                R.drawable.ic_diamond5
            )
        }
        binding.desafio9Game.x = desafio9X
        binding.desafio9Game.y = desafio9Y

        if (colisorCenario(desafio9X, desafio9Y, binding.desafio9Game)){
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
        }
    }

    fun desafio10() {

        if (desafio10gX == -10f){
            desafio10gX = randomX(desafio10gX)
        }
        if (desafio10gY == -10f){
            desafio10gY = randomY(desafio10gY)
        }

        desafio10X = widthCidade(binding.desafio10Game, desafio10gX)
        desafio10Y = heightCidade(binding.desafio10Game, desafio10gY)

        if (colisorJogadorTocar(desafio10X, desafio10Y, binding.desafio10Game)) {
            //mudarFrenteJogador(desafio10Y, binding.desafio10Game)
            binding.desafio10Game.visibility = View.GONE
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond2)

            binding.desafio10Game.visibility = View.VISIBLE
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacao += desafio10Pontos
            pontoSomMedia(true, this)
            velocidadeJogador +=  1
            velocidadeInimigo += 1
            velocidadeMonstroVirose += 1
            velocidadeMonstroMosquito += 1
            if (pontuacao == 1){
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.ponto)
            } else{
                binding.pontosDesafiosTextView.text = pontuacao.toString() + " " + getString(R.string.pontos2)
            }
            binding.imageViewArpg.setImageResource(R.drawable.ic_diamond2)
            if (pontos > 80){
                pontos = 60F
            }
            vidasJogador(pontos)
            popupAdviceGameCidade(
                getString(R.string.info2) + " " + desafio10Pontos + " " + getString(R.string.pontos3),
                getString(R.string.info2v2),
                R.drawable.ic_diamond2
            )
        }
        binding.desafio10Game.x = desafio10X
        binding.desafio10Game.y = desafio10Y

        if (colisorCenario(desafio10X, desafio10Y, binding.desafio10Game)){
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
        }

    }

    fun desafios() {
        desafio1()
        desafio2()
        desafio3()
        desafio4()
        desafio5()
        desafio6()
        desafio7()
        desafio8()
        desafio9()
        desafio10()
    }

    fun atualizacaoCasas1() {

        casas1yY += velocidade_cenarioY
        casas1xX += velocidade_cenarioX
        casas1Y = frameHeight - binding.casas1.height + posicaoJogadorY + casas1yY
        casas1X = frameWidthE + posicaoJogadorX + casas1xX

        atualizacaoFundoCidade()
        florestaEsquerda()
        florestaBaixo()
        florestaCima()
        florestaDireita()
        casas2()
        casas3()
        casas4()
        casas5()
        escola1()
        praca1()
        praca2()
        prefeitura1()
        if (pontosValem){
            desafios()
        }
        feira1()
        feira2()
        atualizacaoFundoQuadriculado()
        colisorObjeto(casas1X,
            casas1Y,
            binding.casas1)
    }

    fun fimDeJogo() {
        pause = true
        fimDeJogo = true

        // Stop timer.
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
        start_booleana = false
        try {
            TimeUnit.SECONDS.sleep(1)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        binding.startLayout.visibility = View.VISIBLE
        binding.imagemSimbolo.visibility = View.VISIBLE
        binding.imagePapelDeBaixo.visibility = View.VISIBLE
        binding.jogador.visibility = View.GONE
        binding.inimigoGame.visibility = View.GONE
        binding.inimigoGame2.visibility = View.GONE
        binding.inimigoGame3.visibility = View.GONE
        binding.inimigoGame4.visibility = View.GONE
        binding.monstro.visibility = View.GONE
        binding.mosquito.visibility = View.GONE
        binding.desafio1Game.visibility = View.GONE
        binding.desafio2Game.visibility = View.GONE
        binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
    }

    fun iniciarJogo(view: View?) {
        tocarSomMedia(2, false, this)
        tocarSomMedia(3, true, this)

        val listPontos = listOf(0, 5, 6, 14, 17, 18, 19, 41, 21, 22, 1, 24, 25, 26, 2, 28, 29, 30, 45)

        pontuacaoInimigo = listPontos.random()
        pontuacaoInimigo2 = listPontos.random()
        pontuacaoInimigo3 = listPontos.random()
        pontuacaoInimigo4 = listPontos.random()
        pontuacaoInimigo5 = listPontos.random()
        pontuacaoInimigo6 = listPontos.random()
        pontuacaoInimigo7 = listPontos.random()
        pontuacaoInimigo8 = listPontos.random()
        pontuacaoInimigo9 = listPontos.random()
        pontuacaoInimigo10 = listPontos.random()
        pontuacaoInimigo11 = listPontos.random()

        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
        when (list.random()){
            1 -> {
                posicaoJogadorY = 0f
                posicaoJogadorX = 0f
            }
            2 -> {
                posicaoJogadorY = (binding.casas1.width * 2.25f)*-1
                posicaoJogadorX = (binding.casas1.width * 13.5f)*-1
            }
            3 -> {
                posicaoJogadorY = (binding.casas1.width * 4.0f)
                posicaoJogadorX = (binding.casas1.width * 10.75f)*-1
            }
            4 -> {
                posicaoJogadorY = (binding.casas1.width * 7.0f)
                posicaoJogadorX = (binding.casas1.width * 10.75f)*-1
            }
            5 -> {
                posicaoJogadorY = (binding.casas1.width * 7.05f)
                posicaoJogadorX = (binding.casas1.width * 15.75f)*-1
            }
            6 -> {
                posicaoJogadorY = (binding.casas1.width * 2.25f)
                posicaoJogadorX = (binding.casas1.width * 15.85f)*-1
            }
            7 -> {
                posicaoJogadorY = (binding.casas1.width * 1f)
                posicaoJogadorX = (binding.casas1.width * 6.5f)*-1
            }
            8 -> {
                posicaoJogadorY = (binding.casas1.width * 7.05f)
                posicaoJogadorX = (binding.casas1.width * 6.5f)*-1
            }
            9 -> {
                posicaoJogadorY = (binding.casas1.width * 6.95f)
                posicaoJogadorX = (binding.casas1.width * 1f)*-1
            }
            10 -> {
                posicaoJogadorY = (binding.casas1.width * 2.25f)*-1
                posicaoJogadorX = (binding.casas1.width * 0.5f)*-1
            }
            11 -> {
                posicaoJogadorY = (binding.casas1.width * 2.25f)*-1
                posicaoJogadorX = (binding.casas1.width * 6.5f)*-1
            }
            12 -> {
                posicaoJogadorY = (binding.casas1.width * 2.25f)*-1
                posicaoJogadorX = (binding.casas1.width * 3.5f)*-1
            }
            13 -> {
                posicaoJogadorY = (binding.casas1.width * 2.25f)*-1
                posicaoJogadorX = (binding.casas1.width * 15.85f)*-1
            }
            14 -> {
                posicaoJogadorY = (binding.casas1.width * 3.5f)
                posicaoJogadorX = (binding.casas1.width * 9f)*-1
            }
        }

        binding.arpg.visibility = View.VISIBLE
        binding.arpgCima.visibility = View.VISIBLE
        binding.cima.visibility = View.VISIBLE
        binding.imageViewSombra.visibility = View.VISIBLE
        checarSeIniciou = true
        start_booleana = true
        binding.jogador.visibility = View.VISIBLE
        binding.jogador.setImageDrawable(imagejogadorUp)
        binding.startLayout.visibility = View.INVISIBLE
        binding.imagemSimbolo.visibility = View.INVISIBLE
        binding.imagePapelDeBaixo.visibility = View.INVISIBLE
        binding.feira1.visibility = View.VISIBLE
        binding.feira2.visibility = View.VISIBLE
        binding.relativeControl.visibility = View.GONE
        pause = false
        pontos = 0f
        if (frameHeight == 0) {
            frameHeight = binding.gameFrame.height
            frameWidthD = binding.gameFrame.width
            frameImage = binding.jogador.height
            frameImageInimigoX = binding.inimigoGame.height
            frameImageInimigoY = binding.inimigoGame.width
            jogadorSize = binding.jogador.height

        }

        binding.inimigoGame.visibility = View.VISIBLE
        binding.inimigoGame2.visibility = View.VISIBLE
        binding.inimigoGame3.visibility = View.VISIBLE
        binding.inimigoGame4.visibility = View.VISIBLE
        binding.inimigoGame5.visibility = View.VISIBLE
        binding.inimigoGame6.visibility = View.VISIBLE
        binding.inimigoGame7.visibility = View.VISIBLE
        binding.inimigoGame8.visibility = View.VISIBLE
        binding.inimigoGame9.visibility = View.VISIBLE
        binding.inimigoGame10.visibility = View.VISIBLE
        binding.inimigoGame11.visibility = View.VISIBLE
        binding.monstro.visibility = View.VISIBLE
        binding.mosquito.visibility = View.VISIBLE
        velocidade_inimigoY = 2
        velocidade_cenarioY = 0f
        velocidade_cenarioX = 0f
        frameX = binding.gameFrame.x.toInt()
        frameY = binding.gameFrame.y.toInt()
        binding.jogador.x = binding.gameFrame.x + binding.gameFrame.width / 2 - binding.jogador.width / 2
        binding.jogador.y = binding.gameFrame.y + binding.gameFrame.height / 2 - binding.jogador.height/2
        jogadorX = binding.gameFrame.x + binding.gameFrame.width / 2 - binding.jogador.width / 2
        jogadorY = binding.gameFrame.y + binding.gameFrame.height / 2 - binding.jogador.height/2
        buracoX = florestaEsquerdaX - binding.inimigoGame.height
        buracoY = florestaEsquerdaY - binding.inimigoGame.height

        binding.monstro.y = buracoY
        binding.monstro.x = buracoX

        binding.casas1.visibility = View.VISIBLE
        binding.fundoCidade.visibility = View.VISIBLE
        binding.fundoQuadriculado.visibility = View.VISIBLE
        binding.florestaDireita.visibility = View.VISIBLE
        binding.florestaCima.visibility = View.VISIBLE
        binding.florestaEsquerda.visibility = View.VISIBLE
        binding.florestaBaixo.visibility = View.VISIBLE
        binding.desafio1Game.visibility = View.VISIBLE
        binding.desafio2Game.visibility = View.VISIBLE
        binding.desafio3Game.visibility = View.VISIBLE
        binding.desafio4Game.visibility = View.VISIBLE
        binding.desafio5Game.visibility = View.VISIBLE
        binding.desafio6Game.visibility = View.VISIBLE
        binding.desafio7Game.visibility = View.VISIBLE
        binding.desafio8Game.visibility = View.VISIBLE
        binding.desafio9Game.visibility = View.VISIBLE
        binding.desafio10Game.visibility = View.VISIBLE
        binding.casas2.visibility = View.VISIBLE
        binding.casas3.visibility = View.VISIBLE
        binding.casas4.visibility = View.VISIBLE
        binding.casas5.visibility = View.VISIBLE
        binding.escola1.visibility = View.VISIBLE
        binding.prefeitura1.visibility = View.VISIBLE
        binding.praca1.visibility = View.VISIBLE
        binding.praca2.visibility = View.VISIBLE
        escolah = binding.escola1.height.toFloat()
        escolaw = binding.escola1.width.toFloat()

        monstroHeight = binding.monstro.height.toFloat()
        monstroWidth = binding.monstro.width.toFloat()

        controlesFuncao()
        contadorDeTempo = 0
        cem = binding.casas1.width.toFloat()
        dez = cem/10
        um = dez/10
        um_metade = um/2

        velocidadeInimigo = 2f*um_metade
        velocidadeJogador = 1.8f*um_metade
        velocidadeMonstroVirose = 1f*um_metade
        velocidadeMonstroMosquito = 3f*um_metade

        val decimalFrameWidthD: BigDecimal = BigDecimal((binding.gameFrame.width/2) + (binding.casas3.height*0.325)).setScale(2, RoundingMode.HALF_UP)
        val decimalFrameWidthE: BigDecimal = BigDecimal((binding.gameFrame.width/2) - (binding.casas3.height*0.325)).setScale(2, RoundingMode.HALF_UP)
        frameWidthD = decimalFrameWidthD.toInt()
        frameWidthE = decimalFrameWidthE.toInt()
        timer = Timer()
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                if (start_booleana) {
                    handler.post {
                        if (on){
                            Atualizacao()
                        }
                    }
                }
            }
        }, 0, 20)

        popupMessageInicio(getString(R.string.mensagem_do_inicio))
    }


    fun finalOficialDeJogo() {
        pause = true
        fimDeJogo = true
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }

        velocidade_inimigoY = 0
        velocidade_cenarioY = 0f
        velocidade_cenarioX = 0f
        val intent = Intent(this, FinalGameActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("PONTUACAO_JOGADOR", pontuacao)
        intent.putExtra("PONTUACAO_INIMIGO", pontuacaoInimigo)
        intent.putExtra("PONTUACAO_INIMIGO2", pontuacaoInimigo2)
        intent.putExtra("PONTUACAO_INIMIGO3", pontuacaoInimigo3)
        intent.putExtra("PONTUACAO_INIMIGO4", pontuacaoInimigo4)
        intent.putExtra("PONTUACAO_INIMIGO5", pontuacaoInimigo5)
        intent.putExtra("PONTUACAO_INIMIGO6", pontuacaoInimigo6)
        intent.putExtra("PONTUACAO_INIMIGO7", pontuacaoInimigo7)
        intent.putExtra("PONTUACAO_INIMIGO8", pontuacaoInimigo8)
        intent.putExtra("PONTUACAO_INIMIGO9", pontuacaoInimigo9)
        intent.putExtra("PONTUACAO_INIMIGO10", pontuacaoInimigo10)
        intent.putExtra("PONTUACAO_INIMIGO11", pontuacaoInimigo11)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun movimento() {

        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        if (cimaB) {
            bateuCimaB = true
            velocidade_cenarioY = velocidadeJogador * aceleracao
            velocidade_cenarioX = 0f
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (esquerdaSerraB) {
            bateuEsquerdaSerraB = true
            velocidade_cenarioY = 0f
            velocidade_cenarioX = velocidadeJogador * aceleracao
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (direitaSerraB) {
            bateuDireitaSerraB = true
            velocidade_cenarioY = 0f
            velocidade_cenarioX = velocidadeJogador * desaceleracao
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (baixoB) {
            bateuBaixoB = true
            velocidade_cenarioY = velocidadeJogador * desaceleracao2
            velocidade_cenarioX = 0f
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (esquerdaSerraSB) {
            bateuEsquerdaSerraSB = true
            velocidade_cenarioY = velocidadeJogador * desaceleracao2
            velocidade_cenarioX = velocidadeJogador * aceleracao
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (direitaSerraSB) {
            bateuDireitaSerraSB = true
            velocidade_cenarioY = velocidadeJogador * desaceleracao2
            velocidade_cenarioX = velocidadeJogador * desaceleracao
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (esquerdaSerraNB) {
            bateuEsquerdaSerraNB = true
            velocidade_cenarioY = velocidadeJogador * aceleracao
            velocidade_cenarioX = velocidadeJogador * aceleracao
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (direitaSerraNB) {
            bateuDireitaSerraNB = true
            velocidade_cenarioY = velocidadeJogador * aceleracao
            velocidade_cenarioX = velocidadeJogador * desaceleracao
            velocidadeToqueX = velocidade_cenarioX
            velocidadeToqueY = velocidade_cenarioY
        }
        if (!(esquerdaSerraB || direitaSerraB || cimaB || baixoB || esquerdaSerraSB || direitaSerraSB || esquerdaSerraNB || direitaSerraNB)) {

            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f //Volte aqui
            //velocidadeToqueX = velocidade_cenarioX
            //velocidadeToqueY = velocidade_cenarioY
        }
        /*}  else {
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
        }*/

    }


    fun joyStick (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        if (direction == JoyStickClass.STICK_UP) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaCimaB){
                cimaB()
                bateuCimaB = true
            } else{
                liberaBaixoB = true
                liberaEsquerdaSerraSB = true
                liberaDireitaSerraSB = true
                liberaCimaB = false
                liberaEsquerdaSerraB = false
                liberaDireitaSerraB = false
                liberaEsquerdaSerraNB = false
                liberaDireitaSerraNB = false
            }
        } else if (direction == JoyStickClass.STICK_UPRIGHT) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaDireitaSerraB){
                direitaSerraNB()
                bateuDireitaSerraNB = true
            } else{
                liberaEsquerdaSerraB = true
                liberaEsquerdaSerraNB = true
                liberaEsquerdaSerraSB = true
                liberaCimaB = false
                liberaBaixoB = false
                liberaDireitaSerraB = false
                liberaDireitaSerraNB = false
                liberaDireitaSerraSB = false

            }

        } else if (direction == JoyStickClass.STICK_RIGHT) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaDireitaSerraB){
                direitaSerraB()
                bateuDireitaSerraB = true
            } else{
                liberaEsquerdaSerraB = true
                liberaEsquerdaSerraNB = true
                liberaEsquerdaSerraSB = true
                liberaCimaB = false
                liberaBaixoB = false
                liberaDireitaSerraB = false
                liberaDireitaSerraNB = false
                liberaDireitaSerraSB = false

            }

        } else if (direction == JoyStickClass.STICK_DOWNRIGHT) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaDireitaSerraSB){
                direitaSerraSB()
                bateuDireitaSerraSB = true
            } else{
                liberaEsquerdaSerraB = true
                liberaEsquerdaSerraNB = true
                liberaEsquerdaSerraSB = true
                liberaCimaB = false
                liberaBaixoB = false
                liberaDireitaSerraB = false
                liberaDireitaSerraNB = false
                liberaDireitaSerraSB = false

            }

        } else if (direction == JoyStickClass.STICK_DOWN) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaBaixoB){
                baixoB()
                bateuBaixoB = true
            } else{
                liberaCimaB = true
                liberaEsquerdaSerraNB = true
                liberaDireitaSerraNB = true
                liberaBaixoB = false
                liberaEsquerdaSerraB = false
                liberaDireitaSerraB = false
                liberaEsquerdaSerraSB = false
                liberaDireitaSerraSB = false

            }

        } else if (direction == JoyStickClass.STICK_DOWNLEFT) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaEsquerdaSerraSB){
                esquerdaSerraSB()
                bateuEsquerdaSerraSB = true
            } else{
                liberaDireitaSerraB = true
                liberaDireitaSerraNB = true
                liberaDireitaSerraSB = true
                liberaCimaB = false
                liberaBaixoB = false
                liberaDireitaSerraB = false
                liberaDireitaSerraNB = false
                liberaDireitaSerraSB = false

            }

        } else if (direction == JoyStickClass.STICK_LEFT) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaEsquerdaSerraB){
                esquerdaSerraB()
                bateuEsquerdaSerraB = true
            } else{
                liberaDireitaSerraB = true
                liberaDireitaSerraNB = true
                liberaDireitaSerraSB = true
                liberaCimaB = false
                liberaBaixoB = false
                liberaEsquerdaSerraB = false
                liberaEsquerdaSerraNB = false
                liberaEsquerdaSerraSB = false

            }

        } else if (direction == JoyStickClass.STICK_UPLEFT) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador) && !liberaEsquerdaSerraNB){
                esquerdaSerraNB()
                bateuEsquerdaSerraNB = true
            } else{
                liberaDireitaSerraB = true
                liberaDireitaSerraNB = true
                liberaDireitaSerraSB = true
                liberaCimaB = false
                liberaBaixoB = false
                liberaEsquerdaSerraB = false
                liberaEsquerdaSerraNB = false
                liberaEsquerdaSerraSB = false

            }
        } else if (direction == JoyStickClass.STICK_NONE) {
            if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
                esquerdaSerraB = false
                direitaSerraB = false
                cimaB = false
                baixoB = false
                esquerdaSerraNB = false
                esquerdaSerraSB = false
                direitaSerraSB = false
                direitaSerraNB = false

                movimento()
                ladoGiro = 0
            }
            //movimentoInverso()
            //imageView.setImageResource(R.drawable.ic_lens_black_24dp);
        }
        /*} else{
            movimentoInverso()
            movimento()
            esquerdaSerraB = false
            direitaSerraB = false
            cimaB = false
            baixoB = false
            esquerdaSerraNB = false
            esquerdaSerraSB = false
            direitaSerraSB = false
            direitaSerraNB = false
            movimento()
            ladoGiro = 0
        }*/
    }

    fun cimaB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorUp)
        binding.jogador.rotation = 0F
        cimaa += (1*um_metade).toInt()
        cimaB = true
        esquerdaSerraB = false
        direitaSerraB = false
        baixoB = false
        esquerdaSerraNB = false
        esquerdaSerraSB = false
        direitaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 1
        bateuCimaB = false
        /*} else{
            bateuCimaB = true
        }*/
    }

    fun esquerdaSerraB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorLeft)
        binding.jogador.rotation = 0F
        //jogadorX -= 25; //*sensibilidade;
        esquerdaSerraB = true
        direitaSerraB = false
        cimaB = false
        baixoB = false
        esquerdaSerraNB = false
        esquerdaSerraSB = false
        direitaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 3
        bateuEsquerdaSerraB = false

        /*} else{
            bateuEsquerdaSerraB = true
        }*/
    }
    fun direitaSerraB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorRight)
        binding.jogador.rotation = 0F
        direitaSerraB = true
        esquerdaSerraB = false
        cimaB = false
        baixoB = false
        esquerdaSerraNB = false
        esquerdaSerraSB = false
        direitaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 4
        bateuDireitaSerraB = false

        /*} else{
            bateuDireitaSerraB = true
        }*/
    }

    fun baixoB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorDown)
        binding.jogador.rotation = 0F
        baixoo += (1*um_metade).toInt()
        baixoB = true
        esquerdaSerraB = false
        direitaSerraB = false
        cimaB = false
        esquerdaSerraNB = false
        esquerdaSerraSB = false
        direitaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 2
        bateuBaixoB = false

        /*} else{
            bateuBaixoB = true
        }*/
    }

    fun esquerdaSerraSB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorDownL)
        binding.jogador.rotation = 0F
        //jogadorX -= 25; //*sensibilidade;
        esquerdaSerraSB = true
        esquerdaSerraB = false
        direitaSerraB = false
        cimaB = false
        baixoB = false
        esquerdaSerraNB = false
        direitaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 5
        bateuEsquerdaSerraSB = false

        /*} else{
            bateuEsquerdaSerraSB = true
        }*/
    }

    fun direitaSerraSB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorDownR)
        binding.jogador.rotation = 0F
        direitaSerraSB = true
        esquerdaSerraB = false
        direitaSerraB = false
        cimaB = false
        baixoB = false
        esquerdaSerraNB = false
        esquerdaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 6
        bateuDireitaSerraSB = false

        /*} else{
            bateuDireitaSerraSB = true
        }*/
    }

    fun esquerdaSerraNB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorUpL)
        binding.jogador.rotation = 0F
        esquerdaSerraNB = true
        esquerdaSerraB = false
        direitaSerraB = false
        cimaB = false
        baixoB = false
        esquerdaSerraSB = false
        direitaSerraSB = false
        direitaSerraNB = false
        movimento()
        ladoGiro = 7
        bateuEsquerdaSerraNB = false

        /*} else{
            bateuEsquerdaSerraNB = true
        }*/
    }

    fun direitaSerraNB (){
        //if (!colisorCenarioTeste(jogadorX, jogadorY, binding.jogador)){
        binding.jogador.setImageDrawable(imagejogadorUpR)
        binding.jogador.rotation = 0F
        direitaSerraNB = true
        esquerdaSerraB = false
        direitaSerraB = false
        cimaB = false
        baixoB = false
        esquerdaSerraNB = false
        esquerdaSerraSB = false
        direitaSerraSB = false
        movimento()
        ladoGiro = 8
        bateuDireitaSerraNB = false

        /*} else{
            bateuDireitaSerraNB = true
        }*/
    }


    fun colisorInimigo(
        j1x: Float,
        j2x: Float,
        j1y: Float,
        j2y: Float,
        j1z: ImageView,
        j2z: ImageView
    ): Boolean {
        if (j1x + j1z.width >= j2x && j1x <= j2x + j2z.width &&
            j1y + j1z.height >= j2y && j1y <= j2y + j2z.height
        ) {
            return true
        }
        return false
    }

    /*fun posicaoInimigo(j1: Float,
        j2: Float,
        j1z: ImageView,
        j2z: ImageView?) {

        if (j1 > j2){
            binding.gameFrame.removeView(j1z)
            binding.gameFrame.removeView(j2z)
            binding.gameFrame.addView(j2z)
            binding.gameFrame.addView(j1z)
        } else if (j1 < j2){
            binding.gameFrame.removeView(j1z)
            binding.gameFrame.removeView(j2z)
            binding.gameFrame.addView(j1z)
            binding.gameFrame.addView(j2z)
        }
    }*/

    //INIMIGO
    fun colisores () {
        if (colisorInimigo(inimigoX, inimigo2X, inimigoY, inimigo2Y, binding.inimigoGame, binding.inimigoGame2)){
            //posicaoInimigo(inimigoY, inimigo2Y, binding.inimigoGame, binding.inimigoGame2)
            whenColideInimigo()
            whenColideInimigo2()
        }

        if (colisorInimigo(inimigoX, inimigo3X, inimigoY, inimigo3Y, binding.inimigoGame, binding.inimigoGame3)){
            //posicaoInimigo(inimigoY, inimigo3Y, binding.inimigoGame, binding.inimigoGame3)
            whenColideInimigo()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigoX, inimigo4X, inimigoY, inimigo4Y, binding.inimigoGame, binding.inimigoGame4)){
            //posicaoInimigo(inimigoY, inimigo4Y, binding.inimigoGame, binding.inimigoGame4)
            whenColideInimigo()
            whenColideInimigo4()
        }


        if (colisorInimigo(inimigo2X, inimigo3X, inimigo2Y, inimigo3Y, binding.inimigoGame2, binding.inimigoGame3)){
            //posicaoInimigo(inimigo2Y, inimigo3Y, binding.inimigoGame2, binding.inimigoGame3)
            whenColideInimigo2()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo2X, inimigo4X, inimigo2Y, inimigo4Y, binding.inimigoGame2, binding.inimigoGame4)){
            //posicaoInimigo(inimigo2Y, inimigo4Y, binding.inimigoGame2, binding.inimigoGame4)
            whenColideInimigo2()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo3X, inimigo4X, inimigo3Y, inimigo4Y, binding.inimigoGame3, binding.inimigoGame4)){
            //posicaoInimigo(inimigo3Y, inimigo4Y, binding.inimigoGame3, binding.inimigoGame4)
            whenColideInimigo3()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo2X, inimigo5X, inimigo2Y, inimigo5Y, binding.inimigoGame2, binding.inimigoGame5)){
            //posicaoInimigo(inimigo2Y, inimigo5Y, binding.inimigoGame2, binding.inimigoGame5)
            whenColideInimigo2()
            whenColideInimigo5()
        }

        if (colisorInimigo(inimigoX, inimigo5X, inimigoY, inimigo5Y, binding.inimigoGame, binding.inimigoGame5)){
            //posicaoInimigo(inimigoY, inimigo5Y, binding.inimigoGame, binding.inimigoGame5)
            whenColideInimigo()
            whenColideInimigo5()
        }

        if (colisorInimigo(inimigo5X, inimigo3X, inimigo5Y, inimigo3Y, binding.inimigoGame5, binding.inimigoGame3)){
            //posicaoInimigo(inimigo5Y, inimigo3Y, binding.inimigoGame5, binding.inimigoGame3)
            whenColideInimigo5()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo5X, inimigo4X, inimigo5Y, inimigo4Y, binding.inimigoGame5, binding.inimigoGame4)){
            //posicaoInimigo(inimigo5Y, inimigo4Y, binding.inimigoGame5, binding.inimigoGame4)
            whenColideInimigo5()
            whenColideInimigo4()
        }


        if (colisorInimigo(inimigo5X, inimigo6X, inimigo5Y, inimigo6Y, binding.inimigoGame5, binding.inimigoGame6)){
            //posicaoInimigo(inimigo5Y, inimigo6Y, binding.inimigoGame5, binding.inimigoGame6)
            whenColideInimigo5()
            whenColideInimigo6()
        }
        if (colisorInimigo(inimigo2X, inimigo6X, inimigo2Y, inimigo6Y, binding.inimigoGame2, binding.inimigoGame6)){
            //posicaoInimigo(inimigo2Y, inimigo6Y, binding.inimigoGame2, binding.inimigoGame6)
            whenColideInimigo2()
            whenColideInimigo6()
        }

        if (colisorInimigo(inimigoX, inimigo6X, inimigoY, inimigo6Y, binding.inimigoGame, binding.inimigoGame6)){
            //posicaoInimigo(inimigoY, inimigo6Y, binding.inimigoGame, binding.inimigoGame6)
            whenColideInimigo()
            whenColideInimigo6()
        }

        if (colisorInimigo(inimigo6X, inimigo3X, inimigo6Y, inimigo3Y, binding.inimigoGame6, binding.inimigoGame3)){
            //posicaoInimigo(inimigo6Y, inimigo3Y, binding.inimigoGame6, binding.inimigoGame3)
            whenColideInimigo6()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo6X, inimigo4X, inimigo6Y, inimigo4Y, binding.inimigoGame6, binding.inimigoGame4)){
            //posicaoInimigo(inimigo6Y, inimigo4Y, binding.inimigoGame6, binding.inimigoGame4)
            whenColideInimigo6()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo6X, inimigo7X, inimigo6Y, inimigo7Y, binding.inimigoGame6, binding.inimigoGame7)){
            //posicaoInimigo(inimigo6Y, inimigo7Y, binding.inimigoGame6, binding.inimigoGame7)
            whenColideInimigo6()
            whenColideInimigo7()
        }
        if (colisorInimigo(inimigo5X, inimigo7X, inimigo5Y, inimigo7Y, binding.inimigoGame5, binding.inimigoGame7)){
            //posicaoInimigo(inimigo5Y, inimigo7Y, binding.inimigoGame5, binding.inimigoGame7)
            whenColideInimigo5()
            whenColideInimigo7()
        }
        if (colisorInimigo(inimigo2X, inimigo7X, inimigo2Y, inimigo7Y, binding.inimigoGame2, binding.inimigoGame7)){
            //posicaoInimigo(inimigo2Y, inimigo7Y, binding.inimigoGame2, binding.inimigoGame7)
            whenColideInimigo2()
            whenColideInimigo7()
        }

        if (colisorInimigo(inimigoX, inimigo7X, inimigoY, inimigo7Y, binding.inimigoGame, binding.inimigoGame7)){
            //posicaoInimigo(inimigoY, inimigo7Y, binding.inimigoGame, binding.inimigoGame7)
            whenColideInimigo()
            whenColideInimigo7()
        }

        if (colisorInimigo(inimigo7X, inimigo3X, inimigo7Y, inimigo3Y, binding.inimigoGame7, binding.inimigoGame3)){
            //posicaoInimigo(inimigo7Y, inimigo3Y, binding.inimigoGame7, binding.inimigoGame3)
            whenColideInimigo7()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo7X, inimigo4X, inimigo7Y, inimigo4Y, binding.inimigoGame7, binding.inimigoGame4)){
            //posicaoInimigo(inimigo7Y, inimigo4Y, binding.inimigoGame7, binding.inimigoGame4)
            whenColideInimigo7()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo7X, inimigo8X, inimigo7Y, inimigo8Y, binding.inimigoGame7, binding.inimigoGame8)){
            //posicaoInimigo(inimigo7Y, inimigo8Y, binding.inimigoGame7, binding.inimigoGame8)
            whenColideInimigo7()
            whenColideInimigo8()
        }
        if (colisorInimigo(inimigo6X, inimigo8X, inimigo6Y, inimigo8Y, binding.inimigoGame6, binding.inimigoGame8)){
            //posicaoInimigo(inimigo6Y, inimigo8Y, binding.inimigoGame6, binding.inimigoGame8)
            whenColideInimigo6()
            whenColideInimigo8()
        }
        if (colisorInimigo(inimigo5X, inimigo8X, inimigo5Y, inimigo8Y, binding.inimigoGame5, binding.inimigoGame8)){
            //posicaoInimigo(inimigo5Y, inimigo8Y, binding.inimigoGame5, binding.inimigoGame8)
            whenColideInimigo5()
            whenColideInimigo8()
        }
        if (colisorInimigo(inimigo2X, inimigo8X, inimigo2Y, inimigo8Y, binding.inimigoGame2, binding.inimigoGame8)){
            //posicaoInimigo(inimigo2Y, inimigo8Y, binding.inimigoGame2, binding.inimigoGame8)
            whenColideInimigo2()
            whenColideInimigo8()
        }

        if (colisorInimigo(inimigoX, inimigo8X, inimigoY, inimigo8Y, binding.inimigoGame, binding.inimigoGame8)){
            //posicaoInimigo(inimigoY, inimigo8Y, binding.inimigoGame, binding.inimigoGame8)
            whenColideInimigo()
            whenColideInimigo8()
        }

        if (colisorInimigo(inimigo8X, inimigo3X, inimigo8Y, inimigo3Y, binding.inimigoGame8, binding.inimigoGame3)){
            //posicaoInimigo(inimigo8Y, inimigo3Y, binding.inimigoGame8, binding.inimigoGame3)
            whenColideInimigo8()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo8X, inimigo4X, inimigo8Y, inimigo4Y, binding.inimigoGame8, binding.inimigoGame4)){
            //posicaoInimigo(inimigo8Y, inimigo4Y, binding.inimigoGame8, binding.inimigoGame4)
            whenColideInimigo8()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo8X, inimigo9X, inimigo8Y, inimigo9Y, binding.inimigoGame8, binding.inimigoGame9)){
            //posicaoInimigo(inimigo8Y, inimigo9Y, binding.inimigoGame8, binding.inimigoGame9)
            whenColideInimigo8()
            whenColideInimigo9()
        }
        if (colisorInimigo(inimigo7X, inimigo9X, inimigo7Y, inimigo9Y, binding.inimigoGame7, binding.inimigoGame9)){
            //posicaoInimigo(inimigo7Y, inimigo9Y, binding.inimigoGame7, binding.inimigoGame9)
            whenColideInimigo7()
            whenColideInimigo9()
        }
        if (colisorInimigo(inimigo6X, inimigo9X, inimigo6Y, inimigo9Y, binding.inimigoGame6, binding.inimigoGame9)){
            //posicaoInimigo(inimigo6Y, inimigo9Y, binding.inimigoGame6, binding.inimigoGame9)
            whenColideInimigo6()
            whenColideInimigo9()
        }
        if (colisorInimigo(inimigo5X, inimigo9X, inimigo5Y, inimigo9Y, binding.inimigoGame5, binding.inimigoGame9)){
            //posicaoInimigo(inimigo5Y, inimigo9Y, binding.inimigoGame5, binding.inimigoGame9)
            whenColideInimigo5()
            whenColideInimigo9()
        }
        if (colisorInimigo(inimigo2X, inimigo9X, inimigo2Y, inimigo9Y, binding.inimigoGame2, binding.inimigoGame9)){
            //posicaoInimigo(inimigo2Y, inimigo9Y, binding.inimigoGame2, binding.inimigoGame9)
            whenColideInimigo2()
            whenColideInimigo9()
        }

        if (colisorInimigo(inimigoX, inimigo9X, inimigoY, inimigo9Y, binding.inimigoGame, binding.inimigoGame9)){
            //posicaoInimigo(inimigoY, inimigo9Y, binding.inimigoGame, binding.inimigoGame9)
            whenColideInimigo()
            whenColideInimigo9()
        }

        if (colisorInimigo(inimigo9X, inimigo3X, inimigo9Y, inimigo3Y, binding.inimigoGame9, binding.inimigoGame3)){
            //posicaoInimigo(inimigo9Y, inimigo3Y, binding.inimigoGame9, binding.inimigoGame3)
            whenColideInimigo9()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo9X, inimigo4X, inimigo9Y, inimigo4Y, binding.inimigoGame9, binding.inimigoGame4)){
            //posicaoInimigo(inimigo9Y, inimigo4Y, binding.inimigoGame9, binding.inimigoGame4)
            whenColideInimigo9()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo9X, inimigo10X, inimigo9Y, inimigo10Y, binding.inimigoGame9, binding.inimigoGame10)){
            //posicaoInimigo(inimigo9Y, inimigo10Y, binding.inimigoGame9, binding.inimigoGame10)
            whenColideInimigo9()
            whenColideInimigo10()
        }
        if (colisorInimigo(inimigo8X, inimigo10X, inimigo8Y, inimigo10Y, binding.inimigoGame8, binding.inimigoGame10)){
            //posicaoInimigo(inimigo8Y, inimigo10Y, binding.inimigoGame8, binding.inimigoGame10)
            whenColideInimigo8()
            whenColideInimigo10()
        }
        if (colisorInimigo(inimigo7X, inimigo10X, inimigo7Y, inimigo10Y, binding.inimigoGame7, binding.inimigoGame10)){
            //posicaoInimigo(inimigo7Y, inimigo10Y, binding.inimigoGame7, binding.inimigoGame10)
            whenColideInimigo7()
            whenColideInimigo10()
        }
        if (colisorInimigo(inimigo6X, inimigo10X, inimigo6Y, inimigo10Y, binding.inimigoGame6, binding.inimigoGame10)){
            //posicaoInimigo(inimigo6Y, inimigo10Y, binding.inimigoGame6, binding.inimigoGame10)
            whenColideInimigo6()
            whenColideInimigo10()
        }
        if (colisorInimigo(inimigo5X, inimigo10X, inimigo5Y, inimigo10Y, binding.inimigoGame5, binding.inimigoGame10)){
            //posicaoInimigo(inimigo5Y, inimigo10Y, binding.inimigoGame5, binding.inimigoGame10)
            whenColideInimigo5()
            whenColideInimigo10()
        }
        if (colisorInimigo(inimigo2X, inimigo10X, inimigo2Y, inimigo10Y, binding.inimigoGame2, binding.inimigoGame10)){
            //posicaoInimigo(inimigo2Y, inimigo10Y, binding.inimigoGame2, binding.inimigoGame10)
            whenColideInimigo2()
            whenColideInimigo10()
        }

        if (colisorInimigo(inimigoX, inimigo10X, inimigoY, inimigo10Y, binding.inimigoGame, binding.inimigoGame10)){
            //posicaoInimigo(inimigoY, inimigo10Y, binding.inimigoGame, binding.inimigoGame10)
            whenColideInimigo()
            whenColideInimigo10()
        }

        if (colisorInimigo(inimigo10X, inimigo3X, inimigo10Y, inimigo3Y, binding.inimigoGame10, binding.inimigoGame3)){
            //posicaoInimigo(inimigo10Y, inimigo3Y, binding.inimigoGame10, binding.inimigoGame3)
            whenColideInimigo10()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo10X, inimigo4X, inimigo10Y, inimigo4Y, binding.inimigoGame10, binding.inimigoGame4)){
            //posicaoInimigo(inimigo10Y, inimigo4Y, binding.inimigoGame10, binding.inimigoGame4)
            whenColideInimigo10()
            whenColideInimigo4()
        }

        if (colisorInimigo(inimigo10X, inimigo11X, inimigo10Y, inimigo11Y, binding.inimigoGame10, binding.inimigoGame11)){
            //posicaoInimigo(inimigo10Y, inimigo11Y, binding.inimigoGame10, binding.inimigoGame11)
            whenColideInimigo10()
            whenColideInimigo11()
        }
        if (colisorInimigo(inimigo9X, inimigo11X, inimigo9Y, inimigo11Y, binding.inimigoGame9, binding.inimigoGame11)){
            //posicaoInimigo(inimigo9Y, inimigo11Y, binding.inimigoGame9, binding.inimigoGame11)
            whenColideInimigo9()
            whenColideInimigo11()
        }
        if (colisorInimigo(inimigo8X, inimigo11X, inimigo8Y, inimigo11Y, binding.inimigoGame8, binding.inimigoGame11)){
            //posicaoInimigo(inimigo8Y, inimigo11Y, binding.inimigoGame8, binding.inimigoGame11)
            whenColideInimigo8()
            whenColideInimigo11()
        }
        if (colisorInimigo(inimigo7X, inimigo11X, inimigo7Y, inimigo11Y, binding.inimigoGame7, binding.inimigoGame11)){
            //posicaoInimigo(inimigo7Y, inimigo11Y, binding.inimigoGame7, binding.inimigoGame11)
            whenColideInimigo7()
            whenColideInimigo11()
        }
        if (colisorInimigo(inimigo6X, inimigo11X, inimigo6Y, inimigo11Y, binding.inimigoGame6, binding.inimigoGame11)){
            //posicaoInimigo(inimigo6Y, inimigo11Y, binding.inimigoGame6, binding.inimigoGame11)
            whenColideInimigo6()
            whenColideInimigo11()
        }
        if (colisorInimigo(inimigo5X, inimigo11X, inimigo5Y, inimigo11Y, binding.inimigoGame5, binding.inimigoGame11)){
            //posicaoInimigo(inimigo5Y, inimigo11Y, binding.inimigoGame5, binding.inimigoGame11)
            whenColideInimigo5()
            whenColideInimigo11()
        }
        if (colisorInimigo(inimigo2X, inimigo11X, inimigo2Y, inimigo11Y, binding.inimigoGame2, binding.inimigoGame11)){
            //posicaoInimigo(inimigo2Y, inimigo11Y, binding.inimigoGame2, binding.inimigoGame11)
            whenColideInimigo2()
            whenColideInimigo11()
        }

        if (colisorInimigo(inimigoX, inimigo11X, inimigoY, inimigo11Y, binding.inimigoGame, binding.inimigoGame11)){
            //posicaoInimigo(inimigoY, inimigo11Y, binding.inimigoGame, binding.inimigoGame11)
            whenColideInimigo()
            whenColideInimigo11()
        }

        if (colisorInimigo(inimigo11X, inimigo3X, inimigo11Y, inimigo3Y, binding.inimigoGame11, binding.inimigoGame3)){
            //posicaoInimigo(inimigo11Y, inimigo3Y, binding.inimigoGame11, binding.inimigoGame3)
            whenColideInimigo11()
            whenColideInimigo3()
        }

        if (colisorInimigo(inimigo11X, inimigo4X, inimigo11Y, inimigo4Y, binding.inimigoGame11, binding.inimigoGame4)){
            //posicaoInimigo(inimigo11Y, inimigo4Y, binding.inimigoGame11, binding.inimigoGame4)
            whenColideInimigo11()
            whenColideInimigo4()
        }

/////////////////////////////////////
        if (colisorInimigo(desafio1X, inimigoX, desafio1Y, inimigoY, binding.desafio1Game, binding.inimigoGame)){
            //posicaoInimigo(desafio1Y, inimigoY, binding.desafio1Game, binding.inimigoGame)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo2X, desafio1Y, inimigo2Y, binding.desafio1Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio1Y, inimigo2Y, binding.desafio1Game, binding.inimigoGame2)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo2 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo3X, desafio1Y, inimigo3Y, binding.desafio1Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio1Y, inimigo3Y, binding.desafio1Game, binding.inimigoGame3)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo3 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo4X, desafio1Y, inimigo4Y, binding.desafio1Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio1Y, inimigo4Y, binding.desafio1Game, binding.inimigoGame4)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo4 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo5X, desafio1Y, inimigo5Y, binding.desafio1Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio1Y, inimigo5Y, binding.desafio1Game, binding.inimigoGame2)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo5 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo6X, desafio1Y, inimigo6Y, binding.desafio1Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio1Y, inimigo6Y, binding.desafio1Game, binding.inimigoGame3)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo6 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo7X, desafio1Y, inimigo7Y, binding.desafio1Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio1Y, inimigo7Y, binding.desafio1Game, binding.inimigoGame4)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo7 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo8X, desafio1Y, inimigo8Y, binding.desafio1Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio1Y, inimigo8Y, binding.desafio1Game, binding.inimigoGame4)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo8 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo9X, desafio1Y, inimigo9Y, binding.desafio1Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio1Y, inimigo9Y, binding.desafio1Game, binding.inimigoGame2)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo9 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo10X, desafio1Y, inimigo10Y, binding.desafio1Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio1Y, inimigo10Y, binding.desafio1Game, binding.inimigoGame3)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo10 += desafio1Pontos
        }

        if (colisorInimigo(desafio1X, inimigo11X, desafio1Y, inimigo11Y, binding.desafio1Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio1Y, inimigo11Y, binding.desafio1Game, binding.inimigoGame4)
            desafio1gX = randomX(desafio1X)
            desafio1gY = randomY(desafio1Y)
            pontuacaoInimigo11 += desafio1Pontos
        }


        if (colisorInimigo(desafio2X, inimigoX, desafio2Y, inimigoY, binding.desafio2Game, binding.inimigoGame)){
            //posicaoInimigo(desafio2Y, inimigoY, binding.desafio2Game, binding.inimigoGame)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo2X, desafio2Y, inimigo2Y, binding.desafio2Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio2Y, inimigo2Y, binding.desafio2Game, binding.inimigoGame2)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo2 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo3X, desafio2Y, inimigo3Y, binding.desafio2Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio2Y, inimigo3Y, binding.desafio2Game, binding.inimigoGame3)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo3 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo4X, desafio2Y, inimigo4Y, binding.desafio2Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio2Y, inimigo4Y, binding.desafio2Game, binding.inimigoGame4)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo4 += desafio2Pontos
        }
        if (colisorInimigo(desafio2X, inimigo5X, desafio2Y, inimigo5Y, binding.desafio2Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio2Y, inimigo5Y, binding.desafio2Game, binding.inimigoGame2)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo5 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo6X, desafio2Y, inimigo6Y, binding.desafio2Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio2Y, inimigo6Y, binding.desafio2Game, binding.inimigoGame3)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo6 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo7X, desafio2Y, inimigo7Y, binding.desafio2Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio2Y, inimigo7Y, binding.desafio2Game, binding.inimigoGame4)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo7 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo8X, desafio2Y, inimigo8Y, binding.desafio2Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio2Y, inimigo8Y, binding.desafio2Game, binding.inimigoGame4)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo8 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo9X, desafio2Y, inimigo9Y, binding.desafio2Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio2Y, inimigo9Y, binding.desafio2Game, binding.inimigoGame2)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo9 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo10X, desafio2Y, inimigo10Y, binding.desafio2Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio2Y, inimigo10Y, binding.desafio2Game, binding.inimigoGame3)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo10 += desafio2Pontos
        }

        if (colisorInimigo(desafio2X, inimigo11X, desafio2Y, inimigo11Y, binding.desafio2Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio2Y, inimigo11Y, binding.desafio2Game, binding.inimigoGame4)
            desafio2gX = randomX(desafio2X)
            desafio2gY = randomY(desafio2Y)
            pontuacaoInimigo11 += desafio2Pontos
        }


        if (colisorInimigo(desafio3X, inimigoX, desafio3Y, inimigoY, binding.desafio3Game, binding.inimigoGame)){
            //posicaoInimigo(desafio3Y, inimigoY, binding.desafio3Game, binding.inimigoGame)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo2X, desafio3Y, inimigo2Y, binding.desafio3Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio3Y, inimigo2Y, binding.desafio3Game, binding.inimigoGame2)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo2 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo3X, desafio3Y, inimigo3Y, binding.desafio3Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio3Y, inimigo3Y, binding.desafio3Game, binding.inimigoGame3)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo3 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo4X, desafio3Y, inimigo4Y, binding.desafio3Game, binding.inimigoGame4)) {
            //posicaoInimigo(desafio3Y, inimigo4Y, binding.desafio3Game, binding.inimigoGame4)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo4 += desafio3Pontos
        }
        if (colisorInimigo(desafio3X, inimigo5X, desafio3Y, inimigo5Y, binding.desafio3Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio3Y, inimigo5Y, binding.desafio3Game, binding.inimigoGame2)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo5 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo6X, desafio3Y, inimigo6Y, binding.desafio3Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio3Y, inimigo6Y, binding.desafio3Game, binding.inimigoGame3)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo6 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo7X, desafio3Y, inimigo7Y, binding.desafio3Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio3Y, inimigo7Y, binding.desafio3Game, binding.inimigoGame4)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo7 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo8X, desafio3Y, inimigo8Y, binding.desafio3Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio3Y, inimigo8Y, binding.desafio3Game, binding.inimigoGame4)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo8 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo9X, desafio3Y, inimigo9Y, binding.desafio3Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio3Y, inimigo9Y, binding.desafio3Game, binding.inimigoGame2)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo9 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo10X, desafio3Y, inimigo10Y, binding.desafio3Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio3Y, inimigo10Y, binding.desafio3Game, binding.inimigoGame3)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo10 += desafio3Pontos
        }

        if (colisorInimigo(desafio3X, inimigo11X, desafio3Y, inimigo11Y, binding.desafio3Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio3Y, inimigo11Y, binding.desafio3Game, binding.inimigoGame4)
            desafio3gX = randomX(desafio3X)
            desafio3gY = randomY(desafio3Y)
            pontuacaoInimigo11 += desafio3Pontos
        }


        if (colisorInimigo(desafio4X, inimigoX, desafio4Y, inimigoY, binding.desafio4Game, binding.inimigoGame)){
            //posicaoInimigo(desafio4Y, inimigoY, binding.desafio4Game, binding.inimigoGame)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo2X, desafio4Y, inimigo2Y, binding.desafio4Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio4Y, inimigo2Y, binding.desafio4Game, binding.inimigoGame2)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo2 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo3X, desafio4Y, inimigo3Y, binding.desafio4Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio4Y, inimigo3Y, binding.desafio4Game, binding.inimigoGame3)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo3 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo4X, desafio4Y, inimigo4Y, binding.desafio4Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio4Y, inimigo4Y, binding.desafio4Game, binding.inimigoGame4)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo4 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo5X, desafio4Y, inimigo5Y, binding.desafio4Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio4Y, inimigo5Y, binding.desafio4Game, binding.inimigoGame2)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo5 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo6X, desafio4Y, inimigo6Y, binding.desafio4Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio4Y, inimigo6Y, binding.desafio4Game, binding.inimigoGame3)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo6 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo7X, desafio4Y, inimigo7Y, binding.desafio4Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio4Y, inimigo7Y, binding.desafio4Game, binding.inimigoGame4)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo7 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo8X, desafio4Y, inimigo8Y, binding.desafio4Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio4Y, inimigo8Y, binding.desafio4Game, binding.inimigoGame4)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo8 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo9X, desafio4Y, inimigo9Y, binding.desafio4Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio4Y, inimigo9Y, binding.desafio4Game, binding.inimigoGame2)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo9 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo10X, desafio4Y, inimigo10Y, binding.desafio4Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio4Y, inimigo10Y, binding.desafio4Game, binding.inimigoGame3)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo10 += desafio4Pontos
        }

        if (colisorInimigo(desafio4X, inimigo11X, desafio4Y, inimigo11Y, binding.desafio4Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio4Y, inimigo11Y, binding.desafio4Game, binding.inimigoGame4)
            desafio4gX = randomX(desafio4X)
            desafio4gY = randomY(desafio4Y)
            pontuacaoInimigo11 += desafio4Pontos
        }



        if (colisorInimigo(desafio5X, inimigoX, desafio5Y, inimigoY, binding.desafio5Game, binding.inimigoGame)){
            //posicaoInimigo(desafio5Y, inimigoY, binding.desafio5Game, binding.inimigoGame)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo2X, desafio5Y, inimigo2Y, binding.desafio5Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio5Y, inimigo2Y, binding.desafio5Game, binding.inimigoGame2)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo2 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo3X, desafio5Y, inimigo3Y, binding.desafio5Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio5Y, inimigo3Y, binding.desafio5Game, binding.inimigoGame3)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo3 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo4X, desafio5Y, inimigo4Y, binding.desafio5Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio5Y, inimigo4Y, binding.desafio5Game, binding.inimigoGame4)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo4 += desafio5Pontos
        }
        if (colisorInimigo(desafio5X, inimigo5X, desafio5Y, inimigo5Y, binding.desafio5Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio5Y, inimigo5Y, binding.desafio5Game, binding.inimigoGame2)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo5 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo6X, desafio5Y, inimigo6Y, binding.desafio5Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio5Y, inimigo6Y, binding.desafio5Game, binding.inimigoGame3)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo6 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo7X, desafio5Y, inimigo7Y, binding.desafio5Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio5Y, inimigo7Y, binding.desafio5Game, binding.inimigoGame4)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo7 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo8X, desafio5Y, inimigo8Y, binding.desafio5Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio5Y, inimigo8Y, binding.desafio5Game, binding.inimigoGame4)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo8 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo9X, desafio5Y, inimigo9Y, binding.desafio5Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio5Y, inimigo9Y, binding.desafio5Game, binding.inimigoGame2)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo9 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo10X, desafio5Y, inimigo10Y, binding.desafio5Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio5Y, inimigo10Y, binding.desafio5Game, binding.inimigoGame3)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo10 += desafio5Pontos
        }

        if (colisorInimigo(desafio5X, inimigo11X, desafio5Y, inimigo11Y, binding.desafio5Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio5Y, inimigo11Y, binding.desafio5Game, binding.inimigoGame4)
            desafio5gX = randomX(desafio5X)
            desafio5gY = randomY(desafio5Y)
            pontuacaoInimigo11 += desafio5Pontos
        }


        if (colisorInimigo(desafio6X, inimigoX, desafio6Y, inimigoY, binding.desafio6Game, binding.inimigoGame)){
            //posicaoInimigo(desafio6Y, inimigoY, binding.desafio6Game, binding.inimigoGame)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo2X, desafio6Y, inimigo2Y, binding.desafio6Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio6Y, inimigo2Y, binding.desafio6Game, binding.inimigoGame2)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo2 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo3X, desafio6Y, inimigo3Y, binding.desafio6Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio6Y, inimigo3Y, binding.desafio6Game, binding.inimigoGame3)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo3 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo4X, desafio6Y, inimigo4Y, binding.desafio6Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio6Y, inimigo4Y, binding.desafio6Game, binding.inimigoGame4)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo4 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo5X, desafio6Y, inimigo5Y, binding.desafio6Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio6Y, inimigo5Y, binding.desafio6Game, binding.inimigoGame2)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo5 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo6X, desafio6Y, inimigo6Y, binding.desafio6Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio6Y, inimigo6Y, binding.desafio6Game, binding.inimigoGame3)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo6 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo7X, desafio6Y, inimigo7Y, binding.desafio6Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio6Y, inimigo7Y, binding.desafio6Game, binding.inimigoGame4)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo7 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo8X, desafio6Y, inimigo8Y, binding.desafio6Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio6Y, inimigo8Y, binding.desafio6Game, binding.inimigoGame4)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo8 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo9X, desafio6Y, inimigo9Y, binding.desafio6Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio6Y, inimigo9Y, binding.desafio6Game, binding.inimigoGame2)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo9 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo10X, desafio6Y, inimigo10Y, binding.desafio6Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio6Y, inimigo10Y, binding.desafio6Game, binding.inimigoGame3)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo10 += desafio6Pontos
        }

        if (colisorInimigo(desafio6X, inimigo11X, desafio6Y, inimigo11Y, binding.desafio6Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio6Y, inimigo11Y, binding.desafio6Game, binding.inimigoGame4)
            desafio6gX = randomX(desafio6X)
            desafio6gY = randomY(desafio6Y)
            pontuacaoInimigo11 += desafio6Pontos
        }



        if (colisorInimigo(desafio7X, inimigoX, desafio7Y, inimigoY, binding.desafio7Game, binding.inimigoGame)){
            //posicaoInimigo(desafio7Y, inimigoY, binding.desafio7Game, binding.inimigoGame)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo2X, desafio7Y, inimigo2Y, binding.desafio7Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio7Y, inimigo2Y, binding.desafio7Game, binding.inimigoGame2)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo2 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo3X, desafio7Y, inimigo3Y, binding.desafio7Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio7Y, inimigo3Y, binding.desafio7Game, binding.inimigoGame3)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo3 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo4X, desafio7Y, inimigo4Y, binding.desafio7Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio7Y, inimigo4Y, binding.desafio7Game, binding.inimigoGame4)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo4 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo5X, desafio7Y, inimigo5Y, binding.desafio7Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio7Y, inimigo5Y, binding.desafio7Game, binding.inimigoGame2)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo5 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo6X, desafio7Y, inimigo6Y, binding.desafio7Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio7Y, inimigo6Y, binding.desafio7Game, binding.inimigoGame3)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo6 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo7X, desafio7Y, inimigo7Y, binding.desafio7Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio7Y, inimigo7Y, binding.desafio7Game, binding.inimigoGame4)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo7 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo8X, desafio7Y, inimigo8Y, binding.desafio7Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio7Y, inimigo8Y, binding.desafio7Game, binding.inimigoGame4)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo8 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo9X, desafio7Y, inimigo9Y, binding.desafio7Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio7Y, inimigo9Y, binding.desafio7Game, binding.inimigoGame2)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo9 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo10X, desafio7Y, inimigo10Y, binding.desafio7Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio7Y, inimigo10Y, binding.desafio7Game, binding.inimigoGame3)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo10 += desafio7Pontos
        }

        if (colisorInimigo(desafio7X, inimigo11X, desafio7Y, inimigo11Y, binding.desafio7Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio7Y, inimigo11Y, binding.desafio7Game, binding.inimigoGame4)
            desafio7gX = randomX(desafio7X)
            desafio7gY = randomY(desafio7Y)
            pontuacaoInimigo11 += desafio7Pontos
        }


        if (colisorInimigo(desafio8X, inimigoX, desafio8Y, inimigoY, binding.desafio8Game, binding.inimigoGame)){
            //posicaoInimigo(desafio8Y, inimigoY, binding.desafio8Game, binding.inimigoGame)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo2X, desafio8Y, inimigo2Y, binding.desafio8Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio8Y, inimigo2Y, binding.desafio8Game, binding.inimigoGame2)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo2 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo3X, desafio8Y, inimigo3Y, binding.desafio8Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio8Y, inimigo3Y, binding.desafio8Game, binding.inimigoGame3)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo3 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo4X, desafio8Y, inimigo4Y, binding.desafio8Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio8Y, inimigo4Y, binding.desafio8Game, binding.inimigoGame4)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo4 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo5X, desafio8Y, inimigo5Y, binding.desafio8Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio8Y, inimigo5Y, binding.desafio8Game, binding.inimigoGame2)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo5 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo6X, desafio8Y, inimigo6Y, binding.desafio8Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio8Y, inimigo6Y, binding.desafio8Game, binding.inimigoGame3)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo6 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo7X, desafio8Y, inimigo7Y, binding.desafio8Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio8Y, inimigo7Y, binding.desafio8Game, binding.inimigoGame4)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo7 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo8X, desafio8Y, inimigo8Y, binding.desafio8Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio8Y, inimigo8Y, binding.desafio8Game, binding.inimigoGame4)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo8 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo9X, desafio8Y, inimigo9Y, binding.desafio8Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio8Y, inimigo9Y, binding.desafio8Game, binding.inimigoGame2)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo9 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo10X, desafio8Y, inimigo10Y, binding.desafio8Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio8Y, inimigo10Y, binding.desafio8Game, binding.inimigoGame3)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo10 += desafio8Pontos
        }

        if (colisorInimigo(desafio8X, inimigo11X, desafio8Y, inimigo11Y, binding.desafio8Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio8Y, inimigo11Y, binding.desafio8Game, binding.inimigoGame4)
            desafio8gX = randomX(desafio8X)
            desafio8gY = randomY(desafio8Y)
            pontuacaoInimigo11 += desafio8Pontos
        }


        if (colisorInimigo(desafio9X, inimigoX, desafio9Y, inimigoY, binding.desafio9Game, binding.inimigoGame)){
            //posicaoInimigo(desafio9Y, inimigoY, binding.desafio9Game, binding.inimigoGame)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo2X, desafio9Y, inimigo2Y, binding.desafio9Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio9Y, inimigo2Y, binding.desafio9Game, binding.inimigoGame2)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo2 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo3X, desafio9Y, inimigo3Y, binding.desafio9Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio9Y, inimigo3Y, binding.desafio9Game, binding.inimigoGame3)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo3 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo4X, desafio9Y, inimigo4Y, binding.desafio9Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio9Y, inimigo4Y, binding.desafio9Game, binding.inimigoGame4)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo4 += desafio9Pontos
        }
        if (colisorInimigo(desafio9X, inimigo5X, desafio9Y, inimigo5Y, binding.desafio9Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio9Y, inimigo5Y, binding.desafio9Game, binding.inimigoGame2)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo5 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo6X, desafio9Y, inimigo6Y, binding.desafio9Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio9Y, inimigo6Y, binding.desafio9Game, binding.inimigoGame3)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo6 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo7X, desafio9Y, inimigo7Y, binding.desafio9Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio9Y, inimigo7Y, binding.desafio9Game, binding.inimigoGame4)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo7 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo8X, desafio9Y, inimigo8Y, binding.desafio9Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio9Y, inimigo8Y, binding.desafio9Game, binding.inimigoGame4)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo8 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo9X, desafio9Y, inimigo9Y, binding.desafio9Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio9Y, inimigo9Y, binding.desafio9Game, binding.inimigoGame2)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo9 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo10X, desafio9Y, inimigo10Y, binding.desafio9Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio9Y, inimigo10Y, binding.desafio9Game, binding.inimigoGame3)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo10 += desafio9Pontos
        }

        if (colisorInimigo(desafio9X, inimigo11X, desafio9Y, inimigo11Y, binding.desafio9Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio9Y, inimigo11Y, binding.desafio9Game, binding.inimigoGame4)
            desafio9gX = randomX(desafio9X)
            desafio9gY = randomY(desafio9Y)
            pontuacaoInimigo11 += desafio9Pontos
        }


        if (colisorInimigo(desafio10X, inimigoX, desafio10Y, inimigoY, binding.desafio10Game, binding.inimigoGame)){
            //posicaoInimigo(desafio10Y, inimigoY, binding.desafio10Game, binding.inimigoGame)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo2X, desafio10Y, inimigo2Y, binding.desafio10Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio10Y, inimigo2Y, binding.desafio10Game, binding.inimigoGame2)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo2 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo3X, desafio10Y, inimigo3Y, binding.desafio10Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio10Y, inimigo3Y, binding.desafio10Game, binding.inimigoGame3)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo3 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo4X, desafio10Y, inimigo4Y, binding.desafio10Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio10Y, inimigo4Y, binding.desafio10Game, binding.inimigoGame4)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo4 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo5X, desafio10Y, inimigo5Y, binding.desafio10Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio10Y, inimigo5Y, binding.desafio10Game, binding.inimigoGame2)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo5 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo6X, desafio10Y, inimigo6Y, binding.desafio10Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio10Y, inimigo6Y, binding.desafio10Game, binding.inimigoGame3)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo6 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo7X, desafio10Y, inimigo7Y, binding.desafio10Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio10Y, inimigo7Y, binding.desafio10Game, binding.inimigoGame4)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo7 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo8X, desafio10Y, inimigo8Y, binding.desafio10Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio10Y, inimigo8Y, binding.desafio10Game, binding.inimigoGame4)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo8 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo9X, desafio10Y, inimigo9Y, binding.desafio10Game, binding.inimigoGame2)){
            //posicaoInimigo(desafio10Y, inimigo9Y, binding.desafio10Game, binding.inimigoGame2)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo9 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo10X, desafio10Y, inimigo10Y, binding.desafio10Game, binding.inimigoGame3)){
            //posicaoInimigo(desafio10Y, inimigo10Y, binding.desafio10Game, binding.inimigoGame3)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo10 += desafio10Pontos
        }

        if (colisorInimigo(desafio10X, inimigo11X, desafio10Y, inimigo11Y, binding.desafio10Game, binding.inimigoGame4)){
            //posicaoInimigo(desafio10Y, inimigo11Y, binding.desafio10Game, binding.inimigoGame4)
            desafio10gX = randomX(desafio10X)
            desafio10gY = randomY(desafio10Y)
            pontuacaoInimigo11 += desafio10Pontos
        }

    }

    //Mudar os valores para os sem mascara
    fun inimigo1(){
        if (inimigo == 0){
            inimigogY = randomY(inimigogY)
            inimigogX = randomX(inimigogX)
            inimigoY = heightCidade(binding.inimigoGame, inimigogY) + inimigoyY
            inimigoX = widthCidade(binding.inimigoGame, inimigogX) + inimigoxX
            if (colisorCenario(inimigoX, inimigoY, binding.inimigoGame)){
                inimigo = 0
            } else{
                inimigo = 1
            }
        } else{
            if (inimigo == 1) {
                inimigoyY -= velocidadeInimigo
                inimigoxX -= 0

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_c)
                binding.inimigoGame.rotationY = 180F
            }

            if (inimigo == 2) {
                inimigoyY += velocidadeInimigo
                inimigoxX -= 0

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_b)
                binding.inimigoGame.rotationY = 180F

            }

            if (inimigo == 3) {
                inimigoyY += 0
                inimigoxX -= velocidadeInimigo

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_d)
                binding.inimigoGame.rotationY = 180F
            }

            if (inimigo == 4) {
                inimigoyY += 0
                inimigoxX += velocidadeInimigo

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_e)
                binding.inimigoGame.rotationY = 180F

            }

            if (inimigo == 5) {
                inimigoyY -= velocidadeInimigo
                inimigoxX -= velocidadeInimigo

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_c)
                binding.inimigoGame.rotationY = 180F
            }

            if (inimigo == 6) {
                inimigoyY += velocidadeInimigo
                inimigoxX += velocidadeInimigo

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_b)
                binding.inimigoGame.rotationY = 180F

            }

            if (inimigo == 7) {
                inimigoyY += velocidadeInimigo
                inimigoxX -= velocidadeInimigo

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_b)
                binding.inimigoGame.rotationY = 180F
            }

            if (inimigo == 8) {
                inimigoyY -= velocidadeInimigo
                inimigoxX += velocidadeInimigo

                binding.inimigoGame.setImageResource(R.drawable.ic_jogador_amarelo_4_m_c)
                binding.inimigoGame.rotationY = 180F

            }

            inimigoY = heightCidade(binding.inimigoGame, inimigogY) + inimigoyY
            inimigoX = widthCidade(binding.inimigoGame, inimigogX) + inimigoxX

            if (colisorCenario(inimigoX, inimigoY, binding.inimigoGame)) {
                whenColideInimigo()
            }

            binding.inimigoGame.x = inimigoX
            binding.inimigoGame.y = inimigoY


            if (colisorJogadorParar(inimigoX, inimigoY, binding.inimigoGame)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }

    }
    fun whenColideInimigo(){
        when (inimigo){
            1 ->{
                /**C**/
                inimigoyY += 10*um_metade
                inimigoxX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo = number

            }
            2 -> {
                /**B**/
                inimigoyY -= 10*um_metade
                inimigoxX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo = number

            }
            3 -> {
                /**E**/
                inimigoyY += 0
                inimigoxX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo = number

            }
            4 ->  {
                /**D**/
                inimigoyY += 0
                inimigoxX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo = number

            }
            5 ->  {
                /**EN**/
                inimigoyY += 10
                inimigoxX += 10
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo = number

            }
            6 ->  {
                /**DS**/
                inimigoyY -= 10*um_metade
                inimigoxX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo = number

            }
            7 ->  {
                /**ES**/
                inimigoyY -= 10*um_metade
                inimigoxX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo = number

            }
            8 -> {
                /**DN**/
                inimigoyY += 10*um_metade
                inimigoxX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo = number

            }
        }
    }

    fun inimigo2(){
        if (inimigo2 == 0){
            inimigog2Y = randomY(inimigog2Y)
            inimigog2X = randomX(inimigog2X)
            inimigo2Y = heightCidade(binding.inimigoGame2, inimigog2Y) + inimigo2yY
            inimigo2X = widthCidade(binding.inimigoGame2, inimigog2X) + inimigo2xX
            if (colisorCenario(inimigo2X, inimigo2Y, binding.inimigoGame2)){
                inimigo2 = 0
            } else{
                inimigo2 = 2
            }
        } else{
            if (inimigo2 == 1) {
                inimigo2yY -= velocidadeInimigo
                inimigo2xX -= 0

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_c)
                binding.inimigoGame2.rotationY = 180F
            }

            if (inimigo2 == 2) {
                inimigo2yY += velocidadeInimigo
                inimigo2xX -= 0

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_b)
                binding.inimigoGame2.rotationY = 180F

            }

            if (inimigo2 == 3) {
                inimigo2yY += 0
                inimigo2xX -= velocidadeInimigo

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_d)
                binding.inimigoGame2.rotationY = 180F
            }

            if (inimigo2 == 4) {
                inimigo2yY += 0
                inimigo2xX += velocidadeInimigo

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_e)
                binding.inimigoGame2.rotationY = 180F

            }

            if (inimigo2 == 5) {
                inimigo2yY -= velocidadeInimigo
                inimigo2xX -= velocidadeInimigo

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_c)
                binding.inimigoGame2.rotationY = 180F
            }

            if (inimigo2 == 6) {
                inimigo2yY += velocidadeInimigo
                inimigo2xX += velocidadeInimigo

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_b)
                binding.inimigoGame2.rotationY = 180F

            }

            if (inimigo2 == 7) {
                inimigo2yY += velocidadeInimigo
                inimigo2xX -= velocidadeInimigo

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_b)
                binding.inimigoGame2.rotationY = 180F
            }

            if (inimigo2 == 8) {
                inimigo2yY -= velocidadeInimigo
                inimigo2xX += velocidadeInimigo

                binding.inimigoGame2.setImageResource(R.drawable.ic_jogador_azul_1_h_c)
                binding.inimigoGame2.rotationY = 180F

            }

            inimigo2Y = heightCidade(binding.inimigoGame2, inimigog2Y) + inimigo2yY
            inimigo2X = widthCidade(binding.inimigoGame2, inimigog2X) + inimigo2xX

            if (colisorCenario(inimigo2X, inimigo2Y, binding.inimigoGame2)) {
                whenColideInimigo2()
            }

            binding.inimigoGame2.x = inimigo2X
            binding.inimigoGame2.y = inimigo2Y



            if (colisorJogadorParar(inimigo2X, inimigo2Y, binding.inimigoGame2)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo2(){
        when (inimigo2){
            1 ->{
                /**C**/
                inimigo2yY += 10*um_metade
                inimigo2xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo2 = number

            }
            2 -> {
                /**B**/
                inimigo2yY -= 10*um_metade
                inimigo2xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo2 = number

            }
            3 -> {
                /**E**/
                inimigo2yY += 0
                inimigo2xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo2 = number

            }
            4 ->  {
                /**D**/
                inimigo2yY += 0
                inimigo2xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo2 = number

            }
            5 ->  {
                /**EN**/
                inimigo2yY += 10*um_metade
                inimigo2xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo2 = number

            }
            6 ->  {
                /**DS**/
                inimigo2yY -= 10*um_metade
                inimigo2xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo2 = number

            }
            7 ->  {
                /**ES**/
                inimigo2yY -= 10*um_metade
                inimigo2xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo2 = number

            }
            8 -> {
                /**DN**/
                inimigo2yY += 10*um_metade
                inimigo2xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo2 = number

            }
        }
    }

    fun inimigo3(){
        if (inimigo3 == 0){
            inimigog3Y = randomY(inimigog3Y)
            inimigog3X = randomX(inimigog3X)
            inimigo3Y = heightCidade(binding.inimigoGame3, inimigog3Y) + inimigo3yY
            inimigo3X = widthCidade(binding.inimigoGame3, inimigog3X) + inimigo3xX
            if (colisorCenario(inimigo3X, inimigo3Y, binding.inimigoGame3)){
                inimigo3 = 0
            } else{
                inimigo3 = 3
            }
        } else {
            if (inimigo3 == 1) {
                inimigo3yY -= velocidadeInimigo
                inimigo3xX -= 0

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_c)
                binding.inimigoGame3.rotationY = 180F
            }

            if (inimigo3 == 2) {
                inimigo3yY += velocidadeInimigo
                inimigo3xX -= 0

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_b)
                binding.inimigoGame3.rotationY = 180F

            }

            if (inimigo3 == 3) {
                inimigo3yY += 0
                inimigo3xX -= velocidadeInimigo

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_d)
                binding.inimigoGame3.rotationY = 180F
            }

            if (inimigo3 == 4) {
                inimigo3yY += 0
                inimigo3xX += velocidadeInimigo

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_e)
                binding.inimigoGame3.rotationY = 180F

            }

            if (inimigo3 == 5) {
                inimigo3yY -= velocidadeInimigo
                inimigo3xX -= velocidadeInimigo

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_c)
                binding.inimigoGame3.rotationY = 180F
            }

            if (inimigo3 == 6) {
                inimigo3yY += velocidadeInimigo
                inimigo3xX += velocidadeInimigo

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_b)
                binding.inimigoGame3.rotationY = 180F

            }

            if (inimigo3 == 7) {
                inimigo3yY += velocidadeInimigo
                inimigo3xX -= velocidadeInimigo

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_b)
                binding.inimigoGame3.rotationY = 180F
            }

            if (inimigo3 == 8) {
                inimigo3yY -= velocidadeInimigo
                inimigo3xX += velocidadeInimigo

                binding.inimigoGame3.setImageResource(R.drawable.ic_jogador_azul_escuro_1_h_c)
                binding.inimigoGame3.rotationY = 180F

            }

            inimigo3Y = heightCidade(binding.inimigoGame3, inimigog3Y) + inimigo3yY
            inimigo3X = widthCidade(binding.inimigoGame3, inimigog3X) + inimigo3xX

            if (colisorCenario(inimigo3X, inimigo3Y, binding.inimigoGame3)) {
                whenColideInimigo3()
            }

            binding.inimigoGame3.x = inimigo3X
            binding.inimigoGame3.y = inimigo3Y



            if (colisorJogadorParar(inimigo3X, inimigo3Y, binding.inimigoGame3)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }

    }

    fun whenColideInimigo3(){
        when (inimigo3){
            1 ->{
                /**C**/
                inimigo3yY += 10*um_metade
                inimigo3xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo3 = number

            }
            2 -> {
                /**B**/
                inimigo3yY -= 10*um_metade
                inimigo3xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo3 = number

            }
            3 -> {
                /**E**/
                inimigo3yY += 0
                inimigo3xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo3 = number

            }
            4 ->  {
                /**D**/
                inimigo3yY += 0
                inimigo3xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo3 = number

            }
            5 ->  {
                /**EN**/
                inimigo3yY += 10*um_metade
                inimigo3xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo3 = number

            }
            6 ->  {
                /**DS**/
                inimigo3yY -= 10*um_metade
                inimigo3xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo3 = number

            }
            7 ->  {
                /**ES**/
                inimigo3yY -= 10*um_metade
                inimigo3xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo3 = number

            }
            8 -> {
                /**DN**/
                inimigo3yY += 10*um_metade
                inimigo3xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo3 = number

            }

        }
    }

    fun inimigo4(){
        if (inimigo4 == 0){
            inimigog4Y = randomY(inimigog4Y)
            inimigog4X = randomX(inimigog4X)
            inimigo4Y = heightCidade(binding.inimigoGame4, inimigog4Y) + inimigo4yY
            inimigo4X = widthCidade(binding.inimigoGame4, inimigog4X) + inimigo4xX
            if (colisorCenario(inimigo4X, inimigo4Y, binding.inimigoGame4)){
                inimigo4 = 0
            } else{
                inimigo4 = 4
            }
        } else {
            if (inimigo4 == 1) {
                inimigo4yY -= velocidadeInimigo
                inimigo4xX -= 0

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_c)
                binding.inimigoGame4.rotationY = 180F
            }

            if (inimigo4 == 2) {
                inimigo4yY += velocidadeInimigo
                inimigo4xX -= 0

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_b)
                binding.inimigoGame4.rotationY = 180F

            }

            if (inimigo4 == 3) {
                inimigo4yY += 0
                inimigo4xX -= velocidadeInimigo

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_d)
                binding.inimigoGame4.rotationY = 180F
            }

            if (inimigo4 == 4) {
                inimigo4yY += 0
                inimigo4xX += velocidadeInimigo

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_e)
                binding.inimigoGame4.rotationY = 180F

            }

            if (inimigo4 == 5) {
                inimigo4yY -= velocidadeInimigo
                inimigo4xX -= velocidadeInimigo

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_c)
                binding.inimigoGame4.rotationY = 180F
            }

            if (inimigo4 == 6) {
                inimigo4yY += velocidadeInimigo
                inimigo4xX += velocidadeInimigo

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_b)
                binding.inimigoGame4.rotationY = 180F

            }

            if (inimigo4 == 7) {
                inimigo4yY += velocidadeInimigo
                inimigo4xX -= velocidadeInimigo

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_b)
                binding.inimigoGame4.rotationY = 180F
            }

            if (inimigo4 == 8) {
                inimigo4yY -= velocidadeInimigo
                inimigo4xX += velocidadeInimigo

                binding.inimigoGame4.setImageResource(R.drawable.ic_jogador_branco_4_m_c)
                binding.inimigoGame4.rotationY = 180F

            }

            inimigo4Y = heightCidade(binding.inimigoGame4, inimigog4Y) + inimigo4yY
            inimigo4X = widthCidade(binding.inimigoGame4, inimigog4X) + inimigo4xX

            if (colisorCenario(inimigo4X, inimigo4Y, binding.inimigoGame4)) {
                whenColideInimigo4()
            }

            binding.inimigoGame4.x = inimigo4X
            binding.inimigoGame4.y = inimigo4Y



            if (colisorJogadorParar(inimigo4X, inimigo4Y, binding.inimigoGame4)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 5 * perdaVida
                vidasJogador(pontos)
            }
        }

    }

    fun whenColideInimigo4(){
        when (inimigo4){
            1 ->{
                /**C**/
                inimigo4yY += 10*um_metade
                inimigo4xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo4 = number

            }
            2 -> {
                /**B**/
                inimigo4yY -= 10*um_metade
                inimigo4xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo4 = number

            }
            3 -> {
                /**E**/
                inimigo4yY += 0
                inimigo4xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo4 = number

            }
            4 ->  {
                /**D**/
                inimigo4yY += 0
                inimigo4xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo4 = number

            }
            5 ->  {
                /**EN**/
                inimigo4yY += 10*um_metade
                inimigo4xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo4 = number

            }
            6 ->  {
                /**DS**/
                inimigo4yY -= 10*um_metade
                inimigo4xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo4 = number

            }
            7 ->  {
                /**ES**/
                inimigo4yY -= 10*um_metade
                inimigo4xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo4 = number

            }
            8 -> {
                /**DN**/
                inimigo4yY += 10*um_metade
                inimigo4xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo4 = number

            }
        }
    }

    fun inimigo5(){
        if (inimigo5 == 0){
            inimigog5Y = randomY(inimigog5Y)
            inimigog5X = randomX(inimigog5X)
            inimigo5Y = heightCidade(binding.inimigoGame5, inimigog5Y) + inimigo5yY
            inimigo5X = widthCidade(binding.inimigoGame5, inimigog5X) + inimigo5xX
            if (colisorCenario(inimigo5X, inimigo5Y, binding.inimigoGame5)){
                inimigo5 = 0
            } else{
                inimigo5 = 5
            }
        } else{
            if (inimigo5 == 1) {
                inimigo5yY -= velocidadeInimigo
                inimigo5xX -= 0

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_c)
                binding.inimigoGame5.rotationY = 180F
            }

            if (inimigo5 == 2) {
                inimigo5yY += velocidadeInimigo
                inimigo5xX -= 0

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_b)
                binding.inimigoGame5.rotationY = 180F

            }

            if (inimigo5 == 3) {
                inimigo5yY += 0
                inimigo5xX -= velocidadeInimigo

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_d)
                binding.inimigoGame5.rotationY = 180F
            }

            if (inimigo5 == 4) {
                inimigo5yY += 0
                inimigo5xX += velocidadeInimigo

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_e)
                binding.inimigoGame5.rotationY = 180F

            }

            if (inimigo5 == 5) {
                inimigo5yY -= velocidadeInimigo
                inimigo5xX -= velocidadeInimigo

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_c)
                binding.inimigoGame5.rotationY = 180F
            }

            if (inimigo5 == 6) {
                inimigo5yY += velocidadeInimigo
                inimigo5xX += velocidadeInimigo

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_b)
                binding.inimigoGame5.rotationY = 180F

            }

            if (inimigo5 == 7) {
                inimigo5yY += velocidadeInimigo
                inimigo5xX -= velocidadeInimigo

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_b)
                binding.inimigoGame5.rotationY = 180F
            }

            if (inimigo5 == 8) {
                inimigo5yY -= velocidadeInimigo
                inimigo5xX += velocidadeInimigo

                binding.inimigoGame5.setImageResource(R.drawable.ic_jogador_laranja_4_m_c)
                binding.inimigoGame5.rotationY = 180F

            }

            inimigo5Y = heightCidade(binding.inimigoGame5, inimigog5Y) + inimigo5yY
            inimigo5X = widthCidade(binding.inimigoGame5, inimigog5X) + inimigo5xX

            if (colisorCenario(inimigo5X, inimigo5Y, binding.inimigoGame5)) {
                whenColideInimigo5()
            }

            binding.inimigoGame5.x = inimigo5X
            binding.inimigoGame5.y = inimigo5Y



            if (colisorJogadorParar(inimigo5X, inimigo5Y, binding.inimigoGame5)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 5 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo5(){
        when (inimigo5){
            1 ->{
                /**C**/
                inimigo5yY += 10*um_metade
                inimigo5xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo5 = number

            }
            2 -> {
                /**B**/
                inimigo5yY -= 10*um_metade
                inimigo5xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo5 = number

            }
            3 -> {
                /**E**/
                inimigo5yY += 0
                inimigo5xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo5 = number

            }
            4 ->  {
                /**D**/
                inimigo5yY += 0
                inimigo5xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo5 = number

            }
            5 ->  {
                /**EN**/
                inimigo5yY += 10*um_metade
                inimigo5xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo5 = number

            }
            6 ->  {
                /**DS**/
                inimigo5yY -= 10*um_metade
                inimigo5xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo5 = number

            }
            7 ->  {
                /**ES**/
                inimigo5yY -= 10*um_metade
                inimigo5xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo5 = number

            }
            8 -> {
                /**DN**/
                inimigo5yY += 10*um_metade
                inimigo5xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo5 = number

            }
        }
    }

    fun inimigo6(){
        if (inimigo6 == 0){
            inimigog6Y = randomY(inimigog6Y)
            inimigog6X = randomX(inimigog6X)
            inimigo6Y = heightCidade(binding.inimigoGame6, inimigog6Y) + inimigo6yY
            inimigo6X = widthCidade(binding.inimigoGame6, inimigog6X) + inimigo6xX
            if (colisorCenario(inimigo6X, inimigo6Y, binding.inimigoGame6)){
                inimigo6 = 0
            } else{
                inimigo6 = 6
            }
        } else{
            if (inimigo6 == 1) {
                inimigo6yY -= velocidadeInimigo
                inimigo6xX -= 0

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_c)
                binding.inimigoGame6.rotationY = 180F
            }

            if (inimigo6 == 2) {
                inimigo6yY += velocidadeInimigo
                inimigo6xX -= 0

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_b)
                binding.inimigoGame6.rotationY = 180F

            }

            if (inimigo6 == 3) {
                inimigo6yY += 0
                inimigo6xX -= velocidadeInimigo

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_d)
                binding.inimigoGame6.rotationY = 180F
            }

            if (inimigo6 == 4) {
                inimigo6yY += 0
                inimigo6xX += velocidadeInimigo

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_e)
                binding.inimigoGame6.rotationY = 180F

            }

            if (inimigo6 == 5) {
                inimigo6yY -= velocidadeInimigo
                inimigo6xX -= velocidadeInimigo

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_c)
                binding.inimigoGame6.rotationY = 180F
            }

            if (inimigo6 == 6) {
                inimigo6yY += velocidadeInimigo
                inimigo6xX += velocidadeInimigo

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_b)
                binding.inimigoGame6.rotationY = 180F

            }

            if (inimigo6 == 7) {
                inimigo6yY += velocidadeInimigo
                inimigo6xX -= velocidadeInimigo

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_b)
                binding.inimigoGame6.rotationY = 180F
            }

            if (inimigo6 == 8) {
                inimigo6yY -= velocidadeInimigo
                inimigo6xX += velocidadeInimigo

                binding.inimigoGame6.setImageResource(R.drawable.ic_jogador_marrom_4_m_c)
                binding.inimigoGame6.rotationY = 180F

            }

            inimigo6Y = heightCidade(binding.inimigoGame6, inimigog6Y) + inimigo6yY
            inimigo6X = widthCidade(binding.inimigoGame6, inimigog6X) + inimigo6xX

            if (colisorCenario(inimigo6X, inimigo6Y, binding.inimigoGame6)) {
                whenColideInimigo6()
            }

            binding.inimigoGame6.x = inimigo6X
            binding.inimigoGame6.y = inimigo6Y



            if (colisorJogadorParar(inimigo6X, inimigo6Y, binding.inimigoGame6)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo6(){
        when (inimigo6){
            1 ->{
                /**C**/
                inimigo6yY += 10*um_metade
                inimigo6xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo6 = number

            }
            2 -> {
                /**B**/
                inimigo6yY -= 10*um_metade
                inimigo6xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo6 = number

            }
            3 -> {
                /**E**/
                inimigo6yY += 0
                inimigo6xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo6 = number

            }
            4 ->  {
                /**D**/
                inimigo6yY += 0
                inimigo6xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo6 = number

            }
            5 ->  {
                /**EN**/
                inimigo6yY += 10*um_metade
                inimigo6xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo6 = number

            }
            6 ->  {
                /**DS**/
                inimigo6yY -= 10*um_metade
                inimigo6xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo6 = number

            }
            7 ->  {
                /**ES**/
                inimigo6yY -= 10*um_metade
                inimigo6xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo6 = number

            }
            8 -> {
                /**DN**/
                inimigo6yY += 10*um_metade
                inimigo6xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo6 = number

            }

        }
    }

    fun inimigo7(){
        if (inimigo7 == 0){
            inimigog7Y = randomY(inimigog7Y)
            inimigog7X = randomX(inimigog7X)
            inimigo7Y = heightCidade(binding.inimigoGame7, inimigog7Y) + inimigo7yY
            inimigo7X = widthCidade(binding.inimigoGame7, inimigog7X) + inimigo7xX
            if (colisorCenario(inimigo7X, inimigo7Y, binding.inimigoGame7)){
                inimigo7 = 0
            } else{
                inimigo7 = 7
            }
        } else{
            if (inimigo7 == 1) {
                inimigo7yY -= velocidadeInimigo
                inimigo7xX -= 0

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_c)
                binding.inimigoGame7.rotationY = 180F
            }

            if (inimigo7 == 2) {
                inimigo7yY += velocidadeInimigo
                inimigo7xX -= 0

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_b)
                binding.inimigoGame7.rotationY = 180F

            }

            if (inimigo7 == 3) {
                inimigo7yY += 0
                inimigo7xX -= velocidadeInimigo

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_d)
                binding.inimigoGame7.rotationY = 180F
            }

            if (inimigo7 == 4) {
                inimigo7yY += 0
                inimigo7xX += velocidadeInimigo

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_e)
                binding.inimigoGame7.rotationY = 180F

            }

            if (inimigo7 == 5) {
                inimigo7yY -= velocidadeInimigo
                inimigo7xX -= velocidadeInimigo

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_c)
                binding.inimigoGame7.rotationY = 180F
            }

            if (inimigo7 == 6) {
                inimigo7yY += velocidadeInimigo
                inimigo7xX += velocidadeInimigo

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_b)
                binding.inimigoGame7.rotationY = 180F

            }

            if (inimigo7 == 7) {
                inimigo7yY += velocidadeInimigo
                inimigo7xX -= velocidadeInimigo

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_b)
                binding.inimigoGame7.rotationY = 180F
            }

            if (inimigo7 == 8) {
                inimigo7yY -= velocidadeInimigo
                inimigo7xX += velocidadeInimigo

                binding.inimigoGame7.setImageResource(R.drawable.ic_jogador_preto_3_m_c)
                binding.inimigoGame7.rotationY = 180F

            }

            inimigo7Y = heightCidade(binding.inimigoGame7, inimigog7Y) + inimigo7yY
            inimigo7X = widthCidade(binding.inimigoGame7, inimigog7X) + inimigo7xX

            if (colisorCenario(inimigo7X, inimigo7Y, binding.inimigoGame7)) {
                whenColideInimigo7()
            }

            binding.inimigoGame7.x = inimigo7X
            binding.inimigoGame7.y = inimigo7Y



            if (colisorJogadorParar(inimigo7X, inimigo7Y, binding.inimigoGame7)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo7(){
        when (inimigo7){
            1 ->{
                /**C**/
                inimigo7yY += 10*um_metade
                inimigo7xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo7 = number

            }
            2 -> {
                /**B**/
                inimigo7yY -= 10*um_metade
                inimigo7xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo7 = number

            }
            3 -> {
                /**E**/
                inimigo7yY += 0
                inimigo7xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo7 = number

            }
            4 ->  {
                /**D**/
                inimigo7yY += 0
                inimigo7xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo7 = number

            }
            5 ->  {
                /**EN**/
                inimigo7yY += 10*um_metade
                inimigo7xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo7 = number

            }
            6 ->  {
                /**DS**/
                inimigo7yY -= 10*um_metade
                inimigo7xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo7 = number

            }
            7 ->  {
                /**ES**/
                inimigo7yY -= 10*um_metade
                inimigo7xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo7 = number

            }
            8 -> {
                /**DN**/
                inimigo7yY += 10*um_metade
                inimigo7xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo7 = number

            }
        }
    }

    fun inimigo8(){
        if (inimigo8 == 0){
            inimigog8Y = randomY(inimigog8Y)
            inimigog8X = randomX(inimigog8X)
            inimigo8Y = heightCidade(binding.inimigoGame8, inimigog8Y) + inimigo8yY
            inimigo8X = widthCidade(binding.inimigoGame8, inimigog8X) + inimigo8xX
            if (colisorCenario(inimigo8X, inimigo8Y, binding.inimigoGame8)){
                inimigo8 = 0
            } else{
                inimigo8 = 8
            }
        } else{
            if (inimigo8 == 1) {
                inimigo8yY -= velocidadeInimigo
                inimigo8xX -= 0

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_c)
                binding.inimigoGame8.rotationY = 180F
            }

            if (inimigo8 == 2) {
                inimigo8yY += velocidadeInimigo
                inimigo8xX -= 0

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_b)
                binding.inimigoGame8.rotationY = 180F

            }

            if (inimigo8 == 3) {
                inimigo8yY += 0
                inimigo8xX -= velocidadeInimigo

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_d)
                binding.inimigoGame8.rotationY = 180F
            }

            if (inimigo8 == 4) {
                inimigo8yY += 0
                inimigo8xX += velocidadeInimigo

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_e)
                binding.inimigoGame8.rotationY = 180F

            }

            if (inimigo8 == 5) {
                inimigo8yY -= velocidadeInimigo
                inimigo8xX -= velocidadeInimigo

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_c)
                binding.inimigoGame8.rotationY = 180F
            }

            if (inimigo8 == 6) {
                inimigo8yY += velocidadeInimigo
                inimigo8xX += velocidadeInimigo

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_b)
                binding.inimigoGame8.rotationY = 180F

            }

            if (inimigo8 == 7) {
                inimigo8yY += velocidadeInimigo
                inimigo8xX -= velocidadeInimigo

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_b)
                binding.inimigoGame8.rotationY = 180F
            }

            if (inimigo8 == 8) {
                inimigo8yY -= velocidadeInimigo
                inimigo8xX += velocidadeInimigo

                binding.inimigoGame8.setImageResource(R.drawable.ic_jogador_rosa_2_h_c)
                binding.inimigoGame8.rotationY = 180F

            }

            inimigo8Y = heightCidade(binding.inimigoGame8, inimigog8Y) + inimigo8yY
            inimigo8X = widthCidade(binding.inimigoGame8, inimigog8X) + inimigo8xX

            if (colisorCenario(inimigo8X, inimigo8Y, binding.inimigoGame8)) {
                whenColideInimigo8()
            }

            binding.inimigoGame8.x = inimigo8X
            binding.inimigoGame8.y = inimigo8Y



            if (colisorJogadorParar(inimigo8X, inimigo8Y, binding.inimigoGame8)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo8(){
        when (inimigo8){
            1 ->{
                /**C**/
                inimigo8yY += 10*um_metade
                inimigo8xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo8 = number

            }
            2 -> {
                /**B**/
                inimigo8yY -= 10*um_metade
                inimigo8xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo8 = number

            }
            3 -> {
                /**E**/
                inimigo8yY += 0
                inimigo8xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo8 = number

            }
            4 ->  {
                /**D**/
                inimigo8yY += 0
                inimigo8xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo8 = number

            }
            5 ->  {
                /**EN**/
                inimigo8yY += 10*um_metade
                inimigo8xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo8 = number

            }
            6 ->  {
                /**DS**/
                inimigo8yY -= 10*um_metade
                inimigo8xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo8 = number

            }
            7 ->  {
                /**ES**/
                inimigo8yY -= 10*um_metade
                inimigo8xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo8 = number

            }
            8 -> {
                /**DN**/
                inimigo8yY += 10*um_metade
                inimigo8xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo8 = number

            }
        }
    }

    fun inimigo9(){
        if (inimigo9 == 0){
            inimigog9Y = randomY(inimigog9Y)
            inimigog9X = randomX(inimigog9X)
            inimigo9Y = heightCidade(binding.inimigoGame9, inimigog9Y) + inimigo9yY
            inimigo9X = widthCidade(binding.inimigoGame9, inimigog9X) + inimigo9xX
            if (colisorCenario(inimigo9X, inimigo9Y, binding.inimigoGame9)){
                inimigo9 = 0
            } else{
                inimigo9 = 1
            }
        } else{
            if (inimigo9 == 1) {
                inimigo9yY -= velocidadeInimigo
                inimigo9xX -= 0

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_c)
                binding.inimigoGame9.rotationY = 180F
            }

            if (inimigo9 == 2) {
                inimigo9yY += velocidadeInimigo
                inimigo9xX -= 0

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_b)
                binding.inimigoGame9.rotationY = 180F

            }

            if (inimigo9 == 3) {
                inimigo9yY += 0
                inimigo9xX -= velocidadeInimigo

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_d)
                binding.inimigoGame9.rotationY = 180F
            }

            if (inimigo9 == 4) {
                inimigo9yY += 0
                inimigo9xX += velocidadeInimigo

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_e)
                binding.inimigoGame9.rotationY = 180F

            }

            if (inimigo9 == 5) {
                inimigo9yY -= velocidadeInimigo
                inimigo9xX -= velocidadeInimigo

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_c)
                binding.inimigoGame9.rotationY = 180F
            }

            if (inimigo9 == 6) {
                inimigo9yY += velocidadeInimigo
                inimigo9xX += velocidadeInimigo

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_b)
                binding.inimigoGame9.rotationY = 180F

            }

            if (inimigo9 == 7) {
                inimigo9yY += velocidadeInimigo
                inimigo9xX -= velocidadeInimigo

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_b)
                binding.inimigoGame9.rotationY = 180F
            }

            if (inimigo9 == 8) {
                inimigo9yY -= velocidadeInimigo
                inimigo9xX += velocidadeInimigo

                binding.inimigoGame9.setImageResource(R.drawable.ic_jogador_roxo_2_h_c)
                binding.inimigoGame9.rotationY = 180F

            }

            inimigo9Y = heightCidade(binding.inimigoGame9, inimigog9Y) + inimigo9yY
            inimigo9X = widthCidade(binding.inimigoGame9, inimigog9X) + inimigo9xX

            if (colisorCenario(inimigo9X, inimigo9Y, binding.inimigoGame9)) {
                whenColideInimigo9()
            }

            binding.inimigoGame9.x = inimigo9X
            binding.inimigoGame9.y = inimigo9Y



            if (colisorJogadorParar(inimigo9X, inimigo9Y, binding.inimigoGame9)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo9(){
        when (inimigo9){
            1 ->{
                /**C**/
                inimigo9yY += 10*um_metade
                inimigo9xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo9 = number

            }
            2 -> {
                /**B**/
                inimigo9yY -= 10*um_metade
                inimigo9xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo9 = number

            }
            3 -> {
                /**E**/
                inimigo9yY += 0
                inimigo9xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo9 = number

            }
            4 ->  {
                /**D**/
                inimigo9yY += 0
                inimigo9xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo9 = number

            }
            5 ->  {
                /**EN**/
                inimigo9yY += 10*um_metade
                inimigo9xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo9 = number

            }
            6 ->  {
                /**DS**/
                inimigo9yY -= 10*um_metade
                inimigo9xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo9 = number

            }
            7 ->  {
                /**ES**/
                inimigo9yY -= 10*um_metade
                inimigo9xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo9 = number

            }
            8 -> {
                /**DN**/
                inimigo9yY += 10*um_metade
                inimigo9xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo9 = number

            }
        }
    }

    fun inimigo10(){
        if (inimigo10 == 0){
            inimigog10Y = randomY(inimigog10Y)
            inimigog10X = randomX(inimigog10X)
            inimigo10Y = heightCidade(binding.inimigoGame10, inimigog10Y) + inimigo10yY
            inimigo10X = widthCidade(binding.inimigoGame10, inimigog10X) + inimigo10xX
            if (colisorCenario(inimigo10X, inimigo10Y, binding.inimigoGame10)){
                inimigo10 = 0
            } else{
                inimigo10 = 2
            }
        } else{
            if (inimigo10 == 1) {
                inimigo10yY -= velocidadeInimigo
                inimigo10xX -= 0

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_c)
                binding.inimigoGame10.rotationY = 180F
            }

            if (inimigo10 == 2) {
                inimigo10yY += velocidadeInimigo
                inimigo10xX -= 0

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_b)
                binding.inimigoGame10.rotationY = 180F

            }

            if (inimigo10 == 3) {
                inimigo10yY += 0
                inimigo10xX -= velocidadeInimigo

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_d)
                binding.inimigoGame10.rotationY = 180F
            }

            if (inimigo10 == 4) {
                inimigo10yY += 0
                inimigo10xX += velocidadeInimigo

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_e)
                binding.inimigoGame10.rotationY = 180F

            }

            if (inimigo10 == 5) {
                inimigo10yY -= velocidadeInimigo
                inimigo10xX -= velocidadeInimigo

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_c)
                binding.inimigoGame10.rotationY = 180F
            }

            if (inimigo10 == 6) {
                inimigo10yY += velocidadeInimigo
                inimigo10xX += velocidadeInimigo

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_b)
                binding.inimigoGame10.rotationY = 180F

            }

            if (inimigo10 == 7) {
                inimigo10yY += velocidadeInimigo
                inimigo10xX -= velocidadeInimigo

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_b)
                binding.inimigoGame10.rotationY = 180F
            }

            if (inimigo10 == 8) {
                inimigo10yY -= velocidadeInimigo
                inimigo10xX += velocidadeInimigo

                binding.inimigoGame10.setImageResource(R.drawable.ic_jogador_verde_1_h_c)
                binding.inimigoGame10.rotationY = 180F

            }

            inimigo10Y = heightCidade(binding.inimigoGame10, inimigog10Y) + inimigo10yY
            inimigo10X = widthCidade(binding.inimigoGame10, inimigog10X) + inimigo10xX

            if (colisorCenario(inimigo10X, inimigo10Y, binding.inimigoGame10)) {
                whenColideInimigo10()
            }

            binding.inimigoGame10.x = inimigo10X
            binding.inimigoGame10.y = inimigo10Y



            if (colisorJogadorParar(inimigo10X, inimigo10Y, binding.inimigoGame10)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 5 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo10(){
        when (inimigo10){
            1 ->{
                /**C**/
                inimigo10yY += 10*um_metade
                inimigo10xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo10 = number

            }
            2 -> {
                /**B**/
                inimigo10yY -= 10*um_metade
                inimigo10xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo10 = number

            }
            3 -> {
                /**E**/
                inimigo10yY += 0
                inimigo10xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo10 = number

            }
            4 ->  {
                /**D**/
                inimigo10yY += 0
                inimigo10xX -= 10
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo10 = number

            }
            5 ->  {
                /**EN**/
                inimigo10yY += 10*um_metade
                inimigo10xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo10 = number

            }
            6 ->  {
                /**DS**/
                inimigo10yY -= 10*um_metade
                inimigo10xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo10 = number

            }
            7 ->  {
                /**ES**/
                inimigo10yY -= 10*um_metade
                inimigo10xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo10 = number

            }
            8 -> {
                /**DN**/
                inimigo10yY += 10*um_metade
                inimigo10xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo10 = number

            }

        }
    }

    fun inimigo11(){
        if (inimigo11 == 0){
            inimigog11Y = randomY(inimigog11Y)
            inimigog11X = randomX(inimigog11X)
            inimigo11Y = heightCidade(binding.inimigoGame11, inimigog11Y) + inimigo11yY
            inimigo11X = widthCidade(binding.inimigoGame11, inimigog11X) + inimigo11xX
            if (colisorCenario(inimigo11X, inimigo11Y, binding.inimigoGame11)){
                inimigo11 = 0
            } else{
                inimigo11 = 3
            }
        } else{
            if (inimigo11 == 1) {
                inimigo11yY -= velocidadeInimigo
                inimigo11xX -= 0

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_c)
                binding.inimigoGame11.rotationY = 180F
            }

            if (inimigo11 == 2) {
                inimigo11yY += velocidadeInimigo
                inimigo11xX -= 0

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_b)
                binding.inimigoGame11.rotationY = 180F

            }

            if (inimigo11 == 3) {
                inimigo11yY += 0
                inimigo11xX -= velocidadeInimigo

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_d)
                binding.inimigoGame11.rotationY = 180F
            }

            if (inimigo11 == 4) {
                inimigo11yY += 0
                inimigo11xX += velocidadeInimigo

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_e)
                binding.inimigoGame11.rotationY = 180F

            }

            if (inimigo11 == 5) {
                inimigo11yY -= velocidadeInimigo
                inimigo11xX -= velocidadeInimigo

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_c)
                binding.inimigoGame11.rotationY = 180F
            }

            if (inimigo11 == 6) {
                inimigo11yY += velocidadeInimigo
                inimigo11xX += velocidadeInimigo

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_b)
                binding.inimigoGame11.rotationY = 180F

            }

            if (inimigo11 == 7) {
                inimigo11yY += velocidadeInimigo
                inimigo11xX -= velocidadeInimigo

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_b)
                binding.inimigoGame11.rotationY = 180F
            }

            if (inimigo11 == 8) {
                inimigo11yY -= velocidadeInimigo
                inimigo11xX += velocidadeInimigo

                binding.inimigoGame11.setImageResource(R.drawable.ic_jogador_vinho_3_m_c)
                binding.inimigoGame11.rotationY = 180F

            }

            inimigo11Y = heightCidade(binding.inimigoGame11, inimigog11Y) + inimigo11yY
            inimigo11X = widthCidade(binding.inimigoGame11, inimigog11X) + inimigo11xX

            if (colisorCenario(inimigo11X, inimigo11Y, binding.inimigoGame11)) {
                whenColideInimigo11()
            }

            binding.inimigoGame11.x = inimigo11X
            binding.inimigoGame11.y = inimigo11Y



            if (colisorJogadorParar(inimigo11X, inimigo11Y, binding.inimigoGame11)) {
                binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
                pontos += 1 * perdaVida
                vidasJogador(pontos)
            }
        }
    }

    fun whenColideInimigo11(){
        when (inimigo11){
            1 ->{
                /**C**/
                inimigo11yY += 10*um_metade
                inimigo11xX -= 0
                val list = listOf(2, 3, 4, 6, 7)
                val number = list.random()
                inimigo11 = number

            }
            2 -> {
                /**B**/
                inimigo11yY -= 10*um_metade
                inimigo11xX -= 0
                val list = listOf(1, 3, 4, 5, 8)
                val number = list.random()
                inimigo11 = number

            }
            3 -> {
                /**E**/
                inimigo11yY += 0
                inimigo11xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo11 = number

            }
            4 ->  {
                /**D**/
                inimigo11yY += 0
                inimigo11xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo11 = number

            }
            5 ->  {
                /**EN**/
                inimigo11yY += 10*um_metade
                inimigo11xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo11 = number

            }
            6 ->  {
                /**DS**/
                inimigo11yY -= 10*um_metade
                inimigo11xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo11 = number

            }
            7 ->  {
                /**ES**/
                inimigo11yY -= 10*um_metade
                inimigo11xX += 10*um_metade
                val list = listOf(1, 2, 4, 6, 8)
                val number = list.random()
                inimigo11 = number

            }
            8 -> {
                /**DN**/
                inimigo11yY += 10*um_metade
                inimigo11xX -= 10*um_metade
                val list = listOf(1, 2, 3, 5, 7)
                val number = list.random()
                inimigo11 = number

            }
        }
    }

    fun monstro1(){
        if (monstro == 0){
            monstroY = heightCidade(binding.monstro, 4f) + monstroyY
            monstroX = widthCidade(binding.monstro, 1f) + monstroxX
            monstro = 1
            caminhoC = true
        }
        /**C**/

        if (monstro == 1) {
            monstroyY -= velocidadeMonstroVirose
            monstroxX -= 0

        }

        /**B**/

        if (monstro == 2) {
            monstroyY += velocidadeMonstroVirose
            monstroxX -= 0

        }

        /**E**/
        if (monstro == 3) {
            monstroyY += 0
            monstroxX -= velocidadeMonstroVirose

        }

        /**D**/
        if (monstro == 4) {
            monstroyY += 0
            monstroxX += velocidadeMonstroVirose

        }


        monstroY = heightCidade(binding.monstro, 4f) + monstroyY
        monstroX = widthCidade(binding.monstro, 1f) + monstroxX

        binding.monstro.x = monstroX
        binding.monstro.y = monstroY

        proibidoPerder = true

        if (pontoA(monstro, caminhoA, monstroX, monstroY, binding.monstro)){
            Log.d("pontoA", "true")
            val list = listOf(1, 4)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoB = true
                    Log.d("pontoA", "caminhoB")
                }
                4 -> {
                    monstro = 4
                    caminhoG = true
                    Log.d("pontoA", "caminhoG")
                }
            }
            caminhoA = false

        } else if (pontoB(monstro, caminhoB, monstroX, monstroY, binding.monstro)){
            Log.d("pontoB", "true")
            val list = listOf(1, 2, 4)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoC = true
                    Log.d("pontoB", "caminhoC")
                }
                2 -> {
                    monstro = 2
                    caminhoA = true
                    Log.d("pontoB", "caminhoA")
                }
                4 -> {
                    monstro = 4
                    caminhoF = true
                    Log.d("pontoB", "caminhoF")
                }
            }
            caminhoB = false

        } else if (pontoC(monstro, caminhoC, monstroX, monstroY, binding.monstro)){
            Log.d("pontoC", "true")
            val list = listOf(2, 4)
            when (list.random()){
                2 -> {
                    monstro = 2
                    caminhoB = true
                    Log.d("pontoC", "caminhoB")
                }
                4 -> {
                    monstro = 4
                    caminhoD = true
                    Log.d("pontoC", "caminhoD")
                }
            }
            caminhoC = false

        } else if (pontoD(monstro, caminhoD,monstroX, monstroY, binding.monstro)){
            Log.d("pontoD", "true")
            val list = listOf(2, 3)
            when (list.random()){
                2 -> {
                    monstro = 2
                    caminhoE = true
                    Log.d("pontoD", "caminhoE")
                }
                3 -> {
                    monstro = 3
                    caminhoC = true
                    Log.d("pontoD", "caminhoC")
                }
            }
            caminhoD = false

        }else if (pontoE(monstro, caminhoE,monstroX, monstroY, binding.monstro)){
            Log.d("pontoE", "true")
            val list = listOf(1, 2, 4)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoD = true
                    Log.d("pontoE", "caminhoD")
                }
                2 -> {
                    monstro = 2
                    caminhoF = true
                    Log.d("pontoE", "caminhoF")
                }
                4 -> {
                    monstro = 4
                    caminhoH = true
                    Log.d("pontoE", "caminhoH")
                }
            }
            caminhoE = false

        }else if (pontoF(monstro, caminhoF,monstroX, monstroY, binding.monstro)){
            Log.d("pontoF", "true")
            val list = listOf(1, 2, 3)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoE = true
                    Log.d("pontoF", "caminhoE")
                }
                2 -> {
                    monstro = 2
                    caminhoG = true
                    Log.d("pontoF", "caminhoG")
                }
                3 -> {
                    monstro = 3
                    caminhoB = true
                    Log.d("pontoF", "caminhoB")
                }
            }
            caminhoF = false

        }else if (pontoG(monstro, caminhoG,monstroX, monstroY, binding.monstro)){
            Log.d("pontoG", "true")
            val list = listOf(1, 3)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoF = true
                    Log.d("pontoG", "caminhoF")
                }
                3 -> {
                    monstro = 3
                    caminhoA = true
                    Log.d("pontoG", "caminhoA")
                }
            }
            caminhoG = false

        }else if (pontoH(monstro, caminhoH,monstroX, monstroY, binding.monstro)){
            Log.d("pontoH", "true")
            val list = listOf(1, 2, 3)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoI = true
                    Log.d("pontoH", "caminhoI")
                }
                2 -> {
                    monstro = 2
                    caminhoN = true
                    Log.d("pontoH", "caminhoN")
                }
                3 -> {
                    monstro = 3
                    caminhoE = true
                    Log.d("pontoH", "caminhoE")
                }
            }
            caminhoH = false

        }else if (pontoI(monstro, caminhoI,monstroX, monstroY, binding.monstro)){
            Log.d("pontoI", "true")
            val list = listOf(2, 4)
            when (list.random()){
                2 -> {
                    monstro = 2
                    caminhoH = true
                    Log.d("pontoI", "caminhoH")
                }
                4 -> {
                    monstro = 4
                    caminhoJ = true
                    Log.d("pontoI", "caminhoJ")
                }
            }
            caminhoI = false

        }else if (pontoJ(monstro, caminhoJ,monstroX, monstroY, binding.monstro)){
            Log.d("pontoJ", "true")
            val list = listOf(2, 3)
            when (list.random()){
                2 -> {
                    monstro = 2
                    caminhoK = true
                    Log.d("pontoJ", "caminhoK")
                }
                3 -> {
                    monstro = 3
                    caminhoI = true
                    Log.d("pontoJ", "caminhoI")
                }
            }
            caminhoJ = false

        }else if (pontoK(monstro, caminhoK,monstroX, monstroY, binding.monstro)){
            Log.d("pontoK", "true")
            val list = listOf(1, 2, 3)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoJ = true
                    Log.d("pontoK", "caminhoJ")
                }
                2 -> {
                    monstro = 2
                    caminhoL = true
                    Log.d("pontoK", "caminhoL")
                }
                3 -> {
                    monstro = 3
                    caminhoN = true
                    Log.d("pontoK", "caminhoN")
                }
            }
            caminhoK = false

        }else if (pontoL(monstro, caminhoL,monstroX, monstroY, binding.monstro)){
            Log.d("pontoL", "true")
            val list = listOf(1, 3)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoK = true
                    Log.d("pontoL", "caminhoK")
                }
                3 -> {
                    monstro = 3
                    caminhoM = true
                    Log.d("pontoL", "caminhoM")
                }
            }
            caminhoL = false

        }else if (pontoM(monstro, caminhoM,monstroX, monstroY, binding.monstro)){
            Log.d("pontoM", "true")
            val list = listOf(1, 4)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoN = true
                    Log.d("pontoM", "caminhoN")
                }
                4 -> {
                    monstro = 4
                    caminhoL = true
                    Log.d("pontoM", "caminhoL")
                }
            }
            caminhoM = false

        }else if (pontoN(monstro, caminhoN,monstroX, monstroY, binding.monstro)){
            Log.d("pontoN", "true")
            val list = listOf(1, 2, 4)
            when (list.random()){
                1 -> {
                    monstro = 1
                    caminhoH = true
                    Log.d("pontoN", "caminhoH")
                }
                2 -> {
                    monstro = 2
                    caminhoM = true
                    Log.d("pontoN", "caminhoM")
                }
                4 -> {
                    monstro = 4
                    caminhoK = true
                    Log.d("pontoN", "caminhoK")
                }
            }
            caminhoN = false

        }


        if (colisorJogadorParar(monstroX, monstroY, binding.monstro)) {
            binding.imageViewArpg.setImageResource(R.drawable.ic_cangaceiro)
            pontos += 15 * perdaVida
            vidasJogador(pontos)
        }
    }

    fun mosquito1(){
        if (mosquito == 0){
            mosquitoY = heightCidade(binding.mosquito, 2f) + mosquitoyY
            mosquitoX = widthCidade(binding.mosquito, 11.25f) + mosquitoxX
            binding.tiroInimigo.visibility = View.VISIBLE
            tiroInimigoX = mosquitoX
            tiroInimigoY = mosquitoY
            caminhoMosquitoN = true

            mosquito = 1
            tiroInimigo = mosquito
        }
        /**C**/
        //tiroInimigo = mosquito

        if (mosquito == 1) {
            mosquitoyY -= velocidadeMonstroMosquito
            mosquitoxX -= 0
        }

        /**B**/

        if (mosquito == 2) {
            mosquitoyY += velocidadeMonstroMosquito
            mosquitoxX -= 0
        }

        /**E**/
        if (mosquito == 3) {
            mosquitoyY += 0
            mosquitoxX -= velocidadeMonstroMosquito

        }

        /**D**/
        if (mosquito == 4) {
            mosquitoyY += 0
            mosquitoxX += velocidadeMonstroMosquito
        }

        if (tiroInimigo == 1) {
            tiroInimigoyY -= velocidadeMonstroMosquito*2
            tiroInimigoxX -= 0

            if (tiroInimigoY < ((mosquitoY*3)*-1)){
                tiroParou = true
            }
        }

        /**B**/

        if (tiroInimigo == 2) {
            tiroInimigoyY += velocidadeMonstroMosquito*2
            tiroInimigoxX -= 0

            if (tiroInimigoY > (mosquitoY*3)){
                tiroParou = true
            }
        }

        /**E**/
        if (tiroInimigo == 3) {
            tiroInimigoyY += 0
            tiroInimigoxX -= velocidadeMonstroMosquito*2

            if (tiroInimigoX < ((mosquitoX*3)*-1)){
                tiroParou = true
            }
        }

        /**D**/
        if (tiroInimigo == 4) {
            tiroInimigoyY += 0
            tiroInimigoxX += velocidadeMonstroMosquito*2

            if (tiroInimigoX > (mosquitoX*3)){
                tiroParou = true
            }
        }

        mosquitoY = heightCidade(binding.mosquito, 2f) + mosquitoyY
        mosquitoX = widthCidade(binding.mosquito, 11.25f) + mosquitoxX

        binding.mosquito.x = mosquitoX
        binding.mosquito.y = mosquitoY



        if (tiroParou) {
            tiroInimigo = mosquito

            tiroInimigoxX = 0F
            tiroInimigoyY = 0F

            tiroInimigoX = mosquitoX + tiroInimigoxX
            tiroInimigoY = mosquitoY + tiroInimigoyY

            binding.tiroInimigo.x = tiroInimigoX
            binding.tiroInimigo.y = tiroInimigoY
            binding.tiroInimigo.visibility = View.GONE
            tiroParou = false
        } else {
            binding.tiroInimigo.visibility = View.VISIBLE
            tiroInimigoX = mosquitoX + tiroInimigoxX
            tiroInimigoY = mosquitoY + tiroInimigoyY

            binding.tiroInimigo.x = tiroInimigoX
            binding.tiroInimigo.y = tiroInimigoY
        }


        if (pontoA(mosquito, caminhoMosquitoA, mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoA", "true")
            val list = listOf(1, 4)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoB = true
                    Log.d("pontoA", "caminhoMosquitoB")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoG = true
                    Log.d("pontoA", "caminhoMosquitoG")
                }
            }
            caminhoMosquitoA = false

        } else if (pontoB(mosquito, caminhoMosquitoB, mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoB", "true")
            val list = listOf(1, 2, 4)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoC = true
                    Log.d("pontoB", "caminhoMosquitoC")
                }
                2 -> {
                    mosquito = 2
                    caminhoMosquitoA = true
                    Log.d("pontoB", "caminhoMosquitoA")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoF = true
                    Log.d("pontoB", "caminhoMosquitoF")
                }
            }
            caminhoMosquitoB = false

        } else if (pontoC(mosquito, caminhoMosquitoC, mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoC", "true")
            val list = listOf(2, 4)
            when (list.random()){
                2 -> {
                    mosquito = 2
                    caminhoMosquitoB = true
                    Log.d("pontoC", "caminhoMosquitoB")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoD = true
                    Log.d("pontoC", "caminhoMosquitoD")
                }
            }
            caminhoMosquitoC = false

        } else if (pontoD(mosquito, caminhoMosquitoD,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoD", "true")
            val list = listOf(2, 3)
            when (list.random()){
                2 -> {
                    mosquito = 2
                    caminhoMosquitoE = true
                    Log.d("pontoD", "caminhoMosquitoE")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoC = true
                    Log.d("pontoD", "caminhoMosquitoC")
                }
            }
            caminhoMosquitoD = false

        }else if (pontoE(mosquito, caminhoMosquitoE,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoE", "true")
            val list = listOf(1, 2, 4)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoD = true
                    Log.d("pontoE", "caminhoMosquitoD")
                }
                2 -> {
                    mosquito = 2
                    caminhoMosquitoF = true
                    Log.d("pontoE", "caminhoMosquitoF")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoH = true
                    Log.d("pontoE", "caminhoMosquitoH")
                }
            }
            caminhoMosquitoE = false

        }else if (pontoF(mosquito, caminhoMosquitoF,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoF", "true")
            val list = listOf(1, 2, 3)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoE = true
                    Log.d("pontoF", "caminhoMosquitoE")
                }
                2 -> {
                    mosquito = 2
                    caminhoMosquitoG = true
                    Log.d("pontoF", "caminhoMosquitoG")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoB = true
                    Log.d("pontoF", "caminhoMosquitoB")
                }
            }
            caminhoMosquitoF = false

        }else if (pontoG(mosquito, caminhoMosquitoG,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoG", "true")
            val list = listOf(1, 3)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoF = true
                    Log.d("pontoG", "caminhoMosquitoF")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoA = true
                    Log.d("pontoG", "caminhoMosquitoA")
                }
            }
            caminhoMosquitoG = false

        }else if (pontoH(mosquito, caminhoMosquitoH,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoH", "true")
            val list = listOf(1, 2, 3)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoI = true
                    Log.d("pontoH", "caminhoMosquitoI")
                }
                2 -> {
                    mosquito = 2
                    caminhoMosquitoN = true
                    Log.d("pontoH", "caminhoMosquitoN")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoE = true
                    Log.d("pontoH", "caminhoMosquitoE")
                }
            }
            caminhoMosquitoH = false

        }else if (pontoI(mosquito, caminhoMosquitoI,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoI", "true")
            val list = listOf(2, 4)
            when (list.random()){
                2 -> {
                    mosquito = 2
                    caminhoMosquitoH = true
                    Log.d("pontoI", "caminhoMosquitoH")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoJ = true
                    Log.d("pontoI", "caminhoMosquitoJ")
                }
            }
            caminhoMosquitoI = false

        }else if (pontoJ(mosquito, caminhoMosquitoJ,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoJ", "true")
            val list = listOf(2, 3)
            when (list.random()){
                2 -> {
                    mosquito = 2
                    caminhoMosquitoK = true
                    Log.d("pontoJ", "caminhoMosquitoK")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoI = true
                    Log.d("pontoJ", "caminhoMosquitoI")
                }
            }
            caminhoMosquitoJ = false

        }else if (pontoK(mosquito, caminhoMosquitoK,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoK", "true")
            val list = listOf(1, 2, 3)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoJ = true
                    Log.d("pontoK", "caminhoMosquitoJ")
                }
                2 -> {
                    mosquito = 2
                    caminhoMosquitoL = true
                    Log.d("pontoK", "caminhoMosquitoL")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoN = true
                    Log.d("pontoK", "caminhoMosquitoN")
                }
            }
            caminhoMosquitoK = false

        }else if (pontoL(mosquito, caminhoMosquitoL,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoL", "true")
            val list = listOf(1, 3)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoK = true
                    Log.d("pontoL", "caminhoMosquitoK")
                }
                3 -> {
                    mosquito = 3
                    caminhoMosquitoM = true
                    Log.d("pontoL", "caminhoMosquitoM")
                }
            }
            caminhoMosquitoL = false

        }else if (pontoM(mosquito, caminhoMosquitoM,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoM", "true")
            val list = listOf(1, 4)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoN = true
                    Log.d("pontoM", "caminhoMosquitoN")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoL = true
                    Log.d("pontoM", "caminhoMosquitoL")
                }
            }
            caminhoMosquitoM = false

        }else if (pontoN(mosquito, caminhoMosquitoN,mosquitoX, mosquitoY, binding.mosquito)){
            Log.d("pontoN", "true")
            val list = listOf(1, 2, 4)
            when (list.random()){
                1 -> {
                    mosquito = 1
                    caminhoMosquitoH = true
                    Log.d("pontoN", "caminhoMosquitoH")
                }
                2 -> {
                    mosquito = 2
                    caminhoMosquitoM = true
                    Log.d("pontoN", "caminhoMosquitoM")
                }
                4 -> {
                    mosquito = 4
                    caminhoMosquitoK = true
                    Log.d("pontoN", "caminhoMosquitoK")
                }
            }
            caminhoMosquitoN = false

        }

        if (colisorJogadorParar(tiroInimigoX, tiroInimigoY, binding.tiroInimigo) ) {
            binding.imageViewArpg.setImageResource(R.drawable.ic_tiro_contra)
            pontos += 15 * perdaVida
            vidasJogador(pontos)
        }

        if (colisorJogadorParar(mosquitoX, mosquitoY, binding.mosquito) ) {
            binding.imageViewArpg.setImageResource(R.drawable.ic_curupira)
            pontos += 10 * perdaVida
            vidasJogador(pontos)
        }
    }

    fun escola1 (view: View?){
        popupAdviceGameCidadeLocal(getString(R.string.colegio),
            getString(R.string.colegio2),
            R.drawable.mata_baixo_one)
    }

    fun prefeitura1 (view: View?){
        popupAdviceGameCidadeLocal(getString(R.string.prefeitura),
            getString(R.string.prefeitura2),
            R.drawable.mata_baixo_two)
    }

    fun praca1 (view: View?){
        popupAdviceGameCidadeLocal(getString(R.string.rua_da_lagoa),
            getString(R.string.rua_da_lagoa2),
            R.drawable.mata_cima_one)
    }

    fun praca2 (view: View?){
        popupAdviceGameCidadeLocal(getString(R.string.praca_nova),
            getString(R.string.praca_nova2),
            R.drawable.mata_baixo_two)
    }

    fun inimigo() {
        colisores()
        inimigo1()
        inimigo2()
        inimigo3()
        inimigo4()
        inimigo5()
        inimigo6()
        inimigo7()
        inimigo8()
        inimigo9()
        inimigo10()
        inimigo11()
        monstro1()
        mosquito1()
    }

    fun popupMessageInicio (text: String){
        proibidoPerder = true

        val dialog: Dialog = Dialog(this)

        //velocidade_cenarioY = binding.casas1.width * 2f

        val popupLutaContraOCoronavirusBinding: PopupLutaContraOCoronavirusBinding = PopupLutaContraOCoronavirusBinding.inflate(layoutInflater)
        dialog.setContentView(popupLutaContraOCoronavirusBinding.root)

        popupLutaContraOCoronavirusBinding.txtBalao.text = text
        //velocidade_cenarioX = widthCidade(binding.jogador, 10.0f) * -1

        popupLutaContraOCoronavirusBinding.ok.setOnClickListener {
            on = true
            proibidoPerder = false
            pontosValem = true
            dialog.dismiss()
        }

        val layoutParams = WindowManager.LayoutParams()
        val windowAlDl: Window = dialog.window!!
        layoutParams.width = (displaymetrics().width*0.95).toInt()
        layoutParams.height = (displaymetrics().height*0.6).toInt()
        windowAlDl.attributes = layoutParams
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun popupAdviceGameCidade (titulo: String, text: String, imagem: Int) {
        on = false
        proibidoPerder = true
        binding.arpg.visibility = View.GONE

        val dialog: Dialog = Dialog(this)

        val popupCidadeInsigniaBinding: PopupCidadeInsigniaBinding = PopupCidadeInsigniaBinding.inflate(layoutInflater)
        dialog.setContentView(popupCidadeInsigniaBinding.root)
        popupCidadeInsigniaBinding.tituloTextView.text = titulo
        popupCidadeInsigniaBinding.txtBalao.text = text
        popupCidadeInsigniaBinding.insigniaImageView.setImageResource(imagem)
        popupCidadeInsigniaBinding.ok.setOnClickListener {
            on = true
            proibidoPerder = false
            binding.arpg.visibility = View.VISIBLE
            dialog.dismiss()
        }

        val layoutParams = WindowManager.LayoutParams()
        val windowAlDl: Window = dialog.window!!
        layoutParams.width = (displaymetrics().width*0.95).toInt()
        layoutParams.height = (displaymetrics().height*0.65).toInt()
        windowAlDl.attributes = layoutParams
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun popupAdviceGameCidadeLocal (titulo: String, text: String, imagem: Int) {
        on = false
        proibidoPerder = true
        binding.arpg.visibility = View.GONE

        val dialog: Dialog = Dialog(this)

        val popupCidadeLocaisBinding: PopupCidadeLocaisBinding = PopupCidadeLocaisBinding.inflate(layoutInflater)
        dialog.setContentView(popupCidadeLocaisBinding.root)
        popupCidadeLocaisBinding.tituloTextView.text = titulo
        popupCidadeLocaisBinding.txtBalao.text = text
        popupCidadeLocaisBinding.insigniaImageView.setImageResource(imagem)
        popupCidadeLocaisBinding.ok.setOnClickListener {
            on = true
            proibidoPerder = false
            binding.arpg.visibility = View.VISIBLE
            dialog.dismiss()
        }

        val layoutParams = WindowManager.LayoutParams()
        val windowAlDl: Window = dialog.window!!
        layoutParams.width = (displaymetrics().width*0.95).toInt()
        layoutParams.height = (displaymetrics().height*0.65).toInt()
        windowAlDl.attributes = layoutParams
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }


    fun popupMessage (text: String){
        on = false
        proibidoPerder = true
        val dialog: Dialog = Dialog(this)

        val popupLutaContraOCoronavirusBinding: PopupLutaContraOCoronavirusBinding = PopupLutaContraOCoronavirusBinding.inflate(layoutInflater)
        dialog.setContentView(popupLutaContraOCoronavirusBinding.root)

        popupLutaContraOCoronavirusBinding.txtBalao.text = text

        popupLutaContraOCoronavirusBinding.ok.setOnClickListener {
            on = true
            proibidoPerder = false
            dialog.dismiss()
        }

        val layoutParams = WindowManager.LayoutParams()
        val windowAlDl: Window = dialog.window!!
        layoutParams.width = (displaymetrics().width*0.95).toInt()
        layoutParams.height = (displaymetrics().height*0.6).toInt()
        windowAlDl.attributes = layoutParams
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun vidasJogador(pontos: Float) {
        if (!proibidoPerder){
            when {
                pontos in -100f..-1f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_6)
                    star = 3
                }
                pontos in 0f..20f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_5)
                    star = 3
                }
                pontos in 20f..39f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_4)
                    star = 3
                }
                pontos in 40f..59f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_3)
                    star = 3
                }
                pontos in 60f..79f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_3)
                    star = 2
                }
                pontos in 80f..99f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_2)
                    star = 2
                }
                pontos >= 100f -> {
                    binding.imageVidaJogador.setImageResource(R.drawable.ic_tabela_vida_jogador_1)
                    star = 1
                }
            }
            if (pontos >= 120f) {
                finalOficialDeJogo()
            }
        }
    }

    fun pontoA(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y > heightCidade(z, 0.25f) && v && (w != 4) && (w != 3)) ||
                    (x < widthCidade(z, 0.5f) && v && (w != 1) && (w != 2))) ) {
            true
        } else{
            false
        }
    }

    fun pontoB(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (w >= 2) {
            if (((y > heightCidade(z, 3.5f)&& v && (w != 4) && (w != 3)) ||
                        (x < widthCidade(z, 0.5f)&& v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else if (w <= 1) {
            if (((y < heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x < widthCidade(z, 0.5f) && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        } else{
            false
        }
    }

    fun pontoC(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y < heightCidade(z, 9.65f) && v && (w != 4) && (w != 3)) ||
                    (x < widthCidade(z, 0.5f) && v && (w != 1) && (w != 2))) ) {
            true
        } else{
            false
        }
    }

    fun pontoD(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y < heightCidade(z, 9.65f) && v && (w != 4) && (w != 3)) ||
                    (x > widthCidade(z, 7f) && v && (w != 1) && (w != 2) ))) {
            true
        } else{
            false
        }
    }

    fun pontoE(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (w >= 2) {
            if (((y > heightCidade(z, 6.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 7f)  && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else if (w <= 1){
            if (((y < heightCidade(z, 6.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 7f)  && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        } else{
            false
        }
    }

    fun pontoF(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (w >= 2) {
            if (((y > heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 7f)  && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else if (w <= 1){
            if (((y < heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 7f)  && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else{
            false
        }
    }

    fun pontoG(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y > heightCidade(z, 0.25f) && v && (w != 4) && (w != 3)) ||
                    (x > widthCidade(z, 7f) && v && (w != 1) && (w != 2)))) {
            true
        } else{
            false
        }
    }

    fun pontoH(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (w >= 2) {
            if (((y > heightCidade(z, 6.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 11.5f) && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else if (w <= 1){
            if (((y < heightCidade(z, 6.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 11.5f) && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else{
            false
        }
    }

    fun pontoI(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y < heightCidade(z, 9.65f) && v && (w != 4) && (w != 3)) ||
                    (x > widthCidade(z, 11.5f) && v && (w != 1) && (w != 2)))) {
            true
        } else{
            false
        }
    }

    fun pontoJ(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y < heightCidade(z, 9.65f) && v && (w != 4) && (w != 3)) ||
                    (x > widthCidade(z, 16.5f) && v && (w != 1) && (w != 2)))) {
            true
        } else{
            false
        }
    }

    fun pontoK(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (w >= 2) {
            if (((y > heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 16.5f)  && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else if (w <= 1){
            if (((y < heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x > widthCidade(z, 16.5f)  && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else{
            false
        }
    }

    fun pontoL(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y > heightCidade(z, 0.25f) && v && (w != 4) && (w != 3)) ||
                    (x > widthCidade(z, 16.5f) && v && (w != 1) && (w != 2)))) {
            true
        } else{
            false
        }
    }

    fun pontoM(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (((y > heightCidade(z, 0.25f) && v && (w != 4) && (w != 3)) ||
                    (x < widthCidade(z, 11.5f) && v && (w != 1) && (w != 2)))) {
            true
        } else{
            false
        }
    }

    fun pontoN(
        w: Int,
        v: Boolean,
        x: Float,
        y: Float,
        z: ImageView
    ): Boolean {
        return if (w >= 2) {
            if (((y > heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x < widthCidade(z, 11.5f) && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else if (w <= 1){
            if (((y < heightCidade(z, 3.5f) && v && (w != 4) && (w != 3)) ||
                        (x < widthCidade(z, 11.5f) && v && (w != 1) && (w != 2)))
            ) {
                true
            } else{
                false
            }
        }else{
            false
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onDown(e: MotionEvent): Boolean {
        return false
    }

    override fun onShowPress(e: MotionEvent) {}
    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return false
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent) {}
    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return false
    }

    override fun onDestroy() {
        binding.adView.destroy()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAndRemoveTask()
        } else {
            finish()
        }
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        binding.adView.resume()
        binding.imagePause.setOnClickListener {
            pause = false
            on = true
            proibidoPerder = false

            velocidade_inimigoY = 2
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.imagePause.visibility = View.GONE
        }
    }

    override fun onPause() {
        if (!fimDeJogo) {
            pause = true
            binding.imagePause.visibility = View.VISIBLE

            velocidade_inimigoY = 0
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            on = false
            proibidoPerder = true
            binding.adView.pause()

            binding.imagePause.setOnLongClickListener {
                pause = false
                on = true
                proibidoPerder = false

                velocidade_inimigoY = 2
                velocidade_cenarioY = 0f
                velocidade_cenarioX = 0f
                binding.imagePause.visibility = View.GONE
                false
            }
        }
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        fimDeJogo = true
        pause = true
        fimDeJogo = true
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }

        velocidade_inimigoY = 0
        velocidade_cenarioY = 0f
        velocidade_cenarioX = 0f
        binding.imagePause.setOnClickListener {
            pause = false

            velocidade_inimigoY = 2
            velocidade_cenarioY = 0f
            velocidade_cenarioX = 0f
            binding.imagePause.visibility = View.GONE
        }
    }

    companion object {
        private const val MIN_DISTANCE = 150
    }
}
