package ua.mintmalory.levelup_ht4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView originalPictureImgView;
    Bitmap original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        originalPictureImgView = (ImageView) findViewById(R.id.image_imgview);
        original = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        originalPictureImgView.setImageDrawable(new BitmapDrawable(getResources(), original));


        Button invertBtm = (Button) findViewById(R.id.invert_colors_btn);
        if (invertBtm != null) {
            invertBtm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (originalPictureImgView != null) {

                        Bitmap myBitmap = Bitmap.createBitmap(original.getWidth(), original.getHeight(), Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(myBitmap);
                        Paint paint = new Paint();
                        paint.setColorFilter(new ColorMatrixColorFilter(
                                getColorMatrix()));
                        canvas.drawBitmap(original, 0, 0, paint);
                        originalPictureImgView.setImageDrawable(new BitmapDrawable(getResources(), myBitmap));
                    }
                }
            });
        }

        final Button shapeBtm = (Button) findViewById(R.id.shape_cut_btn);
        if (shapeBtm != null) {
            shapeBtm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (originalPictureImgView != null) {

                        Bitmap myBitmap = Bitmap.createBitmap(
                                original.getWidth(), original.getHeight(),
                                Bitmap.Config.ARGB_8888);



                        Bitmap mask = BitmapFactory.decodeResource(getResources(), R.drawable.shape_ring);

                        Canvas canvas = new Canvas(myBitmap);

                        canvas.drawBitmap(original, 0, 0, null);
                        canvas.drawBitmap(mask, 0, 0, null);
                        Paint maskPaint = new Paint();
                        maskPaint.setXfermode(
                                new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                        Log.e("ERROR_OOPS", "(canvas == null) = " + (canvas == null));
                        Log.e("ERROR_OOPS", "(mask == null) = " + (mask == null));
                        Log.e("ERROR_OOPS", "(maskPaint == null) = " + (maskPaint == null));
                        if ((canvas != null) && (mask != null) && (maskPaint != null)) {

                            canvas.drawBitmap(mask, 0, 0, maskPaint);
                        }

                        originalPictureImgView.setImageDrawable(new BitmapDrawable(getResources(), myBitmap));
                    }
                }
            });
        }


        Button resetBtn = (Button) findViewById(R.id.reset_btn);
        if (resetBtn != null) {
            resetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    originalPictureImgView.setImageDrawable(new BitmapDrawable(getResources(), original));
                }
            });
        }
    }

    private ColorMatrix getColorMatrix() {
        return new ColorMatrix(new float[]{
                1, 0, 0, 0, 0, //
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 0
        });
    }
}
