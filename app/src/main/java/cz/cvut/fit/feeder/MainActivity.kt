package cz.cvut.fit.feeder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), DetailCommunicator {

    companion object {
        private const val TAG = "MainActivity"
        private const val WIDE_SCREEN_SIZE = 600
    }

    private var isWideScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isWideScreen = findViewById<View>(R.id.frame_layout_detail)?.visibility == View.VISIBLE

        if (isWideScreen) {
            Log.i(TAG, "The device is WIDE")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_thumbnail, ThumbnailFragment.newInstance())
                    .replace(R.id.frame_layout_detail, DetailFragment.newInstance(0))
                    .commit()
        } else {
            val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frame_layout_detail)
            if (fragment != null) supportFragmentManager.beginTransaction().remove(fragment).commit()

            Log.i(TAG, "The device is NOT WIDE")
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_thumbnail, ThumbnailFragment.newInstance())
                    .commit()
        }
    }

    override fun display(identifier: Int) {
        if (isWideScreen) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_detail, DetailFragment.newInstance(identifier))
                    .commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("IDENTIFIER", identifier)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()
        return true
    }


}