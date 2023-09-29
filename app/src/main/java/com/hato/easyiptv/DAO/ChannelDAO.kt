package com.hato.easyiptv.DAO

import android.content.Context
import com.hato.easyiptv.DB.DBHelperMOS
import com.hato.easyiptv.Models.Channel
import com.j256.ormlite.dao.Dao
import java.lang.Exception
import java.sql.SQLException

class ChannelDAO : DBHelperMOS() {
    var dao: Dao<Channel, Int>? = null

    @Throws(SQLException::class)
    fun cargarDao(context: Context?) {
        dao = getHelper(context)?.getChannelDAO()
    }

    fun createChannel(context: Context?, channel: Channel): Boolean {
        try {
            cargarDao(context)
            dao?.create(channel)
            return true
        }catch (ex: Exception){
            ex.printStackTrace()
            return false
        }
    }

}