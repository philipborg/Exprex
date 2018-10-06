package com.philipborg.exprex.exceptions

class MissingParameterException(parameter: Int, message: String? = null, cause: Throwable? = null) :
        IllegalArgumentException(
                message ?: "Parameter $parameter is missing",
                cause)