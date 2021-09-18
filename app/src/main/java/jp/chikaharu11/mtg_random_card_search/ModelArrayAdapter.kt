package jp.chikaharu11.mtg_random_card_search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ModelArrayAdapter(ctx: Context,
                        models: List<Model>) :
    ArrayAdapter<Model>(ctx, 0, models) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {

        val model = getItem(position)

        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.custom_spinner_item,
            parent,
            false
        )

        model?.image?.let { view.findViewById<ImageView>(R.id.modelImage).setImageResource(it) }
        view.findViewById<TextView>(R.id.modelText).text = model?.description

        return view
    }
}