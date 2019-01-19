package ilgulee.com.modernizepractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final View.OnClickListener listener =new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FormActivity.startIntent(getApplicationContext());
//            }
//        };
//        findViewById(R.id.coupe_button).setOnClickListener(listener);
//        findViewById(R.id.minivan_button).setOnClickListener(listener);
//        findViewById(R.id.bike_button).setOnClickListener(listener);
//        findViewById(R.id.sedan_button).setOnClickListener(listener);
//        findViewById(R.id.suv_button).setOnClickListener(listener);
//        findViewById(R.id.boat_button).setOnClickListener(listener);
//        findViewById(R.id.van_button).setOnClickListener(listener);
//        findViewById(R.id.truck_button).setOnClickListener(listener);
//        findViewById(R.id.other_button).setOnClickListener(listener);
    }
    public void onClick(View view){
        FormActivity.startIntent(getApplicationContext());
    }
}
