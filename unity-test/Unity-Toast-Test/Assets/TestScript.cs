using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TestScript : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
	public void Toast(string message){
	    Cafebit.AndroidToast.Instance.Toast(message);
	}
    public void ToastTopCenter(string message)
    {
        Cafebit.AndroidToast.Instance.Toast(message,Cafebit.AndroidToast.ToastGravity.TopCenter);
    }
    public void ToastTopCorner(string message)
    {
        Cafebit.AndroidToast.Instance.Toast(message, Cafebit.AndroidToast.ToastGravity.TopCorner);
    }
    public void ToastCenter(string message)
    {
        Cafebit.AndroidToast.Instance.Toast(message, Cafebit.AndroidToast.ToastGravity.Center);
    }
    public void ToastCancel(string message)
    {
        Cafebit.AndroidToast.Instance.CancelToast();
    }
}
