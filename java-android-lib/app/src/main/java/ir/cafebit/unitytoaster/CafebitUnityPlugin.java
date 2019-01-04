package ir.cafebit.unitytoaster;


import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by Seyed Ahmad Parkhid on 6/15/2018.
 */

public class CafebitUnityPlugin {
    private static CafebitUnityPlugin _instance;
    private static Toast  toast=null;
    private static String TOAST_GRAVITY_DEFAULT="default";
    private static String TOAST_GRAVITY_TOPCENTER="topcenter";
    private static String TOAST_GRAVITY_TOPCORNER="topcorner";
    private static String TOAST_GRAVITY_CENTER="center";

    public static CafebitUnityPlugin instance() {
        if (_instance == null) {
            _instance = new CafebitUnityPlugin();
        }
        return _instance;
    }


    public void Toast(final String toastMessage,final String toastGravity,final float size_text){
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                toast=Toast.makeText(UnityPlayer.currentActivity,toastMessage, Toast.LENGTH_SHORT);
                if(toastGravity.equals(TOAST_GRAVITY_DEFAULT)){

                }
                if(toastGravity.equals(TOAST_GRAVITY_TOPCENTER)){
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                }

                if(toastGravity.equals(TOAST_GRAVITY_TOPCORNER)){
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                }

                if(toastGravity.equals(TOAST_GRAVITY_CENTER)){
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                }

                float sz = size_text;
                if (sz < 12) sz = 12;
                if (sz >= 30) sz = 32;
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(sz);
                toast.show();
            }
        });
    }

    public void ToastLong(final String toastMessage,final String toastGravity,final float size_text){
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                toast= Toast.makeText(UnityPlayer.currentActivity,toastMessage, Toast.LENGTH_LONG);

                if(toastGravity.equals(TOAST_GRAVITY_DEFAULT)){

                }
                if(toastGravity.equals(TOAST_GRAVITY_TOPCENTER)){
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                }
                if(toastGravity.equals(TOAST_GRAVITY_TOPCORNER)){
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                }
                if(toastGravity.equals(TOAST_GRAVITY_CENTER)){
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                }

                float sz = size_text;
                if (sz < 12) sz = 12;
                if (sz >= 30) sz = 32;
                ViewGroup group = (ViewGroup) toast.getView();
                TextView messageTextView = (TextView) group.getChildAt(0);
                messageTextView.setTextSize(sz);

                toast.show();
            }
        });
    }

    public void CancelToast(){
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
               if(toast!=null){
                   toast.cancel();

               }
            }
        });
    }
}
