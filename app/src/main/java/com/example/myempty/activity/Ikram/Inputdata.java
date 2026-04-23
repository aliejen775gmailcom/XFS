package com.example.myempty.activity.Ikram;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myempty.activity.databinding.Inputdata01Binding;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.content.Intent;

public class Inputdata extends AppCompatActivity {
    
    private Inputdata01Binding binding;    
            
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Inputdata01Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable throwable) {
				// Mengambil detail error dalam bentuk String
				String errorMsg = android.util.Log.getStackTraceString(throwable);
				
				Intent intent = new Intent(getApplicationContext(), Inputdata.class);
				intent.putExtra("error_log", errorMsg);
				
				// Membersihkan tumpukan activity agar tidak kembali ke halaman yang crash
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				
				startActivity(intent);
				
				// Mematikan proses yang error sepenuhnya
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(1);
			}
		});
        
        
        
    }
}
