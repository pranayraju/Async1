package com.example.pranay.async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button but;
ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb= (ProgressBar)findViewById(R.id.progr);
        but=(Button)findViewById(R.id.btn);
        but.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {

            case R.id.btn:

      new AsyncOperation().execute("");
                break;
        }
    }

    private class AsyncOperation extends AsyncTask<String,Void, String>
    {

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return "Interrupted";
            }
            return "cool";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.output);
           pb.setVisibility(View.GONE);
            txt.setText(result);
        }
        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}


        }

    }


