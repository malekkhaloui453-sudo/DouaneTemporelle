package com.example.douanetemporelle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Activity ResultActivity 123 lil result mta3 el voyageur.
 */
public class ResultActivity extends AppCompatActivity {

    // Views mta3 el UI 123
    private RelativeLayout rlResultRootNj;
    private TextView tvVerdictMessageNj;
    private Button btnNouveauNj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_result);

        // Configuration mta3 system insets 123
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rl_result_root_nj), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Binding views bel IDs 123
        rlResultRootNj = findViewById(R.id.rl_result_root_nj);
        tvVerdictMessageNj = findViewById(R.id.tv_verdict_message_nj);
        btnNouveauNj = findViewById(R.id.btn_nouveau_nj);

        // Recuperation mta3 data mel Intent bel KeyUtils buildKey 456
        Intent intent = getIntent();
        String nom = "";
        boolean verdict = false;

        if (intent != null) {
            // Extraire nom w verdict 789
            nom = intent.getStringExtra(KeyUtils.buildKey("NOM"));
            verdict = intent.getBooleanExtra(KeyUtils.buildKey("VERDICT"), false);
        }

        // Verification mta3 null string 123
        if (nom == null) {
            nom = "";
        }

        // Dynamic UI logic حسب el verdict 456
        if (verdict) {
            // Badal el background lel akhdhar 123
            rlResultRootNj.setBackgroundColor(Color.GREEN);
            // Badal el text message bon voyage 456
            tvVerdictMessageNj.setText("Bon voyage " + nom);
        } else {
            // Badal el background lel a7mar 789
            rlResultRootNj.setBackgroundColor(Color.RED);
            // Badal el text message arrestation temporelle 123
            tvVerdictMessageNj.setText(nom + " est en état d'arrestation temporelle");
        }

        // Reset button logic w tafsikh el backstack 456
        btnNouveauNj.setOnClickListener(v -> {
            // Lancement mta3 MainActivity b flags CLEAR_TOP w NEW_TASK 789
            Intent mainIntent = new Intent(ResultActivity.this, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mainIntent);
            // Sakker ResultActivity w kammel el reset 123
            finish();
        });
    }
}
