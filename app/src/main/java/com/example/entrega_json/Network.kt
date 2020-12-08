package com.example.entrega_json

import android.content.Context
import android.net.ConnectivityManager
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity

class Network {
    companion object{
        fun hayRed(activity: AppCompatActivity):Boolean{
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE)
            as ConnectivityManager
            val networkInfo =connectivityManager.activeNetworkInfo
            return  networkInfo != null && networkInfo.isConnected
        }
    }
}

class Alumno(val id : Int, val  numero_control : Int, val nombre: String, val carrera : String, val semestre: Int, val grupo: String ):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {

    }




    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        parcel.writeInt(id)
        parcel.writeInt(numero_control)
        parcel.writeString(nombre)
        parcel.writeString(carrera)
        parcel.writeInt(semestre)
        parcel.writeString(grupo)


    }

    override fun describeContents(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
return  0
    }








    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Alumno>
        {
            override fun createFromParcel(parcel: Parcel): Alumno {
                return Alumno(parcel)
            }

            override fun newArray(size: Int): Array<Alumno?> {
                return arrayOfNulls(size)
            }
        }
    }

}