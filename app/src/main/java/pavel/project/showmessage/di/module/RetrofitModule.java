package pavel.project.showmessage.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import pavel.bogrecov.example.data.api.JsonAPI;
import pavel.bogrecov.example.data.api.PhotoApi;
import pavel.bogrecov.example.data.mapper.UserEntityDataMapper;
import pavel.bogrecov.example.data.repository.NetworkRepository;
import pavel.bogrecov.example.domain.InteractorNetwork;
import pavel.bogrecov.example.utils.rx.AppRxSchedulers;
import pavel.project.showmessage.data.api.JsonPlaceholderApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static pavel.bogrecov.example.data.api.UrlConfigApi.BASE_PHOTO;
import static pavel.bogrecov.example.data.api.UrlConfigApi.BASE_URL;
import static pavel.project.showmessage.data.api.UrlConfigApi.BASE_URL;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    JsonPlaceholderApi provideApiService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl(BASE_URL)
                .addConverterFactory(provideGsonClient()).
                        addCallAdapterFactory(provideRxAdapter()).build();

        return retrofit.create(JsonPlaceholderApi.class);
    }


    @Provides
    @Singleton
    OkHttpClient provideHttpClient() {
        return new OkHttpClient().newBuilder().build();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxAdapter() {
        return RxJava2CallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
    }

    @Provides
    GsonConverterFactory provideGsonClient() {
        return GsonConverterFactory.create();
    }

}

