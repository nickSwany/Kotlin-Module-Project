class TimeToChoice(val np:NotesApp) {

    val ch = Create(np, this)


    fun timeToChoice(choice: Int) {
        when {
            (np.currentNote != null && (choice == 1 || choice == 2)) -> {
                currentNoteChoice(choice)
            }

            np.currentArchive != null && (choice == 1 || choice == 2 || choice == 3) -> {
                currentArchiveChoice(choice)
            }

            choice == 1 || choice == 2 || choice == 3 -> {
                choiceOnMainMenu(choice)
            }

            else -> {
                println("Некорректный выбор. Введите цифру из меню.")
            }
        }
    }

    fun currentNoteChoice(choice: Int) {
        when (choice) {
            1 -> {
                np.currentNote = null
            }

            2 -> {
                println("Текст заметки:\n" + np.currentNote?.content)
            }

        }
    }

    fun currentArchiveChoice(choice: Int) {
        when (choice) {
            1 -> {
                np.currentArchive = null
            }

            2 -> {
                ch.createNote()
            }

            3 -> {
                ch.selectNote()
            }
        }
    }

    fun choiceOnMainMenu(choice: Int) {
        when (choice) {
            1 -> ch.createArchive()
            2 -> ch.selectArchive()
            3 -> np.exitNotes()
        }
    }
}