Introduction to Mobile Application Development (5112) – Assignment 2

Introduction 

In this assignment, I was tasked with designing and developing a basic flashcard-style quiz application using Android and Kotlin. The application is structured around three primary screens: a Welcome Screen, a Quiz Screen, and a Result Screen, each providing different interactive elements for the user. The primary purpose of this app is to engage users in a simple True or False quiz experience, testing their general knowledge and providing feedback based on their performance.
Upon launching the application, users are greeted with a visually engaging Welcome Screen that includes a logo, a brief description of the app’s purpose, and a "Start Quiz" button that initiates the interactive experience. Once the quiz begins, the Quiz Screen presents a series of True or False questions one at a time. Users interact with the app by selecting their answers using the two buttons provided. After each response, immediate feedback is given to the user, and they are guided through the quiz until all questions have been answered.
Once the quiz is complete, the app navigates to the Result Screen, where users are shown their total score out of the possible maximum. Additionally, a motivational message is displayed based on the number of correct answers achieved. This message is designed to encourage users to continue practicing or to celebrate their success. The Result Screen also includes navigation options that allow the user to review feedback or return to the Welcome Screen to attempt the quiz again.
Overall, this flashcard quiz app focuses on simplicity, user engagement, and the reinforcement of learning through instant feedback and personalized encouragement. It demonstrates fundamental concepts in Android app development such as navigation between fragments, user interaction through buttons, and dynamic content rendering based on user input.

Purpose of the Application 

The purpose of this application is to create a fun and intuitive space for the user to be use as a study tool that can be used to test their knowledge.
On the first screen, the user will first see a logo created for the application, then they will see a short welcome to the flashcard game. Thereafter, a brief description should give the user an idea of what the application is all about. Following this is a button labelled “Start Quiz”, which will take the user to the following screen, the quiz screen.
On the second screen, the user will be presented with the question(s) which they will be expected to answer, either by clicking on the true or false button, then once they are happy or confident with their answer, they can click on the button labelled “Next”. If the user was to click on the button labelled “Next”, which is meant to take the user to the next question, without selecting either true or false, the error message, “Please select an answer first.” will appear. If the user completes the necessary steps, selecting an answer then clicking next, they will be shown if the answer they entered was correct or incorrect of a short period of time then the application will present them with the next question. 
On the third and final screen, the score screen, the user will be shown the result they obtained, and it will be presented as a score out of five, as the application is expected to have 5 questions. Following the score the user obtained, will be a little message dependent on the score the user got. If the user answers five questions correct, they will get a message saying, “Perfect! You're a quiz master!”. If the gets four, out of the five questions correct, they will get a message saying, “Great job! You really know your stuff!”. If the gets three, out of the five questions correct, they will get a message saying, “Good effort! Keep practicing!”. If the gets two, out of the five questions correct, they will get a message saying, “Not Bad, but there’s room for improvement.” And if the user obtains any score lower than two, they will get a message saying “Keep trying! You’ll get better with practice!”. Under the feedback message is a button labelled “Review”, which will give the user the ability to see which questions they answered correctly or incorrectly. Furthermore, a button labelled “Exit” can be seen, and the purpose of this button is to take the user out of the "game” and back to the home screen, or welcome screen. 
In conclusion, this flashcard quiz application is designed to provide users with an engaging and interactive way to test and reinforce their knowledge through a simple true-or-false format. With a user-friendly interface that guides the user from a warm welcome screen through a series of questions to a final score summary, the app creates an enjoyable learning experience. The inclusion of immediate feedback, a performance-based message, and the ability to review answers ensures that users not only assess their understanding but also learn from their mistakes. Overall, the application serves as an effective study tool that blends education with ease of use and a touch of fun.

Application’s Design

