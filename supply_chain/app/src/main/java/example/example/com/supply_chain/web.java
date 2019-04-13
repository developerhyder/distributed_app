package example.example.com.supply_chain;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class web {
    static String TAG = "RUN";
    public static void scrape(final String username, final String password,final int choice){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (choice == 0) {
                        String url = "https://developerhyder.000webhostapp.com/patent_db/authenticate.php?username="+username+"&password="+password;
                        Document doc = Jsoup.connect(url).get();
                        cons.response = doc.title();
                    }else if(choice == 1){
                        //add bc1.php basically for adding the block
                        if (cons.success.equals("")){
                            String url = cons.response + "bc1.php?pid="+cons.data+"&name="+cons.nam+"&quan="+cons.qua+"&addr="+cons.addr+"&ppu="+cons.pp+"&date="+cons.dat;
                            Document doc = Jsoup.connect(url).get();
                            cons.success = doc.body().toString();
                            Log.d(TAG, "lemme: "+cons.success);
                        }
                    }else if (choice == 2){
                        //add qr1.php and pass the product id as well here you will view the ledger use the body of the webpage
                        String url = cons.response + "qr1.php?pid="+cons.data;
                        Log.d(TAG, "run: "+url);
                        Document doc = Jsoup.connect(url).get();
                        cons.product_information = doc.body().toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
