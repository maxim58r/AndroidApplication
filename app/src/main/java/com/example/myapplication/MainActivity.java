package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;
    TextView tvCheckboxMenu;
    CheckBox checkBoxMenu;

    private static final String TAG = "myLogs";

    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rlayout);

        Log.d(TAG, "найдем View-элементы");
        tvOut = findViewById(R.id.editText);
        btnOk = findViewById(R.id.ok);
        btnCancel = findViewById(R.id.cancel);
        tvCheckboxMenu = findViewById(R.id.textView);
        checkBoxMenu = findViewById(R.id.chbExtMenu);

        // присваиваем обработчик кнопкам
        Log.d(TAG, "присваиваем обработчик кнопкам");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        switch (view.getId()) {
            case R.id.ok:
                // кнопка ОК
                Log.d(TAG, "кнопка ОК");
                tvOut.setText("Нажата кнопка ОК");
                Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                // кнопка Cancel
                Log.d(TAG, "кнопка Cancel");
                tvOut.setText("Нажата кнопка Cancel");
                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.group1, checkBoxMenu.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }
    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "past");
        menu.add(1, 6, 4, "exit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(1, checkBoxMenu.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        StringBuilder sb = new StringBuilder();
        sb.append("Item Menu");
        sb.append("\r\n groupId: ").append(String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: ").append(String.valueOf(item.getItemId()));
        sb.append("\r\n order: ").append(String.valueOf(item.getOrder()));
        sb.append("\r\n title: ").append(item.getTitle());
        tvCheckboxMenu.setText(sb.toString());

        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }*/
}