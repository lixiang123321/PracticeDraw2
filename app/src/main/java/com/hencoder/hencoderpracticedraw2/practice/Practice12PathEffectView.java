package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    CornerPathEffect cornerPathEffect = new CornerPathEffect(20);
    DiscretePathEffect discretePathEffect = new DiscretePathEffect(10, 5);
    DashPathEffect dashPathEffect = new DashPathEffect(new float[]{10, 4, 2, 4}, 0);
    SumPathEffect mSumPathEffect = new SumPathEffect(discretePathEffect, dashPathEffect);
    ComposePathEffect mComposePathEffect = new ComposePathEffect(dashPathEffect, discretePathEffect);

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private final PathDashPathEffect mPathDashPathEffect;

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);

        Path dashPath = new Path();
        dashPath.lineTo(20, -30);
        dashPath.lineTo(40, 0);
        dashPath.close();
        mPathDashPathEffect = new PathDashPathEffect(dashPath, 50, 0, PathDashPathEffect.Style.MORPH);
        // style :
        // 1. translate, donot do anything the the dashPath(triangle),
        //      the bottom of triangle is paralleled with x axis
        // 2. rotate, rotate the dashPath on the draw path,
        //      the bottom of the triangle is paralleled with the draw path
        // 3. morph, like the rotate,
        //      but the bottom of the triangle is not promiss to be line. it fit the path.
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);
        canvas.drawLine(50, 100, 200, 100, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        paint.setPathEffect(discretePathEffect);
        canvas.drawPath(path, paint);
        canvas.drawLine(50, 100, 200, 100, paint);// only effect the path
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        paint.setPathEffect(dashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        paint.setPathEffect(mPathDashPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        paint.setPathEffect(mSumPathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        paint.setPathEffect(mComposePathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
