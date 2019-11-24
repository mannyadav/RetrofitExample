package com.mann.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {
    private TextView mLog;
    private ImageView photo,photo1;
    MyWebService mWebService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        intiView();
        photo = (ImageView) findViewById(R.id.photo);
        mWebService = MyWebService.retrofit.create(MyWebService.class);
        getPhotos();



    }


    private void getPhotos() {
        Call<List<Photo>> call = mWebService.getPhoto();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()){
                    for (Photo model: response.body()){
                        showPost(model);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }
    private void showPost(Photo model) {
        mLog.append("albumId: "+model.getAlbumId()+"\n");
        mLog.append("id: "+model.getId()+"\n");
        mLog.append("title: "+model.getTitle()+"\n");
        mLog.append("url: "+model.getUrl()+"\n");
        mLog.append("thumbnailUrl: "+model.getThumbnailUrl()+"\n\n");
        Picasso.get().load(model.getUrl()
        ).into(photo);
        Picasso.get().load(model.getUrl()
        ).into(photo1);

    }

    private void intiView()
    {
        mLog = findViewById(R.id.textView);
        photo = findViewById(R.id.photo);
        photo1 = findViewById(R.id.photo1);


    }

    public void clear(View view) {

    }
}
