package com.hato.easyiptv.DB

import android.app.Activity
import android.content.Context
import com.j256.ormlite.android.apptools.OpenHelperManager

abstract class DBHelperMOS : Activity() {
    var mDBHelper: DBHelper? = null

    protected fun getHelper(context: Context?): DBHelper? {
        if (mDBHelper == null) {
            mDBHelper = OpenHelperManager.getHelper(context, DBHelper::class.java)
        }
        return mDBHelper
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mDBHelper != null) {
            OpenHelperManager.releaseHelper()
            mDBHelper = null
        }
    }
}