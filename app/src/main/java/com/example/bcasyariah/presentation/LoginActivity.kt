package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.databinding.ActivityLoginBinding
import com.example.bcasyariah.utils.SharedPrefHelper
import java.util.UUID

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var sharePref: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharedPrefHelper(this)
        checkToken()
        handleLogin()
        handlernotregister()


        binding.showPassCheckBox.setOnClickListener {
            val showPassCheckBox = binding.showPassCheckBox
            val passwordEditText = binding.passwordEditText.text
            if (showPassCheckBox.isChecked) {
                binding.passwordEditText.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }
    private fun handleLogin() {
        binding.buttonlogin.setOnClickListener {
            val entername = binding.enterName.text
            val passwordEditText = binding.passwordEditText.text

//            if (entername.isEmpty() || passwordEditText.isEmpty()) {
//                showToast("Harap isi informasi login dulu bang")
            if (entername.isNotEmpty() || passwordEditText.isNotEmpty()) {
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
                handleProfile()
            } else {
                showToast("Hallo Selamat Datang")
            }
        }
    }
    private fun checkToken(){
        val getToken = sharePref.getToken()
        if (getToken.isNotEmpty())
            handlernotregister()
    }

    private fun handlernotregister() {
        binding.tvregister.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleProfile() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}