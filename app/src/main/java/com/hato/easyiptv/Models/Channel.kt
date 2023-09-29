package com.hato.easyiptv.Models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "channels")
class Channel {
    @DatabaseField(generatedId = true, columnName = "id")
    var channel_id: Int? = null
    @DatabaseField(columnName = "channel_number")
    var channel_numner: Int? = null
    @DatabaseField(columnName = "channel_name")
    var channel_name: String? = null
    @DatabaseField(columnName = "channel_url")
    var channel_url: String? = null
    @DatabaseField(columnName = "license_url")
    var license_url: String? = null
    @DatabaseField(columnName = "clearkey")
    var clearkey: String? = null
    @DatabaseField(columnName = "clearkeyid")
    var clearkeyid: String? = null
}