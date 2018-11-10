package app.superesenou.ru.example_neobis_translate.main.ui.webrand


import app.superesenou.ru.webrand.main.StartApplication
import app.superesenou.ru.webrand.main.model.WebrandContact
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebrandPresenter(val view:WebrandContract.View):WebrandContract.Presenter {
    override fun getWebrand() {
        if(isViewAttached()){
            view.showProgress()
            StartApplication.servicewebrand.getWebrand().enqueue(
                object : Callback<MutableList<WebrandContact>>{
                    override fun onFailure(call: Call<MutableList<WebrandContact>>?, t: Throwable?) {
                        if(isViewAttached()){
                            view.hideProgress()
                        }
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<MutableList<WebrandContact>>?, response: Response<MutableList<WebrandContact>>?) {
                        if(isViewAttached()){
                            if (response!!.isSuccessful && response != null) {
                                view.onSuccssesGetWebrand(response.body()!!)
                            }
                            else
                                view.onFailure()
                            view!!.hideProgress()
                        }
                    }
                }
        )
    }
}
    fun isViewAttached():Boolean = view!= null
}

