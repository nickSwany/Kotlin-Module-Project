class NoteAndArchive(val notesapp: NotesApp, val timetochoice: TimeToChoice) {

    fun createNote() {
        println("Введите заголовок заметки.")
        var title: String? = null
        while (true){
            title = readLine()
            if(title.isNullOrEmpty()) {
                println("Необходимо ввести заголовок заметки")
            } else break
        }
        println("Введите текст заметки:")
        var content: String? = null
        while (true) {
            content = readLine()
            if (content.isNullOrEmpty()) {
                println("Необходимо ввести текст заметки")
            } else break
        }
        val note = Note(title!!, content!!)
        notesapp.currentArchive?.notes?.add(note)
        println("Заметки \"$title\" создана.")
    }

    fun createArchive() {
        print("Введите название архива\n")
        var name: String? = null
        while(true){
            name = readLine()
            if (name.isNullOrEmpty()) {
                println("Необходимо ввести название архива")
            } else break
        }
        val archive = Archive(name!!)
        notesapp.archives.add(archive)
        notesapp.currentArchive = archive
        println("Архив \"$name\" создан")
    }

    fun selectArchive() {
        println("Список архивов:")
        println("0. Назад")
        for (i in notesapp.archives.indices) {
            println("${i + 1}. ${notesapp.archives[i].name}")
        }
        println("Введите номер архива:")
        val choice = notesapp.scannerUser()
        if (choice in 0..notesapp.archives.size) {
            notesapp.currentArchive = if (choice == 0) null else notesapp.archives[choice - 1]
        } else {
            println("Некорректный выбор архива")
        }
    }

    fun selectNote() {
        val notes = notesapp.currentArchive?.notes
        if (notes != null && notes.isNotEmpty()) {
            println("Список заметок:")
            for (i in notes.indices)
                println("${i + 1}. ${notes[i].title}")
            println("Введите номер заметки")
            val choice = notesapp.scannerUser()
            if (choice in 1..notes.size) {
                notesapp.currentNote = notes[choice - 1]
            } else {
                println("Некоректный выбор заметки.")
            }
        } else {
            println("Архив пуст. Необходимо создать хотя бы одну заметку")
        }
    }
}