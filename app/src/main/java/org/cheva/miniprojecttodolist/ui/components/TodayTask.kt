package org.cheva.miniprojecttodolist.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.cheva.miniprojecttodolist.dataclass.Task
import org.cheva.miniprojecttodolist.R
import java.util.Calendar

@SuppressLint("DefaultLocale")
@Composable
fun TodayTask(
    modifier: Modifier = Modifier,
    task: Task
){
    //To get time from date
    val cal = Calendar.getInstance()
    cal.time = task.dueDate

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                enabled = true,
                onClick = { }
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = task.category.color1,
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(task.category.image),
                    contentDescription = ""
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = task.title,
                    style = TextStyle(
                        fontSize = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF19304C),
                    )
                )

                Text(
                    text = String.format("Due %02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE)),
                    style = TextStyle(
                        fontSize = 16.51.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0x9919304C),
                    )
                )
            }
        }

        Box(
            modifier = Modifier.padding(5.dp),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(R.drawable.icon_right_arrow_dark),
                contentDescription = ""
            )
        }
    }
}