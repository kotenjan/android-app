package cz.cvut.fit.feeder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve data coming from MainActivity.java
        val identifier = intent.getIntExtra("IDENTIFIER", 0)
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout_detail, DetailFragment.newInstance(identifier))
                .commit()
    }
}