package com.example.jace.soundbox;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private MediaPlayer mediaPlayer;
    private TextView textView;
    private Button playButton;
    private Button prevButton;
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.goinghome);
        mediaPlayer.setLooping(true);

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);

        textView = (TextView) findViewById(R.id.display_text);

        playButton = (Button) findViewById(R.id.play);
        prevButton = (Button) findViewById(R.id.prev);
        nextButton = (Button) findViewById(R.id.next);


        playButton.setOnClickListener(this);



        //set seekbar to change the volume
        //add ids
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void musicPlay(){
        if(mediaPlayer!=null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                textView.setText("Press play to start");
                playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));

            }
            else{
                mediaPlayer.start();
                textView.setText("Press play again to pause");
                playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));

            }
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                musicPlay();
                break;
            case R.id.prev:
                break;
            case R.id.next:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
