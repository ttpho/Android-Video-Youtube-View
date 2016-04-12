package me.photran.youtube.views;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import me.photran.youtube.R;
import me.photran.youtube.Utils;

/**
 * Created by photran on 4/6/16.
 */


/***
 * This is this title of the article
 */
public class YoutubeVideoView implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlayerStateChangeListener {
    private String mUrlYoutubeVideo;
    private FragmentActivity baseActivity;
    private View view;

    public YoutubeVideoView(FragmentActivity activity) {
        this.baseActivity = activity;
    }

    public FragmentActivity getBaseActivity() {
        return baseActivity;
    }

    public void setBaseActivity(FragmentActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    public View getView(LayoutInflater inflater, ViewGroup root) {
        view = inflater.inflate(getLayoutID(), root, false);
        return view;
    }

    private int getLayoutID() {
        return R.layout.layout_youtube_video_view;
    }

    public void fillData(String url) {
        this.mUrlYoutubeVideo = url;
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getBaseActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();
        youTubePlayerFragment.initialize(getBaseActivity().getResources().getString(R.string.developer_key_youtube), this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Utils.doLog("onInitializationSuccess");
        if (!wasRestored) {
            String youtubeVideoId = Utils.getYoutubeIdFormUrl(mUrlYoutubeVideo);
            youTubePlayer.cueVideo(youtubeVideoId);
        }
        youTubePlayer.setPlayerStateChangeListener(this);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Utils.doLog("onInitializationFailure");
    }

    @Override
    public void onLoading() {
        Utils.doLog("onLoading");
    }

    @Override
    public void onLoaded(String s) {
        Utils.doLog("onLoaded");
    }

    @Override
    public void onAdStarted() {
        Utils.doLog("onAdStarted");
    }

    @Override
    public void onVideoStarted() {
        Utils.doLog("onVideoStarted");
    }

    @Override
    public void onVideoEnded() {
        Utils.doLog("onVideoEnded");
    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {
        Utils.doLog("onError " + errorReason.name());
    }
}
