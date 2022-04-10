package com.zura.midtermtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    private lateinit var  nameInput : EditText
    private lateinit var  lastnameInput : EditText
    private lateinit var  emailInput : EditText
    private lateinit var  cardCodeInput : EditText
    private lateinit var  validInput : EditText
    private lateinit var  cvcInput : EditText
    private lateinit var  checkboxInput : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        nameInput = findViewById<EditText>(R.id.nameInp)
        lastnameInput = findViewById<EditText>(R.id.lastnameInp)
        emailInput = findViewById<EditText>(R.id.emailInp)
        cardCodeInput = findViewById<EditText>(R.id.cardInp)
        validInput = findViewById<EditText>(R.id.validInp)
        cvcInput = findViewById<EditText>(R.id.cvcInp)
        checkboxInput = findViewById<CheckBox>(R.id.checkboxInp)


        findViewById<Button>(R.id.btn).setOnClickListener(View.OnClickListener {

            if(!checkName()){
                Toast.makeText(this, "name length must be above 4 element", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }
            else if(!checkLastname()){
                Toast.makeText(this, "lastname length must be above 4 element", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }
            else if(!checkEmail()){
                Toast.makeText(this, "email is invalid", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }
            else if(!checkCardCode()){
                Toast.makeText(this, "card code is invalid", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }
            else if(!checkValid()){
                Toast.makeText(this, "valid is invalid", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }
            else if(!checkCvc()){
                Toast.makeText(this, "cvc is invalid", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }
            else if(!checkCheckbox()){
                Toast.makeText(this, "checkbox is not checked", Toast.LENGTH_SHORT).show()
                return@OnClickListener;
            }

            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", nameInput.text.toString())
            startActivity(intent)

            // finish()
            clear()
        })
    }

    fun checkName(): Boolean{
        return nameInput.text.toString().length >= 5
    }

    fun checkLastname(): Boolean{
        return lastnameInput.text.toString().length >= 5
    }

    fun checkEmail(): Boolean{
        return emailInput.text.toString().length >= 5 && emailInput.text.toString().contains('@')
    }

    fun checkCardCode(): Boolean{
        return cardCodeInput.text.toString().length == 16
    }

    fun checkValid(): Boolean{
        return true
    }

    fun checkCvc(): Boolean{
        return cvcInput.text.toString().length == 3
    }

    fun checkCheckbox(): Boolean{
        return checkboxInput.isChecked
    }

    fun clear(){
        nameInput.text.clear()
        lastnameInput.text.clear()
        emailInput.text.clear()
        cardCodeInput.text.clear()
        validInput.text.clear()
        cvcInput.text.clear()
        checkboxInput.isChecked = false
    }
}