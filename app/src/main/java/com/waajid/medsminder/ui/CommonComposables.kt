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
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(listItems : List<String>,  selectedItem: MutableState<String>) {


    // state of the menu
    var expanded by remember { mutableStateOf(false) }

    // remember the selected item
//    var selectedItem by remember { mutableStateOf(listItems[0]) }

    // box
    ExposedDropdownMenuBox(
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
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // filter options based on text field value
        val filteringOptions = listItems.filter { it.contains(selectedItem.value, ignoreCase = true) }

        if (filteringOptions.isNotEmpty()) {
            // menu
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // this is a column scope
                // all the items are added vertically
                filteringOptions.forEach { selectionOption ->
                    // menu item
                    DropdownMenuItem(
                        text = {},
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
}

@Preview
@Composable
fun DropDownPreviewn() {
    val unit: MutableState<String> = remember {mutableStateOf("")}
    val names = listOf("Alice", "Bob", "Carol")
    DropDown(listItems = names , selectedItem = unit)
}