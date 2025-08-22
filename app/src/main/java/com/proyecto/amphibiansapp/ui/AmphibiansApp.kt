package com.proyecto.amphibiansapp.ui
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.proyecto.amphibiansapp.R
import com.proyecto.amphibiansapp.network.Amphibians
import com.proyecto.amphibiansapp.ui.viewmodel.AmphibiansUiState
import com.proyecto.amphibiansapp.ui.viewmodel.AmphibiansViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
internal fun AmphibiansApp() {
    Scaffold (
        topBar = { AmphibiansTopAppBar() }
    ) { paddingValues ->
        val amphibiansViewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
        Home(uiState = amphibiansViewModel.uiState,
            modifier = Modifier.padding(paddingValues))
    }
}

@Composable
private fun Home(uiState: AmphibiansUiState,
                 modifier: Modifier = Modifier) {
    when (uiState) {
        AmphibiansUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
        AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibiansList(
            amphibians = uiState.amphibians,
            modifier = modifier)
    }
}

@Composable
private fun AmphibiansList(amphibians: List<Amphibians>,
                           modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        items(items = amphibians, key = { it.name }) { amphibian ->
            Log.i("indice","indice: ${amphibians.indexOf(amphibian)}")
            val index = amphibians.indexOf(amphibian)
            when(index) {
                0 -> AmphibianCard(amphibian = amphibian,
                    modifier = Modifier.padding(top = 50.dp))
                amphibians.lastIndex -> AmphibianCard(amphibian = amphibian,
                    modifier = Modifier.padding(bottom = 50.dp))
                else -> AmphibianCard(amphibian = amphibian)
            }
        }
    }
}

@Composable
private fun AmphibianCard(amphibian: Amphibians, modifier: Modifier = Modifier) {
    Card (modifier = modifier) {
        Column {
            Text(text = amphibian.name,
                modifier = Modifier.padding(10.dp))
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = "Un sapo",
                modifier = Modifier.fillMaxWidth(),
                //contentScale = ContentScale.Crop,
            )
            Text(text = amphibian.description,
                modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading..."
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center) {
        Text("Error")
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Nina() {

}

