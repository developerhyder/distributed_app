package example.example.com.supply_chain;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class fourth extends AppCompatActivity {
Button prod_info , add_block;
    public static int counter,count = 0;
    private static Handler handler = new Handler();
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        prod_info = (Button)findViewById(R.id.pro);
        add_block = (Button)findViewById(R.id.block);
        tv = (TextView)findViewById(R.id.textVie);
        prod_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the code for the product info use cons.data as that is the output for the qr code
                count++;
                posting_the_data();
            }
        });
        add_block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the data along with the response in order to add a block to the ledger
                startActivity(new Intent(fourth.this,add_block.class));
                finish();
            }
        });
    }
    private void posting_the_data() {
        if (count == 1){
            //bug solved!!!!
            cons.product_information = "";
            new Thread(new Runnable() {
                public void run() {
                    while (counter < 100) {
                        counter += 1;
                        // Update the progress bar and display the
                        //current value in the text view
                        handler.post(new Runnable() {
                            public void run() {
                                tv.setText(counter + "/" + 100);
                                web.scrape("","",2);
                            }
                        });
                        try {
                            // Sleep for 600 milliseconds.
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (cons.product_information!="") {
                            counter = 0;
                            count = 0;
                            startActivity(new Intent(fourth.this,product.class));
                            finish();
                            break;
                        }
                    }

                }
            }).start();
        }

    }

}
