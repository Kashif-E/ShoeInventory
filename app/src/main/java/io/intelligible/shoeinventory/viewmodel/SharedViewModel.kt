package io.intelligible.shoeinventory.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.intelligible.shoeinventory.model.ShoeModel
import java.util.*

class SharedViewModel : ViewModel() {
    var shoelist= mutableListOf<ShoeModel>()
    var shoeName : String=""
    var shoeSize : String=""
    var company : String =""
    var description: String=""

    fun onAddClick(){


            if (shoeName.isEmpty() || shoeSize.isEmpty() || company.isEmpty() || description.isEmpty()){

            }else{

                shoelist. add(
                    ShoeModel(
                        shoeId = UUID.randomUUID().toString(),
                        shoeName = shoeName,
                        company = company,
                        shoeSize = shoeSize,
                        shoeDescription = description
                    )
                )
            }


    }


}