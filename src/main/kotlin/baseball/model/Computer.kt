package baseball.model

import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.config.GameNumberConfig.END_INCLUSIVE
import baseball.config.GameNumberConfig.START_INCLUSIVE
import baseball.service.NumberValidator
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private var answer: List<Int> = emptyList()

    private val numberComparator = NumberComparator()
    private val numberValidator = NumberValidator()

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
        return numberComparator.compare(input, answer)
    }
}