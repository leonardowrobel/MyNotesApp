package com.example.mynotesapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mynotesapp.ui.home.HomeViewModel
import com.example.mynotesapp.ui.theme.MyNotesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private val mPermissions = arrayOf(Manifest.permission.)
//    private val mRequestPermissions: MutableList<String> = ArrayList()

//    private fun requestPermissions(): Boolean {
//        if (Build.VERSION.SDK_INT >= 23) {
//            for (i in mPermissions.indices) {
//                if (ContextCompat.checkSelfPermission(
//                        this,
//                        mPermissions[i]
//                    ) != PackageManager.PERMISSION_GRANTED
//                ) {
//                    mRequestPermissions.add(mPermissions[i])
//                }
//            }
//            if (mRequestPermissions.size > 0) {
//                ActivityCompat.requestPermissions(this, mPermissions, PERMISSION_REQUEST_CODE)
//                return false
//            }
//        }
//        return true
//    }

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // requestPermissions()

        setContent {
            MyNotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}