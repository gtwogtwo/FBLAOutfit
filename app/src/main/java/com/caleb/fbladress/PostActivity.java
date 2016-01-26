package com.caleb.fbladress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class PostActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

    }
    //following 6 functions called on button click, open tweetcomposer
    public void buttonOnClickOutfitProfessional(View v){
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Does this outfit look professional? #FBLAoutfit");
        builder.show();

    }

    public void buttonOnClickFBLAappropriate(View v){
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Is this outfit appropriate for FBLA-PBL? #FBLAoutfit");
        builder.show();
    }

    public void buttonOnClickOutfitFBLAdresscode(View v){
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Does this outfit follow the FBLA-PBL dress code? #FBLAoutfit");
        builder.show();

    }

    public void buttonOnClickFBLAhowtomakebetter(View v){
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("What should I do to make this outfit better? #FBLAoutfit");
        builder.show();
    }

    public void buttonOnClickStylish(View v){
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Does this outfit look stylish? #FBLAoutfit");
        builder.show();
    }

    public void buttonOnClickThoughts(View v){
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("What do you think about this outfit? #FBLAdress");
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post, menu);
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
}
