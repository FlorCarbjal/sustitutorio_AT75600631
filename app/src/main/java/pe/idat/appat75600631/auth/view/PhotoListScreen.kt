package pe.idat.appat75600631.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import pe.idat.appat75600631.auth.viewmodel.AuthViewModel

@Composable
fun PhotoListScreen(viewModel: AuthViewModel = hiltViewModel()) {
    val photos by viewModel.photos.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchPhotos()
    }

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(photos) { photo ->
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = photo.thumbnailUrl),
                    contentDescription = photo.title,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = "Album ID: ${photo.albumId}")
                Text(text = "ID: ${photo.id}")
                Text(text = "Title: ${photo.title}")
            }
        }
    }
}
