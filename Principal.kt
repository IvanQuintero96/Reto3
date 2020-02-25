package com.example.reto3kotlin

import com.example.reto3kotlin.Model.Aceites
import com.example.reto3kotlin.Model.Cereal
import com.example.reto3kotlin.Model.Frutas
val frutaSelected = mutableListOf<Frutas>()
val aceiteSelected = mutableListOf<Aceites>()
val cerealSelected = mutableListOf<Cereal>()
var listCargada = mutableListOf<String>()
val listCategories = mutableListOf("Agua","leche", "carne", "verduras", "frutas", "cereal", "huevos", "aceites")
val listFrutas = mutableListOf("Fresa", "Platano", "Uvas", "Manzana", "Naranja", "Pera", "Cereza")
val listCereal = mutableListOf("Avena", "Trigo", "Arroz", "Maiz")
val listAceites = mutableListOf("De oliva", "De palma", "Vegetal")
var name = ""
var cantidad = 0

fun main (args: Array<String>){
viewMenu()
}

fun viewMenu() {
    do {

    val message = """BIENVENIDO A RECIPES MAKER
        |
        |Selecciona la opcion deseada
        |
        |1. Hacer una receta
        |2. Ver mis recetas
        |3. Salir
    """.trimMargin()
    println(message)
    val response = readLine()?.toInt()

    when (response) {
        1 -> createReciper()
        2 -> viewRecipe()
        3 -> println("Gracias")
        else -> println("Opcion no valida intentelo de nuevo")
    }
    }while (response!=3)
}

fun createReciper() {


    do {
        var j=1
        println("Hacer receta\n Selecciona por categoria el ingrediente que buscas")
        for (i in listCategories) {
            println("$j. $i")
            j++
        }
        println("\n9. Volver al menu principal")
        val categorieSelected = readLine()?.toInt()

        when (categorieSelected) {
            5 -> {
                listCargada = listFrutas
                loadList(listCargada)
                frutaSelected.add(Frutas(name, cantidad))
                frutaSelected.forEach {
                    println("Fruta: ${it.nombre} | Cantidad: ${it.cantidad}")
                }

        }
            8-> {
                listCargada = listAceites
                loadList(listCargada)
                aceiteSelected.add(Aceites(name, cantidad))
                aceiteSelected.forEach {
                    println("Aceite: ${it.nombre} | Cantidad: ${it.cantidad}")
                }
            }
            6-> {
                listCargada = listCereal
                loadList(listCargada)
                cerealSelected.add(Cereal(name, cantidad))
                cerealSelected.forEach {
                    println("Cereal: ${it.nombre} | Cantidad: ${it.cantidad}")
                }
            }
    }}while(categorieSelected!=9)

}


fun loadList(listLoaded : List<String>){
    var j= 1
    for (i in listLoaded){
        println("$j. $i")
        j++
    }
    println("Seleccione una opcion")
    var optionSelected = readLine()?.toInt()
    if (optionSelected!!<=0)optionSelected=1
    else if (optionSelected>=listLoaded.size)optionSelected=listLoaded.size
    name = listLoaded[optionSelected-1]
    println(" Ingrese la cantidad que desea")
    cantidad = readLine()?.toInt() ?: 1
    if (cantidad<=0)cantidad =1
}

fun viewRecipe(){
    println("ver recetas")
}
