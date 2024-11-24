package com.example.serial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var firstNameOutput: TextView
    private lateinit var lastNameOutput: TextView
    private lateinit var addressOutput: TextView
    private lateinit var phoneOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Инициализация элементов интерфейса
        firstNameOutput = findViewById(R.id.firstNameOutput)
        lastNameOutput = findViewById(R.id.lastNameOutput)
        addressOutput = findViewById(R.id.addressOutput)
        phoneOutput = findViewById(R.id.phoneOutput)

        // Получение данных из Intent
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val address = intent.getStringExtra("address")
        val phone = intent.getStringExtra("phone")

        // Установка данных в TextView
        firstNameOutput.text = "Имя: $firstName"
        lastNameOutput.text = "Фамилия: $lastName"
        addressOutput.text = "Адрес: $address"
        phoneOutput.text = "Телефон: $phone"
    }
}