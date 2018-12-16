package app.c.team.hackathon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import app.c.team.hackathon.R;


public class DashLine extends View {
    private Paint paint;
    private int color;
    private int dashLength;
    private int dashGap;
    private int dashStrokeWidth;
    private boolean isHorizontal;

    public DashLine(Context context) {
        super(context);
        init(context, null);
    }

    public DashLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DashLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public DashLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DashLine, 0, 0);

            try {
                dashGap = a.getDimensionPixelSize(R.styleable.DashLine_dl_dashGap, 1);
                dashLength = a.getDimensionPixelSize(R.styleable.DashLine_dl_dashLength, 1);
                dashStrokeWidth = a.getDimensionPixelSize(R.styleable.DashLine_dl_dashStrokeWidth, 1);
                color = a.getColor(R.styleable.DashLine_dl_color, 0xff000000);
                isHorizontal = a.getBoolean(R.styleable.DashLine_dl_horizontal, false);
            } finally {
                a.recycle();
            }
        }
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dashStrokeWidth);
        paint.setPathEffect(new DashPathEffect(new float[]{dashLength, dashGap,}, 0));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (isHorizontal) {
            float center = getHeight() * .5f;
            canvas.drawLine(0, center, getWidth(), center, paint);
        } else {
            float center = getWidth() * .5f;
            canvas.drawLine(center, 0, center, getHeight(), paint);
        }
        canvas.restore();
    }
}
