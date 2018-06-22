# unity-toaster
In an android game/application a toast provides simple feedback about an operation in a small popup. It only fills the amount of space required for the message and the current activity remains visible and interactive. Toasts automatically disappear after a timeout.
By this plugin you can bring android's toast feature into your unity3D android app/game.

##USAGE:

see the example project: /unity-test/


You should copy the output/toast.aar  into <Your-Unity-Project>/Assets/Plugins/Android/
Then you should copy output/CafebitToaster.dll into <Your-Unity-Project>/Assets/Plugins/

you can use the library like this:


C# Code:

	public void Toast(string message){
	 Cafebit.AndroidToast.Instance.Toast(message);
	}
Regards
Seyed Ahmad Parkhid
#Seyed_Ahmad_Parkhid
