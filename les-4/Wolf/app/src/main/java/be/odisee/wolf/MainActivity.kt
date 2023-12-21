package be.odisee.wolf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.shops.data.Shop
import com.example.shops.data.shops

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    WolfApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WolfApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            WolfTopAppBar()
        }
    ) {
        LazyColumn(contentPadding = it) {
            items(shops) {
                WolfCard(
                    shop = it, modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.medium_padding))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WolfTopAppBar() {
    CenterAlignedTopAppBar(title = {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.logo), contentDescription = null,
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.logo_size))
                    .width(dimensionResource(id = R.dimen.logo_size))
            )
            Text(text = stringResource(id = R.string.app_name))
        }
    })
}


@Composable
fun WolfCard(shop: Shop, modifier: Modifier = Modifier) {

    var expanded by remember {
        mutableStateOf(false)
    }

    val rotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = spring(Spring.DampingRatioHighBouncy, Spring.StiffnessLow)
    )
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.animateContentSize(
                spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_padding))
            ) {
                Image(
                    painter = painterResource(id = shop.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.image_size))
                        .height(dimensionResource(id = R.dimen.image_size))
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = dimensionResource(id = R.dimen.small_padding))
                ) {
                    Text(
                        text = stringResource(id = shop.titleResourceId),
                        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.small_padding)),
                        style = MaterialTheme.typography.titleLarge
                    )

                    shop.handleResourceId?.let {
                        InstagramHandle(text = stringResource(id = it))
                    }
                }

                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier.align(Alignment.Bottom)
                ) {
                    Icon(
                        Icons.Filled.ExpandMore,
                        contentDescription = stringResource(id = R.string.show_more),
                        modifier = Modifier.rotate(rotation)
                    )
                }
            }


            if (expanded) {

                Text(
                    text = stringResource(id = shop.descriptionResourceId),
                    modifier = Modifier.padding(
                        dimensionResource(id = R.dimen.medium_padding)
                    )
                )
            }
        }
    }
}

@Composable
fun InstagramHandle(text: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.secondary)
            .padding(dimensionResource(id = R.dimen.small_padding))
    ) {
        Icon(
            tint = MaterialTheme.colorScheme.onSecondary,
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = null,
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.small_padding))
        )
        Text(
            text,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WolfAppPreview() {
    AppTheme {
        WolfApp()
    }
}

@Preview(showBackground = true)
@Composable
fun WolfCardPreview() {

    AppTheme(useDarkTheme = true) {
        WolfCard(
            shop = Shop(
                R.drawable.bollyfood,
                R.string.bollyfood_stories,
                R.string.bollyfood_stories_description,
                R.string.bollyfood_stories_handle
            )
        )
    }

}

@Preview(showBackground = true)
@Composable
fun InstagranHandlePreview() {
    AppTheme(useDarkTheme = true) {
        InstagramHandle(text = "Bollyfood")
    }
}