package at.fh.swengb.lesch

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Review (val reviewValue:Double,
              val reviewText:String)