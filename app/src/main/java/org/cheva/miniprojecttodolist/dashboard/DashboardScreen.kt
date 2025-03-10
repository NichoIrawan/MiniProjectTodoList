package org.cheva.miniprojecttodolist.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.cheva.miniprojecttodolist.R
import org.cheva.miniprojecttodolist.navigation.LoginScreen
import org.cheva.miniprojecttodolist.ui.theme.MiniProjectTodoListTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    userName: String = "Testing",
    onNavigate: (Any) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(100.dp),
                title = {
                    Column (
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Hello,",
                            style = TextStyle(
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Light,
                                color = Color(0.04f, 0.07f, 0.07f, 0.6f)
                            )
                        )
                        Text(
                            text = userName,
                            style = TextStyle(
                                fontSize = 26.71.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0.04f, 0.07f, 0.07f, 0.6f)
                            )
                        )
                    }
                },
                actions = {
                    Box (
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f),
                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(
                            modifier = Modifier.fillMaxSize(),
                            onClick = { onNavigate(LoginScreen) }
                        ) {
                            Icon(
                                modifier = Modifier.size(60.dp),
                                imageVector = Icons.Default.Person,
                                contentDescription = "",
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
           BottomAppBar(
               modifier = Modifier.height(155.dp),
               actions = {
                   Column (
                       modifier = Modifier.fillMaxWidth(),
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       IconButton(
                       modifier = Modifier.size(60.dp),
                       onClick = {}
                   ) {
                       Icon(
                           modifier = Modifier.size(30.dp),
                           imageVector = Icons.Outlined.Add,
                           contentDescription = ""
                       )
                   }
                       IconButton(
                           modifier = Modifier.size(60.dp),
                           onClick = {}
                       ) {
                           Icon(
                               modifier = Modifier.size(45.dp),
                               imageVector = Icons.Rounded.Home,
                               contentDescription = ""
                           )
                       }
                   }
               }
           )
       }
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                text = "Your Wallet Today",
                style = TextStyle(
                    fontSize = 26.71.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0.04f, 0.07f, 0.07f, 0.6f)
                )
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.62f)
                    .padding(20.dp),
                painter = painterResource(id = R.drawable.card),
                contentDescription = ""
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DashboardScreenPrev() {
    MiniProjectTodoListTheme {
        DashboardScreen(
            userName = "Testing",
            onNavigate = {}
        )
    }
}