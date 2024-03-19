package com.example.bcasyariah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemInboxBinding
import com.example.bcasyariah.model.InboxModel

class ListInboxAdapter : RecyclerView.Adapter<ListInboxAdapter.TransactionViewHolder>() {

    private var _data:MutableList<InboxModel> = mutableListOf()

    private var _onClickTransaction: (InboxModel) -> Unit = {}

    fun setData(newData: MutableList<InboxModel>){
        _data=newData
        notifyDataSetChanged()
    }

    fun setOnClickTransaction(listener: (InboxModel) -> Unit){
        _onClickTransaction = listener

    }

    inner class TransactionViewHolder(private val binding: ItemInboxBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: InboxModel, onClickTransaction: (InboxModel) -> Unit){
            binding.tvInboxDate.text = item.inboxDate
            binding.tvInboxMassage.text = item.inboxMassage

            binding.root.setOnClickListener { onClickTransaction.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            ItemInboxBinding.inflate(
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