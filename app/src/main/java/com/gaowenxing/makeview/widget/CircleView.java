package com.gaowenxing.makeview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gaowenxing.makeview.R;

/**
 * Created by lx on 2017/5/9.
 */

public class CircleView extends View {

    private int mColor = Color.RED;

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context) {
        this(context, null);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //解析自定义属性
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);

        mColor = a.getColor(R.styleable.CircleView_circle_color, Color.BLUE);

        a.recycle();

        init();
    }

    private void init() {

        mPaint.setColor(mColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //使自定义View中的padding生效
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;

        int height = getHeight() - paddingTop - paddingBottom;

        int radius = Math.min(width, height) / 2;

        canvas.drawCircle(paddingLeft + width / 2, paddingTop + height / 2, radius, mPaint);

    }

    /**
     * 设置自定义View的wrap_content
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {

            setMeasuredDimension(200, 200);//200px为wrap_content的默认像素值

        } else if (widthSpecMode == MeasureSpec.AT_MOST) {

            setMeasuredDimension(200, heightSpecSize);

        } else if (heightSpecMode == MeasureSpec.AT_MOST) {

            setMeasuredDimension(200, widthSpecSize);
        }
    }
}
