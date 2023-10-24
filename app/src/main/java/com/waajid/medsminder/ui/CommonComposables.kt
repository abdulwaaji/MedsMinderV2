package com.waajid.medsminder.ui

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(modifier: Modifier,listItems: List<String>, selectedItem: MutableState<String>) {


    // state of the menu
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(

            value = selectedItem.value,
            onValueChange = { selectedItem.value = it },
            label = { Text(text = "Unit") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            readOnly = true,
            modifier = Modifier.menuAnchor()

        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            listItems.forEach { selectionOption ->
                // menu item
                DropdownMenuItem(
                    text = { Text(text = selectionOption) },
                    onClick = {
                        selectedItem.value = selectionOption
//                            Toast.makeText(contextForToast, selectedItem, Toast.LENGTH_SHORT).show()
                        expanded = false
                    }
                )
            }
        }
    }
}
