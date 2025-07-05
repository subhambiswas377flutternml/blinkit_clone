package com.app.blinkit.core


//enum class EndPoints{
//    SignUp
//}
//
//fun EndPoints.value():String{
//    when(this){
//        EndPoints.SignUp-> {
//            return "/accounts:signUp"
//        }
//    }
//}

class EndPointsCollection{
    companion object{
        const val signUp:String = "./accounts:signUp";
        const val signIn:String = "./accounts:signInWithPassword";
    }
}