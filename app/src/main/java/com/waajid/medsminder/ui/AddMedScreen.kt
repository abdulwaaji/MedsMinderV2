@file:OptIn(ExperimentalMaterial3Api::class)

package com.waajid.medsminder.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.waajid.medsminder.model.Med
import com.waajid.medsminder.model.MedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedsScreen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                         verticalArrangement = Arrangement.SpaceBetween

    ) {
        val medViewModel: MedViewModel = hiltViewModel()
        var medName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { intakeQty = it })

        var availableStock by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier,
            label = { Text(text = "Available Stock") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = availableStock,
            onValueChange = { availableStock = it })

        val uomList = listOf("Mg", "G", "µg", "mL", "IU")
        val intakeunit: MutableState<String> = remember {mutableStateOf("")}
        DropDown(modifier = Modifier.padding(16.dp), listItems = uomList , selectedItem = intakeunit)


        Spacer(modifier = Modifier.size(16.dp))

        Button(onClick = {

            val med = Med(
                drugName = medName.text,
                ailment = ailmentName.text,
                conSummingQuantity = intakeQty.text.toDouble(),
                drugUOM = intakeunit.value,
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




