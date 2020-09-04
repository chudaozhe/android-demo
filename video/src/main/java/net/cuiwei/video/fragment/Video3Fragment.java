package net.cuiwei.video.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.MediaController;
import androidx.fragment.app.Fragment;
import net.cuiwei.video.ContentActivity;
import net.cuiwei.video.R;

import java.io.IOException;

/**
 * 3、MediaPlayer+SurfaceView+MediaController
 * MediaPlayer+SurfaceView也可以使用系统自带的MediaController控制器。使用这个方式实现，布局文件只需一个SurfaceView即可，其他的控件都交给MediaController控制器
 */
public class Video3Fragment extends Fragment implements
        MediaController.MediaPlayerControl,
        MediaPlayer.OnBufferingUpdateListener,
        SurfaceHolder.Callback, View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private MediaController controller;
    private int bufferPercentage = 0;

    //屏幕点击事件
    public ContentActivity.FragmentTouchListener fragmentTouchListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video3, container, false);
        fragmentTouchListener = new ContentActivity.FragmentTouchListener() {
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                controller.show();
                mediaPlayer.start();
                return false;
            }
        };
        ((ContentActivity) getActivity()).registerFragmentTouchListener(fragmentTouchListener);
        mediaPlayer = new MediaPlayer(); //MediaPlayer.create(getContext(), R.raw.f123);
        controller = new MediaController(getContext());
        controller.setAnchorView(view.findViewById(R.id.root_ll));
        initSurfaceView(view);
        //通过点击按钮触发播放
        view.findViewById(R.id.play).setOnClickListener(this);
        return view;
    }
    private void initSurfaceView(View view) {
        SurfaceView videoSuf = view.findViewById(R.id.controll_surfaceView);
        videoSuf.setZOrderOnTop(false);
        videoSuf.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        videoSuf.getHolder().addCallback(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        try {
            //String path = Environment.getExternalStorageDirectory().getPath() + "/20180730.mp4";
            //mediaPlayer.setDataSource(path);
            String packageName=getActivity().getPackageName();
            Log.e("video1", packageName);
            //
            //mediaPlayer.setDataSource(getContext(), Uri.parse("android.resource://" + packageName + "/" + R.raw.f123));
            mediaPlayer.setDataSource("https://cw-test.oss-cn-hangzhou.aliyuncs.com/joke/2020-5-22/1590105822290.mp4");
            mediaPlayer.setOnBufferingUpdateListener(this);
            //mediaPlayer.prepare();

            controller.setMediaPlayer(this);
            controller.setEnabled(true);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((ContentActivity) this.getActivity()).unRegisterFragmentTouchListener(fragmentTouchListener);
        if (null != mediaPlayer){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

//    //MediaPlayer
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
    //MediaPlayerControl
    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        bufferPercentage = i;
    }

    @Override
    public void start() {
        if (null != mediaPlayer){
            mediaPlayer.start();
        }
    }

    @Override
    public void pause() {
        if (null != mediaPlayer){
            mediaPlayer.pause();
        }
    }

    @Override
    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    @Override
    public void seekTo(int i) {
        mediaPlayer.seekTo(i);
    }

    @Override
    public boolean isPlaying() {
        if (mediaPlayer.isPlaying()){
            return true;
        }
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return bufferPercentage;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    //SurfaceHolder.callback
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mediaPlayer.setDisplay(surfaceHolder);
        mediaPlayer.prepareAsync();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                mediaPlayer.start();
                break;
        }
    }
}