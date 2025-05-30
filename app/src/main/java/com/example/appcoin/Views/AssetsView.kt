package com.example.appcoin.Views
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.appcoin.Model.Asset
import com.example.appcoin.ui.theme.Typography
import com.example.appcoin.ViewModels.AssetsListViewModel

@Composable
fun AssetsList(viewModel: AssetsListViewModel = hiltViewModel()) {
    val assets by viewModel.assets.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(assets,key={it.id}) { asset ->
            AssetRow(asset)
        }
    }
}


@Composable
fun AssetRow(asset: Asset) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            if (LocalInspectionMode.current) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                )
            } else {
                AsyncImage(
                    model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png\n",
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }

        Column {
            Text(
                text = asset.symbol,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text = asset.name,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "${asset.percentage}%",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = if (asset.percentage >= 0) Color.Green else Color.Red,
            style = Typography.labelLarge

        )

        Text(
            text = "$${asset.price}",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.White,
            style = Typography.labelLarge
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AssetRowPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AssetRow(
            Asset(
                id = "1",
                name = "Bitcoin",
                symbol = "BTC",
                percentage = 5.38,
                price = "87800"
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        AssetRow(
            Asset(
                id = "2",
                name = "Ethereum",
                symbol = "ETH",
                percentage = -8.28,
                price = "1800"
            )
        )

    }}
@Composable
fun AssetsListPreview() {
    AssetsList()
}