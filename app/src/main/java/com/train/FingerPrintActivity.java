package com.train;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.fingerprint.FingerprintManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FingerPrintActivity extends AppCompatActivity {
    private TextView  txtStatus;
    private ImageView imgStatus;
    private FingerprintManager fingerprintManager;
    private FingerprintManager.AuthenticationCallback authenticationCallback;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);

        txtStatus=(TextView) findViewById(R.id.txtstatus);
        imgStatus=(ImageView) findViewById(R.id.imgstatus);

//        imgStatus.setImageResource(R.drawable.image1);
        fingerprintManager=(FingerprintManager) getSystemService(FINGERPRINT_SERVICE);

        authenticationCallback=new FingerprintManager.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                txtStatus.setText("Error");
//                imgStatus.setImageResource(R.drawable.image2);
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                txtStatus.setText("Help");
//                imgStatus.setImageResource(R.drawable.image1);
                super.onAuthenticationHelp(helpCode, helpString);
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
                txtStatus.setText("Success");
//                imgStatus.setImageResource(R.drawable.image3);
                super.onAuthenticationSucceeded(result);
            }

            @Override
            public void onAuthenticationFailed() {
                txtStatus.setText("Failed");
//                imgStatus.setImageResource(R.drawable.image2);
                super.onAuthenticationFailed();
            }
        };

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void scanFingerPrintScan(View view){
        fingerprintManager.authenticate(null,null,0,authenticationCallback,null);
    }
}