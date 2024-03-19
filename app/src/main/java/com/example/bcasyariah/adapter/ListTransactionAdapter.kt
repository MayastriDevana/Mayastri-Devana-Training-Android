package com.example.bcasyariah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemListTransactionBinding
import com.example.bcasyariah.model.TransactionModel

class ListTransactionAdapter : RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>() {

    private var _data:MutableList<TransactionModel> = mutableListOf()

    private var _onClickTransaction: (TransactionModel) -> Unit = {}

    fun setData(newData: MutableList<TransactionModel>){
        _data=newData
        notifyDataSetChanged()
    }

    fun setOnClickTransaction(listener: (TransactionModel) -> Unit){
        _onClickTransaction = listener

    }

    inner class TransactionViewHolder(private val binding: ItemListTransactionBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: TransactionModel, onClickTransaction: (TransactionModel) -> Unit){
            binding.tvStatus.text = item.transferStatus
            binding.tvTransferType.text = item.transferType
            binding.tvDate.text = item.date
            binding.ivAmount.text = item.amount.toString()
            binding.tvTransferDestination.text = item.transferDestination

            binding.root.setOnClickListener { onClickTransaction.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            ItemListTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position], _onClickTransaction)
    }

}