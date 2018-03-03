package org.jzy3d.demos

import org.apache.log4j.BasicConfigurator
import org.jzy3d.analysis.AbstractAnalysis
import org.jzy3d.plot3d.builder.Mapper
import org.jzy3d.plot3d.primitives.Shape

abstract class AbstractDemo : AbstractAnalysis() {

    init {
        init()
    }

    override fun init() {
        BasicConfigurator.configure()
        chart = initializeChart()
        val surface = createSurface()
        chart.scene.graph.add(surface)
    }

    protected abstract fun createSurface(): Shape

    protected fun mapper(lambda: (x: Double, y: Double) -> Double) = object : Mapper() {
        override fun f(x: Double, y: Double): Double {
            return lambda(x, y)
        }
    }
}