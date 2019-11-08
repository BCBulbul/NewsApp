package burakcanbulbul.com.newsapp.data.local.db.serializer

interface Serializer<T> {

    fun deserialize(s: String, type: Class<T>): T

    fun serialize(instance: T): String

}