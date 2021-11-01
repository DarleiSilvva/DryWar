package vm.caatsoft.caatingueiros.utils

import android.app.Activity
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Adapter
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

fun Fragment.displaymetrics():Size {
    val displaymetrics = DisplayMetrics()
    requireActivity().windowManager.defaultDisplay.getMetrics(displaymetrics)
    val height = displaymetrics.heightPixels
    val width = displaymetrics.widthPixels
    return Size(height, width)
}

fun Activity.displaymetrics():Size {
    val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val height = displaymetrics.heightPixels
    val width = displaymetrics.widthPixels
    return Size(height, width)
}

fun Fragment.layoutSizeHeight( height: Float):Int {
    val displaymetrics = DisplayMetrics()
    requireActivity().windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286

    val hf: Double = hd*height
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)

    return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalhf.toFloat(), resources.displayMetrics).toInt()
}

fun Fragment.layoutSizeWidth( width: Float):Int {
    val displaymetrics = DisplayMetrics()
    requireActivity().windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = resources.displayMetrics.density
    val wd = (displaymetrics.widthPixels/density)/411.42856

    val wf: Double = wd*width
    val decimalwf: BigDecimal = BigDecimal(wf).setScale(2, RoundingMode.HALF_UP)

    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalwf.toFloat(), resources.displayMetrics).toInt()
}

fun Activity.layoutSizeHeight( height: Float):Int {
    val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286

    val hf: Double = hd*height
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)

    return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalhf.toFloat(), resources.displayMetrics).toInt()
}

fun Activity.layoutSizeWidth( width: Float):Int {
    val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = resources.displayMetrics.density
    val wd = (displaymetrics.widthPixels/density)/411.42856

    val wf: Double = wd*width
    val decimalwf: BigDecimal = BigDecimal(wf).setScale(2, RoundingMode.HALF_UP)

    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalwf.toFloat(), resources.displayMetrics).toInt()
}

fun Activity.layoutSizeGameHeight( height: Float):Int {
    //Log.d("altura "+ view.id.toString()+" :", height.toString())
    /*val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = this.resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286

    val hf: Double = hd*height
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)*/

    return height.toInt()
}

fun Activity.layoutSizeGameWidth( width: Float):Int {
    //Log.d("largura "+ view.id.toString()+" :", width.toString())
    /*val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = this.resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286

    val hf: Double = hd*width
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)*/

    return width.toInt()
}


fun Adapter.layoutSizeHeight(height: Float, activity: Activity):Int {
    val displaymetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = activity.resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286

    val hf: Double = hd*height
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)

    return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalhf.toFloat(), activity.resources.displayMetrics).toInt()
}

fun Adapter.layoutSizeWidth(width: Float, activity: Activity):Int {
    val displaymetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = activity.resources.displayMetrics.density
    val wd = (displaymetrics.widthPixels/density)/411.42856

    val wf: Double = wd*width
    val decimalwf: BigDecimal = BigDecimal(wf).setScale(2, RoundingMode.HALF_UP)

    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalwf.toFloat(), activity.resources.displayMetrics).toInt()
}


/*fun Activity.layoutTextSize( height: Float,  width: Float):Size {
    val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286
    val wd = (displaymetrics.widthPixels/density)/411.42856

    Log.d("largura", (displaymetrics.widthPixels/density).toString())
    Log.d("altura", (displaymetrics.heightPixels/density).toString())
    Log.d("largura_diviida", ((displaymetrics.widthPixels/density)/2).toString())
    Log.d("altura_diviida", ((displaymetrics.heightPixels/density)/2).toString())
    val hf: Double = hd*height
    val wf: Double = wd*width
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)
    val decimalwf: BigDecimal = BigDecimal(wf).setScale(2, RoundingMode.HALF_UP)

    Log.d("largura_real", decimalwf.toFloat().toString())
    Log.d("altura_real", decimalhf.toFloat().toString())

    val h = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalhf.toFloat(), resources.displayMetrics).toInt()
    val w = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalwf.toFloat(), resources.displayMetrics).toInt()
    return Size(h, w)
}*/

fun Activity.layoutSizeGame( height: Float,  width: Float):Size {
    val displaymetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displaymetrics)
    val density = resources.displayMetrics.density
    val hd = (displaymetrics.heightPixels/density)/683.4286
    val wd = (displaymetrics.widthPixels/density)/411.42856
    Log.d("density", density.toString())

    Log.d("largura", (displaymetrics.widthPixels/density).toString())
    Log.d("altura", (displaymetrics.heightPixels/density).toString())
    Log.d("largura_diviida", ((displaymetrics.widthPixels/density)/2).toString())
    Log.d("altura_diviida", ((displaymetrics.heightPixels/density)/2).toString())
    val hf: Double = hd*height
    val wf: Double = wd*width
    val decimalhf: BigDecimal = BigDecimal(hf).setScale(2, RoundingMode.HALF_UP)
    val decimalwf: BigDecimal = BigDecimal(wf).setScale(2, RoundingMode.HALF_UP)

    Log.d("largura_real", decimalwf.toFloat().toString())
    Log.d("altura_real", decimalhf.toFloat().toString())

    val h = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalhf.toFloat(), resources.displayMetrics).toInt()
    val w = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, decimalwf.toFloat(), resources.displayMetrics).toInt()
    return Size(h, w)
}
fun Activity.sizeGameRelativeLayout(view: View) {
    view.layoutParams =
        RelativeLayout.LayoutParams(
            layoutSizeGameWidth(view.width.toFloat()),
            layoutSizeGameHeight(view.height.toFloat())
        )
}

fun Activity.sizeGameConstraintLayout(view: View) {
    view.layoutParams =
        ConstraintLayout.LayoutParams(
            layoutSizeGameWidth(view.width.toFloat()),
            layoutSizeGameHeight(view.height.toFloat())
        )
}

fun Activity.sizeGameLinearLayout(view: View) {
    view.layoutParams =
        LinearLayout.LayoutParams(
            layoutSizeGameWidth(view.width.toFloat()),
            layoutSizeGameHeight(view.height.toFloat())
        )
}

fun Activity.sizeGameFrameLayout(view: View) {
    val h = view.height
    val w = view.width
    view.layoutParams = FrameLayout.LayoutParams(
            layoutSizeGameWidth(w.toFloat()),
            layoutSizeGameHeight(h.toFloat())
        )
}

fun Activity.sizeGameFrameLayoutData(view: View, height: Int, width: Int) {
    view.layoutParams = FrameLayout.LayoutParams(
        layoutSizeGameWidth(width.toFloat()),
        layoutSizeGameHeight(height.toFloat())
    )
}
fun Activity.sizeGameLinearLayoutWidth(view: View) {
    view.layoutParams.width = layoutSizeGameWidth(view.width.toFloat())
}
data class Size (val height: Int, val width: Int)
