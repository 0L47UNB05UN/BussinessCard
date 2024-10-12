package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard(
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun Information(logo: Int, fullName: Int, businessName: Int, modifier: Modifier=Modifier){
    val image = painterResource(logo)
    val name = stringResource(fullName)
    val business = stringResource(businessName)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier=modifier.fillMaxWidth().padding(bottom=154.dp)
    ){
        Image(
            image,
            contentDescription="logo",
            modifier= modifier
                .size(94.dp)
                .align(
                    alignment = Alignment.CenterHorizontally
                )
        )
        Text(
            text=name,
            fontSize=32.sp,
            textAlign=TextAlign.Center,
            lineHeight=32.sp,
            modifier= modifier
                .padding(top = 10.dp, bottom = 5.dp)
                .align(
                    alignment = Alignment.CenterHorizontally
                )
        )
        Text(
            text=business,
            color= colorResource(R.color.deep_green),
            fontSize=20.sp,
            fontWeight=FontWeight.Bold,
            modifier=modifier.align(
                alignment=Alignment.CenterHorizontally
            )
        )

    }
}


@Composable
fun ContactPane(data: String, dataType: String, modifier: Modifier=Modifier){
    val icon: ImageVector = when (dataType) {
                            "tel" -> {
                                Icons.Rounded.Call
                            }
                            "mail" -> {
                                Icons.Rounded.Email
                            }
                            else -> {
                                Icons.Rounded.Share
                            }
                        }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier=modifier
    ){
        Icon(
            icon,
            contentDescription = null,
            modifier.align(alignment=Alignment.CenterVertically)
                .padding(end=12.dp)
                .size(12.dp)
        )
        Text(
            text=data,
//            fontWeight=FontWeight.Bold,
            textAlign = TextAlign.Justify,
            fontSize=15.sp,
            modifier=modifier.align(alignment=Alignment.CenterVertically)
        )
    }
}

@Composable
fun Contact(modifier: Modifier=Modifier){
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier=modifier.padding(bottom=104.dp)
    ){
        ContactPane(
            data=stringResource(R.string.tel),
            "tel"
        )
        ContactPane(
            data=stringResource(R.string.email),
            "mail"
        )
        ContactPane(
            data=stringResource(R.string.social),
            "social"
        )
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement=Arrangement.Bottom,
        modifier=modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.light_green)
            )
    ) {
        Information(
            R.drawable.ic_launcher,
            R.string.full_name,
            R.string.business,
            modifier = modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Contact(
            modifier.align(alignment=Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}