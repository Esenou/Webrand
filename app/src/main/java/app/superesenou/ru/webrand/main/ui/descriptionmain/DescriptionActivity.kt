package app.superesenou.ru.webrand.main.ui.descriptionmain

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.MediaMetadataRetriever
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.R.id.gone
import android.view.View
import android.widget.ImageView
import app.superesenou.ru.webrand.R
import app.superesenou.ru.webrand.main.model.WebrandContact
import app.superesenou.ru.webrand.main.ui.main.BaseActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.item_selectionmain.*
import kotlinx.android.synthetic.main.item_selectionmain.view.*
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import kotlin.math.max


class DescriptionActivity :BaseActivity() {

    var pbar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)



        val bundle = intent.extras
        if (bundle != null) {
            val json = bundle.getString("key")
            val vh = Gson().fromJson<WebrandContact>(json, WebrandContact::class.java!!)
            web_details_decription.text=vh.web_details
            Picasso.get().load("http://webrand.kg/admin/image/webimg/"+vh.web_img).into(web_img_decription)
           Glide.with(this).load("http://webrand.kg/admin/image/"+vh.web_image)

                   .listener(object : RequestListener<Drawable> {
                       override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                           progressBar1.visibility=View.GONE
                           return false
                       }
                       override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean { progressBar1.visibility=View.GONE
                           progressBar1.visibility=View.GONE
                           return false
                       }
                   })
                   .apply(RequestOptions.overrideOf(max(10,800),max(10,4000)))
                   .into(web_img_decription_two)
            web_name_decription.text=vh.web_name
            web_price_decription.text=vh.web_price






        }



    }
}