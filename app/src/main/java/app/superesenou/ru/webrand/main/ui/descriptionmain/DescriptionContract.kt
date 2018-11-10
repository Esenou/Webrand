package app.superesenou.ru.webrand.main.ui.descriptionmain

interface DescriptionContract {

    interface View{
        fun onSuccessGetDescription()
    }
    interface Presenter{
        fun getDescriptionData()
    }

}