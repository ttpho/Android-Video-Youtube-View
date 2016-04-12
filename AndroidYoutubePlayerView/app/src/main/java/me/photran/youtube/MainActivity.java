package me.photran.youtube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import me.photran.youtube.views.YoutubeVideoView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linContentView;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linContentView = (LinearLayout) findViewById(R.id.linContentView);
        mLayoutInflater = LayoutInflater.from(this);

        String urlVideoYoutube = getResources().getString(R.string.url_video_youtube_test);

        YoutubeVideoView youtubeVideoView = new YoutubeVideoView(this);

        View view = youtubeVideoView.getView(mLayoutInflater, linContentView);
        youtubeVideoView.fillData(urlVideoYoutube);

        linContentView.addView(view);
    }
}
