package com.avi5hek.purrfectapp.repository

import com.avi5hek.purrfectapp.model.Cat
import com.avi5hek.purrfectapp.service.CatService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by "Avishek" on 8/19/2019.
 */
class CatDataRepository
@Inject
constructor(private val catService: CatService) : CatRepository {

  override fun getCuteCatImages(): Observable<List<Cat>> {
    return catService.getCats()
  }

  override fun getImageOfTheCuteCat(id: String): Observable<Cat> {
    return catService.getCat(id)
  }
}
