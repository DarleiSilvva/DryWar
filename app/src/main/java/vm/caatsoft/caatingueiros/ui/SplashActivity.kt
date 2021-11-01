package vm.caatsoft.caatingueiros.ui

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import vm.caatsoft.caatingueiros.R

class SplashActivity : AppCompatActivity() {
    private val SLEEP_TIMER = 0.75f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        supportActionBar!!.hide()
        val logoLauncher = LogoLauncher()
        logoLauncher.start()
    }

    private inner class LogoLauncher : Thread() {
        override fun run() {
            try {
                sleep((1000 * SLEEP_TIMER).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
           val intent = Intent(this@SplashActivity, PreJogoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}