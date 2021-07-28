package dev.nashe.hotfix

class O(s: String) {
    var s = "s"
    override fun toString(): String {
        return s
    }

    init {
        this.s = s
    }
}