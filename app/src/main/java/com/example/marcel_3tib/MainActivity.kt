package com.example.marcel_3tib

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.marcel_3tib.databinding.ActivityMainBinding
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import android.content.Intent
import com.example.marcel_3tib.pertemuan5.LimaActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        p4
        val user = intent.getStringExtra("username")
        val pass= intent.getStringExtra("password")
        val umur = intent.getIntExtra("umur", 0)
        Log.e("hasil","$user $umur $pass")
        binding.txtUsername.text = user
        binding.txtPassword.setText(pass)

        binding.btnSnack.setOnClickListener {
            Snackbar.make(binding.root, "Item dihapus",
                Snackbar.LENGTH_LONG)
                .setAction("BATAL"){
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)

                }.show()
        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak " +
                        "bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnKembali.setOnClickListener {

            finish()
        }

//        p4

        binding.btnToLima.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))
        }
    }
}