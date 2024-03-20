package com.example.bcasyariah.presentation.fragment


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasbdpit.presentation.fragment.adapter.DashboardMenuAdapter
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.example.bcasyariah.utils.HorizontalItemDecoration


class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountNumberAdapter

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
        setupViewMenu()
        setupViewAccountNumber()

    }
    private fun setupViewMenu(){
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(),
            context = binding.root.context
        )
        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context,
                    populateDataMenu()[position].menuName,
                    Toast.LENGTH_SHORT
                ).show()

            }
    }

    private fun setupViewAccountNumber(){
        accountAdapter = AccountNumberAdapter(
            data = populateDataAccountNumber()
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

    private fun populateDataMenu(): List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.fa_brands__telegram_plane,
                menuName = "Transfer",
            ),
            MenuDashboardModel(
                image = R.drawable.grommet_icons__basket,
                menuName = "Pembelian",
            ),
            MenuDashboardModel(
                image = R.drawable.majesticons__creditcard_hand_line,
                menuName = "Pembayaran",
            ),
            MenuDashboardModel(
                image = R.drawable.free_icon_1,
                menuName = "Cardless",
            ),
            MenuDashboardModel(
                image = R.drawable.icon_park_outline__history_query,
                menuName = "Histori Transaksi",
            ),
            MenuDashboardModel(
                image = R.drawable.icon_park_outline__transaction,
                menuName = "Mutasi Rekening",
            ),
            MenuDashboardModel(
                image = R.drawable.mosque,
                menuName = "Jadwal Sholat",
            )

        )
    }
}

private fun populateDataAccountNumber() : List<AccountNumberModel>{
    return listOf(
        AccountNumberModel(
            savingType = 1,
            numberRekening = 12342547,
            balanceAmount = "Rp.10.000"
        ),
        AccountNumberModel(
            savingType = 1,
            numberRekening = 12342547,
            balanceAmount = "Rp.10.000"
        ),
        AccountNumberModel(
            savingType = 1,
            numberRekening = 12342547,
            balanceAmount = "Rp.10.000"
        )
    )
}