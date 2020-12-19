package com.example.learnmvp.util

import java.lang.reflect.ParameterizedType

/**
 * description:
 * Created by dailei on 2020/12/18
 *
 */
object MVPUtil {
    fun <T> getT(o: Any, i: Int): T? {
        try {
            return ((o.javaClass.genericSuperclass as ParameterizedType?)!!.actualTypeArguments[i] as Class<T>).newInstance()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
        return null
    }

}