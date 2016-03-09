package edu.westga.cs6242.robertcarswellinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import edu.westga.cs6242.robertcarswellinvestmentcalculator.Model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void didTapFutureValueButton(View view) {
        EditText periodicPaymentText = (EditText) findViewById(R.id.periodicPayment_edit_text);
        EditText ratePerPeriodText = (EditText) findViewById(R.id.ratePerPeriod_edit_text);
        EditText periodsText = (EditText) findViewById(R.id.periods_edit_text);

        double payment = Double.parseDouble(periodicPaymentText.getText().toString());
        double rate = Double.parseDouble(ratePerPeriodText.getText().toString());
        int periods = Integer.parseInt(periodsText.getText().toString());

        InvestmentCalculator investmentCalculator = new InvestmentCalculator(payment, rate, periods);
        double fValue = investmentCalculator.getFutureValue();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String value = formatter.format(fValue);

        TextView messageTextView = (TextView) findViewById(R.id.message_text_view);
        messageTextView.setText(value);
    }
}
