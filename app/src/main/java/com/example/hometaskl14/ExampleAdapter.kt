package com.example.hometaskl14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_member_layout.view.*


class Adapter(private val values: List<Person>) : RecyclerView.Adapter<ExampleViewHolder>() {
    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_member_layout, parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bind(values[position])
    }

}

class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: Person) {
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        params.setMargins(50 * person.flag, 10, 10, 10)
        itemView.text_name.text = person.name
        itemView.text_age.text = person.age.toString()
        itemView.text_name?.layoutParams = params
        itemView.text_age?.layoutParams = params
    }
}