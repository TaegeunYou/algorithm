package programmers.level1

class Solution011201 {
    fun solution(new_id: String): String {
        return new_id.toLowerCase()
            .filter {
                it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.'
            }
            .replace("[.]+".toRegex(), ".")
            .removePrefix(".").removeSuffix(".")
            .let {
                it.ifEmpty {
                    "a"
                }
            }.let {
                if (it.length >= 16) {
                    it.substring(0..14).let {
                        if (it.lastOrNull() == '.') {
                            it.substring(0..it.lastIndex - 1)
                        } else it
                    }
                } else it
            }.let {
                if (it.length <= 2) {
                    it + it.last().toString().repeat(3 - it.length)
                } else it
            }
    }
}
