package com.busrayalcin.testartbookkotlin.dependencyinjection

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.busrayalcin.testartbookkotlin.R
import com.busrayalcin.testartbookkotlin.api.RetrofitAPI
import com.busrayalcin.testartbookkotlin.repo.ArtRepository
import com.busrayalcin.testartbookkotlin.repo.ArtRepositoryInterface
import com.busrayalcin.testartbookkotlin.room.ArtDAO
import com.busrayalcin.testartbookkotlin.room.ArtDatabase
import com.busrayalcin.testartbookkotlin.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRoomDatabase(
        @ApplicationContext context : Context) = Room.databaseBuilder(
        context, ArtDatabase::class.java,"ArtBookDB"
        ).build()

    @Singleton
    @Provides
    fun injectDao(database: ArtDatabase) = database.artDao()

    @Singleton
    @Provides
    fun injectRetrofitAPI(): RetrofitAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitAPI::class.java)
    }

    @Singleton
    @Provides
    fun injectNormalRepo(dao: ArtDAO, api: RetrofitAPI) = ArtRepository(dao, api) as ArtRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )
}