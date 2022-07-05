package arash.xPreferences.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import arash.xPreferences.R
import arash.xPreferences.xPreferences
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(arash.xPreferences.app.R.layout.activity_main)

        findViewById<MaterialButton>(arash.xPreferences.app.R.id.openGithub).setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/MrArashAzizi/xPreferences")))
        }

        findViewById<MaterialButton>(arash.xPreferences.app.R.id.website).setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://arashazizi.ir")))
        }


    }
}