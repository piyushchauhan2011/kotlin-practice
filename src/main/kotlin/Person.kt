/**
 * Created by piyushchauhan on 8/06/2016.
 */
class Person(val name: String, val age: Int): Comparable<Person>  {
    override fun compareTo(other: Person): Int {
        return this.name.compareTo(other.name)
    }

    override fun toString(): String {
        return "(${this.name}, ${this.age})"
    }
}