package vbn.base.kmpapp.core.presentation

import basekmpapp.composeapp.generated.resources.Res
import basekmpapp.composeapp.generated.resources.error_disk_full
import basekmpapp.composeapp.generated.resources.error_no_internet
import basekmpapp.composeapp.generated.resources.error_request_timeout
import basekmpapp.composeapp.generated.resources.error_serialization
import basekmpapp.composeapp.generated.resources.error_server
import basekmpapp.composeapp.generated.resources.error_too_many_request
import basekmpapp.composeapp.generated.resources.error_unknown
import vbn.base.kmpapp.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes = when (this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_request_timeout
        DataError.Remote.TOO_MANY_REQUEST -> Res.string.error_too_many_request
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_server
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
    }
    return UiText.StringResourceId(stringRes)
}