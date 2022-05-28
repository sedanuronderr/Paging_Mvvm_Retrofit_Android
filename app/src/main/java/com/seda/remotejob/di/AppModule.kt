package com.seda.remotejob.di


import android.content.Context
import androidx.room.Room
import com.seda.remotejob.api.RemoteJobResponse
import com.seda.remotejob.api.jobDatabase
import com.seda.remotejob.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module //Hilt module’ü olacağını belirtiyoruz.
@InstallIn(SingletonComponent::class) //Kullanacağımız kapsamı belirtiyoruz
//Nesneye her ulaştığımızda hep aynı nesneyi verecektir bize sürekli yeniden create etmez .
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides //Module içerisinde provides ile tanımlanan fonksiyonları her zaman kullanacaktır.
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String): RemoteJobResponse =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RemoteJobResponse::class.java)


    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context : Context)=
        Room.databaseBuilder(context,jobDatabase::class.java,"jobtable" ).build()


    @Singleton
    @Provides

    fun provideTodoDao(db:jobDatabase)= db.jobdao()

}