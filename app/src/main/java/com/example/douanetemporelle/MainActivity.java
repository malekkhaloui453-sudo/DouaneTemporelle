package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Views lil UI 123
    private EditText etNomNj;
    private EditText etBirthNj;
    private EditText etDestNj;
    private RadioGroup rgMotifNj;
    private Button btnInspecterNj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_nj), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Binding views bel IDs el jdida 123
        etNomNj = findViewById(R.id.et_nom_nj);
        etBirthNj = findViewById(R.id.et_birth_nj);
        etDestNj = findViewById(R.id.et_dest_nj);
        rgMotifNj = findViewById(R.id.rg_motif_nj);
        btnInspecterNj = findViewById(R.id.btn_inspecter_nj);

        // Event listener lil button inspecter 456
        btnInspecterNj.setOnClickListener(v -> {
            // Extraction el nom 123
            String nom = etNomNj.getText().toString().trim();

            // Extraction birth year int 456
            String birthStr = etBirthNj.getText().toString().trim();
            int birthYear = 0;
            try {
                birthYear = Integer.parseInt(birthStr);
            } catch (NumberFormatException ignored) {
            }

            // Extraction destination year int 789
            String destStr = etDestNj.getText().toString().trim();
            int destYear = 0;
            try {
                destYear = Integer.parseInt(destStr);
            } catch (NumberFormatException ignored) {
            }

            // Extraction selected motif string 123
            String motif = "";
            int selectedId = rgMotifNj.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton rbSelected = findViewById(selectedId);
                if (rbSelected != null) {
                    motif = rbSelected.getText().toString();
                }
            }

            // Intent explicite 123 bsh nemshiw l VerificationActivity
            Intent intent = new Intent(MainActivity.this, VerificationActivity.class);

            // Passing data bel keyUtils buildKey 456
            intent.putExtra(KeyUtils.buildKey("NOM"), nom);
            intent.putExtra(KeyUtils.buildKey("BIRTH"), birthYear);
            intent.putExtra(KeyUtils.buildKey("DEST"), destYear);
            intent.putExtra(KeyUtils.buildKey("MOTIF"), motif);

            // Lance el activity 789
            startActivity(intent);
        });
    }
}
