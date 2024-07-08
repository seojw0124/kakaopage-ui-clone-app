package com.jeongu.kakaopageapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val imageList: List<Int>, private val pageList: List<String>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_content_01)
        val page: TextView = itemView.findViewById(R.id.tv_content_01_current_page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content01, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position % imageList.size])
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