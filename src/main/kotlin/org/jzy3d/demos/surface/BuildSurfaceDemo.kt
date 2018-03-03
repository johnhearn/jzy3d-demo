package org.jzy3d.demos.surface

import org.jzy3d.analysis.AnalysisLauncher
import org.jzy3d.colors.Color
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.demos.AbstractDemo
import org.jzy3d.maths.Coord3d
import org.jzy3d.plot3d.primitives.Point
import org.jzy3d.plot3d.primitives.Polygon
import org.jzy3d.plot3d.primitives.Shape

class BuildSurfaceDemo : AbstractDemo() {

    override fun create(): Shape {
        val distDataProp = arrayOf(doubleArrayOf(.25, .45, .20), doubleArrayOf(.56, .89, .45), doubleArrayOf(.6, .3, .7))
        val polygons = ArrayList<Polygon>()
        for (i in 0 until distDataProp.indices.endInclusive) {
            for (j in 0 until distDataProp[i].indices.endInclusive) {
                val polygon = Polygon()
                val x = i.toDouble()
                val y = j.toDouble()
                polygon.add(Point(Coord3d(x, y, distDataProp[i][j])))
                polygon.add(Point(Coord3d(x, y + 1, distDataProp[i][j + 1])))
                polygon.add(Point(Coord3d(x + 1, y + 1, distDataProp[i + 1][j + 1])))
                polygon.add(Point(Coord3d(x + 1, y, distDataProp[i + 1][j])))
                polygons.add(polygon)
            }
        }
        val surface = Shape(polygons)
        surface.colorMapper = ColorMapper(ColorMapRainbow(), surface.bounds.zmin.toDouble(), surface.bounds.zmax.toDouble(), Color(1f, 1f, 1f, 1f))
        surface.wireframeDisplayed = true
        surface.wireframeColor = Color.BLACK
        return surface
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AnalysisLauncher.open(BuildSurfaceDemo())
        }
    }
}