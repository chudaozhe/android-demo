package net.cuiwei.video.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import net.cuiwei.video.R;

public class Video1Fragment extends Fragment {
    public VideoView videoView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video1, container, false);
        videoView=view.findViewById(R.id.videoView);
        //加载指定视频文件
        //String path= Environment.getExternalStorageDirectory().getPath()+"/xx.mp4";
        //videoView.setVideoPath(path);
        String packageName=getActivity().getPackageName();
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.f123));
        Log.e("video1", packageName);

        videoView.seekTo(200);//设置播放位置,毫秒
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //播放结束
                videoView.seekTo(200);
                Log.e("video1", "play done");
            }
        });
        //VideoView与MediaController建立关联
        MediaController mediaController=new MediaController(getContext());
        //设置媒体控制器,可选
        videoView.setMediaController(mediaController);
        //让VideoView获取焦点，可选
        videoView.requestFocus();
        return view;
    }
}