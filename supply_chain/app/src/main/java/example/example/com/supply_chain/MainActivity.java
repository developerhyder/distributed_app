package example.example.com.supply_chain;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b,b2;
    TextView tv;
    EditText ed1,ed2;
    String username,password;
    public static int counter,count = 0,anim_c=0;
    private static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.editText1);
        ed2 = (EditText)findViewById(R.id.editText2);
        b = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.but1);
        tv = (TextView)findViewById(R.id.tex);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodee();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void posting_the_data() {
        if (count == 1){
            //bug solved!!!!
            cons.response = "";
            new Thread(new Runnable() {
                public void run() {
                    while (counter < 100) {
                        counter += 1;
                        // Update the progress bar and display the
                        //current value in the text view
                        handler.post(new Runnable() {
                            public void run() {
                                tv.setText(counter+"/"+100);
                                web.scrape(username,password,0);
                            }
                        });
                        try {
                            // Sleep for 600 milliseconds.
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (cons.response!="") {
                            counter = 0;
                            count = 0;
                            startActivity(new Intent(MainActivity.this, third.class));
                            finish();
                            break;
                        }
                    }

                }
            }).start();
        }
    }

    private void methodee() {
        username = ed1.getText().toString();
        password = ed2.getText().toString();
        if(username.equals("")){
            ed1.setError("please fill the username");
            ed1.setFocusable(true);
        }else if(password.equals("")){
            ed2.setError("please enter the password");
            ed2.setFocusable(true);
        }else{
            //do the action which is u need to do
            count++;
            posting_the_data();
        }

    }

}
