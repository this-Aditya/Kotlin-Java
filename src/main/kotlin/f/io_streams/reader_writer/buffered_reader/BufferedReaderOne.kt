package f.io_streams.reader_writer.buffered_reader

    import java.io.BufferedReader
            import java.io.File
            import java.io.FileInputStream
            import java.io.InputStreamReader
            import kotlin.system.measureTimeMillis

    val inputFile =
        File("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\reader_writer\\buffered_reader\\input.txt")
    val fileInputStream = FileInputStream(inputFile)
    val inputStreamReader = InputStreamReader(fileInputStream)
    val bufferedReader = BufferedReader(inputStreamReader)
    val data1 = CharArray(1024)
    val data2 = CharArray(1024)

    fun main() {
//        val timeWithBuffer = measureTimeMillis {
//            withBuffer()
//        }
//        println("Time taken with buffer: $timeWithBuffer ms")
//        fileInputStream.close()
//        bufferedReader.close()
//        inputStreamReader.close()
        val timeWithoutBuffer = measureTimeMillis {
            withoutBuffer()
        }
        println("Time taken without buffer: $timeWithoutBuffer ms")
        val timeWithBuffer2 = measureTimeMillis {
            withBuffer2()
        }
        println("Time taken with buffer: $timeWithBuffer2 ms")

    }

    fun withBuffer() {
        var dataRead = bufferedReader.read(data1)
        var count = 1
        while (dataRead != -1) {
            for (i in (0..<dataRead)) {
                count++
            }
            dataRead = bufferedReader.read(data1)
        }
    }

    fun withBuffer2() {
        var dataRead = bufferedReader.read(data1)
        var count = 1
        while (dataRead != -1) {
            for (i in (0..<dataRead)) {
                count++
            }
            dataRead = bufferedReader.read(data1)
        }
    }


    fun withoutBuffer() {
        var dataRead = inputStreamReader.read(data2)
    while (dataRead !=-1) {
        dataRead = bufferedReader.read(data2)
    }
    }
