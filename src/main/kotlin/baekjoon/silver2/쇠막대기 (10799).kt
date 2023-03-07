package baekjoon.silver2

fun main() {
    val input = readLine()
    var totalBar = 0
    var underBar = 0
    var before = ""
    input!!.forEach {
        val tmp = it.toString()
        if (before == "(" && tmp == ")") {
            totalBar += underBar
        } else if (before == "(" && tmp == "(") {
            underBar += 1
            totalBar += 1
        } else if (before == ")" && tmp == ")") {
            underBar -= 1
        }
        before = tmp
    }
    println(totalBar)
}