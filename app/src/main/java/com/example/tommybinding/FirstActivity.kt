package com.example.tommybinding

import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tommybinding.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Dumadu on 26-Oct-17.
 */
class FirstActivity : AppCompatActivity(), RecyclerViewAdapter.DatasClickListener {
    var hasDatas: ArrayList<Datas> = ArrayList()
    override fun getItem(position: Int) {
        val alertDialog = AlertDialog.Builder(this@FirstActivity)
        alertDialog.setTitle(hasDatas.get(position).firstName)
        alertDialog.setMessage(hasDatas.get(position).lastName)
        alertDialog.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@FirstActivity, "OK", Toast.LENGTH_SHORT).show()
        }
//        alertDialog.setNegativeButton("No") { dialog, which ->
//            Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
//        }
        alertDialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview_demo)
        print(recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getDatas().enqueue(object : Callback<ArrayList<Datas>> {
            override fun onResponse(call: Call<ArrayList<Datas>>?, response: Response<ArrayList<Datas>>?) {
                hasDatas = response?.body()!!
                recyclerView.adapter = RecyclerViewAdapter(response.body()!!, this@FirstActivity)
            }

            override fun onFailure(call: Call<ArrayList<Datas>>?, t: Throwable?) {
                print(t.toString())
            }
        })


    }
}