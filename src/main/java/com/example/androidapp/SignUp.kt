package com.example.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var txt_user_name: TextInputEditText = findViewById(R.id.edit_username)

        var txt_email: TextInputEditText = findViewById(R.id.edit_email)
        var txt_password: TextInputEditText = findViewById(R.id.edit_password)

        var btn_sign_up: Button = findViewById(R.id.signup)


        btn_sign_up.setOnClickListener {
            var isEmpty: Boolean = false

            if (isEmpty(txt_user_name)) {
                txt_user_name.setError("User Name is required")
                isEmpty = true
            }

            if (isEmpty(txt_email)) {
                txt_email.setError("Email is required")
                isEmpty = true
            }else if(!validateEmail(txt_email)){
                txt_email.setError("Enter correct email id")
                isEmpty = true
            }

            if (isEmpty(txt_password)) {
                txt_password.setError("Password is required")
                isEmpty = true
            }else if(!validatePassword(txt_password)){
                txt_password.setError("Password must contain at least 6 characters, one uppercase, one lowercase letter with a digit and special symbol")
                isEmpty = true
            }

            if (!isEmpty) {
                println("............." + txt_user_name.text)
                println("............." + txt_email.text)
                println(".............." + txt_password.text)
                Toast.makeText(this, "Sign Up Successful", LENGTH_LONG).show()
            }

        }
    }
    private fun validateEmail(input: TextInputEditText): Boolean {
        var email = input.text.toString()
        var pattern: Pattern
        var matcher: Matcher

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+"
        pattern = Pattern.compile(emailPattern)
        matcher = pattern.matcher(email)
        return matcher.matches()

    }

    private fun validatePassword(input:TextInputEditText): Boolean {
        var pattern: Pattern
        var matcher: Matcher

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(passwordPattern)
        matcher = pattern.matcher(input.text.toString())
        return matcher.matches()
    }

    private fun isEmpty(input: TextInputEditText): Boolean {
        return input.text.toString().trim().isEmpty() //returns true if the input contains space
    }

}