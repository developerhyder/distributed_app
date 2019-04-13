package example.example.com.supply_chain;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class add_block extends AppCompatActivity {
EditText edn, eda,edq,edp,edd;
TextView tv;
Button b1;
    public static int counter,count = 0,anim_c=0;
    private static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_block);
        b1 = (Button)findViewById(R.id.button2);
        edn = (EditText)findViewById(R.id.name);
        eda = (EditText)findViewById(R.id.address);
        edq = (EditText)findViewById(R.id.quantity);
        edp = (EditText)findViewById(R.id.ppu);
        edd = (EditText)findViewById(R.id.dat);
        tv = (TextView)findViewById(R.id.textView2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                somemethod();
            }
        });
    }
    private void posting_the_data() {
        if (count == 1){
//            //bug solved!!!!
            cons.success="";
            new Thread(new Runnable() {
                public void run() {
                    while (counter < 100) {
                        counter += 1;
//                        // Update the progress bar and display the
                        //current value in the text view
                        handler.post(new Runnable() {
                            public void run() {
                                tv.setText(counter+"/"+100);
                                web.scrape("","",1);
                            }
                        });
                        try {
                            // Sleep for 600 milliseconds.
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (cons.success!="") {
                            counter = 0;
                            count = 0;
                            startActivity(new Intent(add_block.this, sixth.class));
                            finish();
                            break;
                        }
                    }

                }
            }).start();
        }

    }
    private void somemethod() {
        cons.nam = edn.getText().toString();
        cons.addr = eda.getText().toString();
        cons.pp = edp.getText().toString();
        cons.qua = edq.getText().toString();
        cons.dat = edd.getText().toString();
        if(cons.nam.equals("")){
            edn.setError("please fill the name");
            edn.setFocusable(true);
        }else if(cons.addr.equals("")){
            eda.setError("please enter the address");
            eda.setFocusable(true);
        }else if (cons.pp.equals("")){
            edp.setError("please enter the ppu");
            edp.setFocusable(true);
        }else if (cons.qua.equals("")){
            edq.setError("please enter the quantity");
            edq.setFocusable(true);
        }else if (cons.dat.equals("")){
            edd.setError("please enter the date");
            edd.setFocusable(true);
        }
        else{
            //do the action which is u need to do
//            Toast.makeText(getApplicationContext(),"done dona done",Toast.LENGTH_SHORT).show();
            count++;
            posting_the_data();
           // handler.postDelayed(update,1000);

        }
    }

}
