package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QuizScreen : Fragment(R.layout.quiz_screen) {
    private val questions = listOf(
        Pair("The earth is flat.", false),
        Pair("Kotlin is used for Android development.", true),
        Pair("The sun rises in the west.", false),
        Pair("Water boils at 100°C.", true),
        Pair("The moon is a planet.", false)
    )

    private var currentQuestion = 0
    private var score = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText: TextView = view.findViewById(R.id.questionText)
        val trueBtn: Button = view.findViewById(R.id.btnTrue)
        val falseBtn: Button = view.findViewById(R.id.btnFalse)

        fun loadQuestion() {
            questionText.text = questions[currentQuestion].first
        }

        fun nextQuestion() {
            if (currentQuestion < questions.size - 1) {
                currentQuestion++
                loadQuestion()
            } else {
                val bundle = Bundle().apply {
                    putInt("score", score)
                }
                findNavController().navigate(R.id.action_quizScreen_to_scoreScreen, bundle)

            }
        }

        trueBtn.setOnClickListener {
            if (questions[currentQuestion].second) score++
            nextQuestion()
        }

        falseBtn.setOnClickListener {
            if (!questions[currentQuestion].second) score++
            nextQuestion()
        }

        loadQuestion()
    }
}
