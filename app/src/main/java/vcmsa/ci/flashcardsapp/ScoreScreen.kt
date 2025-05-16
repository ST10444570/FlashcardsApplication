package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ScoreScreen : Fragment(R.layout.score_screen) {

    private lateinit var scoreText: TextView
    private lateinit var feedbackText: TextView
    private lateinit var reviewButton: Button
    private lateinit var exitButton: Button

    // Called when the fragment's view has been created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get references to UI elements.
        scoreText = view.findViewById(R.id.scoreText)
        feedbackText = view.findViewById(R.id.reviewText)
        reviewButton = view.findViewById(R.id.btnReview)
        exitButton = view.findViewById(R.id.btnExit)

        // Retrieve the score and review data passed from the quiz screen.
        val score = arguments?.getInt("score") ?: 0
        val questions = arguments?.getStringArrayList("questions") ?: arrayListOf()
        val userAnswers = arguments?.getStringArrayList("userAnswers") ?: arrayListOf()
        val correctAnswers = arguments?.getStringArrayList("correctAnswers") ?: arrayListOf()

        // Show score and feedback immediately.
        scoreText.text = getString(R.string.score_message, score)
        feedbackText.text = getFeedback(score)
        feedbackText.visibility = View.VISIBLE

        // REVIEW button to cycle through each question and answer.
        reviewButton.setOnClickListener {
            runReview(questions, userAnswers, correctAnswers)
        }

        // EXIT button to navigate back to welcome screen.
        exitButton.setOnClickListener {
            findNavController().navigate(R.id.action_scoreFragment_to_welcomeFragment)
        }
    }

    // Function to display question-by-question review with delay.
    private fun runReview(
        questions: List<String>,
        userAnswers: List<String>,
        correctAnswers: List<String>
    ) {
        reviewButton.isEnabled = false // disable button during review.
        exitButton.isEnabled = false // disable button during review.

        val handler = Handler(Looper.getMainLooper())
        var index = 0

        fun showNextQuestion() {
            if (index < questions.size) {
                val question = questions[index]
                val userAnswer = userAnswers.getOrNull(index) ?: "No answer"
                val correctAnswer = correctAnswers.getOrNull(index) ?: "Unknown"

                val isCorrect = userAnswer.equals(correctAnswer, ignoreCase = true)
                val result = if (isCorrect) "Correct"
                    else "Incorrect"

                feedbackText.text = "Q${index + 1}: $question\nYour Answer: $userAnswer\nCorrect Answer: $correctAnswer\n$result"

                index++
                handler.postDelayed({ showNextQuestion() }, 2000) // 2 second delay.
            } else {
                // Review complete, navigate back to score screen.
                findNavController().navigate(R.id.action_scoreFragment_self)
            }
        }

        showNextQuestion()
    }

    // Generate feedback message based on final score
    private fun getFeedback(score: Int): String {
        return when {
            score == 5 -> "Perfect! You're a quiz master!"
            score >= 4 -> "Great job! You really know your stuff!"
            score >= 3 -> "Good effort! Keep practicing!"
            score >= 2 -> "Not bad, but there's room for improvement."
            else -> "Keep trying! You’ll get better with practice!"
        }
    }
}
