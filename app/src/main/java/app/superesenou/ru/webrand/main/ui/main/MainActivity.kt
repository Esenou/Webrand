package app.superesenou.ru.webrand.ui.main

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.EventLogTags
import android.view.View
import android.widget.Toast
import app.superesenou.ru.example_neobis_translate.main.ui.webrand.WebrandContract
import app.superesenou.ru.example_neobis_translate.main.ui.webrand.WebrandPresenter
import app.superesenou.ru.webrand.R
import app.superesenou.ru.webrand.main.model.WebrandContact
import app.superesenou.ru.webrand.main.ui.descriptionmain.DescriptionActivity
import app.superesenou.ru.webrand.main.ui.main.BaseActivity
import app.superesenou.ru.webrand.main.ui.main.WebrandAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : BaseActivity(),WebrandContract.View,WebrandAdapter.Listener {
    override fun onFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOnItemClick(position: WebrandContact) {
        Toast.makeText(this,"Item :"+position.web_id, Toast.LENGTH_LONG).show()
      val intent = Intent(this, DescriptionActivity::class.java)
        val bundle = Bundle()
        bundle.putString("key", Gson().toJson(position))
        intent.putExtras(bundle)
        startActivity(intent)
    }

    lateinit var presenter: WebrandPresenter
    lateinit var adapter:WebrandAdapter
    override fun onSuccssesGetWebrand(list: MutableList<WebrandContact>) {
        recyclerViewWebrand.layoutManager= GridLayoutManager(this,1)
        adapter= WebrandAdapter(list,this)
        recyclerViewWebrand.adapter=adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        getSupportActionBar()?.setDisplayShowHomeEnabled(false);

        init()
    }
    fun init(){
        presenter=WebrandPresenter(this)
        presenter.getWebrand()
    }
}
