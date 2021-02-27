package com.example.dogadoption


import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogadoption.ui.theme.DogAdoptionTheme

private const val START_TOP_PADDING = 290

@Composable
fun DogDetails(puppy: Puppy, modifier: Modifier = Modifier) {
    val context = LocalContext.current as? Activity
    val scrollState = rememberScrollState()

    // Calculate the offset of the background image to make it scroll with a parallax effect
    val imageOffset = (-scrollState.value * 0.2f).dp

    // Calculate the alpha used in the background of the back arrow
    val iconBackgroundAlpha = ((scrollState.value / START_TOP_PADDING.toFloat()) * 0.2f).coerceAtMost(0.2f)

    Box {
        Image(
            painter = painterResource(id = puppy.resId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .offset(y = imageOffset)
                .height(200.dp)
                .fillMaxWidth()
        )

        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(top = START_TOP_PADDING.dp)
                .background(
                    MaterialTheme.colors.surface,
                    RoundedCornerShape(topStart = 3.dp, topEnd = 20.dp)
                )
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(all = 32.dp)
        ) {
            Text("Hello I Am" , style = MaterialTheme.typography.h6)
            Spacer(Modifier.size(10.dp))
            Text(text = puppy.name, style = MaterialTheme.typography.h3)
            Spacer(Modifier.size(16.dp))
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "it has four legs, two ears, two eyes, a tail, a mouth, and a nose. It is a very clever animal and is very useful in catching thieves. It runs very fast, barks loudly and attacks the strangers. A dog saves the life of the master from danger.\n\n$LORIM")
        }

        IconButton(onClick = { context?.onBackPressed() }, modifier = Modifier.padding(8.dp).background(Color.Black.copy(alpha = iconBackgroundAlpha), shape = CircleShape)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back_24),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun Detail(heading: String, detail: String, modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(heading, style = MaterialTheme.typography.h6)
        Text(detail, style = MaterialTheme.typography.subtitle1)
    }
}

@Preview
@Composable
private fun DogPreview() {
    DogAdoptionTheme {
        DogDetails(puppy = DogRepresantation.puppies.first())
    }
}

private const val LORIM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.  Cras diam orci, imperdiet et sem in, pharetra euismod nunc. Nullam placerat odio mollis dignissim lacinia. Etiam odio lorem, interdum eu fermentum ut, hendrerit sed orci. Integer non cursus ligula. Ut bibendum turpis sit amet placerat ullamcorper. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque dolor mi, consectetur ut justo at, venenatis aliquam nisl. Donec congue lacus non ipsum luctus, vitae finibus dolor suscipit. Aenean sed lectus porta, ullamcorper quam non, pulvinar sem. Sed lectus lorem, cursus eget vestibulum id, volutpat non felis. Sed pulvinar, justo non finibus consectetur, nunc sem convallis sapien, a scelerisque massa elit eget ex.\n" +
        "\n" +
        "Vestibulum feugiat neque faucibus risus bibendum pulvinar. Nulla viverra mi at risus egestas fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Proin facilisis arcu ut commodo pulvinar. Sed dapibus nisi ac mi accumsan mollis. Integer id sagittis sem, a dictum libero. Sed eget aliquet nisi. Fusce venenatis pulvinar elementum. Suspendisse in nibh scelerisque, lobortis sapien sed, tempor nunc. Sed vitae faucibus tortor. Donec finibus enim et porta consectetur."
