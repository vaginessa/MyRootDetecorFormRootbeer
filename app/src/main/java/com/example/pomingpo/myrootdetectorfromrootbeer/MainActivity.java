package com.example.pomingpo.myrootdetectorfromrootbeer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pomingpo.myrootdetectorfromrootbeer.Task.BaseRootDetectTask;
import com.scottyab.rootbeer.RootBeer;

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




    }
}
