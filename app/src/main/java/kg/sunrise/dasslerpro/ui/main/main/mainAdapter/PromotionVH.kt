package kg.sunrise.dasslerpro.ui.main.main.mainAdapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import kg.sunrise.dasslerpro.R
import kg.sunrise.dasslerpro.base.adapter.BaseVH

class PromotionVH(parent: ViewGroup, @LayoutRes id: Int) : BaseVH<TestPromotionInfo>(parent, id) {
    private val ivImage = itemView.findViewById<ImageView>(R.id.iv_image)
    private val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
    private val tvDate = itemView.findViewById<TextView>(R.id.tv_date)

    override fun bind(item: TestPromotionInfo) {
        ivImage.setImageResource(R.drawable.img_placeholder_promotion)
        tvTitle.text = item.title
        tvDate.text = item.date
    }
}

data class TestPromotionInfo(
    val date: String,
    val title: String
)