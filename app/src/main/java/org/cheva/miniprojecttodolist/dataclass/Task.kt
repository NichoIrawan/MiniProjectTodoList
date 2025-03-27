package org.cheva.miniprojecttodolist.dataclass

import java.util.Date

data class Task(
    val title: String,
    val category: TaskCategory,
    val dueDate: Date
)
