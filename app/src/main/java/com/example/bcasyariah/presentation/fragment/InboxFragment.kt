package com.example.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasyariah.adapter.ListInboxAdapter
import com.example.bcasyariah.databinding.FragmentInboxBinding
import com.example.bcasyariah.model.InboxModel

class InboxFragment : Fragment() {
    private var _binding: FragmentInboxBinding? = null
    private val binding get() = _binding!!
    private var transactionAdapter = ListInboxAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        binding.RvFragmentInbox.adapter = transactionAdapter
        transactionAdapter.setData(createDummyListInbox())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun createDummyListInbox(): MutableList<InboxModel> {
        return mutableListOf(
            InboxModel (
                inboxDate = "14-Maret-2024",
                inboxMassage = "Transaksi Pembayaran QR KAIZEN COFFE",
            ),
            InboxModel (
                inboxDate = "14-Maret-2024",
                inboxMassage = "Transaksi Pembayaran QR SUSHI TEI",
            )
        )

    }
}


