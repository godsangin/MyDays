package com.msproject.myhome.mydays;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;

public class UpdateCategoryDialog extends Dialog implements View.OnClickListener, ColorPickerDialogListener {
    private static final int LAYOUT = R.layout.dialog_update_category;
    private Context context;
    private EditText categoryEditText;
    private LinearLayout categoryColorSetectButton;
    private Button submitButton;
    private Button cancelButton;
    private String pickedColor;
    private static final int DIALOG_ID = 0;

    public UpdateCategoryDialog(Context context) {
        super(context);
        this.context = context;
    }

    public String getPickedColor() {
        return pickedColor;
    }

    public void setPickedColor(String pickedColor) {
        this.pickedColor = pickedColor;
        categoryColorSetectButton.setBackgroundColor(Color.parseColor("#" + pickedColor));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);


        categoryEditText = findViewById(R.id.category_edittext);
        categoryColorSetectButton = findViewById(R.id.color_selec_bt);
        submitButton = findViewById(R.id.submit_bt);
        cancelButton = findViewById(R.id.cancel_bt);

        submitButton.setOnClickListener(this);

        cancelButton.setOnClickListener(this);
        categoryColorSetectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit_bt://db업데이트

                break;
            case R.id.cancel_bt:
                dismiss();
                break;
            case R.id.color_selec_bt:

                ColorPickerDialog.Builder cp = ColorPickerDialog.newBuilder();
                cp.setDialogType(ColorPickerDialog.TYPE_CUSTOM);
                cp.setAllowPresets(false);
                cp.setColor(Color.BLACK);
                cp.setDialogId(DIALOG_ID);
                cp.setShowAlphaSlider(true);
                cp.show((Activity)context);

                break;
        }
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (dialogId){
            case DIALOG_ID:
                final int invertColor = ~color;
                final String hexColor = String.format("%X", color);
                final String hexInvertColor = String.format("%X", invertColor);
                if (BuildConfig.DEBUG) {
                    Log.d("color==", "id " + dialogId + " c: " + hexColor + " i:" + hexInvertColor);
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pickedColor = hexInvertColor;
                    }
                }).start();
                break;
        }

    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }
}
