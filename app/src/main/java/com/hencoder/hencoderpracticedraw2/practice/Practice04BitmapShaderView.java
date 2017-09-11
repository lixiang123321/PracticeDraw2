package com.hencoder.hencoderpracticedraw2.practice;

import com.hencoder.hencoderpracticedraw2.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice04BitmapShaderView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private BitmapShader mShader = new BitmapShader(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

    public Practice04BitmapShaderView(Context context) {
        super(context);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(mShader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setShader(mShader);
        canvas.drawCircle(200, 200, 200, paint);
    }
}
