package com.example.serial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var addressInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var saveButton: Button
    private lateinit var personListView: ListView

    private val personList = mutableListOf<Person>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        firstNameInput = findViewById(R.id.firstNameInput)
        lastNameInput = findViewById(R.id.lastNameInput)
        addressInput = findViewById(R.id.addressInput)
        phoneInput = findViewById(R.id.phoneInput)
        saveButton = findViewById(R.id.saveButton)
        personListView = findViewById(R.id.personListView)

        // Настройка адаптера для списка
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        personListView.adapter = adapter

        // Сохранение данных
        saveButton.setOnClickListener {
            val firstName = firstNameInput.text.toString()
            val lastName = lastNameInput.text.toString()
            val address = addressInput.text.toString()
            val phone = phoneInput.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && address.isNotEmpty() && phone.isNotEmpty()) {
                // Создаем объект Person и добавляем в список
                val person = Person(firstName, lastName, address, phone)
                personList.add(person)

                // Обновляем адаптер списка
                adapter.add("$firstName $lastName")

                // Очищаем поля ввода
                firstNameInput.text.clear()
                lastNameInput.text.clear()
                addressInput.text.clear()
                phoneInput.text.clear()
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        // Переход на второй экран при клике на элемент списка
        personListView.setOnItemClickListener { _, _, position, _ ->
            val selectedPerson = personList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("firstName", selectedPerson.firstName)
                putExtra("lastName", selectedPerson.lastName)
                putExtra("address", selectedPerson.address)
                putExtra("phone", selectedPerson.phone)
            }
            startActivity(intent)
        }
    }
}