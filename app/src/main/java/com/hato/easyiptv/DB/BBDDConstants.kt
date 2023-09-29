package com.hato.easyiptv.DB

import com.hato.easyiptv.Models.Channel
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import java.sql.SQLException

class BBDDConstants {
    companion object {
        @Throws(SQLException::class)
        fun createTables(connectionSource: ConnectionSource) {
            TableUtils.createTable(connectionSource, Channel::class.java)
        }

        @Throws(SQLException::class)
        fun deleteTables(connectionSource: ConnectionSource) {
            TableUtils.dropTable<Channel, Int>(connectionSource, Channel::class.java, true)
        }

        val BBDD_VERSION: Int = 1
        val BBDD_NAME: String = "easyIPTV.db"
        var channelDao: Dao<Channel, Int>? = null
    }
}