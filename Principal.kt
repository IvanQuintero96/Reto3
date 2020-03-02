package com.example.reto3kotlin

import com.example.reto3kotlin.Model.Product
import com.example.reto3kotlin.Model.Receta


val recetas = ArrayList<Receta>()
val listCategories = hashMapOf(1 to "Agua",2 to "leche",3 to "carne",4 to "verduras",5 to "frutas",6 to "cereal",7 to "huevos",8 to "aceites")
val listVerduras = hashMapOf(1 to "habichuela", 2 to "Zanahoria")
val listFrutas = hashMapOf(1 to "Fresa", 2 to "Platano", 3 to "Uvas", 4 to "Manzana", 5 to "Naranja", 6 to "Pera", 7 to "Cereza")
val listCereal = hashMapOf(1 to "Avena", 2 to "Trigo", 3 to "Arroz", 4 to "Maiz")
val listAceites = hashMapOf(1 to "Aceite de oliva", 2 to "Aceite de palma", 3 to "Aceite vegetal")
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
    println("\n$message")
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
    println("Ingrese el nombre de la receta")
    val nombreReceta = readLine()
    var productSelected = ArrayList<Product>()
    do {

        println("\nHacer receta: $nombreReceta\n Selecciona por categoria el ingrediente que buscas")
        listCategories.forEach {
            println("${it.key}. ${it.value}")
        }
        println("\n9. Volver al menu principal")
        val categorieSelected = readLine()?.toInt()

        when (categorieSelected) {
            1-> {name="Agua"
                cantidad=1
                productSelected.add(Product(name, cantidad))
            }
            2-> {name="Leche"
                cantidad=1
                productSelected.add(Product(name, cantidad))
            }
            3-> {name="Carne"
                cantidad = readLine()?.toInt() ?: 1
                productSelected.add(Product(name, cantidad))
            }
            7-> {name="Huevo"
                cantidad = readLine()?.toInt() ?: 1
                if (cantidad>1) name="Huevos"
                productSelected.add(Product(name, cantidad))
            }
            4 -> loadList(listVerduras, productSelected)
            5 -> loadList(listFrutas, productSelected)
            8-> loadList(listAceites, productSelected)
            6-> loadList(listCereal, productSelected)
            9-> {
                recetas.add(Receta(nombreReceta!!, productSelected))
            }
    }}while(categorieSelected!=9)

}


fun loadList(listLoaded : HashMap<Int, String>, productSelect: ArrayList<Product> ){
    listLoaded.forEach {
        println("${it.key}. ${it.value}")
    }
    println("Seleccione una opcion")
    var optionSelected = readLine()?.toInt()
    if (optionSelected!!<=0)optionSelected=1
    else if (optionSelected>=listLoaded.size)optionSelected=listLoaded.size
    name = listLoaded[optionSelected]!!
    println(" Ingrese la cantidad que desea")
    cantidad = readLine()?.toInt() ?: 1
    if (cantidad<=0)cantidad =1
    productSelect.add(Product(name, cantidad))
    productSelect.forEach {
        println("Nombre: ${it.nombre} | Cantidad: ${it.cantidad}")
    }
}

fun viewRecipe(){

    recetas.forEach {
        var j=1
        println("\nReceta: ${it.nombreReceta} ")
        it.listProducts.forEach {
            println("$j. ${it.cantidad} ${it.nombre}" )
            j++
        }
    }

}