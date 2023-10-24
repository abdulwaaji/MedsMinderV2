

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.waajid.medsminder.model.MedViewModel
import com.waajid.medsminder.ui.Screens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(Screens.AddScreen.route)  }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){
        HomeScreenContent()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}

@Composable
fun HomeScreenContent() {
    val medViewModel: MedViewModel = hiltViewModel()
//    val items by medViewModel.getAllData().observeAsState(listOf())
//    medViewModel.getAllData().observe(this, { medslist ->
//    })


    LazyColumn{
//        items(list) { }
//         todo implement the lazy column
//         todo display medicine name, available stock
    }
}



