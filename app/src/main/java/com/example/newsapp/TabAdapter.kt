import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newsapp.Tab01Fragment
import com.example.newsapp.Tab02Fragment

class TabAdapter(fm: FragmentManager, private val context: Context): FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> { Tab01Fragment() }
            else ->  { Tab02Fragment() }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> {
                "tab_01"
            }
            else ->  {
                "tab_02"
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}