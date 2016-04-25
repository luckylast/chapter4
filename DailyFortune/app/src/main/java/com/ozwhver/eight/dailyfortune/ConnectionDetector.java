package com.ozwhver.eight.dailyfortune;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by amyhan on 29/02/16.
 */
public class ConnectionDetector {

    private Context context;
    public ConnectionDetector(Context context){
        this.context = context;
    }
    public boolean isConnectingToInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
