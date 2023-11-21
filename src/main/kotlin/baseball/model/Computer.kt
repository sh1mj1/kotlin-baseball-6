package baseball.model

import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.config.GameNumberConfig.END_INCLUSIVE
import baseball.config.GameNumberConfig.START_INCLUSIVE
import baseball.service.NumberValidator
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer: List<Int> = emptyList()
    private val numberValidator = NumberValidator()
    private lateinit var ballAndStrike: BallAndStrike

    fun generateAnswer() {
        val answer = mutableListOf<Int>()
        while (answer.size < DIGIT_NUMBER) {
            val randomNum = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE)
            if (!answer.contains(randomNum)) {
                answer.add(randomNum)
            }
        }
        this.answer = answer.toList()
    }

    fun getResult(input: String = ""): BallAndStrike {
        numberValidator.validate(input)
        ballAndStrike = BallAndStrike()
        return ballAndStrike.getResult(input, answer)
    }

    fun isSuccess() = ballAndStrike.isSuccess()

}