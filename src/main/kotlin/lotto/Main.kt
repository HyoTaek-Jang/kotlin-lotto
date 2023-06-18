package lotto

import lotto.view.input.LottoPurchasePriceInputView
import lotto.view.input.SixFortyFiveLottoLastWinNumInputView
import lotto.view.output.LottoPurchaseOutputView
import lotto.view.output.NewLineOutputView

fun main() {
    val purchasePrice = LottoPurchasePriceInputView().value
    val purchaseCount = purchasePrice / SixFortyFiveLotto.LOTTO_PRICE
    LottoPurchaseOutputView(purchaseCount).renderMessage()

    val lottoStore = SixFortyFiveLottoStore()
    val lottoList = lottoStore.purchase(purchaseCount)
    lottoStore.renderLottos(lottoList)
    NewLineOutputView().renderMessage()

    val lastWinningNumber = SixFortyFiveLottoLastWinNumInputView().value
    NewLineOutputView().renderMessage()

    lottoStore.renderWinningInsight(lottoList, lastWinningNumber)
}