package org.cheva.miniprojecttodolist.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.cheva.miniprojecttodolist.dataclass.Driver
import org.cheva.miniprojecttodolist.dataclass.TaskCategory
import org.cheva.miniprojecttodolist.R
import org.cheva.miniprojecttodolist.dataclass.Task
import org.cheva.miniprojecttodolist.navigation.LoginScreen
import org.cheva.miniprojecttodolist.ui.components.TasksCategory
import org.cheva.miniprojecttodolist.ui.components.TodayTask
import org.cheva.miniprojecttodolist.ui.theme.MiniProjectTodoListTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    userName: String = "Testing",
    onNavigate: (Any) -> Unit
) {
    val taskList: List<Task> = Driver.taskList
    val taskCategoryList: List<TaskCategory> = Driver.taskCategoryList

    Box (
        modifier = Modifier
            .background(
                color = Color(0xFF19304C)
            ),
        contentAlignment = Alignment.BottomCenter
    ){
        Column (
            modifier = Modifier.fillMaxSize()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            //AppBar
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Text(
                        text = "Hello,",
                        style = TextStyle(
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Light,
                            color = Color(248, 251, 251, 255)
                        )
                    )

                    Text(
                        text = userName,
                        style = TextStyle(
                            fontSize = 26.71.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFF8FBFB),
                        )
                    )
                }

                Box (
                    modifier = Modifier
                        .size(60.dp)
                        .aspectRatio(1f)
                        .clickable(
                            enabled = true,
                            onClick = { }
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.icon_profile),
                        contentDescription = ""
                    )
                }
            }

            //Body
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ){
                //Upper Body
                Column (
                    Modifier.padding(32.dp, 8.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top)
                ){
                    Row (
                        Modifier
                            .fillMaxWidth()
                            .clickable(
                                enabled = true,
                                onClick = { }
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Category",
                            style = TextStyle(
                                fontSize = 26.71.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFF8FBFB),
                            )
                        )

                        Box {
                            Image(
                                painter = painterResource(R.drawable.icon_right_arrow),
                                contentDescription = "",
                                Modifier.size(30.dp)
                            )
                        }
                    }

                    //Lazy row here
                    LazyRow (
                        modifier = Modifier
                            .requiredWidth(LocalConfiguration.current.screenWidthDp.dp),
                        contentPadding = PaddingValues(start = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ){
                        items(taskCategoryList.size) {index ->
                            TasksCategory(
                                tasksCategory = taskCategoryList.elementAt(index)
                            )
                        }
                    }
                }
                //END of lazy Row

                //Lower Body
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp),
                    shape = RoundedCornerShape(
                        topStart = 36.dp,
                        topEnd = 36.dp
                    ),
                    color = Color(0xFFF8FBFB)
                ){
                    Column(
                        modifier = Modifier.padding(32.dp, 48.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "Today’s Task",
                                style = TextStyle(
                                    fontSize = 27.7.sp,
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF19304C),
                                ),
                            )

                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(5.dp)
                                    .clickable(
                                        enabled = true,
                                        onClick = { }
                                    )
                            ) {
                                Icon(
                                    modifier = Modifier.fillMaxSize(),
                                    imageVector = Icons.Rounded.Settings,
                                    contentDescription = "",
                                    tint = Color(0x9919304C)
                                )
                            }
                        }

                        //LazyColumn here
                        LazyColumn {
                            items(taskList.size) { index ->
                                TodayTask(
                                    task = taskList.elementAt(index)
                                )
                            }
                        }
                    }
                }
            }
        }

        //NavBar
        Column(
            Modifier
                .fillMaxWidth()
                .height(144.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Bottom),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box (
                modifier = Modifier
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x63091111),
                        ambientColor = Color(0x1A091111),
                        shape = CircleShape
                    )
                    .background(
                        color = Color(0xFFF8FBFB),
                        shape = RoundedCornerShape(size = 360.dp)
                    )
                    .clickable(
                        enabled = true,
                        onClick = {onNavigate(LoginScreen)}
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(20.dp),
                    painter = painterResource(R.drawable.icon_add),
                    contentDescription = ""
                )
            }
            Box (
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x63091111),
                        ambientColor = Color(0x1A091111),
                        shape = CircleShape
                    )
                    .background(
                        color = Color(0xFFF8FBFB),
                        shape = RoundedCornerShape(size = 360.dp))
                    .clickable(
                        enabled = true,
                        onClick = { }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(15.dp)
                        .size(30.dp),
                    painter = painterResource(R.drawable.icon_home),
                    contentDescription = ""
                )
            }
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