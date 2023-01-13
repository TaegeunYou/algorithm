package programmers.level1

class Solution011301 {

    private class Personality (
        val type: String,
        var point: Int = 0,
    )

    private val personalityMap = listOf(
        listOf(Personality("R"), Personality("T")),
        listOf(Personality("C"), Personality("F")),
        listOf(Personality("J"), Personality("M")),
        listOf(Personality("A"), Personality("N")),
    )

    fun solution(survey: Array<String>, choices: IntArray): String {
        survey.zip(choices.toTypedArray()).forEach { (types, choice) ->
            val tmpPoint = choice - 4
            val idx = when {
                tmpPoint < 0 -> 0
                tmpPoint > 0 -> 1
                else -> -1
            }
            if (idx != -1) {
                personalityMap[getPersonalityMapIdx(types.first())].first {
                    it.type == "${types[idx]}"
                }.point += Math.abs(tmpPoint)
            }
        }
        return personalityMap.joinToString("") { twoPersonality ->
            twoPersonality.first {
                it.point == twoPersonality.maxOf(Personality::point)
            }.type
        }
    }

    private fun getPersonalityMapIdx(chr: Char): Int {
        return personalityMap.indexOfFirst {
            "$chr" in it.map(Personality::type)
        }
    }
}