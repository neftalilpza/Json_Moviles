package com.example.entrega_json

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Listar : AppCompatActivity() {
   lateinit var lista_alumnos :ArrayList<Alumno>

    var lista : RecyclerView?=null
    var layoutManager: RecyclerView.LayoutManager?=null
    var adaptador: Adaptador_custom?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)
        lista_alumnos= ArrayList()
        var intent: Intent = intent
      lista_alumnos = intent.getParcelableArrayListExtra("lista_alumnos")


        lista = findViewById(R.id.lista_alumnos)
        lista?.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        adaptador= Adaptador_custom(this, lista_alumnos!!)
        lista?.layoutManager=layoutManager
        lista?.adapter=adaptador




    }
}
