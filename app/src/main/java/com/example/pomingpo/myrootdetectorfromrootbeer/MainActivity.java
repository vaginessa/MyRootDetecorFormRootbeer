package com.example.pomingpo.myrootdetectorfromrootbeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pomingpo.myrootdetectorfromrootbeer.Task.BaseRootDetectTask;

import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView tvRootManager;
    private TextView tvPotentiallyDangerousApps;
    private TextView tvTestKeys;
    private TextView tvBusyBoxBinary;
    private TextView tvSuBinary;
    private TextView tvSuExists;
    private TextView tvRWPaths;
    private TextView tvDangerousProps;
    private TextView tvRootNative;
    private TextView tvRootCloakingApps;
    private TextView tvSelinuxFlagInEnabled;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvRootManager = (TextView) findViewById(R.id.tv_root_manager);
        tvPotentiallyDangerousApps = (TextView) findViewById(R.id.tv_PotentiallyDangerousApps);
        tvTestKeys = (TextView) findViewById(R.id.tv_TestKeys);
        tvBusyBoxBinary = (TextView) findViewById(R.id.tv_BusyBoxBinary);
        tvSuBinary = (TextView) findViewById(R.id.tv_SuBinary);
        tvSuExists = (TextView) findViewById(R.id.tv_SuExists);
        tvRWPaths = (TextView) findViewById(R.id.tv_RWPaths);
        tvDangerousProps = (TextView) findViewById(R.id.tv_DangerousProps);
        tvRootNative = (TextView) findViewById(R.id.tv_RootNative);
        tvRootCloakingApps = (TextView) findViewById(R.id.tv_RootCloakingApps);
        tvSelinuxFlagInEnabled = (TextView) findViewById(R.id.tv_SelinuxFlagInEnabled);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        new BaseRootDetectTask(this) {
            @Override
            protected void onPostExecute(HashMap<String, Boolean> stringBooleanHashMap) {
                Set<String> keyset = stringBooleanHashMap.keySet();
                for (String key : keyset) {

                    setTheRootDetectedView(key, stringBooleanHashMap.get(key));

                }

                progressBar.setVisibility(View.GONE);
            }
        }.execute();


    }

    private void setTheRootDetectedView(String key, boolean detected) {
        switch (key) {
            case Constants.detectRootManagementApps:
                tvRootManager.setText(booleanToDetectdString(detected));
                break;
            case Constants.detectPotentiallyDangerousApps:
                tvPotentiallyDangerousApps.setText(booleanToDetectdString(detected));
                break;
            case Constants.detectTestKeys:
                tvTestKeys.setText(booleanToDetectdString(detected));
                break;
            case Constants.checkForBusyBoxBinary:
                tvBusyBoxBinary.setText(booleanToDetectdString(detected));
                break;
            case Constants.checkForSuBinary:
                tvSuBinary.setText(booleanToDetectdString(detected));
                break;
            case Constants.checkSuExists:
                tvSuExists.setText(booleanToDetectdString(detected));
                break;
            case Constants.checkForRWPaths:
                tvRWPaths.setText(booleanToDetectdString(detected));
                break;
            case Constants.checkForDangerousProps:
                tvDangerousProps.setText(booleanToDetectdString(detected));
                break;
            case Constants.checkForRootNative:
                tvRootNative.setText(booleanToDetectdString(detected));
                break;
            case Constants.detectRootCloakingApps:
                tvRootCloakingApps.setText(booleanToDetectdString(detected));
                break;
            case Constants.isSelinuxFlagInEnabled:
                tvSelinuxFlagInEnabled.setText(booleanToDetectdString(detected));
                break;
        }


    }

    private String booleanToDetectdString(boolean detected) {
        return detected ? "detected" : "not detected";

    }
}
