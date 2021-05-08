package io.intelligible.shoeinventory.exensions

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.isEmpty(): Boolean{
   return this.editText!!.text.toString().isEmpty()
}