package com.example.bcasyariah.data.remote

import com.example.bcasyariah.data.Service
import com.example.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response
import javax.inject.Inject

class MenuDashboardRemoteDatasourceImpl  @Inject constructor(
    val service: Service
) :
    MenuDashboardRemoteDatasource {
    override suspend fun getMenuDashboard(): Response<MenuDashboardResponse> {
        return service.getHomeMenu()
    }


}