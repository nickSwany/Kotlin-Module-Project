class Create(val nt: NotesApp, val tc: TimeToChoice) {

    fun createNote() {
        println("Введите заголовок заметки.")
        val title = readLine() ?: ""
        println("Введите текст заметки:")
        val content = readLine() ?: ""
        val note = Note(title, content)
        nt.currentArchive?.notes?.add(note)
        println("Заметки \"$title\" создана.")
    }

    fun createArchive() {
        print("Введите название архива\n")
        val name = readLine() ?: ""
        val archive = Archive(name)
        nt.archives.add(archive)
        nt.currentArchive = archive
        println("Архив \"$name\" создан")
    }

    fun selectArchive() {
        println("Список архивов:")
        println("0. Назад")
        for (i in nt.archives.indices) {
            println("${i + 1}. ${nt.archives[i].name}")
        }
        println("Введите номер архива:")
        val choice = nt.scannerUser()
        if (choice in 0..nt.archives.size) {
            nt.currentArchive = if (choice == 0) null else nt.archives[choice - 1]
        } else {
            println("Некорректный выбор архива")
        }
    }

    fun selectNote() {
        val notes = nt.currentArchive?.notes
        if (notes != null && notes.isNotEmpty()) {
            println("Список заметок:")
            for (i in notes.indices)
                println("${i + 1}. ${notes[i].title}")
            println("Введите номер заметки")
            val choice = nt.scannerUser()
            if (choice in 1..notes.size) {
                nt.currentNote = notes[choice - 1]
            } else {
                println("Некоректный выбор заметки.")
            }
        } else {
            println("Архив пуст. Необходимо создать хотя бы одну заметку")
        }
    }
}