package com.example.bcasbdpit.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.bcasyariah.R
import com.example.bcasyariah.model.MenuDashboard
import com.example.bcasyariah.model.MenuDashboardModel

class DashboardMenuAdapter(
    private val menuData: List<MenuDashboard>,
    private val context: Context
) : BaseAdapter() {
    private var image: ImageView? = null
    private var textMenu: TextView? = null
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return menuData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var bindingView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (bindingView == null) {
            bindingView = layoutInflater?.inflate(R.layout.item_menu_dashboard, null)
        }

        image = bindingView?.findViewById(R.id.ivmenu)
        textMenu = bindingView?.findViewById(R.id.tvmenu)

        //fungsinya untuk mendapatkan data dr list berdasarkan posisi
        val  resultMenu = menuData[position]

        //ini fungsinya untuk melakukan set pada masing2 component di layout
//        image?.setImageResource(resultMenu.image)
        textMenu?.text = resultMenu.nameMenu
        return bindingView
    }


}