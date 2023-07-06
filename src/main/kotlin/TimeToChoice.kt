import kotlin.system.exitProcess

class TimeToChoice(val notesapp: NotesApp) {
    val noteandarchive = NoteAndArchive(notesapp, this)
    fun timeToChoice(choice: Int) {
        when {
            (notesapp.currentNote != null && (choice == 1 || choice == 2)) -> currentNoteChoice(choice)
            notesapp.currentArchive != null && (choice == 1 || choice == 2 || choice == 3) -> currentArchiveChoice(choice)
            choice == 1 || choice == 2 || choice == 3 -> choiceOnMainMenu(choice)
            else -> println("Некорректный выбор. Введите цифру из меню.")
        }
    }

    fun currentNoteChoice(choice: Int) {
        when (choice) {
            1 -> notesapp.currentNote = null
            2 -> println("Текст заметки:\n" + notesapp.currentNote?.content)
        }
    }

    fun currentArchiveChoice(choice: Int) {
        when (choice) {
            1 -> notesapp.currentArchive = null
            2 -> noteandarchive.createNote()
            3 -> noteandarchive.selectNote()
        }
    }

    fun choiceOnMainMenu(choice: Int) {
        when (choice) {
            1 -> noteandarchive.createArchive()
            2 -> noteandarchive.selectArchive()
            3 -> {
                println("Выход из приложения \"Заметки\"")
                exitProcess(0)
            }
        }
    }
}