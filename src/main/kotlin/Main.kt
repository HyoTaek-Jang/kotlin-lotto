import lotto.domain.LottoShop
import lotto.domain.LottoStatistics
import lotto.enums.Winner
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val input = InputView()
    val purchasePrice = input.inputPurchasePrice()
    val lottos = LottoShop(purchasePrice).sellLotto()
    val resultView = ResultView()
    resultView.showLottoCount(lottos)
    resultView.showLottos(lottos)
    val lastWinnerNumbers = input.inputLastWinNumbers()
    val statistics = LottoStatistics()
    val rankMap = statistics.initStatisticsMap()
    lottos.forEach {
        val matchCount = it.getMatchCount(lastWinnerNumbers)
        Winner.findWinner(matchCount, rankMap)
    }
    val rating = statistics.getRating(purchasePrice, rankMap)

    resultView.showStatisticsResult(rankMap)
    resultView.showWinRating(rating)
}