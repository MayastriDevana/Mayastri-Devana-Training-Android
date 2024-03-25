package com.example.bcasyariah.data

import com.example.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("menu-dashboard")
    suspend fun getHomeMenu() : Response<MenuDashboardResponse>

}


