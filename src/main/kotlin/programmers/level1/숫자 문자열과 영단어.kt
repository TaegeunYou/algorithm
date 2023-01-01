package programmers.level1

class Solution010106 {
    fun solution(s: String): Int {
        val numStringFormatList = listOf("zero","one","two","three","four","five","six","seven","eight","nine",)
        return numStringFormatList.fold(s) { total, element ->
            total.replace(element, numStringFormatList.indexOf(element).toString())
        }.toInt()
    }
}