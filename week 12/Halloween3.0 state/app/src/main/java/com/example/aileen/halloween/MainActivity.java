package com.example.aileen.halloween;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String message;
    private TextView booText;
    private ImageView ghost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        booText = (TextView)findViewById(R.id.message);
        ghost = (ImageView) findViewById(R.id.imageView);

        // recovering the instance state
        if (savedInstanceState !=null){
            message = savedInstanceState.getString("msg");
            int image_id = savedInstanceState.getInt("imageid");

            booText.setText(message);
            ghost.setImageResource(image_id);
        }
    }

    public void sayBoo(View view) {
        EditText name = (EditText)findViewById(R.id.editText);
        String nameValue = name.getText().toString();
        message = "Happy Halloween " + nameValue + " !";
        booText.setText(message);
        ghost.setImageResource(R.drawable.ghost);
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("msg", message);
        outState.putInt("imageid", R.drawable.ghost);

        super.onSaveInstanceState(outState);
    }
}
