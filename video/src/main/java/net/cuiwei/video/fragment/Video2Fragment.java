package net.cuiwei.video.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;
import net.cuiwei.video.R;

/**
 * 2. MediaPlayer+SurfaceView+自定义控制器
 */
public class Video2Fragment extends Fragment implements SurfaceHolder.Callback,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnInfoListener,
        MediaPlayer.OnSeekCompleteListener,
        MediaPlayer.OnVideoSizeChangedListener,
        SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private ImageView playOrPauseIv;
    private SurfaceView videoSuf;
    private MediaPlayer mPlayer;
    private SeekBar mSeekBar;
    private RelativeLayout rootViewRl;
    private LinearLayout controlLl;
    private TextView startTime, endTime;
    private ImageView forwardButton, backwardButton;
    private boolean isShow = false;

    public static final int UPDATE_TIME = 0x0001;
    public static final int HIDE_CONTROL = 0x0002;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TIME:
                    updateTime();
                    mHandler.sendEmptyMessageDelayed(UPDATE_TIME, 500);
                    break;
                case HIDE_CONTROL:
                    hideControl();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_video2, container, false);
        initViews(view);
        initSurfaceView(view);
        initPlayer();
        initEvent();

        return view;
    }

    private void initEvent() {
        playOrPauseIv.setOnClickListener(this);
        rootViewRl.setOnClickListener(this);
//        rootViewRl.setOnTouchListener(this);
        forwardButton.setOnClickListener(this);
        backwardButton.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
    }
    private void initSurfaceView(View view) {
        videoSuf =view.findViewById(R.id.surfaceView);
        videoSuf.setZOrderOnTop(false);
        videoSuf.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        videoSuf.getHolder().addCallback(this);
    }

    private void initPlayer() {
        mPlayer = new MediaPlayer();
        mPlayer.setOnCompletionListener(this);
        mPlayer.setOnErrorListener(this);
        mPlayer.setOnInfoListener(this);
        mPlayer.setOnPreparedListener(this);
        mPlayer.setOnSeekCompleteListener(this);
        mPlayer.setOnVideoSizeChangedListener(this);
        try {
            //使用手机本地视频
//            mPlayer.setDataSource(path);
            String packageName=getActivity().getPackageName();
            Log.e("video1", packageName);
            mPlayer.setDataSource(getContext(), Uri.parse("android.resource://" + packageName + "/" + R.raw.f123));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initViews(View view) {
        playOrPauseIv = view.findViewById(R.id.playOrPause);
        startTime = view.findViewById(R.id.tv_start_time);
        endTime = view.findViewById(R.id.tv_end_time);
        mSeekBar = view.findViewById(R.id.tv_progess);
        rootViewRl = view.findViewById(R.id.root_rl);
        controlLl = view.findViewById(R.id.control_ll);
        forwardButton = view.findViewById(R.id.tv_forward);
        backwardButton = view.findViewById(R.id.tv_backward);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mPlayer.setDisplay(holder);
        mPlayer.prepareAsync();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
    @Override
    public void onPrepared(MediaPlayer mp) {
        startTime.setText(formatLongToTimeStr(mp.getCurrentPosition()));
        endTime.setText(formatLongToTimeStr(mp.getDuration()));
        mSeekBar.setMax(mp.getDuration());
        mSeekBar.setProgress(mp.getCurrentPosition());
    }
    @Override
    public void onCompletion(MediaPlayer mp) {

    }
    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return false;
    }
    private void play() {
        if (mPlayer == null) {
            return;
        }
//        Log.i("playPath", path);
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
            mHandler.removeMessages(UPDATE_TIME);
            mHandler.removeMessages(HIDE_CONTROL);
            playOrPauseIv.setVisibility(View.VISIBLE);
            playOrPauseIv.setImageResource(android.R.drawable.ic_media_play);
        } else {
            mPlayer.start();
            mHandler.sendEmptyMessageDelayed(UPDATE_TIME, 500);
            mHandler.sendEmptyMessageDelayed(HIDE_CONTROL, 5000);
            playOrPauseIv.setVisibility(View.INVISIBLE);
            playOrPauseIv.setImageResource(android.R.drawable.ic_media_pause);
        }
    }
    @Override
    public void onSeekComplete(MediaPlayer mp) {
        //TODO
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_backward:
                backWard();
                break;
            case R.id.tv_forward:
                forWard();
                break;
            case R.id.playOrPause:
                play();
                break;
            case R.id.root_rl:
                showControl();
                break;
        }
    }
    /**
     * 更新播放时间
     */
    private void updateTime() {
        startTime.setText(formatLongToTimeStr(mPlayer.getCurrentPosition()));
        mSeekBar.setProgress(mPlayer.getCurrentPosition());
    }

    /**
     * 隐藏进度条
     */
    private void hideControl() {
        isShow = false;
        mHandler.removeMessages(UPDATE_TIME);
        controlLl.animate().setDuration(300).translationY(controlLl.getHeight());
    }
    /**
     * 显示进度条
     */
    private void showControl() {
        if (isShow) {
            play();
        }
        isShow = true;
        mHandler.removeMessages(HIDE_CONTROL);
        mHandler.sendEmptyMessage(UPDATE_TIME);
        mHandler.sendEmptyMessageDelayed(HIDE_CONTROL, 5000);
        controlLl.animate().setDuration(300).translationY(0);
    }
    /**
     * 设置快进10秒方法
     */
    private void forWard(){
        if(mPlayer != null){
            int position = mPlayer.getCurrentPosition();
            mPlayer.seekTo(position + 10000);
        }
    }

    /**
     * 设置快退10秒的方法
     */
    public void backWard(){
        if(mPlayer != null){
            int position = mPlayer.getCurrentPosition();
            if(position > 10000){
                position-=10000;
            }else{
                position = 0;
            }
            mPlayer.seekTo(position);
        }
    }

    //OnSeekBarChangeListener
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if(mPlayer != null && b){
            mPlayer.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * @param l 整型的时间串, 微秒
     * @return 将微秒格式化为分：秒得形式 返回
     */
    public static String formatLongToTimeStr(int l) {
        String str = "";
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l / 1000;
        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }
        String formatDate = null;
        if(hour>0){
            formatDate = Integer.toString(hour)+":"+Integer.toString(minute)+":"+Integer.toString(second);
        }else{
            formatDate = Integer.toString(minute)+":"+Integer.toString(second);
        }
        return formatDate;
    }

}