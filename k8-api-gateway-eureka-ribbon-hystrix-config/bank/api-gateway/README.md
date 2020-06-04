insert the entry in mongodb

{"username": "username",
"password": "password"
}

from the rest client hit the following as post request:

http://localhost:8080/api/signin

with values:
{
  "username": "admin",
  "password":"admin"
  
}


in DB password should be encrypted. Using password encoder


 BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println(b.encode("admin"));