The design of this application is meant to be simple, intuitive and easy to comprehend for all types of users which have the aim to learn and better their knowledge. 
The colours which are used also follow the same principles as the design of the application as the colours are playful and youthful as the aim is to make the android application as appealing as possible to a larger audience. Examples of the colour use can be found in the screenshot below.
The font of the text displayed throughout the application is meant to be easily readable to allow easy use for all users.
On the Welcome Screen, the first thing the user will see is the logo of the application, which is present throughout the application. Following the logo, the welcoming message “Welcome to the Flashcards App” will be seen and the purpose of this message will be to invite the user to reduce chances of them being intimidated rather than just throwing them straight into the application. Thereafter the user will be able to read a little text which just explains what the application is all about in case they are unaware. The text reads, “This application will make learning much easier and fun!”. Then lastly, is a button labelled “Start Quiz”, which has the sole purpose of starting the application by navigating to the Quiz Screen.
On the Quiz Screen, the first thing the user will see is a heading for this screen, which is labelled “Questions:”, and it is on this screen where the user will be presented with the question, they must answer by either clicking true or false. Under the logo of the application is where the question(s) will appear for the user and right under that is the text which will indicate to the user if their answer was correct or incorrect. This text will change colour depending on whether the answer is indeed current or incorrect. Under that will be two buttons labelled “True” and “False”, and these are the two buttons which the user uses to answer the question(s). Following the true and false buttons is another button labelled “Next”, and this button displays the next question for the user, but before displaying the next question for the user, there is a one second delay which indicates to the user whether the answer they have just submitted is correct or incorrect. 
On the Score Screen, the first thing the user will see is a heading for this screen, which is labelled “Score:” and it is on this screen where the user will be presented with the score which they obtained when answering the questions out of five. Under that will be a custom message for the user depending on the mark they obtained. Following the custom message, is a button labelled “Review” which gives the user the ability to go back to the questions and see which questions they answered correctly or incorrectly. After this is a button labelled “Exit”, which exits the app and navigates back to the Home/Welcome Screen. 
In conclusion, the design of the Flashcards App prioritises simplicity, intuitiveness, and accessibility to ensure a positive and engaging learning experience for users of all levels. The playful and youthful colour scheme, along with easily readable fonts, contributes to the app's overall approachability and user-friendly interface. The Welcome Screen sets a welcoming tone, introducing the app’s purpose and guiding users into the quiz. The Quiz Screen offers a straightforward interaction with clear feedback on answers, while the Score Screen provides a personalised result, along with options to review answers or exit the app. Overall, the design and functionality work together to make learning both enjoyable and efficient for users.
 
Source Code from Android Studio

Source Code for WelcomeScreen.kt 
package vcmsa.ci.flashcardsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

// Class defines the WelcomeScreen fragment, which displays the welcome layout to the user.
class WelcomeScreen : Fragment(R.layout.welcome_screen) {

    // Called when the view associated with this fragment is created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the "Start" button in the layout.
        val startButton: Button = view.findViewById(R.id.btnStart)

        // Set a click listener on the "Start" button.
        // When clicked, it navigates from the WelcomeScreen to the QuizScreen.
        startButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_quizFragment)
        }
    }
}

Source Code for welcome_screen.xml
<LinearLayout xmlns:android = "http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    android:layout_width = "match_parent"
    android:layout_height = "match_parent"
    android:background = "#2295F1"
    android:gravity = "center"
    android:orientation = "vertical"
    android:padding = "24dp">

    <ImageView
        android:id = "@+id/imageView"
        android:layout_width = "match_parent"
        android:layout_height = "300dp"
        android:layout_marginBottom = "24dp"
        android:scaleType = "fitCenter"
        android:contentDescription = "@string/flashcards_logo_description"
        app:srcCompat = "@drawable/flashcards_logo" />


    <TextView
        android:id = "@+id/WelcomeMessage"
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        android:layout_marginBottom = "16dp"
        android:fontFamily = "@font/besley"
        android:text = "@string/welcome_message"
        android:textAlignment = "center"
        android:textColor = "#FFFFFF"
        android:textSize = "28sp" />

    <TextView
        android:id = "@+id/BriefDescription"
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        android:layout_marginBottom = "32dp"
        android:fontFamily = "@font/besley"
        android:text = "@string/brief_description"
        android:textAlignment = "center"
        android:textColor = "#FFFFFF"
        android:textSize = "18sp" />

    <Button
        android:id = "@+id/btnStart"
        android:layout_width = "350dp"
        android:layout_height = "wrap_content"
        android:text = "@string/start_quiz"
        android:textSize = "18sp"
        android:textColor = "#0F0E0E"
        android:backgroundTint = "#FBF5F5" />
</LinearLayout>

Source Code for QuizScreen.kt 
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
        Pair("The earth is flat.", false),
        Pair("Kotlin is used for Android development.", true),
        Pair("The sun rises in the west.", false),
        Pair("Water boils at 100°C.", true),
        Pair("The moon is a planet.", false)
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

