package com.avi5hek.purrfectapp.repository

import com.avi5hek.purrfectapp.model.Cat
import io.reactivex.Observable

/**
 * Created by "Avishek" on 8/19/2019.
 */
interface CatRepository {

  fun getCuteCatImages(): Observable<List<Cat>>

  fun getImageOfTheCuteCat(id: String): Observable<Cat>
}
