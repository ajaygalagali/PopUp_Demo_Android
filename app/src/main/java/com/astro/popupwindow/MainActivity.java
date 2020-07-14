package com.astro.popupwindow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void PopUpClicked(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("I am a popup");
        alert.setMessage("I am a popupwindow by alertdialouge buider");
        final EditText editText = new EditText(this);
        editText.setHint("Enter something...");
        alert.setView(editText);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, String.valueOf(editText.getText()), Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();


    }

    public void popupLayoutClicked(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);


        final View popupView = getLayoutInflater().inflate(R.layout.popup,null);
        editText = popupView.findViewById(R.id.editTextTextPersonName);
        button = popupView.findViewById(R.id.toastBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(editText.getText()), Toast.LENGTH_SHORT).show();

            }
        });

        alert.setView(popupView);
        alert.show();


    }

    public void puWindowClicked(View view) {
        final PopupWindow popupWindow;
        final View popupView = getLayoutInflater().inflate(R.layout.popup,null);
        popupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setAnimationStyle(android.R.style.Animation_Translucent);
        popupWindow.setBackgroundDrawable(this.getDrawable(R.drawable.pop_bg));

        popupWindow.setElevation(43);
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        editText = popupView.findViewById(R.id.editTextTextPersonName);
        button = popupView.findViewById(R.id.toastBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(editText.getText()), Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

    }

    public void dialogClicked(View view) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup);
        button = dialog.findViewById(R.id.toastBtn);
        editText = dialog.findViewById(R.id.editTextTextPersonName);

//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(editText.getText()), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}