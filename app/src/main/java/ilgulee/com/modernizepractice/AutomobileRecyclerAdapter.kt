package ilgulee.com.modernizepractice

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ilgulee.com.modernizepractice.room.AutomobileDatabase

class AutomobileRecyclerAdapter(private val context: Context, val lifecycle: Lifecycle) : RecyclerView.Adapter<AutomobileRecyclerAdapter.AutomobileViewHolder>() {

    private var automobiles = ArrayList<Automobile>()

    fun setAutomobiles(arrayList: ArrayList<Automobile>) {
        this.automobiles.clear()
        this.automobiles.addAll(arrayList)
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
        automobileViewHolder.deleteButton.setOnClickListener {
            Thread {
                AutomobileDatabase.getDatabase(context)!!.automobileDao().deleteAuto(automobile)
                (context as Activity).runOnUiThread {
                    automobiles.remove(automobile)
                    notifyDataSetChanged()
                }
            }.start()
        }
    }

    override fun getItemCount() = automobiles.size

    inner class AutomobileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textMaker: TextView
        var textModel: TextView
        var updateButton: Button
        var deleteButton: Button

        init {
            textMaker = itemView.findViewById(R.id.maker_text)
            textModel = itemView.findViewById(R.id.model_text)
            updateButton = itemView.findViewById(R.id.update_button)
            deleteButton = itemView.findViewById(R.id.delete_button)
        }

    }
}
