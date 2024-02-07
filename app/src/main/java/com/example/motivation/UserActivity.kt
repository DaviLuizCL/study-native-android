package com.example.motivation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("UserActivity", "Aplicativo Iniciado")

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()

        verifyUserName()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()

        }
    }

    private fun verifyUserName(){
        Log.d("UserActivity", "Starting Main Activity")
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        Log.d("UserActivity", "User name: $name")
        if (name != ""){
            Log.d("UserActivity", "Nome não vazio")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_LONG).show()
        }
    }
}
