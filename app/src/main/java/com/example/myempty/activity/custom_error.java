package com.example.myempty.activity;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;import com.example.myempty.activity.databinding.CustomerroractivityBinding;


public class custom_error extends AppCompatActivity {
    
    private CustomerroractivityBinding binding;
    private String sklm = "";
    
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        binding = CustomerroractivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        // initialize(_savedInstanceState); // Hapus jika kosong
        initializeLogic();
    }
    
    private void initializeLogic() {
        // 1. Ambil log error dari Intent
        final String errorLog = getIntent().getStringExtra("error_log");
        sklm = (errorLog != null) ? errorLog : "No error log found";
        
        // Gunakan binding untuk set text
        binding.textviewError.setText(sklm);
        
        // 2. Logika Tombol Restart (Gunakan ID yang ada di XML melalui binding)
        binding.btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pastikan nama class-nya benar: custom_error.this
                Intent intent = new Intent(custom_error.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        
        // 3. Logika Tombol Lapor
        binding.btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Salin ke Clipboard
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(android.content.Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Error Log", sklm);
                clipboard.setPrimaryClip(clip);
                
                Toast.makeText(getApplicationContext(), "Log error berhasil disalin!", Toast.LENGTH_SHORT).show();
                
                // Kirim ke WhatsApp
                String nomorWA = "6283897503120";
                String pesanLaporan = "Halo Pengembang,\n\nAplikasi saya crash. Berikut detail log-nya:\n\n" + sklm;
                String url = "https://wa.me/" + nomorWA + "?text=" + android.net.Uri.encode(pesanLaporan);
                
                Intent intentWA = new Intent(Intent.ACTION_VIEW);
                intentWA.setData(android.net.Uri.parse(url));
                
                try {
                    startActivity(intentWA);
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "WhatsApp tidak ditemukan.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}