package app.superesenou.ru.webrand.main.ui.main

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import app.superesenou.ru.webrand.R
import app.superesenou.ru.webrand.main.utils.ConnectionManager

@Suppress("DEPRECATION")
open class BaseActivity:AppCompatActivity() {
    private var progressBar: ProgressDialog?=null;


    open fun showProgress(){
        this.runOnUiThread{
            progressBar=null
            if(progressBar==null && !isFinishing){

                progressBar= ProgressDialog(this)
                progressBar?.setMessage(getString(R.string.loading))
                progressBar?.setCanceledOnTouchOutside(false)
                progressBar?.show()
            }
        }
    }

    open fun hideProgress(){
        this.runOnUiThread{
            if(progressBar != null && progressBar?.isShowing!!){
                progressBar!!.dismiss()
                progressBar = null
            }
        }
    }

    open fun onRefresh() {

    }

    override fun onResume() {
        super.onResume()
        if(!ConnectionManager.isNetworkAvailable(this))
            Toast.makeText(this,"No Internet Connection", Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0,0);
    }

    override fun onDestroy() {
        super.onDestroy()
        hideProgress()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setupBackButton()
    }

    private fun setupBackButton() {
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
    }




}