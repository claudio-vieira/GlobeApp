package com.example.helloearth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mousebird.maply.*
import java.io.File


class GlobeFragment : GlobeMapFragment() {

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

    override fun controlHasStarted() {
        super.controlHasStarted()

        // Set up the local cache directory
        val cacheDirName = "stamen_watercolor6"
        val cacheDir = File(activity?.cacheDir, cacheDirName)
        cacheDir.mkdir()

        // Set up access to the tile images
        val tileInfo = RemoteTileInfoNew(
            "http://tile.stamen.com/watercolor/{z}/{x}/{y}.png",
            0,
            18)
        tileInfo.cacheDir = cacheDir

        // Set up the globe parameters
        val params = SamplingParams()
        params.coordSystem = SphericalMercatorCoordSystem()
        params.coverPoles = true
        params.edgeMatching = true
        params.minZoom = tileInfo.minZoom
        params.maxZoom = tileInfo.maxZoom
        params.singleLevel = true

        // Set up an image loader, tying all the previous together.
        val loader = QuadImageLoader(params, tileInfo, baseControl)
        loader.setImageFormat(RenderController.ImageFormat.MaplyImageUShort565)

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