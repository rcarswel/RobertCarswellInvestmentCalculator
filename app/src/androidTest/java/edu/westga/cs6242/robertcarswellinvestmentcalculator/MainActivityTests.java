package edu.westga.cs6242.robertcarswellinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    private EditText periodicPaymentText;
    private EditText ratePerPeriodText;
    private EditText periodsText;
    private Button futureValueButton;
    private TextView futureValueMessage;

    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testCalculate() {
        MainActivity activity = getActivity();
        setupScenario(activity);

        sendValue(periodicPaymentText, "1000");
        sendValue(ratePerPeriodText, "0.03");
        sendValue(periodsText, "10");

        // Tap "Future Value" button
        TouchUtils.clickView(this, futureValueButton);

        // Verify future value message
        String actualText = futureValueMessage.getText().toString();
        assertEquals("$11,463.88", actualText);
    }

    public void testNoPayment() {
        MainActivity activity = getActivity();
        setupScenario(activity);

        sendValue(ratePerPeriodText, "0.03");
        sendValue(periodsText, "10");

        // Tap "Future Value" button
        TouchUtils.clickView(this, futureValueButton);

        // Verify future value message
        String actualText = futureValueMessage.getText().toString();
        assertEquals("Not Calculated Yet!", actualText);
    }

    public void testNoRate() {
        MainActivity activity = getActivity();
        setupScenario(activity);

        sendValue(periodicPaymentText, "1000");
        sendValue(periodsText, "10");

        // Tap "Future Value" button
        TouchUtils.clickView(this, futureValueButton);

        // Verify future value message
        String actualText = futureValueMessage.getText().toString();
        assertEquals("Not Calculated Yet!", actualText);
    }

    public void testNoPeriod() {
        MainActivity activity = getActivity();
        setupScenario(activity);

        sendValue(periodicPaymentText, "1000");
        sendValue(ratePerPeriodText, "0.03");

        // Tap "Future Value" button
        TouchUtils.clickView(this, futureValueButton);

        // Verify future value message
        String actualText = futureValueMessage.getText().toString();
        assertEquals("Not Calculated Yet!", actualText);
    }

    private void setupScenario(MainActivity activity) {
        this.periodicPaymentText = (EditText) activity.findViewById(R.id.periodicPayment_edit_text);
        this.ratePerPeriodText = (EditText) activity.findViewById(R.id.ratePerPeriod_edit_text);
        this.periodsText = (EditText) activity.findViewById(R.id.periods_edit_text);
        this.futureValueButton = (Button) activity.findViewById(R.id.futureValue_button);
        this.futureValueMessage = (TextView) activity.findViewById(R.id.message_text_view);
    }

    private void sendValue(final EditText editText, final String value) {
        // Send string input value
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync(value);
        getInstrumentation().waitForIdleSync();
    }
}