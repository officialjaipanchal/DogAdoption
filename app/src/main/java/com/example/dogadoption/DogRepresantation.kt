package com.example.dogadoption


import androidx.annotation.DrawableRes

data class Puppy(
    @DrawableRes val resId: Int,
    val name: String,
    val description: String
)

object DogRepresantation {
    val puppies = listOf<Puppy>(
        Puppy(R.drawable.jerry, "Jerry", ""),
        Puppy(R.drawable.jay, "Jay", ""),
        Puppy(R.drawable.manav, "Manav", ""),
        Puppy(R.drawable.rushi, "Rushi", ""),
        Puppy(R.drawable.rahul, "Rahul", ""),
        Puppy(R.drawable.akash, "Akash_lalit", ""),
        Puppy(R.drawable.bholu, "Bholu", ""),
        Puppy(R.drawable.jai, "Jai", "")
    )
}
