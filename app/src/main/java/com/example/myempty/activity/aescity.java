package com.example.myempty.activity;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import com.example.myempty.activity.databinding.AescityBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import java.io.*;
import java.text.*;
import java.util.*;
import com.example.myempty.activity.sub.esing;

public class aescity extends AppCompatActivity {
    
    
    private AescityBinding binding;
    private String nullj = "Hello";
    private long io = 80;
    private String ki = "";
    private String iv = "";
	private String output = "";
   
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AescityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        ki = String.valueOf((long)(io));
        long nuf = Long.parseLong(ki);
        
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
        // Ambil detail error
        String errorMsg = android.util.Log.getStackTraceString(throwable);
    
        Intent intent = new Intent(getApplicationContext(), custom_error.class);
        intent.putExtra("error_log", errorMsg);
      
        // Flag untuk membersihkan tumpukan activity
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    
        startActivity(intent);
    
        // Matikan proses
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        });
        
        binding.button1.setOnClickListener(v -> {
        // Ambil teks dari TextView melalui binding
               if (binding.edittext1.getText().toString().equals("")) {
					
				} else {
					if (binding.edittext2.getText().toString().equals("")) {
						
					} else {
						output = binding.edittext1.getText().toString();
						iv = binding.edittext2.getText().toString();
                        esing aesTool = new esing();
                        try {
                        String hasil = aesTool.encryptAES256(output, iv);
                        binding.textview1.setText(hasil);
                        } catch (Exception e) {
                        e.printStackTrace();
                        }
					}
		        }
        
        });
        
        binding.button2.setOnClickListener(v -> {
        // Ambil teks dari TextView melalui binding
               if (binding.edittext1.getText().toString().equals("")) {
					
				} else {
					if (binding.edittext2.getText().toString().equals("")) {
						
					} else {
						output = binding.edittext1.getText().toString();
						iv = binding.edittext2.getText().toString();
                        esing aesTool = new esing();
                        try {
                        String hasil = aesTool.decryptAES256(output, iv);
                        binding.textview1.setText(hasil);
                        } catch (Exception e) {
                        e.printStackTrace();
                        }
					}
				}
        
        });
        
        binding.textview1.setOnLongClickListener(v -> {
        // Ambil teks dari TextView melalui binding
        String textToCopy = binding.textview1.getText().toString();

        // Eksekusi penyalinan
        copyToClipboard(textToCopy);

        // Berikan feedback suara/getar kecil (Haptic Feedback)
        v.performHapticFeedback(android.view.HapticFeedbackConstants.LONG_PRESS);

        // Berikan Toast
        Toast.makeText(this, "Teks berhasil disalin!", Toast.LENGTH_SHORT).show();

        // Return true artinya event "dikonsumsi" (biar tidak lanjut ke onClick biasa)
        return true;
        
        });
        
    }
    
    private void copyToClipboard(String text) {
    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clip = ClipData.newPlainText("Copied Text", text);
    if (clipboard != null) {
        clipboard.setPrimaryClip(clip);
    }
}


}
