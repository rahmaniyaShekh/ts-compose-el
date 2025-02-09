package com.aipg.composets

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBasicComponentsApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBasicComponentsApp() {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Basic Components Demo") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text Examples
            SectionTitle("Text Examples")
            SimpleText()
            StyledText()
            ColoredText()

            Spacer(modifier = Modifier.height(24.dp))

            // Button Examples
            SectionTitle("Button Examples")
            SimpleButton()
            OutlinedButtonExample()
            TextButtonExample(context = LocalContext.current)
            DisabledButton()

            Spacer(modifier = Modifier.height(24.dp))

            // Image Examples
            SectionTitle("Image Examples")
            LocalImage()
            NetworkImage()
            TintedImage()
        }
    }
}

// Text Components
@Composable
fun SimpleText() {
    Text("This is a simple text")
}

@Composable
fun StyledText() {
    Text(
        text = "Styled Text",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ColoredText() {
    Text(
        text = "Colored Text",
        color = Color.Blue,
        fontSize = 18.sp
    )
}

// Button Components
@Composable
fun SimpleButton() {
    Button(onClick = { /* Handle click */ }) {
        Text("Click Me!")
    }
}

@Composable
fun OutlinedButtonExample() {
    OutlinedButton(onClick = { /* Handle click */ }) {
        Text("Outlined Button")
    }
}

@Composable
fun TextButtonExample(context: Context) {
    TextButton(onClick = {
        Toast.makeText(context, "Text Button Clicked", Toast.LENGTH_SHORT).show()
    }) {
        Text("Text Button")
    }
}

@Composable
fun DisabledButton() {
    Button(
        onClick = { /* Disabled click */ },
        enabled = false
    ) {
        Text("Disabled Button")
    }
}

// Image Components
@Composable
fun LocalImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground), // Replace with your image
        contentDescription = "Local Image",
        modifier = Modifier.size(100.dp)
    )
}

@Composable
fun NetworkImage() {
    Image(
        painter = rememberAsyncImagePainter(
            model = "https://upload.wikimedia.org/wikipedia/commons/4/4d/12_-_The_Mystical_King_Cobra_and_Coffee_Forests.jpg" // Replace with actual URL
        ),
        contentDescription = "Network Image",
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun TintedImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground), // Replace with your image
        contentDescription = "Tinted Image",
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Red),
        modifier = Modifier.size(100.dp)
    )
}

// Helper component for section titles
@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = Color.Gray,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Divider()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyBasicComponentsApp()
}