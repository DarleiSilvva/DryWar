package vm.caatsoft.caatingueiros.ui.game_cidade

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import vm.caatsoft.caatingueiros.model.DadosDeUsuarioGameCidade
import vm.caatsoft.caatingueiros.ClassificacaoCidadeAdapter
import vm.caatsoft.caatingueiros.R
import vm.caatsoft.caatingueiros.databinding.ActivityFinalGameCidadeBinding
import vm.caatsoft.caatingueiros.ui.PreJogoActivity
import vm.caatsoft.caatingueiros.utils.tocarSomMedia
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class FinalGameActivity : AppCompatActivity(), ClassificacaoCidadeAdapter.ClassificacaoClickListener {
    var pontuacaoJogador = 0
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
    private lateinit var binding: ActivityFinalGameCidadeBinding
    private lateinit var classificacaoAdapter: ClassificacaoCidadeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalGameCidadeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tocarSomMedia(2, true, this)

        pontuacaoJogador = intent.getIntExtra("PONTUACAO_JOGADOR", 0)
        pontuacaoInimigo = intent.getIntExtra("PONTUACAO_INIMIGO", 0)
        pontuacaoInimigo2 = intent.getIntExtra("PONTUACAO_INIMIGO2", 0)
        pontuacaoInimigo3 = intent.getIntExtra("PONTUACAO_INIMIGO3", 0)
        pontuacaoInimigo4 = intent.getIntExtra("PONTUACAO_INIMIGO4", 0)
        pontuacaoInimigo5 = intent.getIntExtra("PONTUACAO_INIMIGO5", 0)
        pontuacaoInimigo6 = intent.getIntExtra("PONTUACAO_INIMIGO6", 0)
        pontuacaoInimigo7 = intent.getIntExtra("PONTUACAO_INIMIGO7", 0)
        pontuacaoInimigo8 = intent.getIntExtra("PONTUACAO_INIMIGO8", 0)
        pontuacaoInimigo9 = intent.getIntExtra("PONTUACAO_INIMIGO9", 0)
        pontuacaoInimigo10 = intent.getIntExtra("PONTUACAO_INIMIGO10", 0)
        pontuacaoInimigo11 = intent.getIntExtra("PONTUACAO_INIMIGO11", 0)

        val settings = getSharedPreferences("pontoCidade", Context.MODE_PRIVATE)
        var guardarPontos = settings.getInt("guardarPontos", 0)
        if (pontuacaoJogador > guardarPontos){
            guardarPontos = pontuacaoJogador
        }
        val editor = settings.edit()
        editor.putInt("guardarPontos", guardarPontos)
        editor.apply()

        binding.textPontuacaoRecordFora.text = guardarPontos.toString()

        val mLayoutManager = LinearLayoutManager(this)
        binding.myRecycler.layoutManager = mLayoutManager;
        classificacaoAdapter = ClassificacaoCidadeAdapter(getJogosData(), this)
        binding.myRecycler.adapter = classificacaoAdapter

    }

    private fun getJogosData (): ArrayList<DadosDeUsuarioGameCidade> {
        val dadosArray: ArrayList<DadosDeUsuarioGameCidade> = ArrayList<DadosDeUsuarioGameCidade>()
        var dados = DadosDeUsuarioGameCidade()

        dados.nome = getString(R.string.seu_avatar)
        dados.pontos = pontuacaoJogador
        dados.count = 0
        dados.foto = R.drawable.ic_jogador_principal_2_h_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Percilina da Silva"
        dados.pontos = pontuacaoInimigo
        dados.count = 1
        dados.foto = R.drawable.ic_jogador_amarelo_4_m_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Saturnino dos Santos"
        dados.pontos = pontuacaoInimigo2
        dados.count = 2
        dados.foto = R.drawable.ic_jogador_azul_1_h_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Justiniano de Oliveira"
        dados.pontos = pontuacaoInimigo3
        dados.count = 3
        dados.foto = R.drawable.ic_jogador_azul_escuro_1_h_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Dosolina de Souza"
        dados.pontos = pontuacaoInimigo4
        dados.count = 4
        dados.foto = R.drawable.ic_jogador_branco_4_m_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Fin??lila Rodrigues"
        dados.pontos = pontuacaoInimigo5
        dados.count = 5
        dados.foto = R.drawable.ic_jogador_laranja_4_m_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Yolanga Ferreira"
        dados.pontos = pontuacaoInimigo6
        dados.count = 6
        dados.foto = R.drawable.ic_jogador_marrom_4_m_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Jovelina Alves"
        dados.pontos = pontuacaoInimigo7
        dados.count = 7
        dados.foto = R.drawable.ic_jogador_preto_3_m_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Lindulfo Pereira"
        dados.pontos = pontuacaoInimigo8
        dados.count = 8
        dados.foto = R.drawable.ic_jogador_rosa_2_h_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Orquerio Lima"
        dados.pontos = pontuacaoInimigo9
        dados.count = 9
        dados.foto = R.drawable.ic_jogador_roxo_2_h_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Zebedeu Gomes"
        dados.pontos = pontuacaoInimigo10
        dados.count = 10
        dados.foto = R.drawable.ic_jogador_verde_1_h_b
        dadosArray.add(dados)

        dados = DadosDeUsuarioGameCidade()
        dados.nome = "Linildes Ribeiro"
        dados.pontos = pontuacaoInimigo11
        dados.count = 11
        dados.foto = R.drawable.ic_jogador_vinho_3_m_b
        dadosArray.add(dados)

        Collections.sort(dadosArray, Comparator<DadosDeUsuarioGameCidade> { o1, o2 -> o2.pontos - o1.pontos })

        return dadosArray
    }

    fun sair(view: View?) {
        val intent = Intent(this, PreJogoActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.putExtra("VINDO", 1)
        startActivity(intent)
        finish()
    }

    fun recomecar(view: View?) {
        onBackPressed()
    }

    override fun onClassificacaoClicked(
        holder: ClassificacaoCidadeAdapter.ClassificacaoCidadeAdapteAdapterHolder,
        position: Int,
        jogador: ArrayList<DadosDeUsuarioGameCidade>
    ) {
        val classificacao = position + 1



        val settingsPosicao = getSharedPreferences("pontoPosicao", Context.MODE_PRIVATE)
        var guardarPosicao = settingsPosicao.getInt("guardarPosicao", 13)
        val settingsPontos = getSharedPreferences("pontoPontos", Context.MODE_PRIVATE)
        var guardarPontos = settingsPontos.getInt("guardarPontos", 0)

        if (jogador[position].count == 0){
            if (classificacao <= guardarPosicao){
                guardarPosicao = classificacao
                guardarPontos = jogador[position].pontos
            }
        }
        val editorPosicao = settingsPosicao.edit()
        editorPosicao.putInt("guardarPosicao", guardarPosicao)
        editorPosicao.apply()

        val editorPontos = settingsPontos.edit()
        editorPontos.putInt("guardarPontos", guardarPontos)
        editorPontos.apply()

        when (guardarPosicao) {
            1 -> {
                binding.imageUsuarioRecord.setBackgroundResource(R.drawable.balao_ouro)
                binding.textClassificacaoRecord.setBackgroundResource(R.drawable.balao_ouro)
                binding.textUsuarioRecord.setBackgroundResource(R.drawable.balao_ouro)
                binding.textPontuacaoRecord.setBackgroundResource(R.drawable.balao_ouro)
            }
            2 -> {
                binding.imageUsuarioRecord.setBackgroundResource(R.drawable.balao_prata)
                binding.textClassificacaoRecord.setBackgroundResource(R.drawable.balao_prata)
                binding.textUsuarioRecord.setBackgroundResource(R.drawable.balao_prata)
                binding.textPontuacaoRecord.setBackgroundResource(R.drawable.balao_prata)
            }
            3 -> {
                binding.imageUsuarioRecord.setBackgroundResource(R.drawable.balao_bronze)
                binding.textClassificacaoRecord.setBackgroundResource(R.drawable.balao_bronze)
                binding.textUsuarioRecord.setBackgroundResource(R.drawable.balao_bronze)
                binding.textPontuacaoRecord.setBackgroundResource(R.drawable.balao_bronze)
            }
        }

        binding.textClassificacaoRecord.text = guardarPosicao.toString()
        binding.textUsuarioRecord.text = getString(R.string.voce)
        binding.textPontuacaoRecord.text = guardarPontos.toString()
        binding.imageUsuarioRecord.setImageResource(R.drawable.ic_jogador_principal_2_h_b)
    }

    override fun onBackPressed() {
        val intent = Intent(this, PreJogoActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
        super.onBackPressed()
    }
}