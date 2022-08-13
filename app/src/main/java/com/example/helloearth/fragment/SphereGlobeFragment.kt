package com.example.helloearth.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helloearth.GlobeSetup
import com.mousebird.maply.*


class SphereGlobeFragment : GlobeMapFragment() {

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
        insertSpheres()
    }

    private fun insertSpheres() {

        val shapes: MutableList<Shape> = ArrayList()

        // Kansas City
        var shape = ShapeSphere()
        shape.setLoc(Point2d.FromDegrees(-94.58, 39.1))
        shape.setRadius(0.04f) // 1.0 is the radius of the Earth
        shapes.add(shape)

        // Washington D.C.
        shape = ShapeSphere()
        shape.setLoc(Point2d.FromDegrees(-77.036667, 38.895111))
        shape.setRadius(0.1f)
        shapes.add(shape)

        // Sao Paulo
        shape = ShapeSphere()
        shape.setLoc(Point2d.FromDegrees(-46.625290,-23.533773))
        shape.setRadius(0.2f)
        shapes.add(shape)

        // Hong Kong
        shape = ShapeSphere()
        shape.setLoc(Point2d.FromDegrees(114.177216, 22.302711))
        shape.setRadius(0.08f)
        shapes.add(shape)

        val shapeInfo = ShapeInfo()
        shapeInfo.setColor(0.7f, 0.2f, 0.7f, 0.8f) // R,G,B,A - values [0.0 => 1.0]
        shapeInfo.drawPriority = 1000000

        globeControl.addShapes(shapes, shapeInfo, ThreadMode.ThreadAny)

        val latitude = 40 * Math.PI / 180
        val longitude = -100 * Math.PI / 180
        val zoomEarthRadius = 1.0
        globeControl.animatePositionGeo(longitude, latitude, zoomEarthRadius, 1.0)
    }

}