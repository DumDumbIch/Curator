package com.dumdumbich.curator.di.scope.main.module

import com.dumdumbich.curator.di.scope.main.MainScope
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named

@Module
class SchedulerModule {

    @Named("ui")
    @MainScope
    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

}