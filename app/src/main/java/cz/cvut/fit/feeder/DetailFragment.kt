package cz.cvut.fit.feeder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.core.view.contains
import androidx.fragment.app.Fragment


private const val ARG_IDENTIFIER = "IDENTIFIER"

class DetailFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(identifier: Int) =
                DetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_IDENTIFIER, identifier)
                    }
                }
        private const val TAG = "DetailFragment"
    }

    private var identifier: Int = 0
    private var data: DataProvider = DataProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            identifier = it.getInt(ARG_IDENTIFIER)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false) as ViewGroup

        val head = rootView.findViewById<TextView>(R.id.text_view_head)
        val body = rootView.findViewById<TextView>(R.id.text_view_body)

        head.text = DataProvider.data[identifier]?.title
        body.text = DataProvider.data[identifier]?.body

        return rootView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menu.findItem(R.menu.detail_menu ) == null){
            inflater.inflate(R.menu.detail_menu, menu)
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_menu_share){
            Log.i(TAG, "Clicked on share")
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL")
            i.putExtra(Intent.EXTRA_TEXT, DataProvider.data[identifier]?.address)
            startActivity(Intent.createChooser(i, "Share URL"))
        }else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }
}