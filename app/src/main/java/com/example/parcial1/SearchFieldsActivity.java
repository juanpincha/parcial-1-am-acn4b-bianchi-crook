package com.example.parcial1;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class SearchFieldsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_fields_activity);

        RecyclerView fieldsRecyclerView = findViewById(R.id.fieldsRecyclerView);
        fieldsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> fieldList = Arrays.asList("Cancha 1", "Cancha 2", "Cancha 3", "Cancha 4", "Cancha 5");
        FieldAdapter adapter = new FieldAdapter(fieldList, this::onFieldClick);
        fieldsRecyclerView.setAdapter(adapter);
    }

    private void onFieldClick(String fieldName) {
        Intent intent = new Intent(this, ReserveFieldActivity.class);
        intent.putExtra("fieldName", fieldName);
        startActivity(intent);
    }
}

