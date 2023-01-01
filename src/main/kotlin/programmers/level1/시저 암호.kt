package programmers.level1

class Solution010102 {
    fun solution(s: String, n: Int): String {
        return s.map { char ->
            if (!char.isWhitespace()) {
                (char.code + n).let { charCode ->
                    if (char.isUpperCase() && charCode > 90 || char.isLowerCase() && charCode > 122) charCode - 26
                    else charCode
                }.toChar()
            }
            else char
        }.joinToString("")
    }
}