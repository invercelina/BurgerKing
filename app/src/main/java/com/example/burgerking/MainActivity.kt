package com.example.burgerking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.burgerking.ui.theme.BurgerKingTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BurgerKingTheme {
                MainScreen()
            }
        }
    }


    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            BurgerMain(paintId = R.drawable.whopper, burgerName = "와퍼", burgerPrice = 7100)
            BurgerMain(
                paintId = R.drawable.garlicbulbogiwhopper,
                burgerName = "갈릭불고기와퍼",
                burgerPrice = 7700
            )
            BurgerMain(paintId = R.drawable.cheesewhopper, burgerName = "치즈와퍼", burgerPrice = 7400)
            BurgerMain(
                paintId = R.drawable.hotchillilover,
                burgerName = "핫칠리러버",
                burgerPrice = 3800
            )
            BurgerMain(
                paintId = R.drawable.hotchillidouble,
                burgerName = "핫칠리러버 더블",
                burgerPrice = 4900
            )
            BurgerMain(
                paintId = R.drawable.bulgogiwhopper,
                burgerName = "불고기와퍼",
                burgerPrice = 7100
            )
        }
    }

    @Composable
    fun BurgerMain(paintId: Int, burgerName: String, burgerPrice: Int) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { /*ToDo*/ },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = paintId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 15.dp, start = 20.dp, end = 20.dp)
                )
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .weight(1f)
                ) {

                    Text(
                        text = burgerName,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)

                    )
                    Text(
                        text = "${String.format(Locale.KOREA,"%,d",burgerPrice)}원 ~",
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = "arrow",
                        alignment = Alignment.TopEnd
                    )
                }
            }
            Divider(thickness = 2.dp)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        BurgerKingTheme {
            MainScreen()
        }
    }

}