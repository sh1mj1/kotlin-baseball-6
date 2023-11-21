package baseball.controller

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
        computer.generateAnswer()

        while (true) {
            val result = computer.getResult(inputNumberView.inputNumber())
            outputResultView.showResult(result)
            if (computer.isSuccess()) {
                break
            }
        }
    }

}