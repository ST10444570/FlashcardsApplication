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

// This class represents the quiz screen fragment.
class quizScreen : Fragment(R.layout.quiz_screen) {

    // List of quiz questions and their corresponding correct answers.
    private val questions = listOf(
        Pair("The earth is flat.", false),
        Pair("Kotlin is used for Android development.", true),
        Pair("The sun rises in the west.", false),
        Pair("Water boils at 100°C.", true),
        Pair("The moon is a planet.", false),
    )

    // Keeps track of which question the user is on.
    private var currentQuestion = 0

    // Keeps track of the user's score.
    private var score = 0

    // Stores the user's selected answer (true or false), or null if not selected yet.
    private var selectedAnswer: Boolean? = null

    // Called when the quiz screen view is created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialise UI (user interface) components.
        val questionText: TextView = view.findViewById(R.id.questionText)
        val trueBtn: Button = view.findViewById(R.id.btnTrue)
        val falseBtn: Button = view.findViewById(R.id.btnFalse)
        val nextBtn: Button = view.findViewById(R.id.btnNext)
        val resultText: TextView = view.findViewById(R.id.resultText)

        // Resets the selection and colours after every question.
        fun resetSelection() {
            selectedAnswer = null
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
            resultText.text = ""
        }

        // Loads the current question into the UI (user interface).
        fun loadQuestion() {
            questionText.text = questions[currentQuestion].first
            resetSelection()
        }

        // Handle "True" button click — marks selection and updates button colour.
        trueBtn.setOnClickListener {
            selectedAnswer = true
            trueBtn.setBackgroundColor(Color.GREEN)
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
        }

        // Handle "False" button click — marks selection and updates button colour.
        falseBtn.setOnClickListener {
            selectedAnswer = false
            falseBtn.setBackgroundColor(Color.RED)
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
        }

        // Handle "Next" button click.
        nextBtn.setOnClickListener {
            // Show error message if user has not selected an answer.
            if (selectedAnswer == null) {
                Toast.makeText(requireContext(), "Please select an answer first.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if the selected answer is correct.
            val correctAnswer = questions[currentQuestion].second
            if (selectedAnswer == correctAnswer) {
                score++ // Increase score if correct.
                resultText.text = "Correct"
            } else {
                resultText.text = "Incorrect"
            }

            // Wait for 1 second before loading next question or navigating to score screen.
            nextBtn.postDelayed({
                if (currentQuestion < questions.size - 1) {
                    // Move to next question.
                    currentQuestion++
                    loadQuestion()
                } else {
                    // End of quiz — send score to the score screen.
                    val bundle = Bundle().apply {
                        putInt("score", score)
                    }
                    findNavController().navigate(R.id.action_quizFragment_to_scoreFragment, bundle)
                }
            }, 1000)
        }

        // Load the first question when screen is shown.
        loadQuestion()
    }
}
