package com.example.viraj.designlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textView.setText("On SnackBar Action clicked");
                            }
                        }).show();
            }
        });
    }

    public void goToMainView(MenuItem item) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void goToTab(MenuItem item) {
        startActivity(new Intent(this, TabActivity.class));
    }

    public void goToCollapsingToolbar(MenuItem item) {
        startActivity(new Intent(this, CollTB.class));
    }

    public void getToken(View view) {
        Token token = new Token(this);
        token.execute();

    }



    public class Token extends AsyncTask <Void, Void, String> {
        Context mContext;

        public Token(Context c) {
            this.mContext = c;
        }

        @Override
        protected String doInBackground(Void... params) {
            String registrationId = null;
            try {
                registrationId = InstanceID.getInstance(mContext).getToken("1024153867154", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return registrationId;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }

}
