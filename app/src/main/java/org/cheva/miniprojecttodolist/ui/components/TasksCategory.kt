package org.cheva.miniprojecttodolist.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.cheva.miniprojecttodolist.dataclass.TaskCategory
import org.cheva.miniprojecttodolist.R

@Composable
fun TasksCategory (
    modifier: Modifier = Modifier,
    tasksCategory: TaskCategory,
) {
    Box(
        Modifier
            .shadow(
                elevation = 8.dp,
                spotColor = tasksCategory.color1,
                ambientColor = tasksCategory.color1,
                shape = RoundedCornerShape(24.dp)
            )
            .width(144.dp)
            .height(192.dp)
            .background(
                shape = RoundedCornerShape(24.dp),
                brush = Brush.linearGradient(
                    colors = listOf(
                        tasksCategory.color2,
                        tasksCategory.color1
                    )
                )
            ),
    ) {
        Column (
            Modifier
                .padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
        ) {
            Box (Modifier.size(45.dp)) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(tasksCategory.image),
                    contentDescription = "",
                )
            }

            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = tasksCategory.title,
                    style = TextStyle(
                        fontSize = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFF8FBFB),
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(8.dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = "",
                        tint = Color(0xFFF8FBFB),
                    )

                    Text(
                        text = "${tasksCategory.taskList.size} Tasks",
                        style = TextStyle(
                            fontSize = 16.51.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFF8FBFB),
                        )
                    )
                }
            }

            Box(
                Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(
                            enabled = true,
                            onClick = { }
                        ),
                    painter = painterResource(R.drawable.icon_add_white),
                    contentDescription = "",
                )
            }
        }
    }
}