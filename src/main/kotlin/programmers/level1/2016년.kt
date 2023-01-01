package programmers.level1

import java.time.LocalDate

class Solution010108 {
    fun solution(a: Int, b: Int): String {
        return LocalDate.of(2016, a, b).dayOfWeek.name.take(3)
    }
}