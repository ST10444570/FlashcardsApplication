package vcmsa.ci.flashcardsapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// This fragment handles the main quiz functionality, including displaying questions, capturing user answers, calculating score, and navigating to the score screen.
class QuizScreen : Fragment(R.layout.quiz_screen) {

    // List of questions with their correct true/false answers
    private val questions = listOf(
        Pair("The earth is flat?", false),
        Pair("Kotlin is used for Android development?", true),
        Pair("The sun rises in the west?", false),
        Pair("Water boils at 100°C?", true),
        Pair("The moon is a planet?", false)
    )

    // Current question index and user score
    private var currentQuestion = 0
    private var score = 0
    private var selectedAnswer: Boolean? = null

    // Lists to store user progress for review
    private val userAnswers = mutableListOf<String>()
    private val correctAnswers = mutableListOf<String>()
    private val questionTexts = mutableListOf<String>()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get references to UI components
        val questionText: TextView = view.findViewById(R.id.questionText)
        val trueBtn: Button = view.findViewById(R.id.btnTrue)
        val falseBtn: Button = view.findViewById(R.id.btnFalse)
        val nextBtn: Button = view.findViewById(R.id.btnNext)
        val resultText: TextView = view.findViewById(R.id.resultText)

        // Function to reset button colors and selection state
        fun resetSelection() {
            selectedAnswer = null
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
            resultText.text = ""
            nextBtn.isEnabled = true
        }

        // Function to load and display the current question
        fun loadQuestion() {
            questionText.text = questions[currentQuestion].first
            resetSelection()
        }

        // Handle selection of "True" answer
        trueBtn.setOnClickListener {
            selectedAnswer = true
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selection_color))
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
        }

        // Handle selection of "False" answer
        falseBtn.setOnClickListener {
            selectedAnswer = false
            falseBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.selection_color))
            trueBtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.original_button_color))
        }

        // Handle "Next" button click
        nextBtn.setOnClickListener {
            if (selectedAnswer == null) {
                // Show a message if the user tries to proceed without selecting an answer
                Toast.makeText(requireContext(), "Please select an answer first.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Store current question, user's answer, and correct answer
            val correctAnswer = questions[currentQuestion].second
            questionTexts.add(questions[currentQuestion].first)
            userAnswers.add(selectedAnswer.toString())
            correctAnswers.add(correctAnswer.toString())

            // Check if the answer was correct and update score
            if (selectedAnswer == correctAnswer) {
                score++
                resultText.text = "Correct"
            } else {
                resultText.text = "Incorrect"
            }

            // Disable button temporarily to prevent double clicks
            nextBtn.isEnabled = false

            // Delay before moving to the next question or score screen
            nextBtn.postDelayed({
                if (currentQuestion < questions.size - 1) {
                    // Load the next question
                    currentQuestion++
                    loadQuestion()
                } else {
                    // All questions answered, navigate to score screen
                    val bundle = Bundle().apply {
                        putInt("score", score)
                        putStringArrayList("questions", ArrayList(questionTexts))
                        putStringArrayList("userAnswers", ArrayList(userAnswers))
                        putStringArrayList("correctAnswers", ArrayList(correctAnswers))
                    }
                    findNavController().navigate(R.id.action_quizFragment_to_scoreFragment, bundle)
                }
            }, 1000)
        }

        // Reset quiz state when the fragment is created (e.g., after returning from score screen)
        currentQuestion = 0
        score = 0
        userAnswers.clear()
        correctAnswers.clear()
        questionTexts.clear()

        // Load the first question
        loadQuestion()
    }
}