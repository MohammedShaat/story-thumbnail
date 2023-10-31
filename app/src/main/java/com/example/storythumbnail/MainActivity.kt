package com.example.storythumbnail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.story_thumbnail.StoryThumbnail
import com.example.storythumbnail.ui.theme.StoryThumbnailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    StoryThumbnailTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            StoryThumbnail(
                count = 5,
                seen = 3,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                    )
                },
                modifier = Modifier.size(150.dp),
                onClick = { },
                seenColor = Color.Green,
                unSeenColor = Color.Gray,
                width = 3.dp,
                spacing = 2.dp,
            )
        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}