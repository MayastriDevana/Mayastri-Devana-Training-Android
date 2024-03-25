package com.example.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemAccountNumberBinding
import com.example.bcasyariah.databinding.ItemPromoDashboardBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.PromoModel

class PromoAdapter(private val data:List<PromoModel>): RecyclerView.Adapter<PromoAdapter.PromoViewHolder> () {


    inner class PromoViewHolder(
        val binding: ItemPromoDashboardBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(data: PromoModel){
            binding.ivBca.setImageResource(data.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        return PromoViewHolder(
            ItemPromoDashboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(data[position])

    }


}