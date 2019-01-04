using UnityEngine;

namespace Cafebit
{
    public class AndroidToast
    {
        
        #region <<Fields>>

        private static AndroidToast _instance;
        
        private static AndroidJavaObject _toastJavaObject;

        private static string TOAST_CLASS_IN_JAVA = "ir.cafebit.unitytoaster.CafebitUnityPlugin";
      
        public enum ToastGravity
        {
            Default,
            TopCenter,
            TopCorner,
            Center
            
        }

        public static AndroidToast Instance
        {
            get
            {
                if (_instance == null)
                {
                    _instance = new AndroidToast();
                }

                if (_toastJavaObject == null)
                {
                    using (var toastClassPointer = new AndroidJavaClass(TOAST_CLASS_IN_JAVA))
                    {
                        _toastJavaObject = toastClassPointer.CallStatic<AndroidJavaObject>("instance");
                    }
                }

                return _instance;
            }
        }

     
        #endregion


        public void Toast(string msg, ToastGravity gravity= ToastGravity.Default, float sizeText=18)
        {
            if (Application.platform == RuntimePlatform.Android)
            {
                string strgravity = "default";
                if(gravity== ToastGravity.Default) strgravity = "default";
                if (gravity == ToastGravity.TopCenter) strgravity = "topcenter";
                if (gravity == ToastGravity.TopCorner) strgravity = "topcorner";
                if (gravity == ToastGravity.Center) strgravity = "center";
                
                _toastJavaObject.Call("Toast", msg, strgravity, sizeText);
            }

        }

        public void ToastLong(string msg, ToastGravity gravity = ToastGravity.Default,float sizeText=18)
        {
            if (Application.platform == RuntimePlatform.Android)
            {
                string strgravity = "default";
                if (gravity == ToastGravity.Default) strgravity = "default";
                if (gravity == ToastGravity.TopCenter) strgravity = "topcenter";
                if (gravity == ToastGravity.TopCorner) strgravity = "topcorner";
                if (gravity == ToastGravity.Center) strgravity = "center";
               

                _toastJavaObject.Call("ToastLong", msg, strgravity, sizeText);
            }
        }

        public void CancelToast()
        {
            if (Application.platform == RuntimePlatform.Android)
            {
                _toastJavaObject.Call("CancelToast");
            }
        }
    }

}