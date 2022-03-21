package cz.cvut.fit.feeder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

class ThumbnailFragment : Fragment() {

    companion object {
        fun newInstance() = ThumbnailFragment()
        private const val TAG = "ThumbnailFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val rootView = inflater.inflate(R.layout.fragment_thumbnail, container, false) as ViewGroup

        val articleLayout = rootView.findViewById<View>(R.id.linear_layout_thumbnails) as LinearLayout

        for (i in 0..10){
            val view = LayoutInflater.from(context).inflate(R.layout.layout_thumbnail, container, false)

            val head = view.findViewById<TextView>(R.id.text_view_head)
            val body = view.findViewById<TextView>(R.id.text_view_body)

            head.text = DataProvider.data[i]?.title
            body.text = DataProvider.data[i]?.body

            view.tag = i
            view.setOnClickListener {
                Log.i(TAG, "Clicked on textview with tag: ${view.tag}")
                val communicator = context as DetailCommunicator
                communicator.display(view.tag as Int)
            }
            articleLayout.addView(view)
        }
        return rootView
    }
}