package com.example.eschild.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eschild.R;
import com.example.eschild.model.users.UserSession;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 3005;
    Animation topAnimation;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notification();
        getWindow().setFlags(View.SYSTEM_UI_FLAG_FULLSCREEN,View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.animation_top);
        image.setAnimation(topAnimation);
        //text.setText("Type du cour");
        //getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                try{
                    if(UserSession.getSession(MainActivity.this) != null)
                        intent = new Intent(MainActivity.this, HomeActivity.class);
                }
                catch (Exception e){
//                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                }
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }


    public void notification(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notification_channel", "notification_channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("general")
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    String msg = "Subscribed Successfully";
                    if (!task.isSuccessful()) {
                        msg = "Subscription failed";
                    }
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            });
    }

}
