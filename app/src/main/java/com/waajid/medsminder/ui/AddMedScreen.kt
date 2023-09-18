package com.waajid.medsminder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waajid.medsminder.model.MedViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.waajid.medsminder.model.Med

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedsScreen() {
    Column(modifier = Modifier.
                        fillMaxWidth().
                        padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,

    ) {


        val medViewModel: MedViewModel = hiltViewModel()
        var medName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
//            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Medicine Name") },
            value = medName,
            onValueChange = { medName = it })

        var ailmentName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier,
            label = { Text(text = "Ailment Name") },
            value = ailmentName,
            onValueChange = { ailmentName = it })

        var intakeQty by  remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier,
            label = { Text(text = "Intake Quantity") },
            value = intakeQty,
            onValueChange = { intakeQty = it })

        var availableStock by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier,
            label = { Text(text = "Available Stock") },
            value = availableStock,
            onValueChange = { availableStock = it })

        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = {

            val med = Med(
                drugName = medName.text,
                ailment = ailmentName.text,
                conSummingQuantity = intakeQty.text.toDouble(),
                drugUOM = "Tablet",
                drugColorId = "Blue",
                schedule = listOf("Every 4 hours"),
                beforeAfterFood = "After food",
                availableStock = availableStock.text.toDouble()
            )

            medViewModel.insertData(med)
        }) {
            Text(text = "Save")
        }

    }
}


    @Preview
    @Composable
    fun addMedsPreview() {
        AddMedsScreen()
    }




