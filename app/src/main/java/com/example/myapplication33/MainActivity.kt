package com.example.myapplication33

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // Pour les différents éléments de layout
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication33.ui.theme.MyApplication33Theme
import com.example.myapplication33.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication33Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Appel de la fonction ImageWithButton
                    ImageWithButton(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ImageWithButton(modifier: Modifier = Modifier) {
    // Utilisation d'un état pour changer l'image =======***********remember
    var currentImage by remember {
        mutableStateOf(R.drawable.cycy)
    }

    // Colonne pour afficher l'image et le bouton en dessous
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Affichage de l'image actuelle
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = "Image à afficher",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp), // Vous pouvez ajuster la taille de l'image ici
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacement entre l'image et le bouton

        // Bouton pour changer d'image
        Button(onClick = {
            // Changement de l'image lorsqu'on clique sur le bouton
            currentImage = if (currentImage == R.drawable.cycy) {
                R.drawable.cy
            } else {
                R.drawable.cycy
            }
        }) {
            Text("Changer d'image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageWithButtonPreview() {
    MyApplication33Theme {
        ImageWithButton()
    }
}