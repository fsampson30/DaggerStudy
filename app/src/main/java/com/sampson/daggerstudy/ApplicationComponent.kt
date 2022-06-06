package com.sampson.daggerstudy

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun createMainSubComponent() : MainSubcomponent
}