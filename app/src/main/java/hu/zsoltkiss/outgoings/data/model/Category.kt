package hu.zsoltkiss.outgoings.data.model

import hu.zsoltkiss.outgoings.R

enum class Category(val jsonValue: String) {

    Clothing("clothing"),
    Food("food"),
    Housing("housing"),
    Travel("travel");

    val imageResource: Int?
        get() {
            return when (this) {
                Travel ->  R.drawable.category_travel
                Clothing ->  R.drawable.category_clothing
                Housing ->  R.drawable.category_housing
                Food ->  R.drawable.category_food
            }
        }

}