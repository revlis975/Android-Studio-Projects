

/**
 * IMPORTANT: Make sure you are using the correct package name.
 import androidx.appcompat.app.AppCompatActivity; * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package android.example.com;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int q=0;
    public void submitOrder(View view)
    {
//        EditText nm = findViewById(R.id.nameInp);
//        String name = nm.getText().toString();
        boolean isCheckedWC = ((CheckBox) findViewById(R.id.WCcheckBox)).isChecked();
        boolean isCheckedChoco = ((CheckBox) findViewById(R.id.ChocolatecheckBox)).isChecked();
        int price = q*10;
        price = isCheckedWC? price+1:price;
        price = isCheckedChoco? price+1:price;
        displayName();
        displayFinalQuan(q, isCheckedWC, isCheckedChoco);
        displayMessage("Total : ₹"+price+"\n"+"Have a nice day :)");

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for "+name);
//        intent.putExtra(Intent.EXTRA_TEXT, "You get the idea right?");
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number)
    {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    private void displayFinalQuan(int number, boolean a, boolean b)
    {
        TextView finalquan = findViewById(R.id.quan);
        finalquan.setText("Add whipped cream? "+a+"\n"+"Add chocolate? "+b+"\n"+"Quantity : "+number);
    }

    public void displayName()
    {
        EditText nm = findViewById(R.id.nameInp);
        TextView nameDisp = findViewById(R.id.name);
        String name = nm.getText().toString();
        nm.clearFocus();
        nameDisp.setText("Name : "+name);
    }

    /**
     * This method displays the given price on the screen.
     */

    public void decrement(View view)
    {
        q = q-1;
        if(q<0)
            q=0;
        displayQuantity(q);
    }

    public void increment(View view)
    {

        displayQuantity(++q);
    }

    /**
     * This method displays the given text on the screen.
     */
    public void displayMessage(String message)
    {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
