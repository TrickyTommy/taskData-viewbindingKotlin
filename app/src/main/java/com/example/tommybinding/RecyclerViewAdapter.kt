package com.example.tommybinding


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tommybinding.R


class RecyclerViewAdapter(var DatasLists: ArrayList<Datas>?, var itemClick: DatasClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun getItemCount(): Int {
        return DatasLists!!.size
    }

    interface DatasClickListener {
        fun getItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(DatasLists, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
        return RecyclerViewHolder(view, itemClick)
    }

    class RecyclerViewHolder(itemView: View, var itemClick: DatasClickListener) : RecyclerView.ViewHolder(itemView) {
        //    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.text_name)
        var textAddress: TextView = itemView.findViewById(R.id.text_address)
        var textId: TextView = itemView.findViewById(R.id.id)
        var textEmail: TextView = itemView.findViewById(R.id.email)
        fun bindData(hospitalsList: ArrayList<Datas>?, position: Int) {
            textName.text = hospitalsList!!.get(position).firstName
            textAddress.text = hospitalsList!!.get(position).lastName
            textId.text = hospitalsList!!.get(position).id.toString()
            textEmail.text = hospitalsList!!.get(position).email
            itemView.setOnClickListener(View.OnClickListener {
                itemClick.getItem(adapterPosition)
            })
        }
    }
}