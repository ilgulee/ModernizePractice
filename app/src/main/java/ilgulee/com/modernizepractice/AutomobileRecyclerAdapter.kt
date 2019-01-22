package ilgulee.com.modernizepractice

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

class AutomobileRecyclerAdapter : RecyclerView.Adapter<AutomobileRecyclerAdapter.AutomobileViewHolder>() {
    private val automobiles = ArrayList<Automobile>()

    fun addAutomobile(automobile: Automobile) {
        this.automobiles.add(automobile)
        notifyDataSetChanged()
    }

    fun updateData(automobiles: List<Automobile>) {
        this.automobiles.addAll(automobiles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AutomobileViewHolder {
        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item, viewGroup, false)
        return AutomobileViewHolder(view)
    }

    override fun onBindViewHolder(automobileViewHolder: AutomobileViewHolder, i: Int) {
        val automobile = automobiles[i]
        automobileViewHolder.textMaker.text = automobile.maker
        automobileViewHolder.textModel.text = automobile.model
    }

    override fun getItemCount() = automobiles.size


    inner class AutomobileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textMaker: TextView
        var textModel: TextView

        init {
            textMaker = itemView.findViewById(R.id.maker_text)
            textModel = itemView.findViewById(R.id.model_text)
        }
    }
}
