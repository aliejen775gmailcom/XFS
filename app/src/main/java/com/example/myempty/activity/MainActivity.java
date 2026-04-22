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
import org.json.*;
import com.example.myempty.activity.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;


public class MainActivity extends AppCompatActivity {
    
        
    private String n = "Hallo Dunia";
    private ActivityMainBinding binding;
            
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable throwable) {
				// Mengambil detail error dalam bentuk String
				String errorMsg = android.util.Log.getStackTraceString(throwable);
				
				Intent intent = new Intent(getApplicationContext(), custom_error.class);
				intent.putExtra("error_log", errorMsg);
				
				// Membersihkan tumpukan activity agar tidak kembali ke halaman yang crash
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				
				startActivity(intent);
				
				// Mematikan proses yang error sepenuhnya
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(1);
			}
		});
        
        binding.bottomnavigation2.getMenu().add(0, 1, 0, "Rumah").setIcon(R.drawable.home);
        binding.bottomnavigation2.getMenu().add(0, 2, 0, "Menu").setIcon(R.drawable.sharp_menu_open);
        binding.bottomnavigation2.getMenu().add(0, 3, 0, "Lainnya").setIcon(R.drawable.sharp_insert_comment);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}