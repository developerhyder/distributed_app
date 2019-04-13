package example.example.com.supply_chain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class sixth extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        Toast.makeText(getApplicationContext(),cons.success,Toast.LENGTH_SHORT).show();
        tv = (TextView)findViewById(R.id.textView);
        tv.setText(cons.success);
    }
}
