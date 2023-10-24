package com.waajid.medsminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModelProvider
import com.waajid.medsminder.model.MedViewModel
import com.waajid.medsminder.ui.navGraph
import com.waajid.medsminder.ui.theme.MedsMinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var medViewModel: MedViewModel

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        medViewModel = ViewModelProvider(this)[MedViewModel::class.java]

        setContent {
            MedsMinderTheme {
                navGraph()
            }

        }

        medViewModel.getAllData().observe(this, { medslist ->

        }
        )
    }


}