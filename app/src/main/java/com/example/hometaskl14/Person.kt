package com.example.hometaskl14

fun getMe(obj: Person): Person {
    return obj
}

class Person(
    val name: String,
    val age: Int,
    var flag: Int = 1
) {
    var values: MutableList<Person> = mutableListOf()
    var mother: Person? = null
    var father: Person? = null
    var sistersAndBrothers: ArrayList<Person> = ArrayList<Person>()

    fun isAdulthood(): Boolean {
        return age >= 18
    }

    fun setMother(name: String, age: Int) {
        val customFlag = flag + 1
        mother = Person(name, age, customFlag)
    }

    fun setFather(name: String, age: Int) {
        val customFlag = flag + 1
        father = Person(name, age, customFlag)
    }

    fun hasMother(): Boolean {
        return this.mother != null
    }

    fun hasFather(): Boolean {
        return this.father != null
    }


    fun setSisterOrBrother(name: String, age: Int) {
        sistersAndBrothers.add(Person(name, age))
    }

    fun numOfRelatives(): Int {
        var counter = 0
        if (hasMother()) {
            counter += 1
            counter += this.mother?.numOfRelatives() ?: 0
        }
        if (hasFather()) {
            counter += 1
            counter += this.father?.numOfRelatives() ?: 0
        }
        counter += sistersAndBrothers.size
        return counter
    }

}


