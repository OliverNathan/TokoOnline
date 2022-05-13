package com.example.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tokoonline.R
import com.example.tokoonline.helper.Helper
import kotlinx.android.synthetic.main.toolbar_custom.*

class TambahAlamatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_tambah_alamat)
        Helper().setToolbar(this, toolbar, "Tambah Alamat")

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}