package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityHomeBinding
import com.example.bcasyariah.databinding.ActivityLoginBinding
import com.example.bcasyariah.presentation.fragment.AdminFragment
import com.example.bcasyariah.presentation.fragment.DashboardFragment
import com.example.bcasyariah.presentation.fragment.InboxFragment
import com.example.bcasyariah.presentation.fragment.MessageFragment
import com.example.bcasyariah.utils.ConfirmationDialogUtil
import com.example.bcasyariah.utils.SharedPrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil
    private lateinit var sharePref: SharedPrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationInbox -> {
                    replaceFragment(InboxFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationAdmin -> {
                    replaceFragment(AdminFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener false
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        confirmationDialogUtil = ConfirmationDialogUtil(this)
        sharePref = SharedPrefHelper(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun showConfirmation(){
        val title = "Apakah anda ingin keluar ?"
        val icon = R.drawable.barbie

        confirmationDialogUtil.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            },
            onCancel = {},
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}