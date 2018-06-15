package ir.cafebit.unitytoaster;


import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

/**
 * Created by Seyed Ahmad Parkhid on 6/15/2018.
 */

public class CafebitUnityPlugin {
    private static CafebitUnityPlugin _instance;

    public static CafebitUnityPlugin instance() {
        if (_instance == null) {
            _instance = new CafebitUnityPlugin();
        }
        return _instance;
    }


    public void Toast(final String toastMessage){
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(UnityPlayer.currentActivity,toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ToastLong(final String toastMessage){
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(UnityPlayer.currentActivity,toastMessage, Toast.LENGTH_LONG).show();
            }
        });
    }
}
