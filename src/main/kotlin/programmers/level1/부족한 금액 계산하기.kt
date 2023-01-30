package programmers.level1

class Solution013002 {
    fun solution(price: Int, money: Int, count: Int): Long {
        var tmpPrice: Long
        var totalMoney = 0.toLong()
        repeat(count) {
            tmpPrice = price * (it+1).toLong()
            totalMoney += tmpPrice
        }
        return if (money >= totalMoney) 0 else totalMoney - money
    }
}