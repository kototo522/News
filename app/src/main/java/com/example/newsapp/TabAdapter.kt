import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.R
import com.example.newsapp.Tab01Fragment
import com.example.newsapp.Tab02Fragment
import com.example.newsapp.databinding.FragmentHomeBinding

class TabAdapter(fa: FragmentManager, private val context: Context): FragmentStateAdapter(fa){

    override fun getItemCount(position: Int): Fragment {
        return when(position){
            0 -> {
                Tab01Fragment()
            }
            else ->  {
                Tab02Fragment()
            }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        override fun TabLayoutMediator(position: Int): CharSequence? {
            return when(position){
                0 -> {
                    "tab_01"
                }
                else ->  {
                    "tab_02"
                }
            }
        }.attach()
    }

    override fun getItemCount(): Int {
        return 2
    }
}