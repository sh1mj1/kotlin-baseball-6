package baseball.model

import baseball.config.GameMsg.BALL
import baseball.config.GameMsg.NOTING
import baseball.config.GameMsg.STRIKE
import baseball.config.GameNumberConfig.DIGIT_NUMBER

data class BallAndStrike(
    private var ball: Int = 0,
    private var strike: Int = 0,
) {
    fun getResult(input: String, answer: List<Int>): BallAndStrike {
        for (i in 0 until DIGIT_NUMBER) {
            if (input[i] - '0' == answer[i]) {
                strike++
                continue
            }
            if (answer.contains(input[i] - '0')) {
                ball++
            }
        }
        return this
    }

    fun isSuccess() = strike == DIGIT_NUMBER

    override fun toString(): String = when {
        ball == 0 && strike == 0 -> NOTING
        strike == 0 -> "$ball" + BALL
        ball == 0 -> "$strike" + STRIKE
        else -> "$ball$BALL $strike$STRIKE"
    }
}