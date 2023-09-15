package com.waajid.medsminder.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.waajid.medsminder.model.MedViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.waajid.medsminder.model.Med

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedsScreen() {
    Column {


        val medViewModel: MedViewModel = hiltViewModel()
        val medName = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Medicine Name") },
            value = medName.value,
            onValueChange = { medName.value = it })

        val ailmentName = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Ailment Name") },
            value = ailmentName.value,
            onValueChange = { ailmentName.value = it })

        val intakeQty = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Intake Quantity") },
            value = intakeQty.value,
            onValueChange = { intakeQty.value = it })

        val availableStock = remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Intake Quantity") },
            value = availableStock.value,
            onValueChange = { availableStock.value = it })

        Button(onClick = {

            val med = Med(
                drugName = medName.value.toString(),
                ailment = ailmentName.toString(),
                conSummingQuantity = 0.5,//intakeQty.value.toString().toDouble(),
                drugUOM = "Tablet",
                drugColorId = "Blue",
                schedule = listOf("Every 4 hours"),
                beforeAfterFood = "After food",
                availableStock = 14.9//availableStock.value.toString().toDouble()
            )

            medViewModel.insertData(med)
        }) {
            Text(text = "Save")
        }

    }
}
/*
*     @PrimaryKey(autoGenerate = true) var id: Int?= null,
    var drugName: String,
    var ailment: String,
    var conSummingQuantity: Double,
    val drugUOM: String,
    var drugColorId: String,
    var schedule: List<String>,
    var beforeAfterFood: String,
    var availableStock: Double*/

    @Preview
    @Composable
    fun addMedsPreview() {
        AddMedsScreen()
    }




