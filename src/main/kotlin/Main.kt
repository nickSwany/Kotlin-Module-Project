fun main() {
    val app = NotesApp()
    app.runApp()
}
class Archive(val name: String) {
    val notes: MutableList<Note> = mutableListOf()
}
data class Note(val title: String, val content: String)
class NotesApp() {
    val archives: MutableList<Archive> = mutableListOf()
    var currentArchive: Archive? = null
    var currentNote: Note? = null
    val tc = TimeToChoice(this)

    fun runApp() {
        while (true) {
            mainMenu()
            val choice = scannerUser()
            tc.timeToChoice(choice)
        }
    }

    fun scannerUser(): Int {
        try {
            return readLine()?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            println("Некорректный ввод. Введите число.")
        }
        return 0
    }

    fun mainMenu() {
        println("Меню:")
        if (currentNote == null && currentArchive == null) {
            println("1. Создать архив\n2. Выбрать архив\n3. Выход")
        } else if (currentNote != null) {
            println("1. Вернуться к списку заметок\n2. Вывести текст заметки")
        } else if (currentArchive != null) {
            println("1. Вернуться к списку архивов\n2. Создать заметку\n3. Выбрать заметку")
        }
    }

    fun exitNotes() {
        println("Выход из приложения")
        System.exit(0)
    }
}









