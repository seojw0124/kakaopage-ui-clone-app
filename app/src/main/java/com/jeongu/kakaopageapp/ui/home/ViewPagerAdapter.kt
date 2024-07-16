package com.jeongu.kakaopageapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeongu.kakaopageapp.data.TopContentInfo
import com.jeongu.kakaopageapp.databinding.Content01Binding

class ViewPagerAdapter(
    private val items: List<TopContentInfo>,
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(val binding: Content01Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Content01Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = position % items.size
        val item = items[actualPosition]
        with(holder.binding) {
            ivContent01.setImageResource(item.thumbnailImage)
            ivContent01Title.setImageResource(item.title)
            tvContent01Description.text = item.description

            if (item.freeTypeImage != null) {
                ivContent01Free.visibility = View.VISIBLE
                ivContent01Free.setImageResource(item.freeTypeImage!!)
            } else {
                ivContent01Free.visibility = View.INVISIBLE
            }

            if (item.uploadImage != null) {
                ivContent01Up.visibility = View.VISIBLE
                ivContent01Up.setImageResource(item.uploadImage!!)
            } else {
                ivContent01Up.visibility = View.GONE
            }

            if (item.genre != null) {
                tvContent01Genre.visibility = View.VISIBLE
                tvContent01Genre.text = item.genre
            } else {
                tvContent01Genre.visibility = View.INVISIBLE
            }

            tvContent01CurrentPage.text = item.page
        }
    }

    override fun getItemCount(): Int {
        return items.size * INFINTE_MULTIPLIER
    }

    companion object {
        private const val INFINTE_MULTIPLIER = 100
    }
}

//class ViewPagerAdapter(private val context: Context, private val imageList: List<Int>): PagerAdapter() {
//    override fun getCount(): Int {
//        return imageList.size
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view = inflater.inflate(R.layout.content01, container, false)
//        val imageView = view.findViewById<ImageView>(R.id.iv_content_01)
//        imageView.setImageResource(imageList[position])
//        container.addView(view)
//        return view
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View)
//    }
//}