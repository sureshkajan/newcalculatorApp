package com.kajanthan.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import android.text.Editable
import android.view.View
import android.widget.TextView
import android.widget.Button
import android.widget.EditText


import net.objecthunter.exp4j.ExpressionBuilder



class MainActivity : AppCompatActivity() {

    var isNewOp=true
    var oldNumber=""
    var op="+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun numberEvent(view: View) {
        if(isNewOp)
            mytextview1.setText(" ")
        isNewOp=false
        var buclick=mytextview1.text.toString()
        var buselect=view as Button
        when(buselect.id)
        {
            one.id->{buclick += "1"}
            two.id->{buclick += "2"}
            three.id->{buclick += "3"}
            four.id->{buclick += "4"}
            five.id->{buclick += "5"}
            six.id->{buclick += "6"}
            seven.id->{buclick += "7"}
            eight.id->{buclick += "8"}
            nine.id->{buclick += "9"}
            zero.id->{buclick += "0"}
            dot.id->{buclick += "."}
            plusorminus.id->{buclick = "-$buclick"}





        }
        mytextview1.setText(buclick)
    }

    fun operatorEvent(view:View)
    {
        isNewOp=true
        oldNumber=mytextview1.text.toString()
        var buselect=view as Button
        when(buselect.id)
        {
            minus.id->{op="-"}
            plus.id->{op="+"}
            division.id->{op="/"}
            multiply.id->{op="*"}
            mod.id->{op="%"}
        }

    }

    fun equalEvent(view: View) {
        var newNumber=mytextview1.text.toString()
        var result=0.0

        when(op){
            "+"->{result=oldNumber.toDouble()+newNumber.toDouble()}
            "-"->{result=oldNumber.toDouble()-newNumber.toDouble()}
            "*"->{result=oldNumber.toDouble()*newNumber.toDouble()}
            "/"->{result=oldNumber.toDouble()/newNumber.toDouble()}
            "%"->{result=oldNumber.toDouble()%newNumber.toDouble()}
        }
        mytextview1.setText(result.toString())
    }

    fun acEvent(view: View) {
        mytextview1.setText("0")
        isNewOp=true
    }


}