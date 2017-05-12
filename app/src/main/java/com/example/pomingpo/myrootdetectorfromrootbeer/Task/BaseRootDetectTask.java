package com.example.pomingpo.myrootdetectorfromrootbeer.Task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.pomingpo.myrootdetectorfromrootbeer.Constants;
import com.scottyab.rootbeer.RootBeer;
import com.scottyab.rootbeer.util.Utils;

import java.util.HashMap;

/**
 * Created by pomingpo on 2017/5/12.
 */

public class BaseRootDetectTask extends AsyncTask<Void, Void, HashMap<String, Boolean>> {

    private static final int SLEEP_TIME = 70;
    private Context mContext;

    public BaseRootDetectTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected HashMap<String, Boolean> doInBackground(Void... params) {
        RootBeer check = new RootBeer(mContext);
        boolean mIsCheck = false;
        check.setLogging(true);
        HashMap<String, Boolean> resultmap = new HashMap<>();

        for (int i = 0; i < 90; i++) {
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {

            }
            switch (i) {
                case 8:
                    mIsCheck = check.detectRootManagementApps();
                    resultmap.put(Constants.detectRootManagementApps, mIsCheck);
                    break;
                case 16:
                    mIsCheck = check.detectPotentiallyDangerousApps();
                    resultmap.put(Constants.detectPotentiallyDangerousApps, mIsCheck);
                    break;
                case 24:
                    mIsCheck = check.detectTestKeys();
                    resultmap.put(Constants.detectTestKeys, mIsCheck);
                    break;
                case 32:
                    mIsCheck = check.checkForBusyBoxBinary();
                    resultmap.put(Constants.checkForBusyBoxBinary, mIsCheck);
                    break;
                case 40:
                    mIsCheck = check.checkForSuBinary();
                    resultmap.put(Constants.checkForSuBinary, mIsCheck);
                    break;
                case 48:
                    mIsCheck = check.checkSuExists();
                    resultmap.put(Constants.checkSuExists, mIsCheck);
                    break;
                case 56:
                    mIsCheck = check.checkForRWPaths();
                    resultmap.put(Constants.checkForRWPaths, mIsCheck);
                    break;
                case 64:
                    mIsCheck = check.checkForDangerousProps();
                    resultmap.put(Constants.checkForDangerousProps, mIsCheck);
                    break;
                case 72:
                    mIsCheck = check.checkForRootNative();
                    resultmap.put(Constants.checkForRootNative, mIsCheck);
                    break;
                case 80:
                    mIsCheck = check.detectRootCloakingApps();
                    resultmap.put(Constants.detectRootCloakingApps, mIsCheck);
                    break;
                case 88:
                    mIsCheck = Utils.isSelinuxFlagInEnabled();
                    resultmap.put(Constants.isSelinuxFlagInEnabled, mIsCheck);
                    break;
            }

        }
        return resultmap;
    }

}
