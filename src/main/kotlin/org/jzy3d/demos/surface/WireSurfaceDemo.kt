package org.jzy3d.demos.surface

import org.jzy3d.analysis.AnalysisLauncher
import org.jzy3d.colors.Color
import org.jzy3d.colors.ColorMapper
import org.jzy3d.colors.colormaps.ColorMapRainbow
import org.jzy3d.demos.AbstractDemo
import org.jzy3d.maths.Dimension
import org.jzy3d.maths.Range
import org.jzy3d.plot3d.builder.Builder
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid
import org.jzy3d.plot3d.primitives.Shape
import org.jzy3d.plot3d.rendering.legends.colorbars.AWTColorbarLegend

class WireSurfaceDemo : AbstractDemo() {

    override fun create(): Shape {
        val mapper = mapper({ x, y -> 10 * Math.sin(x / 10) * Math.cos(y / 20) * x })
        val range = Range(-150f, 150f)
        val steps = 50
        val surface = Builder.buildOrthonormal(OrthonormalGrid(range, steps, range, steps), mapper) as Shape
        surface.colorMapper = ColorMapper(ColorMapRainbow(), surface.bounds.zmin.toDouble(), surface.bounds.zmax.toDouble())
        surface.faceDisplayed = true
        surface.wireframeDisplayed = true
        surface.wireframeColor = Color.BLACK
        val cbar = AWTColorbarLegend(surface, chart.view.axe.layout)
        cbar.minimumSize = Dimension(100, 600)
        surface.legend = cbar
        return surface
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AnalysisLauncher.open(WireSurfaceDemo())
        }
    }
}