package org.jzy3d.demos

import org.apache.log4j.BasicConfigurator
import org.jzy3d.analysis.AbstractAnalysis
import org.jzy3d.plot3d.builder.Mapper
import org.jzy3d.plot3d.primitives.AbstractDrawable

abstract class AbstractDemo : AbstractAnalysis() {

    init {
        init()
    }

    final override fun init() {
        BasicConfigurator.configure()
        chart = initializeChart()
        chart.scene.graph.add(create())
    }

    protected abstract fun create(): AbstractDrawable

    protected fun mapper(lambda: (x: Double, y: Double) -> Double) = object : Mapper() {
        override fun f(x: Double, y: Double): Double {
            return lambda(x, y)
        }
    }
}