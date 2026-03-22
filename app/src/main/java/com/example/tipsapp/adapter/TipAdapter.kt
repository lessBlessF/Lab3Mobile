package com.example.tipsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tipsapp.R
import com.example.tipsapp.model.Tip

class TipAdapter(
    private val dataset: List<Tip>,
    private val onClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDay: TextView = view.findViewById(R.id.tvDay)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val ivImage: ImageView = view.findViewById(R.id.ivTipImage)
        val tvShortDesc: TextView = view.findViewById(R.id.tvShortDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val item = dataset[position]
        val context = holder.itemView.context

        holder.tvDay.text = context.getString(R.string.day_label, item.dayNumber)
        holder.tvTitle.text = context.getString(item.titleRes)
        holder.tvShortDesc.text = context.getString(item.shortDescRes)
        holder.ivImage.setImageResource(item.imageRes)

        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = dataset.size
}