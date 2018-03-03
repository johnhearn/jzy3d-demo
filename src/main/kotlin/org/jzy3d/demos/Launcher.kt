package org.jzy3d.demos

import org.jzy3d.analysis.AbstractAnalysis
import org.jzy3d.chart.ChartLauncher
import org.jzy3d.chart.Settings
import org.jzy3d.maths.Rectangle

object Launcher {
    fun openDemo(demo: AbstractAnalysis) {
        openDemo(demo, DEFAULT_WINDOW)
    }

    fun openDemo(demo: AbstractAnalysis, rectangle: Rectangle) {
        Settings.getInstance().isHardwareAccelerated = true
        ChartLauncher.instructions()
        ChartLauncher.openChart(demo.chart, rectangle, demo.name)
    }

    private val DEFAULT_WINDOW: Rectangle = Rectangle(0, 0, 600, 600)
}