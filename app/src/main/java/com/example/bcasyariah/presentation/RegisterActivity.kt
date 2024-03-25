package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private var defaultPasswordVisibility = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleRegister()

        binding.ivPassword.setOnClickListener {
            defaultPasswordVisibility = !defaultPasswordVisibility

            if (defaultPasswordVisibility){
                binding.ivPassword.setImageResource(R.drawable.baseline_alarm_on_24)
                binding.etreenterpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }else{
                binding.ivPassword.setImageResource(R.drawable.baseline_alarm_off_24)
                binding.etreenterpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
        }
    }

    private fun handleRegister() {

       binding.buttonregiter.setOnClickListener {
           val etname = binding.etentername.text
            if (etname.isEmpty() || binding.etreenterpassword.text.isEmpty() || binding.etreenterpassword.text.isEmpty()) {
                showToast("Harap Lengkapi Data Dulu Bang")
            } else {
                showToast("Hallo Selamat Datang")
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra(KEY_NAME, etname.toString())
                startActivity(intent)
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"
    }

}


