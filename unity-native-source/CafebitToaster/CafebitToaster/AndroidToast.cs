using UnityEngine;

namespace Cafebit
{
    public class AndroidToast
    {
        
        #region <<Fields>>

        private static AndroidToast _instance;
        
        private static AndroidJavaObject _toastJavaObject;

        private static string TOAST_CLASS_IN_JAVA = "ir.cafebit.unitytoaster.CafebitUnityPlugin";


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


        public void Toast(string msg)
        {
            if (Application.platform == RuntimePlatform.Android)
            {
                _toastJavaObject.Call("Toast", msg);
            }

        }

        public void ToastLong(string msg)
        {
            if (Application.platform == RuntimePlatform.Android)
            {
                _toastJavaObject.Call("ToastLong", msg);
            }
        }
    }

}