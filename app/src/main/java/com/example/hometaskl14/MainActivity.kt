package com.example.hometaskl14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        var values: MutableList<Person>? = mutableListOf<Person>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = someTask()?.let { Adapter(it) }

    }

    private fun someTask(): List<Person>? {

        val me = Person("Я (Алексей)", 21)
        me.setMother("Мама (Наташа)", 51)
        me.setFather("Папа (Никита)", 51)

        me.mother?.setMother("Бабушка1 (Мама мамы) ", 71)
        me.mother?.setFather("Дедушка1 (Папа мамы)", 70)

        me.father?.setMother("Бабушка2 (Мама папы)", 69)
        me.father?.setFather("Дедушка2 (Папа папы)", 72)

        me.mother?.mother?.setMother("Прабабушка (Мама бабушки1)", 91)
        me.mother?.mother?.setFather("Прадедушка (Папа бабушки1)", 95)

        me.mother?.father?.setMother("Прабабушка (Мама дедушки1)", 89)
        me.mother?.father?.setFather("Прадедушка (Папа дедушки1)", 88)

        me.father?.father?.setMother("Прабабушка (Мама бабушки2)", 85)
        me.father?.father?.setFather("Прадедушка (Папа бабушки2)", 95)

        me.father?.mother?.setMother("Прабабушка (Мама дедушки2)", 100)
        me.father?.mother?.setFather("Прадедушка (Папа дедушки2)", 90)


        doo(me)

        return values?.toList()
    }

    private fun doo(obj: Person) {
        values?.add(obj)
        obj.mother?.let { doo(it) }
        obj.father?.let { doo(it) }
    }
}