package ilgulee.com.modernizepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    EditText editMaker;
    EditText editModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editMaker = findViewById(R.id.edit_maker);
        editModel = findViewById(R.id.edit_model);

        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maker = editMaker.getText().toString();
                String model = editModel.getText().toString();
                Automobile automobile = new Automobile(maker, model);
                Intent intent = new Intent();
                intent.putExtra(MainActivity.KEY_AUTOMOBILE, automobile);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

//    public static void startIntent(Context context){
//        Intent intent = new Intent(context,FormActivity.class);
//        context.startActivity(intent);
//    }

}
