package com.example.retrofit_demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_demo.api.MyRetroClient;
import com.example.retrofit_demo.model.GithubFollowersPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//helps the Url and set the headerr method
public class MainActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        getFollowers();
    }

    private void getFollowers()
    {
        MyRetroClient.api.getFollowers("akshaysingh5").enqueue(new Callback<List<GithubFollowersPojo>>() {
            @Override
            public void onResponse(Call<List<GithubFollowersPojo>> call, Response<List<GithubFollowersPojo>> response) {
                List<GithubFollowersPojo> list = response.body();
                Log.d("list_size",list+"");
                txt.setText(list.size()+"");
                Toast.makeText(MainActivity.this, list.size()+"", Toast.LENGTH_SHORT).show();

                            }

            @Override
            public void onFailure(Call<List<GithubFollowersPojo>> call, Throwable t) {
                txt.setText("error :"+t.getMessage());
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
