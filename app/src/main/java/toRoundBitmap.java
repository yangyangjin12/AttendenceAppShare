import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;

public class toRoundBitmap {
    /**
     * 转换图片成圆形
     *
     *@param bitmap
     * 传入Bitmap对象
     *@return
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {

        int width = bitmap.getWidth();

        int height = bitmap.getHeight();

        float roundPx;

        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;

        if (width <= height) {

            roundPx = width / 2;
            left = 0;
            top = 0;
            right = width;
            bottom = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }

        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        new RectF(dst);

        paint.setAntiAlias(true);// 设置画笔无锯齿
        canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas
        paint.setColor(color);
        canvas.drawCircle(roundPx, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
        canvas.drawBitmap(bitmap, src, dst, paint); // 以Mode.SRC_IN模式合并bitmap和已经draw了的Circle
        return output;

    }
    //将drawable中的图片转为Bitmap对象

/**

 * drawable2Bitmap

 *

 *@param //bitmap

 * 传入Drawable对象

 *@return

 */

    @SuppressWarnings("deprecation")

    public static Bitmap drawable2Bitmap(int a , Context context) {

        Resources resources = context.getResources();

        Drawable drawable = resources.getDrawable(a);

        if (drawable instanceof BitmapDrawable) {

            return ((BitmapDrawable) drawable).getBitmap();

        } else if (drawable instanceof NinePatchDrawable) {

            Bitmap bitmap = Bitmap

                    .createBitmap(

                            drawable.getIntrinsicWidth(),

                            drawable.getIntrinsicHeight(),

                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888

                                    : Bitmap.Config.RGB_565);

            Canvas canvas = new Canvas(bitmap);

            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),

                    drawable.getIntrinsicHeight());

            drawable.draw(canvas);

            return bitmap;

        } else {

            return null;
        }
    }

    //图片旋转

    /**

     * rotateImage

     *

     * @param id

     * 传入derawable id

     * @return bitmap

     */

    public Bitmap rotateImage(int id,Context context,float rotate){

        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(id)).getBitmap();

        Matrix matrix = new Matrix();

        matrix.setRotate(rotate);

        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);

        return bitmap;
    }

    public static void main(String[] args){
        //toRoundBitmap();
    }
}


