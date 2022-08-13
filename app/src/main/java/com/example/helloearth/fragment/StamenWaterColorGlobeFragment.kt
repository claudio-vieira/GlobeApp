package com.example.helloearth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helloearth.GlobeSetup
import com.mousebird.maply.*


class StamenWaterColorGlobeFragment : GlobeMapFragment() {

    override fun chooseDisplayType(): MapDisplayType {
        return MapDisplayType.Globe
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return baseControl.contentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobeSetup(activity, baseControl).setup()
    }

    override fun controlHasStarted() {
        super.controlHasStarted()

        // Go to a specific location with animation
        //
        // `globeControl` is the controller when using MapDisplayType.Globe
        // `mapControl` is the controller when using MapDisplayType.Map
        // `baseControl` refers to whichever of them is used.
        val latitude = 40.5023056 * Math.PI / 180
        val longitude = -3.6704803 * Math.PI / 180
        val zoom_earth_radius = 0.5
        globeControl.animatePositionGeo(longitude, latitude, zoom_earth_radius, 1.0)
    }

}