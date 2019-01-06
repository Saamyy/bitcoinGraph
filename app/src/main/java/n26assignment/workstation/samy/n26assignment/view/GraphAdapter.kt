package n26assignment.workstation.samy.n26assignment.view

import com.robinhood.spark.SparkAdapter
import n26assignment.workstation.samy.base.model.MarketPrice

/**
 * Created by defuera on 27/03/2017.
 */
class GraphAdapter : SparkAdapter() {

    var data: List<MarketPrice>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getY(index: Int): Float {
        return data?.get(index)?.value?: 0F
    }

    override fun getItem(index: Int): Any? {
        return data?.get(index)
    }

    override fun getCount() = data?.size ?: 0

}