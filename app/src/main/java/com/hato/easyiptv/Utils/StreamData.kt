@file:Suppress("DEPRECATION")

package com.hato.easyiptv.Utils
/*
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
*/
import android.util.Log
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.MimeTypes
import java.util.UUID

class StreamData(
    var licenseUrl: String?,
    var streamUrl: String?,
    var clearKey: String?,
    var clearKeyId: String?,
    var schemeType: UUID
) {


    override fun toString(): String {
        return "StreamData(licenseUrl=$licenseUrl, streamUrl=$streamUrl, clearKey=$clearKey, clearKeyId=$clearKeyId)"
    }

    fun buildMediaItem() : MediaItem {
        Log.d("StreamData", "$licenseUrl?key=${clearKey}&keyid=${clearKeyId}");
        return MediaItem.Builder()
            .setUri(streamUrl)
            .setMimeType(MimeTypes.APPLICATION_MPD)
            .setDrmUuid(schemeType)
            .setDrmLicenseUri("$licenseUrl?key=${clearKey}&keyid=${clearKeyId}")
            .setLiveConfiguration(
                MediaItem.LiveConfiguration.Builder().setMaxPlaybackSpeed(1.02f).build()
            )
            .build()
    }
}