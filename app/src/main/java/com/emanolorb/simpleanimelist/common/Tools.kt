package com.emanolorb.simpleanimelist.common

import android.widget.Toast

object Tools {
    fun debug_print(anything: Any, title : String = "", show : Boolean = false){
        if (show){
            Toast.makeText(MyApp.instance, anything.toString(), Toast.LENGTH_SHORT).show()
        }
        println(title.plus(" <----------------------------\n"))
        println(anything)
        print("------------------------------------------->\n")
    }
}