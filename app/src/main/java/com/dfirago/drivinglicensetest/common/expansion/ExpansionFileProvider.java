package com.dfirago.drivinglicensetest.common.expansion;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;

import com.google.android.vending.expansion.zipfile.APKExpansionSupport;
import com.google.android.vending.expansion.zipfile.ZipResourceFile;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

/**
 * Created by Dmytro Firago (firago94@gmail.com) on 10/20/2017.
 */
public class ExpansionFileProvider {

    private Context context;

    @Inject
    public ExpansionFileProvider(Context context) {
        this.context = context;
    }

    public AssetFileDescriptor getAssetFileDescriptor(String fileName) {
        ZipResourceFile expansionFile = getApkExpansionZipFile();
        return expansionFile.getAssetFileDescriptor(fileName);
    }

    public InputStream getInputStream(String fileName) throws IOException {
        ZipResourceFile expansionFile = getApkExpansionZipFile();
        return expansionFile.getInputStream(fileName);
    }

    private ZipResourceFile getApkExpansionZipFile() {
        try {
            int versionCode = getVersionCode();
            return APKExpansionSupport.getAPKExpansionZipFile(context, versionCode, versionCode);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to find expansion file", e);
        }
    }

    private int getVersionCode() {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Failed to retrieve application version", e);
        }
    }
}
