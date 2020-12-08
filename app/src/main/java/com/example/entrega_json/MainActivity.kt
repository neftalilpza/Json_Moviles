package com.example.entrega_json

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
 lateinit var lista_alumnos : ArrayList<Alumno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun comprobarConexion(){
        if (Network.hayRed(this)){
                solicitarJSON_object();
        }else{
            Toast.makeText(this,"Error de conexion",Toast.LENGTH_SHORT).show()
        }
    }





    fun solicitarJSON_object(){
        val queue = Volley.newRequestQueue(this)
        //val url = "https://moviles-dos.000webhostapp.com/"
        //val url = "http://localhost/escuela/"
        val url = "https://escuela-moviles.000webhostapp.com/"



        val JsonObjectRequest = JsonObjectRequest(url, null,
            Response.Listener { response ->
                try {
                    val json : JSONObject
                    json =response
                    generar_array(json)

                }catch (e:JSONException){
                    Log.d("msg_error",e.localizedMessage)
                }
                Log.i("JSON_OBJECT", "response is $response")
            },
            Response.ErrorListener { error ->
                error.printStackTrace()

            }
        )
            queue.add(JsonObjectRequest)
    }

        fun generar_array(json :JSONObject){
            lista_alumnos = ArrayList()

            val json =json
            val  alumnos =json.getJSONArray("Alumnos")
            for (i in 0.. alumnos.length()-1){
                val id = alumnos.getJSONObject(i).getInt("id");
                val numero_control = alumnos.getJSONObject(i).getInt("numero_control")
                val nombre = alumnos.getJSONObject(i).getString("nombre")
                val carrera = alumnos.getJSONObject(i).getString("carrera")
                val semestre = alumnos.getJSONObject(i).getInt("semestre")
                val grupo = alumnos.getJSONObject(i).getString("grupo")
                lista_alumnos.add(Alumno(id,numero_control,nombre,carrera,semestre,grupo))
                Log.d("onCreate", lista_alumnos.count().toString())

                mandar_lista(lista_alumnos);
            }
    }


    fun btn_mostrar(view: View) {
        comprobarConexion()
    }


        fun mandar_lista(lista_alunos : ArrayList<Alumno>){
            val intent : Intent = Intent(applicationContext, Listar::class.java)
            intent.putParcelableArrayListExtra("lista_alumnos",lista_alumnos as java.util.ArrayList<out Parcelable>)
            startActivity(intent)

        }

}
