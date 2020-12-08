package com.example.entrega_json

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador_custom(var context: Context, items : ArrayList<Alumno>):
    RecyclerView.Adapter<Adaptador_custom.ViewHolder>() {

     var items:ArrayList<Alumno>?
    init {
        this.items=items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptador_custom.ViewHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val vista = LayoutInflater.from(context).inflate(R.layout.template_alumnos,parent, false)
        var viewHolder =ViewHolder(vista)
        return  viewHolder
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: Adaptador_custom.ViewHolder, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val item =items?.get(position)

        holder?.id?.text=item?.id.toString()
        holder?.numero_control?.text=item?.numero_control.toString()
        holder?.nombre?.text=item?.nombre
        holder?.carrera?.text=item?.carrera
        holder?.semestre?.text=item?.semestre.toString()
        holder?.grupo?.text=item?.grupo

    }



    class ViewHolder (vista : View) : RecyclerView.ViewHolder(vista){
        var vista= vista

        var id : TextView? = null
        var numero_control : TextView? = null
        var nombre : TextView? = null
        var carrera : TextView? = null
        var semestre : TextView? = null
        var grupo : TextView? = null


        init {
                id= vista.findViewById(R.id.mostrar_id)
            numero_control= vista.findViewById(R.id.mostrar_numero_control)
            nombre= vista.findViewById(R.id.mostrar_nombre)
            carrera= vista.findViewById(R.id.mostrar_carrera)
            semestre= vista.findViewById(R.id.mostrar_semestre)
            grupo= vista.findViewById(R.id.mostrar_grupo)
        }
    }
}