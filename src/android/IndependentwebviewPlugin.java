package com.zsoftware.independentwebview;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;


import com.zsoftware.independentwebview.IndependentWebViewActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndependentwebviewPlugin extends CordovaPlugin {
    private static final String LOG_TAG = "IndependentwebviewPlugin";

    private static String OPEN_ACTION = "open";

    public boolean execute(String action,final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (this.cordova.getActivity().isFinishing()) return true;

        if (action.equalsIgnoreCase(OPEN_ACTION)) { //打开新的页面
            final String url = args.getString(0);
            final Context _context = this.cordova.getActivity();
            cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(_context, IndependentWebViewActivity.class);
                    intent.putExtra("url", url);
//                    intent.putExtra("param", "这是需要传给网页的数据");
                    _context.startActivity(intent);
                    callbackContext.success();
                }
            });
            return true;
        }



        // Only alert and confirm are async.
        callbackContext.success();
        return true;
    }
}
