package com.example.helloearth

import android.app.Activity
import com.mousebird.maply.*
import java.io.File

class GlobeSetup(
    private val activity: Activity?,
    private val baseControl: BaseController
    ) {

    fun setup() {
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
    }
}