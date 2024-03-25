package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.presentation.RegisterActivity.Companion.KEY_NAME
import com.example.bcasyariah.databinding.ActivityProfileBinding
import dagger.hilt.android.AndroidEntryPoint


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val getName = intent.getStringExtra(KEY_NAME)
        binding.tvLabelName.text = getName

        binding.vTopBar.tvToolsProfile.text = "Profile"
        binding.vTopBar.ivLogoback.setOnClickListener {
            onBackPressed() }

        val buttonLogout = findViewById<Button>(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            handleProfile()
        }

}
    private fun handleProfile() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}