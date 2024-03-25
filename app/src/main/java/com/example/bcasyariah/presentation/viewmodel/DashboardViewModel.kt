package com.example.bcasyariah.presentation.viewmodel

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.R
import com.example.bcasyariah.data.remote.MenuDashboardRemoteDatasource
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboard
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.model.MenuDashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val menuDashboardRemoteDatasource: MenuDashboardRemoteDatasource
): ViewModel() {

    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()

    val homeMenu: LiveData<MenuDashboardResponse>
        get() = _homeMenu

    private val _homeMenuError = MutableLiveData<String>()
    val homeMenuError: LiveData<String>
        get() = _homeMenuError

    private val _accountMenu = MutableLiveData<List<AccountNumberModel>>()
    val accountNumber: LiveData<List<AccountNumberModel>>
        get() = _accountMenu
//    private fun populateDataMenu(): List<MenuDashboardModel> {
//        return listOf(
//            MenuDashboardModel(
//                image = R.drawable.fa_brands__telegram_plane,
//                menuName = "Transfer",
//            ),
//            MenuDashboardModel(
//                image = R.drawable.grommet_icons__basket,
//                menuName = "Pembelian",
//            ),
//            MenuDashboardModel(
//                image = R.drawable.majesticons__creditcard_hand_line,
//                menuName = "Pembayaran",
//            ),
//            MenuDashboardModel(
//                image = R.drawable.free_icon_1,
//                menuName = "Cardless",
//            ),
//            MenuDashboardModel(
//                image = R.drawable.icon_park_outline__history_query,
//                menuName = "Histori Transaksi",
//            ),
//            MenuDashboardModel(
//                image = R.drawable.icon_park_outline__transaction,
//                menuName = "Mutasi Rekening",
//            ),
//            MenuDashboardModel(
//                image = R.drawable.mosque,
//                menuName = "Jadwal Sholat",
//            )
//
//        )
//    }
    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO){
        menuDashboardRemoteDatasource.getMenuDashboard().let {
            if (it.isSuccessful){
                _homeMenu.postValue(it.body())
            } else{
                _homeMenuError.postValue(it.message())
            }
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
    fun getAccountNumber() = viewModelScope.launch(Dispatchers.IO){
        _accountMenu.postValue(populateDataAccountNumber())
    }
}