package org.cheva.miniprojecttodolist.add_task

import java.util.Date

interface AddTaskEvent {
    data class onTitleChanged(val title: String): AddTaskEvent
    data class onDueDateChanged(val date: Date): AddTaskEvent
    data class onTimeChanged(val time: Date): AddTaskEvent
    object onAddClicked: AddTaskEvent
}