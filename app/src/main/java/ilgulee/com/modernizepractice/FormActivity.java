package ilgulee.com.modernizepractice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }
    public static void startIntent(Context context){
        Intent intent = new Intent(context,FormActivity.class);
        context.startActivity(intent);
    }
}
