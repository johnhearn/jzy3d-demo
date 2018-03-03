package org.jzy3d.demos.scatter

import org.jzy3d.analysis.AnalysisLauncher
import org.jzy3d.colors.Color
import org.jzy3d.demos.AbstractDemo
import org.jzy3d.maths.Coord3d
import org.jzy3d.plot3d.primitives.Scatter
import java.util.*


class ScatterDemo : AbstractDemo() {

    override fun create(): Scatter {

        val size = 500000
        val points = arrayOfNulls<Coord3d>(size)
        val colors = arrayOfNulls<Color>(size)

        val r = Random()
        r.setSeed(0)

        for (i in 0 until size) {
            val x = r.nextGaussian().toFloat()
            val y = r.nextGaussian().toFloat()
            val z = r.nextGaussian().toFloat()
            points[i] = Coord3d(x, y, z)
            val a = 0.25f
            colors[i] = Color(x, y, z, a)
        }

        return Scatter(points, colors)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AnalysisLauncher.open(ScatterDemo())
        }
    }
}
