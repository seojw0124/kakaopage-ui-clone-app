package com.jeongu.kakaopageapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(
    private val imageList: List<Int>,
    private val titleList: List<Int>,
    private val descriptionList: List<String>,
    private val freeTypeList: List<Int?>,
    private val upList: List<Int?>,
    private val genreList: List<String?>,
    private val pageList: List<String>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_content_01)
        val title: ImageView = itemView.findViewById(R.id.iv_content_01_title)
        val description: TextView = itemView.findViewById(R.id.tv_content_01_description)
        val free: ImageView = itemView.findViewById(R.id.iv_content_01_free)
        val up: ImageView = itemView.findViewById(R.id.iv_content_01_up)
        val genre: TextView = itemView.findViewById(R.id.tv_content_01_genre)
        val page: TextView = itemView.findViewById(R.id.tv_content_01_current_page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content01, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position % imageList.size])
        holder.title.setImageResource(titleList[position % titleList.size])
        holder.description.text = descriptionList[position % descriptionList.size]
        if (freeTypeList[position % freeTypeList.size] != null) {
            holder.free.visibility = View.VISIBLE
            holder.free.setImageResource(freeTypeList[position % freeTypeList.size]!!)
        } else {
            holder.free.visibility = View.INVISIBLE
        }
        if (upList[position % upList.size] != null) {
            holder.up.visibility = View.VISIBLE
            holder.up.setImageResource(upList[position % upList.size]!!)
        } else {
            holder.up.visibility = View.GONE
        }
        if (genreList[position % genreList.size] != null) {
            holder.genre.visibility = View.VISIBLE
            holder.genre.text = genreList[position % genreList.size]!!
        } else {
            holder.genre.visibility = View.INVISIBLE
        }
        holder.page.text = pageList[position % pageList.size]
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE // 가상 아이템 목록 크기
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