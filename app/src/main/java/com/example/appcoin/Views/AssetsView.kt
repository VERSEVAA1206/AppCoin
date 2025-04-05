package com.example.appcoin.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.appcoin.Model.Asset

@Composable
fun AssetRow(asset: Asset){
    Row (
        modifier=Modifier
            .fillMaxWidth()
            .background(Color.Blue)
    ){
        Icon(imageVector = Icons.Filled.CheckCircle,
            contentDescription = null,
            tint = Color.Red,
            modifier=Modifier.padding(horizontal=8.dp)
        )

        AsyncImage(
            model="https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
            contentDescription = null

        )


        Column{
            Text(text=asset.symbol,
                fontSize=18.sp)
            Text(text="Bitcoin",
                fontSize=14.sp)
        }
        Column{
            Text(text=asset.name,
                fontSize=18.sp)
            Text(text="Bitcoin",
                fontSize=14.sp)
        }
        Spacer(modifier=Modifier.weight(1f))
//        Icon(
//            imageVector = Icons.Filled.KeyboardArrowUp,
//            contentDescription = null,
//            tint = Color.Green
//        )



        Text(
            text = asset.price,
            fontSize=16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
            )
        Text(
            text = "${asset.percentage}%",
            fontSize=16.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            color=if(asset.percentage>=0)Color.Green else Color.Red


        )
        
    }
}



@Preview(
    showBackground = true,
    showSystemUi=true
)
@Composable
fun AssetRowPreview(){

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

    )
        {
            AssetRow(
                Asset(
                    id="1",
                    name="bitcoin",
                    symbol="BTC",
                    price="$6565",
                    percentage=-5.44
                )

            )
            AssetRow(
                Asset(
                    id="2",
                    name="BITCOIN 1",
                    symbol="BTC",
                    price="$6565",
                    percentage=43.44
                )

            )

        }
}