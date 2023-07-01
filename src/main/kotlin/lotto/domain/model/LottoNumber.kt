package lotto.domain.model

@JvmInline
value class LottoNumber private constructor(val value: Int) {

    init {
        require(value in FIRST_NUMBER..LAST_NUMBER) {
            "숫자의 범위는 $FIRST_NUMBER 이상 $LAST_NUMBER 이하 입니다"
        }
    }

    override fun toString(): String {
        return "$value"
    }

    companion object {
        const val FIRST_NUMBER = 1
        const val LAST_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (FIRST_NUMBER..LAST_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber = NUMBERS[value] ?: throw IllegalArgumentException()
    }
}