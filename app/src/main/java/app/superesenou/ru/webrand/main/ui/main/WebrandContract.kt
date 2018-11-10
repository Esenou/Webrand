package app.superesenou.ru.example_neobis_translate.main.ui.webrand


import app.superesenou.ru.example_neobis_translate.main.utils.IProgressBar
import app.superesenou.ru.webrand.main.model.WebrandContact

interface WebrandContract {

    interface View:IProgressBar{
        fun onSuccssesGetWebrand(list: MutableList<WebrandContact>)
        fun onFailure()
    }
    interface Presenter{
        fun getWebrand()
    }
}