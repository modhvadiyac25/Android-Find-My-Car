package com.example.findmycar

class User {

    var uid = ""
    var fname =  ""
    var lname =""
    var email =""
    var mobile_no :Long = 0
    var password=""


    constructor(uid:String,fname:String ,lname:String,email:String,mobile_no:Long,password:String){

        this.uid = uid
        this.fname =  fname
        this.lname = lname
        this.email = email
        this.mobile_no= mobile_no
        this.password= password
    }

}