package lotto.domain

import lotto.enums.Winner

class LottoStatistics{


    fun initStatisticsMap(): MutableMap<Winner, Int> {
        val rankMap: MutableMap<Winner, Int> = mutableMapOf(
            Winner.FOURTH_PLACE to 0,
            Winner.THIRD_PLACE to 0,
            Winner.SECOND_PLACE to 0,
            Winner.FIRST_PLACE to 0
        )
        return rankMap
    }

    fun getRating(purchasePrice: Int, resultMap: Map<Winner, Int>): Double {
        val filterMap = resultMap.filter { it.value >= 1 }
        return (filterMap.keys.sumOf { it.reward } / purchasePrice).toDouble()
    }
}