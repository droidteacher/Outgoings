package hu.zsoltkiss.outgoings.data.model

import com.google.gson.TypeAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


data class TransactionItem(
    @SerializedName("id")
    @Expose
    val transactionId: String,

    @SerializedName("summary")
    @Expose
    val summary: String,

    @SerializedName("category")
    @JsonAdapter(CategoryTypeAdapter::class)
    @Expose
    val category: Category,

    @SerializedName("sum")
    @Expose
    val amount: Int,

    @SerializedName("currency")
    @Expose
    val currency: String,

    @SerializedName("paid")
    @JsonAdapter(InstantTypeAdapter::class)
    @Expose
    val transactionTime: Instant
) {

    val transactionDate: String
        get() {
            return DateTimeFormatter.ofPattern("yyyy.MM.dd.")
                .withZone(ZoneId.systemDefault()).let {
                    it.format(transactionTime)
                }
        }

}

class InstantTypeAdapter: TypeAdapter<Instant>() {

    override fun write(writer: JsonWriter?, value: Instant?) {
        value?.let { instant ->
            writer?.value(instant.toString())
        }
    }

    override fun read(reader: JsonReader?): Instant? {
        return reader?.nextString()?.let {
            Instant.parse(it)
        }
    }

}

class CategoryTypeAdapter: TypeAdapter<Category>() {
    override fun write(writer: JsonWriter?, value: Category?) {
        value?.let { category ->
            writer?.value(category.jsonValue)
        }
    }

    override fun read(reader: JsonReader?): Category? {
        return reader?.nextString()?.let {
            when (it) {
                "travel" -> Category.Travel
                "housing" -> Category.Housing
                "food" -> Category.Food
                "clothing" -> Category.Clothing
                else -> null
            }
        }
    }

}