Source Code for quiz_screen.xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    android:layout_width = "match_parent"
    android:layout_height = "match_parent"
    android:background = "#2295F1"
    android:gravity = "center"
    android:orientation = "vertical"
    android:padding = "16dp">

    <LinearLayout
        android:layout_width = "wrap_content"
        android:layout_height = "wrap_content"
        android:orientation = "vertical"
        android:gravity = "center_horizontal">

        <TextView
            android:id = "@+id/screenHeading"
            android:layout_width = "match_parent"
            android:layout_height = "wrap_content"
            android:layout_marginBottom = "16dp"
            android:fontFamily = "@font/besley"
            android:text = "@string/questions_heading"
            android:textAlignment = "center"
            android:textColor = "#FFFFFF"
            android:textSize = "34sp" />

        <ImageView
            android:id = "@+id/Logo"
            android:layout_width = "match_parent"
            android:layout_height = "250dp"
            android:layout_marginBottom = "16dp"
            android:scaleType = "centerInside"
            android:contentDescription = "@string/flashcards_logo_description"
            app:srcCompat = "@drawable/flashcards_logo" />


        <TextView
            android:id = "@+id/questionText"
            android:layout_width = "match_parent"
            android:layout_height = "wrap_content"
            android:layout_marginBottom = "8dp"
            android:fontFamily = "@font/besley"
            android:text = "@string/question_placeholder"
            android:textAlignment = "center"
            android:textColor = "#FFFFFF"
            android:textSize = "20sp" />

        <TextView
            android:id = "@+id/resultText"
            android:layout_width = "match_parent"
            android:layout_height = "39dp"
            android:fontFamily = "@font/besley"
            android:text = "@string/result_placeholder"
            android:textAlignment = "center"
            android:textColor = "#FFFFFF"
            android:textSize = "20sp" />
    </LinearLayout>

    <LinearLayout
        style = "?android:attr/buttonBarStyle"
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        android:orientation = "horizontal"
        android:gravity = "center"
        android:layout_marginBottom = "16dp">

        <Button
            android:id = "@+id/btnTrue"
            android:layout_width = "175dp"
            android:layout_height = "wrap_content"
            android:layout_marginTop = "16dp"
            android:backgroundTint = "#FBF5F5"
            android:text = "@string/btnTrue"
            android:textColor = "#0F0E0E"
            android:textSize = "18sp" />

        <Button
            android:id = "@+id/btnFalse"
            android:layout_width = "175dp"
            android:layout_height = "wrap_content"
            android:layout_marginTop = "16dp"
            android:backgroundTint = "#FBF5F5"
            android:text = "@string/btnFalse"
            android:textColor = "#0F0E0E"
            android:textSize="18sp" />
    </LinearLayout>

    <Button
        android:id = "@+id/btnNext"
        android:layout_width = "350dp"
        android:layout_height = "wrap_content"
        android:layout_marginTop = "16dp"
        android:backgroundTint = "#FBF5F5"
        android:text = "@string/btnNext"
        android:textColor = "#0F0E0E"
        android:textSize = "18sp" />
</LinearLayout>

Source Code for ScoreScreen.kt 
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

Source Code for score_screen.xml
<?xml version = "1.0" encoding = "utf-8"?>
<LinearLayout xmlns:android = "http://schemas.android.com/apk/res/android"
    xmlns:app = "http://schemas.android.com/apk/res-auto"
    android:layout_width = "match_parent"
    android:layout_height = "match_parent"
    android:background = "#2295F1"
    android:gravity = "center"
    android:orientation = "vertical"
    android:padding = "16dp">

    <LinearLayout
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        android:orientation = "vertical"
        android:gravity = "center_horizontal"
        android:layout_marginBottom = "24dp">

        <TextView
            android:id = "@+id/screenHeading"
            android:layout_width = "match_parent"
            android:layout_height = "wrap_content"
            android:layout_marginBottom = "16dp"
            android:fontFamily = "@font/besley"
            android:text = "@string/score_heading"
            android:textAlignment = "center"
            android:textColor = "#FFFFFF"
            android:textSize = "34sp" />

        <ImageView
            android:id = "@+id/Logo"
            android:layout_width = "match_parent"
            android:layout_height = "319dp"
            android:layout_marginBottom = "16dp"
            android:scaleType = "centerInside"
            android:contentDescription = "@string/flashcards_logo_description"
            app:srcCompat = "@drawable/flashcards_logo" />

        <TextView
            android:id = "@+id/scoreText"
            android:layout_width = "match_parent"
            android:layout_height= "wrap_content"
            android:layout_marginBottom = "8dp"
            android:fontFamily = "@font/besley"
            android:text=""
            android:textAlignment = "center"
            android:textColor = "#FFFFFF"
            android:textSize = "20sp" />

        <TextView
            android:id = "@+id/reviewText"
            android:layout_width = "match_parent"
            android:layout_height = "wrap_content"
            android:layout_marginBottom = "24dp"
            android:fontFamily = "@font/besley"
            android:text = ""
            android:textAlignment = "center"
            android:textColor = "#FFFFFF"
            android:textSize = "20sp" />
    </LinearLayout>

    <LinearLayout
        android:layout_width = "match_parent"
        android:layout_height = "wrap_content"
        android:orientation = "vertical"
        android:gravity = "center"
        android:layout_marginBottom = "32dp">

        <Button
            android:id = "@+id/btnReview"
            android:layout_width = "350dp"
            android:layout_height = "wrap_content"
            android:layout_marginBottom = "5dp"
            android:backgroundTint = "#FBF5F5"
            android:fontFamily = "sans-serif-medium"
            android:minHeight = "56dp"
            android:padding = "16dp"
            android:text = "@string/btnReview" />

        <Button
            android:id = "@+id/btnExit"
            android:layout_width = "350dp"
            android:layout_height = "wrap_content"
            android:backgroundTint = "#FBF5F5"
            android:fontFamily = "sans-serif-medium"
            android:minHeight = "56dp"
            android:padding = "16dp"
            android:text = "@string/btnExit" />
    </LinearLayout>
