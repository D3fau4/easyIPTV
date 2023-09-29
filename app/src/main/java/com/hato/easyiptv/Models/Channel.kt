package com.hato.easyiptv.Models

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "channels")
class Channel {
    @DatabaseField(generatedId = true, columnName = "id")
    var channel_id: Int? = null
}