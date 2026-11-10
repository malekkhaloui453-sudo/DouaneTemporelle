package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Activity VerificationActivity 123 lil verification mta3 data w paradoxe.
 */
public class VerificationActivity extends AppCompatActivity {

    // Views mta3 el UI 123
    private TextView tvSummaryNj;
    private Button btnApprouverNj;
    private Button btnRefuserNj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_verification);

        // Configuration mta3 system insets 123
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ll_verification_nj), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Binding views bel IDs 456
        tvSummaryNj = findViewById(R.id.tv_summary_nj);
        btnApprouverNj = findViewById(R.id.btn_approuver_nj);
        btnRefuserNj = findViewById(R.id.btn_refuser_nj);

        // Recuperation mta3 data mel Intent bel KeyUtils buildKey 789
        Intent intent = getIntent();
        String nom = "";
        int birthYear = 0;
        int destinationYear = 0;
        String motif = "";

        if (intent != null) {
            // Extraire nom w birth w dest w motif 123
            nom = intent.getStringExtra(KeyUtils.buildKey("NOM"));
            birthYear = intent.getIntExtra(KeyUtils.buildKey("BIRTH"), 0);
            destinationYear = intent.getIntExtra(KeyUtils.buildKey("DEST"), 0);
            motif = intent.getStringExtra(KeyUtils.buildKey("MOTIF"));
        }

        // Verification mta3 null strings 456
        if (nom == null) {
            nom = "";
        }
        if (motif == null) {
            motif = "";
        }

        // Hseb el age gap bin destinationYear w birthYear 123
        int ageGap = Math.abs(destinationYear - birthYear);

        // Affichage mta3 summary fi tv_summary_nj fih Name w Age Gap w Motif 456
        String summary = "Nom: " + nom + "\nAge Gap: " + ageGap + "\nMotif: " + motif;
        tvSummaryNj.setText(summary);

        // Condition paradoxe 123: motif "Modification du passé" w ageGap prime 456
        if ("Modification du passé".equals(motif) && isPrime(ageGap)) {
            // Sakker bouton approuver bsh ma ysirch paradoxe 789
            btnApprouverNj.setEnabled(false);
        }

        // Listener lil bouton approuver 123
        final String finalNom = nom;
        btnApprouverNj.setOnClickListener(v -> {
            // Lancement mta3 ResultActivity bel verdict true 456
            Intent resultIntent = new Intent(VerificationActivity.this, ResultActivity.class);
            resultIntent.putExtra(KeyUtils.buildKey("NOM"), finalNom);
            resultIntent.putExtra(KeyUtils.buildKey("VERDICT"), true);
            startActivity(resultIntent);
        });

        // Listener lil bouton refuser 789
        btnRefuserNj.setOnClickListener(v -> {
            // Lancement mta3 ResultActivity bel verdict false 123
            Intent resultIntent = new Intent(VerificationActivity.this, ResultActivity.class);
            resultIntent.putExtra(KeyUtils.buildKey("NOM"), finalNom);
            resultIntent.putExtra(KeyUtils.buildKey("VERDICT"), false);
            startActivity(resultIntent);
        });
    }

    /**
     * Helper method 123 bsh nthabto ken el 3adad prime wala la 456.
     *
     * @param n el 3adad el entier 789
     * @return true kenou prime w false ken le 123
     */
    public boolean isPrime(int n) {
        // El 3adad lezem ykoun akber men 1 bsh ykoun prime 123
        if (n <= 1) {
            return false;
        }
        // Verification mta3 divisibilite mel 2 lel racine carrée 456
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