</LinearLayout>
 
Screenshot of the Application from BlueStacks

![image](https://github.com/user-attachments/assets/33b789b5-5e9f-4f1b-8df3-d25cb1625355)

Figure 1: Screenshot of Welcome Screen 		

![image](https://github.com/user-attachments/assets/fb850675-a8ca-4e49-809f-585aea68aba0)

Figure 2: Screenshot of Questions Screen

![image](https://github.com/user-attachments/assets/5db77c9d-7058-4e85-a364-e6a2c36d2c55)

Figure 3: Screenshot of Correct Answer	           

![image](https://github.com/user-attachments/assets/cc252e3b-6f26-4dd5-9a4a-1126b64a55c8)

Figure 4: Screenshot of Incorrect Answer

![image](https://github.com/user-attachments/assets/d8e144ee-8195-4b3b-8846-cb3b3a7521e1)

Figure 5: Screenshot of Error Message	           

![image](https://github.com/user-attachments/assets/2c7d51d0-ccf1-41c2-8f1b-498490ce99f5)

Figure 6: Screenshot of Score Screen 

![image](https://github.com/user-attachments/assets/e8a544f4-435b-4429-9fc2-302301d6f519)

Figure 7: Screenshot of an Example of a Review


 
Design View from Android Studio

![image](https://github.com/user-attachments/assets/81e0c77e-325a-4c2e-a068-c2fd6c690b38)

Figure 8: Design View of the Welcome Screen.

![image](https://github.com/user-attachments/assets/b7bab1f4-6b07-49dd-940b-c27c3aab1a54)

Figure 9: Design View of the Quiz Screen.

![image](https://github.com/user-attachments/assets/f4249be3-3744-48df-b768-f46307b17093)

Figure 10: Design View of the Score Screen. 

Utilisation of GitHub and GitHub Actions
•	GitHub Link
-	https://github.com/ST10444570/FlashcardsApplication.git 
•	YouTube Video Link
-	
 
Reference List
OpenAI. (2024) ChatGPT (April 2024 version) [Online]. Available at: https://chat.openai.com/ (Accessed: 5 May 2025).
Stack Overflow (n.d.) Questions. Available at: https://stackoverflow.com/questions (Accessed: 5 May 2025). 
Lephoto, T. (2025) Figure 1: Screenshot of Welcome Screen. [Image] Created by Tisetso Lephoto, 20 May.
Lephoto, T. (2025) Figure 2: Screenshot of Questions Screen. [Image] Created by Tisetso Lephoto, 20 May.
Lephoto, T. (2025) Figure 3: Screenshot of Correct Answer. [Image] Created by Tisetso Lephoto, 20 May. 
Lephoto, T. (2025) Figure 4: Screenshot of Incorrect Answer. [Image] Created by Tisetso Lephoto, 20 May.
Lephoto, T. (2025) Figure 5: Screenshot of Error Message. [Image] Created by Tisetso Lephoto, 20 May.
Lephoto, T. (2025) Figure 6: Screenshot of Score Screen. [Image] Created by Tisetso Lephoto, 20 May. 
Lephoto, T. (2025) Figure 7: Screenshot of an Example of a Review. [Image] Created by Tisetso Lephoto, 20 May. 
Lephoto, T. (2025) Figure 8: Design View of the Welcome Screen. [Image] Created by Tisetso Lephoto, 5 May.
Lephoto, T. (2025) Figure 9: Design View of the Quiz Screen. [Image] Created by Tisetso Lephoto, 5 May.
Lephoto, T. (2025) Figure 10: Design View of the Score Screen. [Image] Created by Tisetso Lephoto, 5 May. 
