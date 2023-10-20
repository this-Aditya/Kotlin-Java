package a.test.a.hash_check

import java.util.Objects

class One {
    var id = 8765432
    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}