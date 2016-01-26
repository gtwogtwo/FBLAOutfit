package com.caleb.fbladress;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.view.View;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetViewAdapter;

import java.util.List;

public class SearchActivity extends ActionBarActivity{



    //search setup
    private static String Search_query = "#FBLAoutfit";
    private TweetViewAdapter adapter;
    private static final String Search_result_type = "recent";
    private static final int Search_count = 20;

    ListView SearchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        adapter = new TweetViewAdapter(SearchActivity.this);
        SearchList = (ListView) findViewById(R.id.tweet_search);
        SearchList.setAdapter(adapter);
        SearchList.setEmptyView(findViewById(R.id.loading));

        //run search
        final SearchService service = Twitter.getApiClient().getSearchService();
        service.tweets(Search_query, null, null, null, Search_result_type, Search_count, null, null, null,
                true, new Callback<Search>() {
                    @Override
                    public void success(Result<Search> result) {
                        setProgressBarIndeterminateVisibility(false);//end loading
                        final List<Tweet> tweets = result.data.tweets;//get tweets
                        adapter.getTweets().addAll(tweets);//add tweets to list
                        adapter.notifyDataSetChanged();//update list
                    }

                    @Override
                    public void failure(TwitterException e) {
                        setProgressBarIndeterminateVisibility(false);//end loading
                        Toast.makeText(SearchActivity.this, "Failed to load", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void buttonOnClickPost(View v){
        startActivity(new Intent(SearchActivity.this, PostActivity.class));//start post activity
    }


    public void buttonOnClickRefresh(View v){
        recreate();// restart the activity
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
