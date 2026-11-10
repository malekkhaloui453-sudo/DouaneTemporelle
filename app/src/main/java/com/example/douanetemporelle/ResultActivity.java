package com.example.douanetemporelle;

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
 * Activity ResultActivity 123 lil result.
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
    }
}
