package com.example.parcial1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReserveFieldActivity extends AppCompatActivity {

    private String fieldName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_field_activity);

        fieldName = getIntent().getStringExtra("fieldName");
        TextView fieldNameTextView = findViewById(R.id.fieldNameTextView);
        fieldNameTextView.setText(fieldName);

        Button reserveButton = findViewById(R.id.reserveButton);
        reserveButton.setOnClickListener(v -> reserveField());
    }

    private void reserveField() {
        // Aquí puedes agregar la lógica para guardar la reserva en la base de datos SQLite.
        SQLiteDatabase db = new DBHelper(this).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fieldName", fieldName);
        long newRowId = db.insert("reservations", null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Reserva realizada exitosamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al realizar la reserva", Toast.LENGTH_SHORT).show();
        }
    }
}
