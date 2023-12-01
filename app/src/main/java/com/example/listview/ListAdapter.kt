package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listview.ListData
import com.example.listview.R

class ListAdapter(context: Context, dataArrayList: ArrayList<ListData?>) :
    ArrayAdapter<ListData?>(context, R.layout.activity_list_item, dataArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val listData = getItem(position)

        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_list_item, parent, false)
            viewHolder = ViewHolder()
            viewHolder.listImage = view.findViewById(R.id.listImage)
            viewHolder.listName = view.findViewById(R.id.listName)
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        listData?.let {
            viewHolder.listImage?.setImageResource(it.image)
            viewHolder.listName?.text = it.name
        }

        return view!!
    }

    private class ViewHolder {
        var listImage: ImageView? = null
        var listName: TextView? = null
    }
}
