package pe.idat.appat75600631.auth.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pe.idat.appat75600631.auth.viewmodel.AuthViewModel

@Composable
fun TodoListScreen(viewModel: AuthViewModel = hiltViewModel()) {
    val todos by viewModel.todos.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchTodos()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(todos) { todo ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp) // Espacio entre elementos
            ) {
                Text(text = "ID: ${todo.id}")
                Text(text = "Title: ${todo.title}")
                Text(text = "Completed: ${todo.completed}")
            }
        }
    }
}

