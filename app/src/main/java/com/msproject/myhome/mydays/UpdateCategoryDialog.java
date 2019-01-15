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

public class UpdateCategoryDialog extends Dialog implements View.OnClickListener{
    private static final int LAYOUT = R.layout.dialog_update_category;
    private Context context;
    private EditText categoryEditText;
    private LinearLayout categoryColorSetectButton;
    private Button submitButton;
    private Button cancelButton;
    private String pickedColor;
    private static final int DIALOG_ID = 0;

    private MyDialogListener dialogListener;
    private boolean isModify;//ture이면 버튼을 수정으로 변경, textView를 readOnly로!
    private int modifyIndex;
    private Category modifyCategory;

    public UpdateCategoryDialog(Context context) {
        super(context);
        this.context = context;
        this.pickedColor = "#567789";
    }

    public UpdateCategoryDialog(Context context, Category category, int index){//수정인지 판별 필요
        super(context);
        this.context = context;
        this.isModify = true;
        this.modifyIndex = index;
        this.modifyCategory = category;
    }

    public String getPickedColor() {
        return pickedColor;
    }

    public void setPickedColor(String pickedColor) {
        this.pickedColor = pickedColor;
        categoryColorSetectButton.setBackgroundColor(Color.parseColor(this.pickedColor));
    }

    public void setDialogListener(MyDialogListener myDialogListener){
        this.dialogListener = myDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        categoryEditText = findViewById(R.id.category_edittext);
        categoryColorSetectButton = findViewById(R.id.color_selec_bt);
        submitButton = findViewById(R.id.submit_bt);
        cancelButton = findViewById(R.id.cancel_bt);

        if(isModify){
            submitButton.setText("수정");
            categoryEditText.setText(modifyCategory.getCategoryName());
            categoryEditText.setEnabled(false);
            setPickedColor(modifyCategory.getColor());
        }
        submitButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
        categoryColorSetectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit_bt://db업데이트
                String categoryName = categoryEditText.getText().toString();
                if(categoryName.equals("")){
                    Toast.makeText(context, "카테고리의 이름을 입력해주세요.", Toast.LENGTH_SHORT);
                    return;
                }
                if(isModify){

                    dialogListener.onModifyClicked(new Category(categoryName, pickedColor), modifyIndex);
                }
                else{

                    dialogListener.onPostClicked(new Category(categoryName, pickedColor));
                }
                dismiss();
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

}
