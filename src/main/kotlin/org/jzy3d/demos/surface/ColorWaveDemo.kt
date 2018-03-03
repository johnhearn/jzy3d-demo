package org.jzy3d.demos.surface

import org.jzy3d.colors.Color
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.demos.AbstractDemo
import org.jzy3d.demos.Launcher
import org.jzy3d.maths.Range
import org.jzy3d.plot3d.builder.Builder
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid
import org.jzy3d.plot3d.primitives.Shape

class ColorWaveDemo : AbstractDemo() {

    override fun createSurface(): Shape {
        val mapper = mapper { x, y -> x * Math.sin(x * y) }
        val range = Range(-3f, 3f)
        val steps = 80
        val surface = Builder.buildOrthonormal(OrthonormalGrid(range, steps, range, steps), mapper) as Shape
        surface.colorMapper = ColorMapper(ColorMapRainbow(), surface.bounds.zmin.toDouble(), surface.bounds.zmax.toDouble(), Color(1f, 1f, 1f, .5f))
        surface.faceDisplayed = true
        surface.wireframeDisplayed = false
        return surface
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Launcher.openDemo(ColorWaveDemo())
        }
    }
}