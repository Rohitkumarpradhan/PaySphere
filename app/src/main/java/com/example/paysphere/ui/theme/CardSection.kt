package com.example.paysphere.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.paysphere.data.Card
import kotlin.String
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import com.example.paysphere.R
//private val Unit.drawable: Any
val Cards = listOf(


    Card(
        cardType = "VISA",
        cardNumber = "4715 5683 1241 9887",
        cardName = "Business",
        balance = 9700.7,
        color   = getGradient(PurpleStart, PurpleEnd),
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "4715 5883 1241 9887",
        cardName = "Savings",
        balance = 940.7,
        color   = getGradient(BlueStart, BlueEnd),
    ),

    Card(
        cardType = "VISA",
        cardNumber = "2315 5123 1241 9887",
        cardName = "School",
        balance = 78.7,
        color   = getGradient(OrangeStart , OrangeEnd),
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "4734 5683 1241 9887",
        cardName = "Trips",
        balance = 78900.7,
        color   = getGradient(GreenStart,GreenEnd),
    )




)


fun getGradient(
    startColor : Color,
    endColor : Color,
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor , endColor)
    )
}

@Preview
@Composable
fun CardSection(){
    LazyRow {
        items(Cards.size){ index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index : Int
){
    val card = Cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == Cards.size - 1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.visanew)
    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.mastercardnew)
    }

    Box(modifier = Modifier
        .padding(start = 16.dp , end = lastItemPaddingEnd)
    ){
        Column (
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable{}
                .padding(vertical = 12.dp , horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(painter = image ,
                contentDescription = card.cardName,
                modifier = Modifier
                    .width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )



//            Text(
//                text = card.cardName,
//                color = Color.White,
//                fontSize = 17.sp,
//                fontWeight = FontWeight.Bold
//            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}