package kg.sunrise.dasslerpro.ui.main.main.mainAdapter

import android.view.ViewGroup
import kg.sunrise.dasslerpro.R
import kg.sunrise.dasslerpro.base.adapter.BaseAdapter
import kg.sunrise.dasslerpro.dto.SliderInfoDto

class PromotionAdapter : BaseAdapter<TestPromotionInfo, PromotionVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionVH {
        return PromotionVH(parent, R.layout.rv_promotion_item)
    }
}