package com.adwaith.edvoramap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecycleViewAdapter(private val adList: List<MapCard>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecycleViewAdapter.ViewHolder, position: Int) {
        holder.rideapi.text = adList[position].id.toString()
        holder.orginapi.text = adList[position].origin_station_code
        holder.stationapi.text = adList[position].station_path.toString()

        Picasso.get().load(adList[position].map_url).into(holder.itemImage)

        holder.itemcity.text = adList[position].city
        holder.itemstate.text = adList[position].state
        holder.dateapi.text = adList[position].date
        holder.distanceapi.text= adList[position].destination_station_code.toString()

    }

    override fun getItemCount(): Int {
        return adList.size

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemcity: TextView
        var itemstate: TextView
        var rideitem: TextView
        var rideapi: TextView
        var orginitem: TextView
        var orginapi: TextView
        var staitionitem: TextView
        var stationapi: TextView
        var dateitem: TextView
        var dateapi: TextView
        var distanceitem: TextView
        var distanceapi: TextView

        init {

            itemImage = itemView.findViewById(R.id.image_map)
            itemcity = itemView.findViewById(R.id.item_city)
            itemstate = itemView.findViewById(R.id.item_state)
            rideitem = itemView.findViewById(R.id.ride_item)
            rideapi = itemView.findViewById(R.id.ride_api)
            orginitem = itemView.findViewById(R.id.orginstation_item)
            orginapi = itemView.findViewById(R.id.orginstation_api)
            staitionitem = itemView.findViewById(R.id.staionpath_item)
            stationapi = itemView.findViewById(R.id.staionpath_api)
            dateitem = itemView.findViewById(R.id.date_item)
            dateapi = itemView.findViewById(R.id.date_api)
            distanceitem = itemView.findViewById(R.id.distance_item)
            distanceapi = itemView.findViewById(R.id.distance_api)

        }


    }


}