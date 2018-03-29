package zhou.com.mybook.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import zhou.com.mybook.R

class SplashActivity : AppCompatActivity() {

    private var flag: Boolean = false
    private val runnable: Runnable
        get() {
            val runnable = Runnable { kotlin.run { goHome() } }
            return runnable
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        textView.setOnClickListener({ goHome() })

        textView.postDelayed(runnable, 2000)
    }

    fun goHome() {
        if (!flag) {
            flag = true
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        flag = true
        textView.removeCallbacks(runnable)
    }
}
