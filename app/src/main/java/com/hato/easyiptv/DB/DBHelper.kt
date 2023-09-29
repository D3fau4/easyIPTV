package com.hato.easyiptv.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.hato.easyiptv.Models.Channel
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource

class DBHelper(var context: Context) :
    OrmLiteSqliteOpenHelper(context, BBDDConstants.BBDD_NAME, null, BBDDConstants.BBDD_VERSION) {
    init {
        this.context.openOrCreateDatabase(BBDDConstants.BBDD_NAME, Context.MODE_PRIVATE, null)
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        Log.d("DBHelper", "Creating BBDD...")
        try {
            if (connectionSource != null) {
                BBDDConstants.createTables(connectionSource)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int,
    ) {
        try {
            if (connectionSource != null) {
                BBDDConstants.deleteTables(connectionSource)
            }
            onCreate(database, connectionSource)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun getChannelDAO(): Dao<Channel, Int>? {
        if (BBDDConstants.channelDao == null) {
            BBDDConstants.channelDao = getDao(Channel::class.java)
        }
        return BBDDConstants.channelDao
    }
}