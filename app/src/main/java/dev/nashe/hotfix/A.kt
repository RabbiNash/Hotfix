package dev.nashe.hotfix

import android.util.Log

class A {
    var s = "s"
    fun b(s1: String?, s2: String?): Int {
        Log.i("euler", "fix error")
        Log.i("euler", o.s)
        return 0
    }

    val i: Int
        get() = Companion.i

    companion object {
        private val o: O = O("a")
        var i = 10
        fun a(str: String?): String {
            Log.i("euler", "fix error")
            return "a"
        }
    }
}