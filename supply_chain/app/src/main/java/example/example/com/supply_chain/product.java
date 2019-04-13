package example.example.com.supply_chain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class product extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        tv = (TextView)findViewById(R.id.textprod);
        //wprk on removal of all the junk pieces of data like <th>
        cons.product_information=cons.product_information.replace("<th>","");
        cons.product_information=cons.product_information.replace("</th>","");
        cons.product_information=cons.product_information.replace("<table>","");
        cons.product_information=cons.product_information.replace("</table>","");
        cons.product_information=cons.product_information.replace("<tbody>","");
        cons.product_information=cons.product_information.replace("<body>","");
        cons.product_information=cons.product_information.replace("<tr>","");
        cons.product_information=cons.product_information.replace("</tr>","");
        cons.product_information=cons.product_information.replace("</body>","");
        cons.product_information=cons.product_information.replace("</tbody>","");
        tv.setText(cons.product_information);
    }
}
