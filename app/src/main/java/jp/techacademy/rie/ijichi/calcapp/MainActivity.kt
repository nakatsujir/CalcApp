package jp.techacademy.rie.ijichi.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            formula(1)
        }
        button2.setOnClickListener {
            formula(2)
        }
        button3.setOnClickListener {
            formula(3)
        }
        button4.setOnClickListener {
            formula(4)
        }
    }

    private fun formula(buttonNum: Int) {

        val firstNumCount = (firstNum.text).count()
        val secondNumCount = (secondNum.text).count()

        if (firstNumCount == 0 ||secondNumCount == 0){
            Snackbar.make(mainLayout,"数字が入力されていません",Snackbar.LENGTH_LONG)
                .setAction("閉じる"){}.show()
        }else{
            val firstNum = firstNum.text.toString().toDouble()
            val secondNum = secondNum.text.toString().toDouble()
            val resultNum = when (buttonNum) {
                1 -> "${firstNum + secondNum}".toDouble()
                2 -> "${firstNum - secondNum}".toDouble()
                3 -> "${firstNum * secondNum}".toDouble()
                4 -> "${firstNum / secondNum}".toDouble()
                else -> 0.0
            }
            transition(resultNum)
        }
    }

    private fun transition(resultNum: Double) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("Value1", resultNum)
        startActivity(intent)
    }
}
