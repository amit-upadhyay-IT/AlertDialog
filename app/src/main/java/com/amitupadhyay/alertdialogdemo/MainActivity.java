package com.amitupadhyay.alertdialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    AlertDialog.Builder builder;
    AlertDialog dialog;

    public void showAlertDialog()
    {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Please Confirm !");
        builder.setMessage("Do you want to exit?");

        builder.setPositiveButton("YES", this);
        builder.setNegativeButton("NO", this);

        dialog = builder.create();

        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i)
        {
            case DialogInterface.BUTTON_POSITIVE:
                finish();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                if (dialog.isShowing())
                    dialog.dismiss();
                break;
        }
    }
}
