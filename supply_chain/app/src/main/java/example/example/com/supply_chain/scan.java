package example.example.com.supply_chain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scan extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }
    @Override
    public void handleResult(Result result) {
        cons.data=result.getText();
        startActivity(new Intent(scan.this,fourth.class));
        finish();
    }

    @Override
    protected void onPause() {

        super.onPause();

        scannerView.stopCamera();
    }

    @Override
    protected void onResume() {

        super.onResume();

        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
