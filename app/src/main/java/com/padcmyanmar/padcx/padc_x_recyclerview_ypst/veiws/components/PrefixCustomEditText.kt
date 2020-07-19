package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class PrefixCustomEditText @JvmOverloads constructor(
    context : Context,
    attrs : AttributeSet ?= null
) : AppCompatEditText(context,attrs) {

    private var mPrefixText = "+95"
    private var mPrefixColor = Color.BLACK
    private val mPrefixRectangle = Rect()

    init {
        context.withStyledAttributes(attrs, R.styleable.PrefixCustomEditText){
            mPrefixText = getString(R.styleable.PrefixCustomEditText_prefixText) ?: mPrefixText
            mPrefixColor = getColor(R.styleable.PrefixCustomEditText_prefixColor,mPrefixColor)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        paint.getTextBounds(mPrefixText,0,mPrefixText.length,mPrefixRectangle)

        mPrefixRectangle.right += paint.measureText(" ").toInt()

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = mPrefixColor

        canvas?.drawText(mPrefixText,
            super.getCompoundPaddingLeft().toFloat(),
            baseline.toFloat(),
            paint
        )
        super.onDraw(canvas)
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + mPrefixRectangle.width()
    }
}