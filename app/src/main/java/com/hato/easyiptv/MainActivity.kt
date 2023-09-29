@file:Suppress("DEPRECATION")

package com.hato.easyiptv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.util.Util
import com.hato.easyiptv.Utils.StreamData

class MainActivity : AppCompatActivity() {

    var player: SimpleExoPlayer? = null
    var playerview: PlayerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerview = findViewById<PlayerView>(R.id.video_view)
    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(this)
            .setMediaSourceFactory(DefaultMediaSourceFactory(baseContext).setLiveMaxOffsetMs(6000))
            .build()
            .also { exoPlayer ->
                playerview?.player = exoPlayer

                var streamdata = StreamData(
                    "",
                    "",
                    "",
                    "",
                    C.CLEARKEY_UUID
                )
                exoPlayer.setMediaItem(streamdata.buildMediaItem())
                exoPlayer.prepare()
                exoPlayer.playWhenReady = true
            }
    }

    public override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }
}