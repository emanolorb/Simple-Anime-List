package com.emanolorb.simpleanimelist.common

object Tools {
    fun debug_print(string: String, title : String = ""){
        println(title.plus(" <----------------------------\n"))
        println(string)
        print("------------------------------------------->\n")
    }
}