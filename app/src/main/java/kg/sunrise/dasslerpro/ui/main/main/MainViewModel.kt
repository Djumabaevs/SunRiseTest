package kg.sunrise.dasslerpro.ui.main.main

import kg.sunrise.dasslerpro.base.viewModel.BaseViewModel
import kg.sunrise.dasslerpro.ui.main.main.mainAdapter.TestPromotionInfo

class MainViewModel : BaseViewModel() {

    // todo: remove
    fun getData(): ArrayList<TestPromotionInfo> {
        return arrayListOf(
            TestPromotionInfo("00.11.22", "sldjf;la dksjaf;lkj lksdjf lkjsdlkf "),
            TestPromotionInfo("11.22.22", "asd sad kasjd lksdla "),
            TestPromotionInfo("22.33.22", "asdk skald "),
            TestPromotionInfo("44.11.33", "aslkdj askldj aklsjd aksjd laksjd lkasjd lkajsdl; kajsdkl "),
            TestPromotionInfo("22.33.11", "askdl jalksjd laksjdlk asd "),
            TestPromotionInfo("00.55.11", "aksdjlk asjk jaslkd jkalsd "),
        )
    }
}
