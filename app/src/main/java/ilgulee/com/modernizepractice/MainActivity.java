package ilgulee.com.modernizepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final public static int FORM_REQUEST_CODE = 1;
    final public static String KEY_AUTOMOBILE = "key_automobile";
    final public static String SAVE_STATE_KEY = "key_saved_instance_state";
    private RecyclerView mRecyclerView;
    private AutomobileRecyclerAdapter mAdapter;
    private ArrayList<Automobile> automobiles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new AutomobileRecyclerAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        if (savedInstanceState != null) {
            this.automobiles = savedInstanceState.getParcelableArrayList(SAVE_STATE_KEY);
            mAdapter.updateData(this.automobiles);
        }
    }
    public void onClick(View view){
        Intent intent = new Intent(this, FormActivity.class);
        startActivityForResult(intent, FORM_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == FORM_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Automobile automobile = data.getParcelableExtra(KEY_AUTOMOBILE);
                addAutomobileToList(automobile);
            }
        }
    }

    private void addAutomobileToList(Automobile automobile) {
        automobiles.add(automobile);
        mAdapter.addAutomobile(automobile);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(SAVE_STATE_KEY, automobiles);
        super.onSaveInstanceState(outState);
    }
}
