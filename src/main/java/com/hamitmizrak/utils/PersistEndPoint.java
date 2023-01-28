package com.hamitmizrak.utils;

public class PersistEndPoint {

    //LIST
    //GET /register/list HTTP/1.1
    //http://localhost:4444/register/list

    //FIND
    //GET /register/-1 HTTP/1.1
    //http://localhost:4444/register/1

    //CREATE
    /*
    POST /register/create HTTP/1.1
    Host: localhost:4444
    Content-Type: application/json
    Content-Length: 158
    {

        "username":"adi",
        "surname":"soyadi",
        "email":"emailsdf44@gmail.com",
        "passwd":"Hm1234@",
        "telephoneNumber":"123-456-7890"
    }
    */

    //DELETE
    //DELETE /register/-1 HTTP/1.1
    //http://localhost:4444/register/1

    //UPDATE
    ////http://localhost:4444/register/2
    /*
    POST /register/create HTTP/1.1
    Host: localhost:4444
    Content-Type: application/json
    Content-Length: 158
    {

        "username":"adi2",
        "surname":"soyadi2",
        "email":"email2@gmail.com",
        "passwd":"Hm1222@",
        "telephoneNumber":"123-456-2222"
    }
    */
}
