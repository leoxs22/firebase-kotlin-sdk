package dev.gitlive.firebase

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ClosedSendChannelException
import kotlinx.coroutines.channels.SendChannel

//workaround for https://github.com/Kotlin/kotlinx.coroutines/issues/974
@ExperimentalCoroutinesApi
fun <E> SendChannel<E>.safeOffer(element: E) = try {
    !isClosedForSend && offer(element)
} catch (e : ClosedSendChannelException) {
    false
}