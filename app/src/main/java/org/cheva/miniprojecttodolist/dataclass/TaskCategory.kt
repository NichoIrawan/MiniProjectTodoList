package org.cheva.miniprojecttodolist.dataclass

import androidx.compose.ui.graphics.Color

data class TaskCategory(
    val title: String,
    val image: Int,
    val color1: Color,
    val color2: Color = color1,
    val taskList: MutableList<Task> = ArrayList<Task>()
)
