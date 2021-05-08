package io.intelligible.shoeinventory.viewmodel

import androidx.lifecycle.ViewModel
import io.intelligible.shoeinventory.model.ShoeModel

class SharedViewModel : ViewModel() {

    var shoelist = mutableListOf<ShoeModel>()


}