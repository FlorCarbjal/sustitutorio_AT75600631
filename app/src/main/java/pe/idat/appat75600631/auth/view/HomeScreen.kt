package pe.idat.appat75600631.auth.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.idat.appat75600631.core.util.Menuitem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val drawerstate = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerstate,
        drawerContent = {
            DrawerContent(items = opcionesMenu(), onItemClick = { item ->
                coroutineScope.launch {
                    drawerstate.close()
                }
                when (item.titulo) {
                    "Opcion 1" -> navController.navigate("todoList")
                    "Opcion 2" -> navController.navigate("photoList")
                }
            })
        },
        content = {
            Column {
                TopAppBar(
                    title = { Text(text = "Prueba") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerstate.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )


                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        Text("Bienvenido a la Home")
                    }
                    composable("todoList") {
                        TodoListScreen()
                    }
                    composable("photoList") {
                        PhotoListScreen()
                    }
                }
            }
        }
    )
}

@Composable
fun DrawerContent(items: List<Menuitem>, onItemClick: (Menuitem) -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .systemBarsPadding()) {
        items.forEach{ item ->
            DrawerMenuItem(item = item, onItemClick = onItemClick)
        }
    }
}


@Composable
fun DrawerMenuItem(
    item: Menuitem,
    onItemClick: (Menuitem) -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(item) }
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically){
        Text(text = item.titulo)
    }
    }

fun opcionesMenu(): List<Menuitem>{
    return listOf(
        Menuitem("Opcion 1"),
        Menuitem("Opcion 2")
    )
}