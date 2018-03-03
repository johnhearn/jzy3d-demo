package org.jzy3d.demos.surface

import org.jzy3d.colors.Color
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapWhiteBlue
import org.jzy3d.demos.AbstractDemo
import org.jzy3d.demos.Launcher
import org.jzy3d.maths.Range
import org.jzy3d.plot3d.builder.Builder
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid
import org.jzy3d.plot3d.primitives.Shape
import org.jzy3d.plot3d.rendering.legends.colorbars.AWTColorbarLegend

class MexicanDemo : AbstractDemo() {

    override fun createSurface(): Shape {
        val sigma = 10
        val mapper = mapper { x, y -> Math.exp(-(x * x + y * y) / sigma) * Math.abs(Math.cos(2 * Math.PI * (x * x + y * y))) }
        val range = Range(-0.5f, .5f)
        val steps = 50
        val surface = Builder.buildOrthonormal(OrthonormalGrid(range, steps, range, steps), mapper) as Shape
        surface.colorMapper = ColorMapper(ColorMapWhiteBlue(), surface.bounds.zmin.toDouble(), surface.bounds.zmax.toDouble())
        surface.faceDisplayed = true
        surface.wireframeDisplayed = true
        surface.wireframeColor = Color.BLACK
        surface.legend = AWTColorbarLegend(surface, chart.view.axe.layout)
        return surface
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Launcher.openDemo(MexicanDemo())
        }
    }

}