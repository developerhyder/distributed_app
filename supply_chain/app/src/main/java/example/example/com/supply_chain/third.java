package example.example.com.supply_chain;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class third extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third);
            if (cons.response.equals("")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        third.this);
                builder.setCancelable(false);
                builder.setTitle("Alert !!!");
                builder.setMessage("Looks like we are having a network issue please try again later");
                builder.setPositiveButton("Try Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                finish();
                            }
                        });
                builder.show();

            } else if (cons.response.equals("nope")) {

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        third.this);
                builder.setCancelable(false);
                builder.setTitle("Alert !!!");
                builder.setMessage("Looks like you have typed wong credentials , please retry!!");
                builder.setPositiveButton("Try Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                startActivity(new Intent(third.this,MainActivity.class));
                                finish();
                            }
                        });
                builder.show();
            } else {//ctrl+o
                // textView.setText(con.latitude+" "+con.longitude);
                Toast.makeText(getApplicationContext(),cons.response,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(third.this, scan.class));
                finish();
            }
        }
        @Override
        public void onBackPressed() {

            super.onBackPressed();
        }
    }
