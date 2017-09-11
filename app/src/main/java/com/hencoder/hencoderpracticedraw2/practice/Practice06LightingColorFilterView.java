package com.hencoder.hencoderpracticedraw2.practice;

import com.hencoder.hencoderpracticedraw2.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice06LightingColorFilterView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private final LightingColorFilter lightingColorFilter1;
    private final LightingColorFilter lightingColorFilter2;

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        lightingColorFilter1 = new LightingColorFilter(Color.argb(255, 0, 255, 255), Color.TRANSPARENT);
        lightingColorFilter2 = new LightingColorFilter(Color.WHITE, Color.argb(0, 0, 48, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        paint.setColorFilter(lightingColorFilter1);
        canvas.drawBitmap(bitmap, 0, 0, paint);

        // 第二个 LightingColorFilter：增强绿色部分
        paint.setColorFilter(lightingColorFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
