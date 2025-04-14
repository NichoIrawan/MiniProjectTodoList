package org.cheva.miniprojecttodolist.add_task

import java.time.LocalDate
import java.time.LocalTime

data class AddTastState (
    val title: String = "",
    val date: LocalDate = LocalDate.now(),
    val time: LocalTime = LocalTime.now()
)