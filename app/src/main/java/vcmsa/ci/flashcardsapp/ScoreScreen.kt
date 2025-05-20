package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// This fragment displays the user's score and feedback after the quiz, allows the user to review their answers, or return to the welcome screen.
class ScoreScreen : Fragment(R.layout.score_screen) {

    // UI elements
    private lateinit var scoreText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var reviewButton: Button
    private lateinit var exitButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Link UI elements with XML layout
        scoreText = view.findViewById(R.id.scoreText)
        feedbackText = view.findViewById(R.id.reviewText)
        reviewButton = view.findViewById(R.id.btnReview)
        exitButton = view.findViewById(R.id.btnExit)

        // Get data passed from QuizScreen
        val score = arguments?.getInt("score") ?: 0
        val questions = arguments?.getStringArrayList("questions") ?: arrayListOf()
        val userAnswers = arguments?.getStringArrayList("userAnswers") ?: arrayListOf()
        val correctAnswers = arguments?.getStringArrayList("correctAnswers") ?: arrayListOf()

        // Display score and feedback
        scoreText.text = getString(R.string.score_message, score)
        feedbackText.text = getFeedback(score, questions.size)
        feedbackText.visibility = View.VISIBLE

        // When the review button is clicked, start reviewing questions
        reviewButton.setOnClickListener {
            runReview(questions, userAnswers, correctAnswers)
        }

        // When the exit button is clicked, go back to the welcome screen
        exitButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_welcomeFragment)
        }
    }

    // This function automatically displays each question, user answer, and correct answer one by one
    private fun runReview(
        questions: List<String>,
        userAnswers: List<String>,
        correctAnswers: List<String>
    ) {
        // Disable buttons while review is running
        reviewButton.isEnabled = false
        exitButton.isEnabled = false

        val handler = Handler(Looper.getMainLooper())
        var index = 0

        // Function to display each question with its result
        fun showNextQuestion() {
            if (index < questions.size) {
                val question = questions[index]
                val userAnswer = userAnswers.getOrNull(index) ?: "No answer"
                val correctAnswer = correctAnswers.getOrNull(index) ?: "Unknown"
                val isCorrect = userAnswer.equals(correctAnswer, ignoreCase = true)
                val result = if (isCorrect) "Correct" else "Incorrect"

                // Display the review message with question details
                feedbackText.text = getString(
                    R.string.review_message,
                    index + 1,
                    question,
                    userAnswer,
                    correctAnswer,
                    result
                )

                index++

                // Wait for 2 seconds before showing the next question
                handler.postDelayed({ showNextQuestion() }, 2000)
            } else {
                // Restart the ScoreScreen fragment once review is finished
                findNavController().navigate(R.id.action_scoreFragment_self)
            }
        }

        showNextQuestion()
    }

    // Generates feedback text based on the user's score
    private fun getFeedback(score: Int, total: Int): String {
        return when {
            score == total -> "Perfect! You're a quiz master!"
            score >= total - 1 -> "Great job! You really know your stuff!"
            score >= total / 2 -> "Good effort! Keep practicing!"
            score >= 1 -> "Not bad, but there's room for improvement."
            else -> "Keep trying! You’ll get better with practice!"
        }
    }
}
