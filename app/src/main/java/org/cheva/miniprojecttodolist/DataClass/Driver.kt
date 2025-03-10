package org.cheva.miniprojecttodolist.DataClass

class Driver() {
    companion object {
        val userList: MutableList<User> = ArrayList<User>()

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
    }
}
