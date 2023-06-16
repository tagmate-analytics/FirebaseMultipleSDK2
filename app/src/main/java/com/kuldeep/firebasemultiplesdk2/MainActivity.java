package com.kuldeep.firebasemultiplesdk2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    FirebaseAnalytics mfirebase1, mfirebase2;
    FirebaseApp faOne, faTwo;


    Boolean one = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseOptions options1 = new FirebaseOptions.Builder()
                .setProjectId(getString(R.string.project_id_one))
                .setApplicationId(getString(R.string.google_app_id_one))
                .setApiKey(getString(R.string.google_api_key_one))
                .build();

        FirebaseOptions options2 = new FirebaseOptions.Builder()
                .setProjectId(getString(R.string.project_id_two))
                .setApplicationId(getString(R.string.google_app_id_two))
                .setApiKey(getString(R.string.google_api_key_two))
                .build();

        if (one) {
            //Dharmikbhai1
            //performed initialization
            /*faOne = */
            FirebaseApp.initializeApp(this, options1, "primary");
//            Log.d("HEY_FIRE", "onCreate: "+FirebaseApp.);
            //Now create instance
//            faOne = FirebaseApp.getInstance("primary");

            mfirebase1 = FirebaseAnalytics.getInstance(this);
            //create bundle
            Bundle b1 = new Bundle();
            b1.putString("CUSTOM_PARAM_1", "CUSTOM_VALUE_1");
            b1.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "CAT_1");

            mfirebase1.logEvent(FirebaseAnalytics.Event.LOGIN, b1);
        } else if (!one) {
            //Dharmikbhai2
            //performed initialization
            /*faOne = */
            FirebaseApp.initializeApp(this, options2, "secondary");

            //Now create instance
//            faTwo = FirebaseApp.getInstance("secondary");
//            Log.d(TAG, "onCreate: ");

            mfirebase2 = FirebaseAnalytics.getInstance(this);
            //create bundle
            Bundle b2 = new Bundle();
            b2.putString("CUSTOM_PARAM_2", "CUSTOM_VALUE_2");
            b2.putString(FirebaseAnalytics.Param.ITEM_NAME, "CAT_2");

            mfirebase2.logEvent(FirebaseAnalytics.Event.LOGIN, b2);
        }
    }

    /*protected boolean isDefaultFirebaseAppInitialized() {
        try {
            // try get
            return FirebaseApp.getInstance(FirebaseApp.DEFAULT_APP_NAME) != null;
            // catch illegal state exc
        } catch (IllegalStateException ise) {
            // on such case not initialized
            return false;
        }
    }*/

}