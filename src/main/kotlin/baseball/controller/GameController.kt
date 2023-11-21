package baseball.controller

import baseball.config.GameNumberConfig.DIGIT_NUMBER
import baseball.model.Computer
import baseball.view.InputCmdView
import baseball.view.InputNumberView
import baseball.view.OutputGuideView
import baseball.view.OutputResultView

class GameController {

    // model
    private val computer = Computer()

    // view
    private val inputNumberView = InputNumberView()
    private val inputCmdView = InputCmdView()
    private val outputGuideView = OutputGuideView()
    private val outputResultView = OutputResultView()

    fun startGame() {
        outputGuideView.showStartMsg()
        do {
            startTurn()
            outputGuideView.showEndMsg()
        } while (inputCmdView())
    }

    private fun startTurn() {
        computer.generateAnswer() // A. 컴퓨터는 사용자가 맞힐 정답을 생성한다.

        while (true) {
            val result = computer.getResult(inputNumberView.inputNumber()) // 사용자의 수를 가지고, 결과를 얻는다.

            outputResultView.showResult(result) // C-2 결과 출력
            if (result.strike == DIGIT_NUMBER) {
                break
            }
        }
    }

}