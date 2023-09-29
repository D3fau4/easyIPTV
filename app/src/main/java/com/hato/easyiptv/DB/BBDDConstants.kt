package com.hato.easyiptv.DB

import com.hato.easyiptv.Models.Channel
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class BBDDConstants {
    companion object {
        fun createTables(connectionSource: ConnectionSource) {
            TableUtils.createTable(connectionSource, Channel::class.java)
        }

        val BBDD_VERSION: Int = 1
        val BBDD_NAME: String = "easyIPTV.db"
        var channelDao: Dao<Channel, Int>? = null
    }
}