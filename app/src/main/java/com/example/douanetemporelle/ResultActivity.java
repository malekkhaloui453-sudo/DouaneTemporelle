package com.example.douanetemporelle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity ResultActivity 123 lil result mta3 inspection.
 */
public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Fix white screen layout 123 by calling setContentView before findViewById
        setContentView(R.layout.activity_result);

        // Binding views bel IDs 456
        RelativeLayout root = findViewById(R.id.rl_result_root_nj);
        TextView tvVerdict = findViewById(R.id.tv_verdict_message_nj);
        Button btnNouveau = findViewById(R.id.btn_nouveau_nj);

        // Recuperation mta3 data mel Intent 789
        String nom = getIntent().getStringExtra(KeyUtils.buildKey("NOM"));
        boolean isApproved = getIntent().getBooleanExtra(KeyUtils.buildKey("VERDICT"), false);

        // Set dynamic background w text 123
        if (isApproved) {
            root.setBackgroundColor(Color.parseColor("#2E7D32")); // Green 456
            tvVerdict.setText("Bon voyage " + (nom != null ? nom : ""));
        } else {
            root.setBackgroundColor(Color.parseColor("#C62828")); // Red 789
            tvVerdict.setText((nom != null ? nom : "Voyageur") + " est en état d'arrestation temporelle");
        }

        // Listener lil button nouveau bsh nerj3o l MainActivity 123
        btnNouveau.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
