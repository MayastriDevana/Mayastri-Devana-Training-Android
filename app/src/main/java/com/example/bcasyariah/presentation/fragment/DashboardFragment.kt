package com.example.bcasyariah.presentation.fragment


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasbdpit.presentation.fragment.adapter.DashboardMenuAdapter
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboard
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.model.PromoModel
import com.example.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.example.bcasyariah.presentation.fragment.adapter.PromoAdapter
import com.example.bcasyariah.presentation.viewmodel.DashboardViewModel
import com.example.bcasyariah.utils.HorizontalItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountNumberAdapter
    private lateinit var promoAdapter: PromoAdapter

    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing16),
            true
        )
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }


    override fun setupView() {
        setupViewPromo()

        viewModel.getHomeMenu()

        viewModel.getAccountNumber()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.homeMenu.observe(viewLifecycleOwner){
            setupViewMenu(it.data)
        }
        viewModel.accountNumber.observe(viewLifecycleOwner){
            setupViewAccountNumber(it)
        }
    }

    private fun setupViewMenu(data: List<MenuDashboard>?){
        menuAdapter = DashboardMenuAdapter(
            menuData = data ?: listOf(),
            context = binding.root.context
        )
        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context,
                    data?.get(position)?.nameMenu,
                    Toast.LENGTH_SHORT
                ).show()

            }
    }

    private fun setupViewAccountNumber(data: List<AccountNumberModel>){
        accountAdapter = AccountNumberAdapter(
            data = data,
        )
        binding.componentaccountnumber.rvAccountNumber.adapter = accountAdapter
        binding.componentaccountnumber.rvAccountNumber.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentaccountnumber.rvAccountNumber.apply {
            if (itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
        }

    }

    private fun setupViewPromo(){
        promoAdapter = PromoAdapter(
            data = populatePromo()
        )
        binding.componentpromodashboard.rvPromo.adapter = promoAdapter
        binding.componentpromodashboard.rvPromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentpromodashboard.rvPromo.apply {
            if (itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
        }

    }
}
private fun populatePromo() : List<PromoModel>{
    return listOf(
        PromoModel(
            image = R.drawable.bca1
        ),
        PromoModel(
            image = R.drawable.bca2
        ),
        PromoModel(
            image = R.drawable.bca3
        ),
        PromoModel(
            image = R.drawable.bca4
        ),

    )
}