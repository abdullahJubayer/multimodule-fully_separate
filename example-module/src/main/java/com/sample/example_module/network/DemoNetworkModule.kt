package com.sample.example_module.network


import com.sample.base.utils.NetworkConnectivity
import com.sample.example_module.demo.repo.DemoLocalRepositoryImp
import com.sample.example_module.demo.repo.DemoRemoteRepositoryImp
import com.sample.example_module.demo.repo.DemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DemoNetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://www.example.com")
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun provideDemoRepository(
        networkConnectivity: NetworkConnectivity,
        remoteRepositoryImp: DemoRemoteRepositoryImp,
        localRepositoryImp: DemoLocalRepositoryImp
    ): DemoRepository =
        if (networkConnectivity.isConnected())
            remoteRepositoryImp
        else
            localRepositoryImp

}
