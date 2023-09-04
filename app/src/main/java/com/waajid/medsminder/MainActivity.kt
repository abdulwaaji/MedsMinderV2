package com.waajid.medsminder

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.waajid.medsminder.model.Med
import com.waajid.medsminder.model.MedViewModel
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
                // A surface container using the 'background' color from the theme
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { addMed()},
                            modifier = Modifier
                                .padding(16.dp),
                            contentColor = Color.White,
                            containerColor = Color.Black, // Customize FAB background color
                            elevation = FloatingActionButtonDefaults.elevation(8.dp),
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        }
                    },
                    modifier = Modifier.fillMaxSize(), // This modifier should be here
                    contentColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        Greeting("Android")
                    }

                }
            }

        }

        medViewModel.getAllData().observe(this,{medslist ->
            Log.d("aaaaaaaaaa", medslist.toString())
        }
        )
    }

    fun addMed(){
        val med = Med(
            drugName = "Paracetamol",
            ailment = "Fever",
            conSummingQuantity = 1.0,
            drugUOM = "Tablet",
            drugColorId = "Blue",
            schedule = listOf("Every 4 hours"),
            beforeAfterFood = "After food",
            availableStock = 10.0
        )
        medViewModel.insertData(med)
    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MedsMinderTheme {
            Greeting("Android")
        }
    }
}