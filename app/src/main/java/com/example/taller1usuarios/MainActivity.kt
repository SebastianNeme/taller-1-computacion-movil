package com.example.taller1usuarios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.taller1usuarios.ui.navigation.UsersApp
import com.example.taller1usuarios.ui.theme.Taller1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UsersApp()
                }
            }
        }
    }
}
