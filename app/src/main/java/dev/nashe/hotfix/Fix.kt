package dev.nashe.hotfix

import android.util.Log

class Fix {
    var s = "s"
    fun b(s1: String, s2: String): Int {
        Log.e("euler", s1)
        Log.e("euler", i.toString() + "==" + c())
        Log.i("euler", "fix succes$s")
        Log.i("euler", o.s)
        return 0
    }

    private fun c(): String {
        return "a"
    }

    companion object {
        private val o = O("fix")
        var i = 11
        fun a(str: String): String {
            Log.d("qq", str)
            Log.i("euler", "fix succes")
            return "b"
        }
    }
}