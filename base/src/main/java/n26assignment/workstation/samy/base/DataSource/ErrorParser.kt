package n26assignment.workstation.samy.base.DataSource

import n26assignment.workstation.samy.base.Model.ErrorModel
import retrofit2.Response
import java.io.IOException

object ErrorParser {
    private val genralErrorMessage: String = "something went wrong please try again later"
    fun parseError(response: Response<*>): ErrorModel {
        val baseRetrofitRequest = BaseRetrofitRequest()
        val converter = baseRetrofitRequest.retrofit.responseBodyConverter<ErrorModel>(
            ErrorModel::class.java,
            arrayOfNulls<Annotation>(0)
        )
        val error: ErrorModel

        try {
            error = converter.convert(response.errorBody()!!)
        } catch (e: IOException) {
            return ErrorModel("", genralErrorMessage)
        }
        return error
    }
}