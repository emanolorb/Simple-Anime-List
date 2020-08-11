import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Attributes (

	@SerializedName("createdAt") val createdAt : String,
	@SerializedName("updatedAt") val updatedAt : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("synopsis") val synopsis : String,
	@SerializedName("coverImageTopOffset") val coverImageTopOffset : Int,
	@SerializedName("titles") val titles : Titles,
	@SerializedName("canonicalTitle") val canonicalTitle : String,
	@SerializedName("abbreviatedTitles") val abbreviatedTitles : List<String>,
	@SerializedName("averageRating") val averageRating : Double,
	@SerializedName("ratingFrequencies") val ratingFrequencies : RatingFrequencies,
	@SerializedName("userCount") val userCount : Int,
	@SerializedName("favoritesCount") val favoritesCount : Int,
	@SerializedName("startDate") val startDate : String,
	@SerializedName("endDate") val endDate : String,
	@SerializedName("nextRelease") val nextRelease : String,
	@SerializedName("popularityRank") val popularityRank : Int,
	@SerializedName("ratingRank") val ratingRank : Int,
	@SerializedName("ageRating") val ageRating : String,
	@SerializedName("ageRatingGuide") val ageRatingGuide : String,
	@SerializedName("subtype") val subtype : String,
	@SerializedName("status") val status : String,
	@SerializedName("tba") val tba : String,
	@SerializedName("posterImage") val posterImage : PosterImage,
	@SerializedName("coverImage") val coverImage : CoverImage,
	@SerializedName("episodeCount") val episodeCount : Int,
	@SerializedName("episodeLength") val episodeLength : Int,
	@SerializedName("totalLength") val totalLength : Int,
	@SerializedName("youtubeVideoId") val youtubeVideoId : String,
	@SerializedName("showType") val showType : String,
	@SerializedName("nsfw") val nsfw : Boolean
)