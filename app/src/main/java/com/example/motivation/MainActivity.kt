package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        handleFilter(R.id.image_all)

        // eventos
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageShrine.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            var s = ""
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_shrine)){
            handleFilter(view.id)
        }
    }

    private fun handleFilter(id: Int){


        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageShrine.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))


        if (id == R.id.image_all){
            binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        } else if (id == R.id.image_happy){
            binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        }else if (id == R.id.image_shrine){
            binding.imageShrine.setColorFilter(ContextCompat.getColor(this, R.color.white))
        }

    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, ${name}!"
    }
}
