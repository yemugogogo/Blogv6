package com.example.jingjing.blogv6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class tabd extends RelativeLayout {
    private Button button;
    private Context myContext;
    private View view01;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button button2;
    ListView mybloglist;
    List<myblog> myblog;

    public tabd(Context context) {
        super(context);
        myContext = context;
        view01 = LayoutInflater.from(myContext).inflate(R.layout.tabd, null);
        addView(view01);

        button = (Button)findViewById(R.id.button);
        //button2= (Button)findViewById(R.id.button2);
        myblog=new ArrayList<>();
        mybloglist=(ListView)findViewById(R.id.mybloglist);



                db.collection("Blog_test1")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (DocumentSnapshot document : task.getResult()) {
                                        Log.d("itspeter", document.getId() + " => " + document.getData());
                                        JSONObject tmpJsonobj = new JSONObject(document.getData());
                                        // Convert to Movie class
                                        try {
                                            myblog blogs = new myblog(
                                                    "名字"+tmpJsonobj.getString("name"),
                                                    "標題"+tmpJsonobj.getString("title"),
                                                    "文章"+tmpJsonobj.getString("article"),
                                                    "熱度"+tmpJsonobj.getString("like"));
                                            myblog.add(blogs);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        ArrayAdapter adapter = new Bloglist_myblog((Activity) myContext, myblog);
                                        mybloglist.setAdapter(adapter);
                                    }
                                } else {
                                    Log.w("itspeter", "Error getting documents.", task.getException());
                                }
                            }
                        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openest();
                Log.e("ooo", "onClick registered for tabd class");
            }
        });
    }

    public void openest() {
        Log.e("kkk", "Button clicked");
        //removeAllViews();
        //addView(view02);

        Intent intent = new Intent(myContext, test.class);
        myContext.startActivity(intent);
        //button.setText("I'm clicked!");
    }
}

class tabd1 extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button button2;
    ListView mybloglist;
    List<myblog> myblog;
    Context myContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabd);


    }
}
