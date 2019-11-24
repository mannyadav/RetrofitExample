package com.mann.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mann.retrofitexample.Class.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
    private TextView mLog;
    MyWebService mWebService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
        mWebService = MyWebService.retrofit.create(MyWebService.class);
        getPosts();
    }
//    public void run(View view){
//
//        getPosts();
////        getComments();
//    }

//    private void getComments() {
//        Call<List<Comment>> call = mWebService.getComments(3);
//        call.enqueue(new Callback<List<Comment>>() {
//            @Override
//            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
//                if (response.isSuccessful()){
//                    showComments(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Comment>> call, Throwable t) {
//
//            }
//        });
//    }

//    private void showComments(List<Comment> body) {
//        for (Comment comment: body){
//            mLog.append("id :"+comment.getId()+ "\n");
//            mLog.append("postId :"+comment.getPostId()+ "\n");
//            mLog.append("name :"+comment.getName()+ "\n");
//            mLog.append("body :"+comment.getBody()+ "\n");
//            mLog.append("email :"+comment.getEmail()+ "\n\n");
//
//
//        }
//    }

    private void getPosts() {
        Call<List<Model>> call = mWebService.getPosts();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()){
                    for (Model model: response.body()){
                        showPost(model);

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }

    private void showPost(Model model) {
        mLog.append("userId: "+model.getUserId()+"\n");
        mLog.append("id: "+model.getId()+"\n");
        mLog.append("title: "+model.getTitle()+"\n");
        mLog.append("body: "+model.getBody()+"\n\n");


    }


    private void intiView() {
        mLog = findViewById(R.id.textView);
    }

    public void clear(View view) {

    }
}
