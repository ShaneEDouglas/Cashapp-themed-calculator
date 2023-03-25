package com.example.cashappclone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText

// Empty strings to set the current postion for the current
private var curr = ""
private var reslt = ""

private var dot_inserted =  false
private var operator_inserted =  false

//Animation for buttons


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scaleUp = AnimationUtils.loadAnimation(this,R.anim.scaleup) as Animation
        val scaledown = AnimationUtils.loadAnimation(this,R.anim.scaledown) as Animation
        //Below Sets all of the buttons


        //Calculator buttons using a list to initialize multiple buttons
       val calcbtnids = listOf(R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.btndot,R.id.btn0,R.id.btnbequal)
            val calcbtns = calcbtnids.map { findViewById<Button>(it)}

        //Operator buttons Same method as above
        val operbtnid = listOf(R.id.add,R.id.subtract,R.id.multiply,R.id.divide,R.id.clear,R.id.Reset)
        val operbtns = operbtnid.map{findViewById<Button>(it)}

        //Edittexts Calculations and result
        val calculation = findViewById<EditText>(R.id.Calulation)
        val Result = findViewById<EditText>(R.id.result)

        // Functions for operator buttons
        //Sets the text to the calculation edit text
        fun currdisplay(){
            calculation.setText(curr)
        }

        fun resultdisplay(){
            Result.setText(reslt)
        }
        //resets both edittexts by setting both variables as empty strings
        fun Clear(){
         curr = ""
         reslt = ""
         dot_inserted = false
         operator_inserted = false
        }

        fun backspace() {
            if (curr.isNotEmpty()) {
                if (curr.substring(curr.length - 1, curr.length).equals(".")) {
                    dot_inserted = false
                }

                // when operator is detected and set operated inserted false
                if (curr.substring(curr.length - 1, curr.length).equals(" ")) {
                    // Delete three times to get rid of spaces and the operator
                    curr = curr.substring(0, curr.length - 3)
                    operator_inserted = false
                } else {
                    //Anything else it will only take away one character
                    curr = curr.substring(0, curr.length - 1)
                }
            }
        }

        //Operation Buttons
        val btnback = operbtns[5]
        btnback.setOnClickListener { view->
            btnback.startAnimation(scaleUp)
            btnback.startAnimation(scaledown)
            backspace()
            currdisplay()
        }

        val Add = operbtns[0]
        Add.setOnClickListener { view->
            Add.startAnimation(scaleUp)
            Add.startAnimation(scaledown)
            dot_inserted = false

            if (curr.isNotEmpty()){
                if (curr.substring(curr.length-1,curr.length).equals(".")) {
                    backspace()
                }
            }
            if (!operator_inserted){
                curr = curr + " + "
                operator_inserted = true
            }
            currdisplay()
        }

        val subtract = operbtns[1]
        subtract.setOnClickListener { view->
            subtract.startAnimation(scaleUp)
            subtract.startAnimation(scaledown)
            dot_inserted = false

            if (curr.isNotEmpty()){
                if (curr.substring(curr.length-1,curr.length).equals(".")) {
                    backspace()
                }
            }
            if (!operator_inserted){
                curr = curr + " - "
                operator_inserted = true
            }
            currdisplay()
        }
        val multiply = operbtns[2]
        multiply.setOnClickListener { view->
            multiply.startAnimation(scaleUp)
            multiply.startAnimation(scaledown)
            dot_inserted = false

            if (curr.isNotEmpty()){
                if (curr.substring(curr.length-1,curr.length).equals(".")) {
                    backspace()
                }
            }
            if (!operator_inserted){
                curr = curr + " x "
                operator_inserted = true
            }
            currdisplay()
        }

        val divide = operbtns[3]
        divide.setOnClickListener { view->
            divide.startAnimation(scaleUp)
            divide.startAnimation(scaledown)
            dot_inserted = false

            if (curr.isNotEmpty()){
                if (curr.substring(curr.length-1,curr.length).equals(".")) {
                    backspace()
                }
            }
            if (!operator_inserted){
                curr = curr + " ÷ "
                operator_inserted = true
            }
            currdisplay()
        }


        val btnclear = operbtns[4]
      btnclear.setOnClickListener { view ->
          btnclear.startAnimation(scaleUp)
          btnclear.startAnimation(scaledown)
          Clear()
          currdisplay()
          resultdisplay()
     }

        //Will calculate the operations together and put it in the res edittext(bottom one)
        val equal = calcbtns[11]
        equal.setOnClickListener { view ->
            equal.startAnimation(scaleUp)
            equal.startAnimation(scaledown)
            //Will check if the operator is inserted and if there are no spaces
            if (operator_inserted == true && !curr.substring(curr.length - 1, curr.length).equals(" ")) {
                //Splits the curr string ino the two numbers
                var tokens = curr.split(" ");

                if (tokens.size == 3) {
                    val opreand1 = tokens[0].toDouble()
                    val operator = tokens[1]
                    val opreand2 = tokens[2].toDouble()

                    when (operator) {
                        "x" -> {
                            reslt = (opreand1 * opreand2).toString()
                        }
                        "+" -> {
                            reslt = (opreand1 + opreand2).toString()
                        }
                        "÷" -> {
                            reslt = (opreand1 / opreand2).toString()
                        }

                        "-" -> {
                            reslt = (opreand1 - opreand2).toString()
                            // Incase the result is a negative number will convert back to a double multiply by -1  and set back to a string to display
                            if (reslt.toDouble() < 0){
                                Result.setText("-" + ((reslt.toDouble() * -1).toString()))
                            }
                        }
                    }
                    resultdisplay()
                }
            }
        }
    //Calculation btns
        val btn1  = calcbtns[0]
        btn1.setOnClickListener { view ->
            btn1.startAnimation(scaleUp)
            btn1.startAnimation(scaledown)
            curr = curr + "1"
            currdisplay()
        }

        val btn2 = calcbtns[1]
        btn2.setOnClickListener { View ->
            btn2.startAnimation(scaleUp)
            btn2.startAnimation(scaledown)
            curr = curr + "2"
            currdisplay()
        }



        val btn3 = calcbtns[2]
        btn3.setOnClickListener { View ->
            btn3.startAnimation(scaleUp)
            btn3.startAnimation(scaledown)
            curr = curr + "3"
            currdisplay()
        }


        val btn4 = calcbtns[3]
        btn4.setOnClickListener { View ->
            btn4.startAnimation(scaleUp)
            btn4.startAnimation(scaledown)
            curr = curr + "4"
            currdisplay()
        }


        val btn5 = calcbtns[4]
        btn5.setOnClickListener { View ->
            btn5.startAnimation(scaleUp)
            btn5.startAnimation(scaledown)
            curr = curr + "5"
            currdisplay()
        }


        val btn6 = calcbtns[5]
        btn6.setOnClickListener { View ->
            btn6.startAnimation(scaleUp)
            btn6.startAnimation(scaledown)
            curr = curr + "6"
            currdisplay()
        }


        val btn7 = calcbtns[6]
        btn7.setOnClickListener { View ->
            btn7.startAnimation(scaleUp)
            btn7.startAnimation(scaledown)
            curr = curr + "7"
            currdisplay()
        }


        val btn8 = calcbtns[7]
        btn8.setOnClickListener { View ->
            btn8.startAnimation(scaleUp)
            btn8.startAnimation(scaledown)
            curr = curr + "8"
            currdisplay()
        }


        val btn9 = calcbtns[8]
        btn9.setOnClickListener { View ->
            btn9.startAnimation(scaleUp)
            btn9.startAnimation(scaledown)
            curr = curr + "9"
            currdisplay()
        }


     val btndot = calcbtns[9]
     btndot.setOnClickListener { View ->
         btndot.startAnimation(scaleUp)
         btndot.startAnimation(scaledown)
      //Will set the calculation text with a 0. when it is empty (appends the edit text with 0.)
      if (curr.isEmpty()) {
       curr = "0."
       dot_inserted = true
      }
      if (dot_inserted == false) {
       curr = curr + "."
       dot_inserted = true
      }
      currdisplay()
     }


        val btn0 = calcbtns[10]
        btn0.setOnClickListener { View ->
            btn0.startAnimation(scaleUp)
            btn0.startAnimation(scaledown)
            curr = curr + "0"
            currdisplay()
        }
        currdisplay()
    }
 }
