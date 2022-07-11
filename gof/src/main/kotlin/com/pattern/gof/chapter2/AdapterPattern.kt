package com.pattern.gof.chapter2

//-----------------서드파티----------------------------
interface UserService {

    fun getUser(name: String): User
}

interface User {
    fun checkPassword(password: String): Boolean
}


//-------------------로컬 계정 사용 중-----------------------------

class LocalUser(val name: String, val password: String) {
    fun checkPassword(password: String): Boolean {
        return password == this.password
    }
}

class LocalUserService {
    private val repository = mapOf<String, LocalUser>("name" to LocalUser("name", "pasowrd"))

    fun getUser(name: String): LocalUser {
        return repository.getOrDefault(name, LocalUser("Anonymous","no-password"))
    }
}

//-----------------------어댑터 적용-------------------------

class AdapterUser(
    private val localUser: LocalUser
) : User {

    override fun checkPassword(password: String): Boolean {
        return localUser.checkPassword(password)
    }

}

class AdapterUserService(
    private val localUserService: LocalUserService
) : UserService {

    override fun getUser(name: String): User {
        val user = localUserService.getUser(name)
        return AdapterUser(user)
    }


}
