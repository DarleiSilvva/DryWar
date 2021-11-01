package vm.caatsoft.caatingueiros

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import vm.caatsoft.caatingueiros.model.DadosDeUsuarioGameCidade
import vm.caatsoft.caatingueiros.databinding.ModeloClassificacaoBinding
import java.util.*


class ClassificacaoCidadeAdapter(
    var model: ArrayList<DadosDeUsuarioGameCidade>, var classificacaoClickListener : ClassificacaoClickListener) :
    RecyclerView.Adapter<ClassificacaoCidadeAdapter.ClassificacaoCidadeAdapteAdapterHolder>() {
    var classificacao = 0

    class ClassificacaoCidadeAdapteAdapterHolder (val modelBinding: ModeloClassificacaoBinding): RecyclerView.ViewHolder(modelBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClassificacaoCidadeAdapteAdapterHolder {
        return ClassificacaoCidadeAdapteAdapterHolder(ModeloClassificacaoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ClassificacaoCidadeAdapteAdapterHolder, position: Int) {
        classificacaoClickListener.onClassificacaoClicked(holder, position, model)
        val context = holder.modelBinding.root.context

        classificacao = position + 1

        when (classificacao) {
            1 -> {
                holder.modelBinding.imageUsuario.setBackgroundResource(R.drawable.balao_ouro)
                holder.modelBinding.textClassificacao.setBackgroundResource(R.drawable.balao_ouro)
                holder.modelBinding.textUsuario.setBackgroundResource(R.drawable.balao_ouro)
                holder.modelBinding.textPontuacao.setBackgroundResource(R.drawable.balao_ouro)
            }
            2 -> {
                holder.modelBinding.imageUsuario.setBackgroundResource(R.drawable.balao_prata)
                holder.modelBinding.textClassificacao.setBackgroundResource(R.drawable.balao_prata)
                holder.modelBinding.textUsuario.setBackgroundResource(R.drawable.balao_prata)
                holder.modelBinding.textPontuacao.setBackgroundResource(R.drawable.balao_prata)
            }
            3 -> {
                holder.modelBinding.imageUsuario.setBackgroundResource(R.drawable.balao_bronze)
                holder.modelBinding.textClassificacao.setBackgroundResource(R.drawable.balao_bronze)
                holder.modelBinding.textUsuario.setBackgroundResource(R.drawable.balao_bronze)
                holder.modelBinding.textPontuacao.setBackgroundResource(R.drawable.balao_bronze)
            }
        }
        if (model[position].count == 0){
            val boldtypeface = Typeface.defaultFromStyle(Typeface.BOLD)
            val typeface = ResourcesCompat.getFont(context, R.font.bangers);
            holder.modelBinding.textUsuario.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            holder.modelBinding.textPontuacao.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            holder.modelBinding.textClassificacao.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            holder.modelBinding.textUsuario.typeface = boldtypeface
            holder.modelBinding.textPontuacao.typeface = boldtypeface
            holder.modelBinding.textClassificacao.typeface = boldtypeface
            holder.modelBinding.textUsuario.typeface = typeface
            holder.modelBinding.textPontuacao.typeface = typeface
            holder.modelBinding.textClassificacao.typeface = typeface

        }

        holder.modelBinding.textClassificacao.text = classificacao.toString()
        holder.modelBinding.textUsuario.text = model[position].nome
        holder.modelBinding.textPontuacao.text = model[position].pontos.toString()
        holder.modelBinding.imageUsuario.setImageResource(model[position].foto)

    }

    interface ClassificacaoClickListener{
        fun onClassificacaoClicked(holder: ClassificacaoCidadeAdapteAdapterHolder,
                                   position: Int, jogador: ArrayList<DadosDeUsuarioGameCidade>)
    }

    override fun getItemCount(): Int {
        return model.size
    }

}