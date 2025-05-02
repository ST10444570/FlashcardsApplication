package vcmsa.ci.flashcardsapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class QuizScreen : Fragment(R.layout.quiz_screen) {
    private val questions = listOf(
        Pair("The earth is flat.", false),
        Pair("Kotlin is used for Android development.", true),
        Pair("The sun rises in the west.", false),
        Pair("Water boils at 100°C.", true),
        Pair("The moon is a planet.", false),
    )

    private var currentQuestion = 0
    private var score = 0
    private var selectedAnswer: Boolean? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText: TextView = view.findViewById(R.id.questionText)
        val trueBtn: Button = view.findViewById(R.id.btnTrue)
        val falseBtn: Button = view.findViewById(R.id.btnFalse)
        val nextBtn: Button = view.findViewById(R.id.btnNext)
        val resultText: TextView = view.findViewById(R.id.resultText)

        fun resetSelection() {
            selectedAnswer = null
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
            resultText.text = ""
        }

        fun loadQuestion() {
            questionText.text = questions[currentQuestion].first
            resetSelection()
        }

        trueBtn.setOnClickListener {
            selectedAnswer = true
            trueBtn.setBackgroundColor(Color.GREEN)
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
        }

        falseBtn.setOnClickListener {
            selectedAnswer = false
            falseBtn.setBackgroundColor(Color.RED)
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
        }

        nextBtn.setOnClickListener {
            if (selectedAnswer == null) {
                Toast.makeText(requireContext(), "Please select an answer first.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val correctAnswer = questions[currentQuestion].second
            if (selectedAnswer == correctAnswer) {
                score++
                resultText.text = "Correct"
            } else {
                resultText.text = "Incorrect"
            }

            nextBtn.postDelayed({
                if (currentQuestion < questions.size - 1) {
                    currentQuestion++
                    loadQuestion()
                } else {
                    val bundle = Bundle().apply {
                        putInt("score", score)
                    }
                    findNavController().navigate(R.id.action_quizScreen_to_scoreScreen, bundle)
                }
            }, 1000)
        }

        loadQuestion()
    }
}
