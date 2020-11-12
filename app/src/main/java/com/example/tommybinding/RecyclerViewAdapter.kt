package com.example.tommybinding


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tommybinding.R


class RecyclerViewAdapter(var DatasLists: ArrayList<Datas>, var itemClick: DatasClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun getItemCount(): Int {
        return DatasLists.size
    }

    interface DatasClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = DatasLists.get(position)
        holder.bindData(item, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return RecyclerViewHolder(view, itemClick)
    }

    class RecyclerViewHolder(itemView: View, var itemClick: DatasClickListener) : RecyclerView.ViewHolder(itemView) {
        //    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.text_name)
        var textAddress: TextView = itemView.findViewById(R.id.text_address)
        var textId: TextView = itemView.findViewById(R.id.id)

        var textEmail: TextView = itemView.findViewById(R.id.email)
        fun bindData(hospitalsList: Datas, position: Int) {
            println(hospitalsList.toString())
            textName.text = hospitalsList.firstName
            textAddress.text = hospitalsList.lastName
            textId.text = hospitalsList.id.toString()
            textEmail.text = hospitalsList.email
            itemView.setOnClickListener(View.OnClickListener {
                itemClick.getItem(adapterPosition)
            })
        }
    }
}