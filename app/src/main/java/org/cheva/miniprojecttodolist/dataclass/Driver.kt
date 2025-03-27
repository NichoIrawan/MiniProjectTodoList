package org.cheva.miniprojecttodolist.dataclass

import androidx.compose.ui.graphics.Color
import org.cheva.miniprojecttodolist.R
import java.util.Date

class Driver() {
    companion object {
        //List
        val userList: MutableList<User> = ArrayList<User>()
        val taskCategoryList: MutableList<TaskCategory> = ArrayList<TaskCategory>()
        val taskList: MutableList<Task> = ArrayList<Task>()

        //User Method
        fun addUser(name: String, email: String, pass: String) {
            userList.add(User(name, email, pass))
        }

        fun checkAvailability(name: String, email: String, pass: String): Boolean {
            return !userList.contains(User(name, email, pass))
        }

        fun checkCredential(name: String, pass: String): Boolean {
            for (user: User in userList) {
                if (user.name == name && user.password == pass) {
                    return true
                }
            }
            return false
        }

        //TaskCategory
        fun addTaskCategory(title: String, image: Int, color1: Color, color2: Color){
            taskCategoryList.add(TaskCategory(title, image, color1, color2))
        }

        //Task
        fun addTask(title: String, category: TaskCategory, dueDate: Date){
            var newTask = Task(title, category, dueDate)
            taskList.add(newTask)
            category.taskList.add(newTask)
        }

        // Dummy constructor
        fun driverConstruct() {
            addTaskCategory(
                title = "To-Do",
                image = R.drawable.icon_todo,
                color1 = Color(0xFFEE68AF),
                color2 = Color(0xFFEB479E)
            )
            addTaskCategory(
                title = "In-Progress",
                image = R.drawable.icon_progress,
                color1 = Color(0xFFEE68AF),
                color2 = Color(0xFFEB479E)
            )
            addTaskCategory(
                title = "Done",
                image = R.drawable.icon_done,
                color1 = Color(0xFFEE68AF),
                color2 = Color(0xFFEB479E)
            )

            addTask(
                title = "Make a wireframe",
                category = taskCategoryList.elementAt(0),
                dueDate = Date(2000)
            )
        }
    }
}
