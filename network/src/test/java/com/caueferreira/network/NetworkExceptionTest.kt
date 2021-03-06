package com.caueferreira.network

import org.junit.Test
import java.io.InterruptedIOException
import java.net.*
import java.nio.channels.ClosedChannelException
import javax.net.ssl.SSLException

class NetworkExceptionTest {

    @Test
    fun `should all be true`() {
        val networkExceptions = arrayListOf(
            BindException(),
            ClosedChannelException(),
            ConnectException(),
            InterruptedIOException(),
            NoRouteToHostException(),
            PortUnreachableException(),
            ProtocolException(),
            SocketException(),
            SocketTimeoutException(),
            SSLException(""),
            UnknownHostException(),
            UnknownServiceException())

        networkExceptions.forEach {
            assert(it.isNetworkException())
        }
    }

    @Test
    fun `should be false`(){
        assert(!Throwable().isNetworkException())
    }
}