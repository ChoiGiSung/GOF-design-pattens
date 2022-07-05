package com.pattern.gof


class SingletonNotThreadSafe {

    private var instance: SingletonNotThreadSafe? = null

    fun getInstance(): SingletonNotThreadSafe {
        if (instance == null) {
            instance = SingletonNotThreadSafe()
        }
        return instance!!
    }
}

class SingletonThreadSafe {
    private var instance: SingletonNotThreadSafe? = null

    @Synchronized
    fun getInstance(): SingletonNotThreadSafe {
        if (instance == null) {
            instance = SingletonNotThreadSafe()
        }
        return instance!!
    }
}

class SingletonThreadSafePerformance {
    private var instance: SingletonThreadSafePerformance? = null

    fun getInstance(): SingletonThreadSafePerformance {
        if (instance == null) {
            synchronized(lock = this) {
                if (instance == null) {
                    instance = SingletonThreadSafePerformance()
                }
            }
        }
        return instance!!
    }
}

class SingletonStaticEagerLazyLoading {

        class InnerHolder {
            companion object {
                val SINGLETONE: SingletonStaticEagerLazyLoading = SingletonStaticEagerLazyLoading()
            }

    }

    fun getInstance(): SingletonStaticEagerLazyLoading {
        return InnerHolder.SINGLETONE
    }

}

