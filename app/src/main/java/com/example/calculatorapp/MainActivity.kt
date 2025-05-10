package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var ilkSayi = 0
    private var ikinciSayi = 0
    private var toplam = 0
    private var islemYapiliyor = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewIslem.text = "0"
        binding.textViewSonuc.text = "0"

        val sayiButonlari = arrayOf(
            binding.button0,
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9
        )

        for (i in sayiButonlari.indices) {
            sayiButonlari[i].setOnClickListener {
                sayiTiklandi(i)
            }
        }

        binding.buttonToplama.setOnClickListener {
            if (!binding.textViewIslem.text.toString().endsWith("+")) {
                binding.textViewIslem.text = binding.textViewIslem.text.toString() + "+"
            }
        }

        binding.buttonEsittir.setOnClickListener {
            val islem = binding.textViewIslem.text.toString()
            val sayilar = islem.split("+")

            toplam = 0
            for (sayi in sayilar) {
                if (sayi.isNotEmpty()) {
                    toplam += sayi.toInt()
                }
            }

            binding.textViewSonuc.text = toplam.toString()
        }

        binding.buttonAC.setOnClickListener {
            temizle()
        }
    }
    private fun sayiTiklandi(sayi:Int){
        if (binding.textViewIslem.text.toString() == "0" || islemYapiliyor && !binding.textViewIslem.text.contains("+${sayi}")) {

            if (islemYapiliyor && binding.textViewIslem.text.toString().endsWith("+")) {
                binding.textViewIslem.text = binding.textViewIslem.text.toString() + sayi.toString()

            } else if (islemYapiliyor) {
                binding.textViewIslem.text = binding.textViewIslem.text.toString() + sayi.toString()

            } else {
                binding.textViewIslem.text = sayi.toString()

            }
        } else {
            binding.textViewIslem.text = binding.textViewIslem.text.toString() + sayi.toString()

        }
    }

    private fun temizle(){
        binding.textViewSonuc.text = "0"
        binding.textViewIslem.text = "0"
        toplam = 0
        ilkSayi =0

    }
}