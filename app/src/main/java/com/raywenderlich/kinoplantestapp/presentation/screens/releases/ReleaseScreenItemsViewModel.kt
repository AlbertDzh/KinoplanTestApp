package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import android.app.Service
import android.widget.Button
import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.model.Release

data class ReleaseScreenItems (
    val banners: List<Banner>,
    val now: RepertoryItem,
    val premiere: RepertoryItem,
    val kids: RepertoryItem,
    val soon: RepertoryItem
) {
    val size: Int = 5
}

data class RepertoryItem(
    val title: String,
    val releases: List<Release>
    )



/* class TestView: ViewInputInterface {

    val button: Button
    val output: ViewOutputInterface?

    initView() {
      val presenter = Presenter(view: this)\
      this.output = presenter
    }

    button.listener {
        output.onButtonClicked()
    }

}

interface ViewOutputInterface {
    fun onButtonClicked()
}

interface ViewInputInterface {
    fun startLoading()
}


val testView = TestView()
val testPresenter = TestPresenter(view: testView)
testView.output = testPresenter


class TestPresenter: ViewOutputInterface  {

    val view: ViewInputInterface?
    val registerService: Service

    init(view: ViewInputInterface) {
        this.view = view
    }

    override fun onButtonClicked() {
        registerService.register()
            .onComplete { view?.startLoading() }
            .onError {}
    }

}

*/