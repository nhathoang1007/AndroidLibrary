package com.ecoatm.ecoapp.android.dagger.scope

import javax.inject.Scope


/**
 * Created by Jason on 2/10/2019.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FILE,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class FragmentScope